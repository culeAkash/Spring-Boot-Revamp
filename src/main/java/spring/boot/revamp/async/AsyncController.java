package spring.boot.revamp.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/async")
public class AsyncController {

    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService){
        this.asyncService = asyncService;
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("In Main " + Thread.currentThread().getName());
        asyncService.asyncMethodTest1();
        return "";
    }

    @GetMapping("/test1")
    public String test1(){
        System.out.println("In Main " + Thread.currentThread().getName());
        CompletableFuture<String> future = asyncService.asyncMethodTest2();
        // We can handle exceptions from async methods with a return type by catching them here after calling get()
        try{
            String s = future.get();
            System.out.println(s);
        }catch (Exception e){
            System.out.println("Exception occurred in Async method");
        }
        return "";
    }
}
