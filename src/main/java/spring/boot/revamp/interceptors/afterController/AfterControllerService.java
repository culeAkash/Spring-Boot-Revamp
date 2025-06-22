package spring.boot.revamp.interceptors.afterController;

import org.springframework.stereotype.Component;

@Component
public class AfterControllerService {

    @MyCustomAnnotation(key = "user")
    public void getUser(){
        System.out.println("get the user details");
    }

    public void getUser1(){
        System.out.println("get the user details");
    }
}
