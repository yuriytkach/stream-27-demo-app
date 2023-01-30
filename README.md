# Demo Project for Online Stream #27 - Scheduling Tasks in Java
Demo project for online stream #27 about different ways of scheduling tasks in Java,
using Java core, spring boot annotations, Quartz and Jobrunr.

## Access to Online Stream on YouTube

To get a link to online stream on YouTube please do the following:

- :moneybag: Make any donation to support my volunteering initiative to help Ukrainian Armed Forces by means described on [my website](https://www.yuriytkach.com/volunteer)
- :email: Write me an [email](mailto:me@yuriytkach.com) indicating donation amount and time
- :tv: I will reply with the link to the stream on YouTube.

Thank you in advance for your support! Слава Україні! :ukraine:

## Running the Demo
Please, compile and run the demo project. You can use provided gradle script:
```shell
./gradlew bootRun
```

Use the provided `docker-compose.yaml` file to start PostgreSQL in Docker (needed for Quartz and Jobrunr).

Uncomment `@Component` annotations on different examples to see them working.

### Reference Documentation
For further reference, please consider the following sections:

* [JobRunr Official Documentation](https://www.jobrunr.io/en/documentation/)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.quartz)
