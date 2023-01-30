package com.yuritkach.demo.stream27.app;

import java.time.Instant;
import java.util.Random;

import org.jobrunr.jobs.JobId;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobRunrSchedulerExample {

  @Autowired
  private JobScheduler scheduler;

  private final Random rnd = new Random();

  @Recurring(id = "my-recurring-job", /*cron = "0/5 * * * *",*/ interval = "PT5S")
  @Job(name = "JobRunr recurring job")
  public void doRecurringJob() {
    log.info("Doing some work without arguments");
    if (rnd.nextBoolean()) {
      scheduleJob();
    }
  }

  public void scheduleJob() {
    //scheduler.enqueue(() -> log.info("Enqueued job"));
    final JobId jobId = scheduler.schedule(Instant.now().plusSeconds(3), () -> System.out.println("Enqueued job"));
    log.debug("Scheduled job: {}", jobId.asUUID());
  }
}
