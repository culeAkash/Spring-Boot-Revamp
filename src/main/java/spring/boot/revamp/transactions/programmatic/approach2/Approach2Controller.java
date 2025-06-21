package spring.boot.revamp.transactions.programmatic.approach2;


import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction/approach2")
public class Approach2Controller {


    private final TransactionTemplate transactionTemplate;

    public Approach2Controller(TransactionTemplate approach2transactionTemplate){
        this.transactionTemplate = approach2transactionTemplate;
    }


    @GetMapping("/try")
    public String approach2(){
        // insert the business logic a a lambda expression
        // exceptions thrown, or manual rollbacks result in rollback
        // else transaction is committed
        // no need to handle commit and rollbacks
        transactionTemplate.execute(status->{
            System.out.println("Insert Query run1");
            System.out.println("Update Query run2");
            return null;
        });

        return "Approach 2";
    }
}
