package spring.boot.revamp.interceptors.afterController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interceptor/aop")
public class AfterControllerTestController {

    private final AfterControllerService service;

    public AfterControllerTestController(AfterControllerService service){
        this.service = service;
    }

    @GetMapping("/getUser")
    public String getUser(){
        System.out.println("Invoked controller");
        this.service.getUser1();
        return "success";
    }
}
