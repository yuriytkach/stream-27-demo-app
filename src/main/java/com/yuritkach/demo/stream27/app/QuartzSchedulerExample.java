package com.yuritkach.demo.stream27.app;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class QuartzSchedulerExample {

//  @Bean
//  public JobDetail jobDetail() {
//    return JobBuilder.newJob().ofType(ScheduledJob.class)
//      .storeDurably()
//      .withIdentity("SuperJob")
//      .withDescription("Super job detail...")
//      .usingJobData("data", "value")
//      .build();
//  }

  @Bean
  public JobDetailFactoryBean jobDetail() {
    final JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
    jobDetailFactory.setJobClass(ScheduledJob.class);
    jobDetailFactory.setDescription("Super job detail...");
    jobDetailFactory.setDurability(true);
    jobDetailFactory.setName("SuperJob");
    jobDetailFactory.setJobDataAsMap(Map.of("data", "value"));
    return jobDetailFactory;
  }

//  @Bean
//  public SimpleTriggerFactoryBean trigger(final JobDetail job) {
//    final SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
//    trigger.setJobDetail(job);
//    trigger.setStartDelay(1000);
//    trigger.setRepeatInterval(10_000);
//    trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//    return trigger;
//  }

//  @Bean
//  @QuartzDataSource
//  public DataSource qds() {
//    return DataSourceBuilder.create().type(SimpleDriverDataSource.class).build();
//  }


  @Component
  public static class ScheduledJob implements Job {

    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
      log.info("Quartz Job: {} : {}", context.getFireInstanceId(), context.getMergedJobDataMap().get("data"));
    }
  }

}
