package spring.boot.revamp.interceptors.afterController;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class AfterControllerInterceptor {

    @Around("@annotation(spring.boot.revamp.interceptors.afterController.MyCustomAnnotation)")// pointcut expression
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable { //advice
        System.out.println(" do something before actual method call");

        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();

        if(method.isAnnotationPresent(MyCustomAnnotation.class)){
            MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
            assert annotation != null;
            System.out.println("name of annotation: " + annotation.key());
        }

        joinPoint.proceed();

        System.out.println("Do something after actual method");
    }
}
