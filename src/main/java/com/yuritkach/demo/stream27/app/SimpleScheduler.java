package com.yuritkach.demo.stream27.app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class SimpleScheduler {

  private final ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5);

  @PostConstruct
  public void scheduleTasks() {
    log.info("Scheduling tasks...");

    service.schedule(() -> log.info("Simple run"), 1, TimeUnit.SECONDS);
    final ScheduledFuture<String> futureCallable = service.schedule(() -> {
      log.info("Simple callable");
      return "Yay!";
    }, 3, TimeUnit.SECONDS);

    final ScheduledFuture<?> fixedDelayFuture = service.scheduleWithFixedDelay(
      () -> log.info("Fixed delay run"),
      1500,
      500,
      TimeUnit.MILLISECONDS
    );

    try {
      log.info("From callable: {}", futureCallable.get(4, TimeUnit.SECONDS));
      fixedDelayFuture.cancel(false);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    } catch (TimeoutException e) {
      log.error("Timeout: {}", e.getMessage());
    }
  }

}
