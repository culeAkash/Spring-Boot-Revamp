package spring.boot.revamp.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // We can give the pointcut to point to diff methods after/before which this must be run
    @Before("execution(public String spring.boot.revamp.aop.AopController.fetchEmployee())")
    public void beforeMethod1(){
        System.out.println("inside beforeMethod1 Aspect");
    }

    // We can use (*) wildcard which matches any single item
    // matches all methods with return type any and accepts a String param
    @Before("execution(* spring.boot.revamp.aop.AopController.*(String))")
    public void beforeMethod2(){
        System.out.println("inside beforeMethod2 Aspect");
    }

    // We can also use (..) wildcard which matches 0 or more item
    // matches fetchEmployee method with String return type with any number of params with any data type
    @Before("execution(String spring.boot.revamp.aop.AopController.fetchEmployee(..))")
    public void beforeMethod3(){
        System.out.println("inside beforeMethod3 Aspect");
    }


    // within : matches all methods within any class or package
    @Before("within(spring.boot.revamp.aop.*)")
    public void withinExampleMethod(){
        System.out.println("Invoked for all methods");
    }

    // @within : matches any method in a class which has the annotation
    @Before("@within(org.springframework.stereotype.Service)")
    public void withinExampleMethod2(){
        System.out.println("@within example log called");
    }

    // @annotated : matches any method annotated with the annotation
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotationExampleMethod2(){
        System.out.println("@annotation example log called");
    }

    // args : matches any method with particular arguments or params
    @Before("args(String,int)")
    public void argsExampleMethod1(){
        System.out.println("args example log called");
    }


    // We can also combine two pointcuts using : && (boolean and) || (boolean or)
    @Before("execution(* spring.boot.revamp.aop.AopController.*())" +
    "&& @within(org.springframework.web.bind.annotation.RestController)")
    public void beforeAndMethod(){
        System.out.println("inside beforeAndMethod aspect");
    }

    @Before("execution(* spring.boot.revamp.aop.AopController.*())" +
            "|| @within(org.springframework.stereotype.Component)")
    public void beforeOrMethod(){
        System.out.println("inside beforeOrMethod aspect");
    }


    // Apart from @Before, we can also use @After and @Around
    @After("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotationExampleMethodAfter(){
        System.out.println("@annotation example log called for after advice");
    }

    @Around("execution(* spring.boot.revamp.aop.AopController.*(String,Integer))")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("bbefore method call");
        joinPoint.proceed();
        System.out.println("after method call");
    }


}
