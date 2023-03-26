package com.seeleaf.usercenter.once;

import com.seeleaf.usercenter.mapper.UserMapper;
import com.seeleaf.usercenter.model.domain.User;
import com.seeleaf.usercenter.service.UserService;
import com.sun.xml.internal.ws.util.CompletedFuture;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class InsertUsers {


    @Resource
    private UserService userService;
    /**
     * 并发执行，这里的线程可自定义或者用idea默认的，两种方法的区别是，自定义可以跑满线程，而默认的只能跑CPU核数-1，代码区别：就是在异步执行处加上自定义的线程名
     */
//    @Resource
//    private ExecutorService executorService = new ThreadPoolExecutor(40,1000,10000, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10000));
    @Resource
    private Executor executorService;
    /**
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000; //100000000
        List<User> userList  = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fake");
            user.setGender(0);
            user.setAvatarUrl("https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/3475/avatar.jpg");
            user.setUserPassword("b0dd3697a192885d7c055db46155b26a");
            user.setPhone("18307984130");
            user.setEmail("18307984130@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("9999");
            user.setTags("[]");
            user.setProfile("阿巴阿巴");
//            userMapper.insert(user); 一次性插入一条太慢了
            userList.add(user);
        }
        // 批量插入
        userService.saveBatch(userList,100);
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("花了"+totalTimeMillis/1000+"秒");
    }

    /**
     * 多线程执行
     * 并发插入用户
     */
    @Async
//    @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doConcurrencyInsertUsers2(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000; //100000000
        // 分组 10组
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            List<User> userList  = new ArrayList<>();
            while (true){
                j++;
                User user = new User();
                user.setUsername("假用户");
                user.setUserAccount("fake");
                user.setGender(0);
                user.setAvatarUrl("https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/3475/avatar.jpg");
                user.setUserPassword("b0dd3697a192885d7c055db46155b26a");
                user.setPhone("18307984130");
                user.setEmail("18307984130@qq.com");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("9999");
                user.setTags("[]");
                user.setProfile("阿巴阿巴");
                userList.add(user);
                if (j%10000 == 0){
                    break;
                }
            }
            // 异步
            // 默认线程池是CPU的核数
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("ThreadName:"+Thread.currentThread().getName());
                userService.saveBatch(userList, 10000);
            },executorService);
            futureList.add(future);
        }
        // 开始执行
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        // 批量插入
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("花了"+totalTimeMillis/1000+"秒");
    }
}
