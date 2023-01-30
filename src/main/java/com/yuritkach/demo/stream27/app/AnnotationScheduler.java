package com.yuritkach.demo.stream27.app;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
//@EnableScheduling
// application.yml --->  spring.task.scheduling.pool.size: 5
public class AnnotationScheduler { //implements SchedulingConfigurer {

  @Scheduled(fixedRate = 1000, initialDelay = 1000)
  public void doOnScheduleFixedRate() throws InterruptedException {
    log.info("Fixed rate");
    Thread.sleep(2000);
  }

  //@Scheduled(fixedDelay = 1000, initialDelay = 2000)
  public void doOnScheduleFixedDelay() throws InterruptedException {
    log.info("Fixed delay");
    Thread.sleep(900);
  }

  @Scheduled(cron = "0/1 * * * * *")
  public void doOnCron() {
    log.info("Cron yeah");
  }

//  @Override
//  public void configureTasks(final ScheduledTaskRegistrar taskRegistrar) {
//    taskRegistrar.setScheduler(beanExecutor());
//  }
//
//  @Bean(destroyMethod = "shutdown")
//  public ScheduledThreadPoolExecutor beanExecutor() {
//    return new ScheduledThreadPoolExecutor(5);
//  }
}
