package spring.boot.revamp.dependencyInjection.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Order {

    @Autowired
    @Lazy
    Invoice invoice;

    public Order(){
        System.out.println("Order object initialized");
    }
}
