package spring.boot.revamp.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncService {

    @Async
    public void asyncMethodTest(){
        try{
            System.out.println("In asyncMethodTest: " + Thread.currentThread().getName());
            Thread.sleep(50000);// simulate delay
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    @Async
    public void asyncMethodTest1(){
        int i = 0;
        int div = 5/i;
    }

    @Async
    public CompletableFuture<String> asyncMethodTest2(){
//        throw new RuntimeException("Completable Future");
        return CompletableFuture.completedFuture("Completable Future");
    }
}
