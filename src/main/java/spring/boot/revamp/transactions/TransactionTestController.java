package spring.boot.revamp.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction/normal")
public class TransactionTestController {

    private final TransactionTestService transactionTestService;

    @Autowired
    public TransactionTestController(TransactionTestService transactionTestService){
        this.transactionTestService = transactionTestService;
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        this.transactionTestService.updateUser();
        return "user updated";
    }
}
