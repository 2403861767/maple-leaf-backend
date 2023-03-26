package com.seeleaf.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;

@SpringBootApplication
@MapperScan("com.seeleaf.usercenter.mapper")
@EnableScheduling
@EnableAsync
//@ComponentScan({"com.seeleaf.usercenter.once","com.seeleaf.usercenter.service","com.seeleaf.usercenter.controller"})
//@ComponentScan({"com.seeleaf.usercenter.*"})
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

    /**
     * 并发执行，这里的线程可自定义或者用idea默认的，两种方法的区别是，自定义可以跑满线程，而默认的只能跑CPU核数-1，代码区别：就是在异步执行处加上自定义的线程名
     */
    @Bean
    public ExecutorService executorService(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(40);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(10000);
        executor.initialize();
        return executor.getThreadPoolExecutor();
    }
}
