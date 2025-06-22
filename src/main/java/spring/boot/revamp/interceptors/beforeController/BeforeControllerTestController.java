package spring.boot.revamp.interceptors.beforeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/v1/interceptor")
public class BeforeControllerTestController {

    @GetMapping("/get")
    public String get(){
        System.out.println("Get controller invoked");
        return "Get method";
    }

    @GetMapping("/update")
    public String update(){
        System.out.println("Update controller invoked");
        return "Update method";
    }

    @GetMapping("/delete")
    public String delete(){
        System.out.println("Delete controller invoked");
        return "Delete method";
    }
}
