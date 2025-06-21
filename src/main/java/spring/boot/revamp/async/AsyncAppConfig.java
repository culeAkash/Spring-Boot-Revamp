package spring.boot.revamp.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


// We don't want to remember all the conditions when which Executor is used, we want to use our custom executor
// irrespective of ThreadPoolTaskExecutor or ThreadPoolExecutor
// and whether name is given in @Async annotation or not
// We can implement the AsyncConfigurer interface
@Configuration
public class AsyncAppConfig implements AsyncConfigurer {

    // Since bean created is not by @Bean, hence not singleton so we have to handle it by using synchronized and conditions
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private DefaultAsyncUnCaughtExceptionHandler exceptionHandler;

    @Override
    public synchronized Executor getAsyncExecutor() {
        if(threadPoolExecutor==null){
            threadPoolExecutor= new ThreadPoolExecutor(
                    2, 4, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(3), new CustomThreadFactory());
        }
        return threadPoolExecutor;
    }

    // Configure the default exception handling to be used
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return this.exceptionHandler;
    }
}


// Custom Exception Handling for method annotated with @Async annotation and return type void
@Component
class DefaultAsyncUnCaughtExceptionHandler implements AsyncUncaughtExceptionHandler{

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("Default Exception Handling for Async methods");
    }
}


// Example to use custom ThreadPoolTaskExecutor and ThreadPoolExecutor
class AsyncAppConfig1 {

    // creating our own custom ThreadPoolTaskExecutor
    @Bean(name = "myThreadPoolTaskExecutor")
    public Executor taskPoolExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(4);
        taskExecutor.setQueueCapacity(3);
        taskExecutor.setThreadNamePrefix("MyThread -");
        taskExecutor.initialize();
        return taskExecutor;
    }

    // If we use a ThreadPoolExecutor instead of a ThreadPoolTaskExecutor, then we have to specify the name of the executor inside the
    // @Async annotation otherwise the SimpleAsyncTaskExecutor is used as fallback and default ThreadPoolTaskExecutor won't be created either
    @Bean("myThreadPoolExecutor")
    public Executor myThreadPoolExecutor(){
        return new ThreadPoolExecutor(
                2,4,1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3),new CustomThreadFactory());
    }



}

class CustomThreadFactory implements ThreadFactory{

    private final AtomicInteger threadNo = new AtomicInteger(1);
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("MyThread - " + threadNo.getAndIncrement());
        return thread;
    }
}
