package spring.boot.revamp.interceptors.beforeController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// create the customer interceptor by implementing the HandlerInterceptor interface
@Component
public class BeforeControllerInterceptor implements HandlerInterceptor {

    // In order to handle request interception, we have to override the below three methods

    // invoked before the controller method is invoked, if false -> don't proceed to call the controller
    // true -> call the controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Inside pre handle method");
        return true;
    }

    // invoked after the controller method is called but view is not rendered
    // not get called if controller throws and exception
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Inside post handle method");
    }

    // invoked after the controller method is called and view is rendered
    // gets called even if controller throws an exception, similar to finally block
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Inside after handle method");
    }
}
