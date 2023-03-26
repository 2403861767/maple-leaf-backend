package com.seeleaf.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seeleaf.usercenter.mapper.UserMapper;
import com.seeleaf.usercenter.model.domain.User;
import com.seeleaf.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热任务
 *
 * @author seeleaf
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L);

    // 每天执行, 预热推荐用户
    @Scheduled(cron = "0 33 15 * * ? ")
    public void doCacheRecommendUser() {
        RLock lock = redissonClient.getLock("seeleaf:precachejob:docache:lock");
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // waitTime 等0s，释放时间30s
        /**
         * 每个服务器想要抢锁等0s，如果有锁就直接离开，没有才执行，30s后锁释放
         */
        // 只有一个线程能获取到锁
        try {
            if (lock.tryLock(0, 30000L, TimeUnit.MILLISECONDS)){
                for (Long userId : mainUserList) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("seeleaf:user:recommend:%s", userId);
                    // 写缓存
                    try {
                        valueOperations.set(redisKey, userPage, 10, TimeUnit.MINUTES);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }


            }
        } catch (InterruptedException e) {
            log.error("docache lock",e);
        }finally {
            // 防止报错了就不执行
            // 只能释放自己的锁
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }

    }

}
