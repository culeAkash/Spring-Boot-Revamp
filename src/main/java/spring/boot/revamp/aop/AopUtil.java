package spring.boot.revamp.aop;

import org.springframework.stereotype.Service;

@Service
public class AopUtil {

    public void employeeHelperMethod(String t,Integer val){
        System.out.println("Employee helper method called");
    }
}
