package spring.boot.revamp.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aop")
public class AopController {

    private final AopUtil aopUtil;

    @Autowired
    public AopController(AopUtil aopUtil){
        this.aopUtil = aopUtil;
    }


    @GetMapping("/fetchEmployee")
    public String fetchEmployee(){
        System.out.println("Called");
        return "item fetched";
    }

    @GetMapping("/fetchEmployee2")
    public String fetchEmployee2(String str){
        return "fetchEmployee2";
    }

    @GetMapping("/fetchEmployee3")
    public String fetchEmployee3(String str){
        return "fetchEmployee3";
    }

    @GetMapping("/fetchEmployee4")
    public String fetchEmployee(String str){
        return "fetchEmployee4";
    }

    @GetMapping("/fetchEmployee5")
    public String fetchEmployee5(String str){
        this.aopUtil.employeeHelperMethod("",1);
        return "fetchEmployee5";
    }

    @GetMapping("/fetchEmployee6")
    public String fetchEmployee6(){
        this.aopUtil.employeeHelperMethod("",1);
        return "fetchEmployee6";
    }

    @GetMapping("/fetchEmployee7")
    public String fetchEmployee7(String str,Integer b){
        System.out.println("Called");
        return "fetchEmployee7";
    }


}
