package spring.boot.revamp.dependencyInjection.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class User {

    // Field INjection
//    @Autowired
//    Order order;

    Order order;

    @Autowired
    public User(Order order){
        this.order = order;
        System.out.println("User object initialized");
    }

    // setter injection
//    @Autowired
//    public void setOrder(Order order){
//        this.order = order;
//    }
}
