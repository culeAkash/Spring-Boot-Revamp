package spring.boot.revamp.filters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/multiple/interceptors")
public class MultipleInterceptorFilterTestController {

    @GetMapping("/get")
    public String get(){
        System.out.println("Get method invoked");
        return "success";
    }

    @GetMapping("/delete")
    public String delete(){
        System.out.println("Delete method invoked");
        return "success";
    }

    @GetMapping("/update")
    public String update(){
        System.out.println("Update method invoked");
        return "success";
    }
}
