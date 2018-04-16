#Spring Execution and Schedule

Spring提供TaskExecutor和TaskSchedule两个接口来实现异步执行（可以理解为线程池）和定时任务的功能。

##TaskExecutor
Spring提供的TaskExecutor实现类有:

1. SimpleAsyncTaskExecutor：不是真的线程池，这个类不重用线程，每次调用都会创建一个新的线程。 
2. SyncTaskExecutor：这个类没有实现异步调用，只是一个同步操作。只适用于不需要多线程的地方 
3. ConcurrentTaskExecutor：Executor的适配类，不推荐使用。如果ThreadPoolTaskExecutor不满足要求时，才用考虑使用这个类 
4. SimpleThreadPoolTaskExecutor：是Quartz的SimpleThreadPool的类。线程池同时被quartz和非quartz使用，才需要使用此类 
5. ThreadPoolTaskExecutor：最常使用，推荐。其实质是对java.util.concurrent.ThreadPoolExecutor的包装;
6. WorkManagerTaskExecutor:不常用。

##TaskSchedule
这个接口的具体内容如下

    public interface TaskScheduler {
		ScheduledFuture schedule(Runnable task, Trigger trigger);
		ScheduledFuture schedule(Runnable task, Date startTime);
		ScheduledFuture scheduleAtFixedRate(Runnable task, Date startTime, long period);
		ScheduledFuture scheduleAtFixedRate(Runnable task, long period);
		ScheduledFuture scheduleWithFixedDelay(Runnable task, Date startTime, long delay);
		ScheduledFuture scheduleWithFixedDelay(Runnable task, long delay);
	}
这个接口的实现类推荐使用ThreadPoolTaskSchedule

Trigger：促发定时任务。实现类如下：

- CronTrigger
- PeriodicTrigger

##Java Config

    //java config的方式
    @Configuration
	@EnableAsync
	@EnableScheduling
	public class TaskConfig {

    @Bean("threadPoolExecutor1")
    public TaskExecutor threadPoolExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("threadPool-1-");
        return taskExecutor;
    }

    @Bean("threadPoolExecutor2")
    public TaskExecutor threadPoolExecutor2(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("threadPool-2-");
        return taskExecutor;
    }

    }

##其他
如果系统的定时任务较多，建议使用Quartz这个定时任务框架。支持数据库 任务同步。