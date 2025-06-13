package spring.boot.revamp.dependencyInjection.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

    @Autowired
    Order order;


    public Invoice(){
        System.out.println("Invoice object initialized");
    }

    @PostConstruct
    public void postConstruct(){
        order.invoice = this;
    }
}
