package spring.boot.revamp.beanScopes.session;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beanScopes/session")
@Scope("session")
public class TestSessionController {

    @Autowired
    SessionUser user;

    public TestSessionController(){
        System.out.println("TestSessionController object initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestSessionController object hashCode: " + this.hashCode() + " and SessionUser object hashCode: " + this.user.hashCode());
    }

    @GetMapping("/fetchUser")
    public ResponseEntity<String> getUserDetails(){
        System.out.println("fetchUser Api invoked");
        return ResponseEntity.ok("");
    }

    @GetMapping("logout")
    public  ResponseEntity<String> logout(HttpServletRequest request){
        System.out.println("end the session");
        HttpSession session = request.getSession();
        session.invalidate();
        return ResponseEntity.ok("");
    }
}
