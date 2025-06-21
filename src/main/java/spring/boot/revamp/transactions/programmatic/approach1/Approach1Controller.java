package spring.boot.revamp.transactions.programmatic.approach1;


import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction/approach1")
// using this as service also
public class Approach1Controller {

    private final PlatformTransactionManager transactionManager;


    public Approach1Controller(PlatformTransactionManager approach1transactionManager){
        this.transactionManager = approach1transactionManager;
    }


    @GetMapping("/try")
//   @Transactional : No need as we are handling the transaction manually
    public String tryApproach1(){
        // Create and start a transaction before business logic
        // TransactionStatus contains the curr status of the transaction going on
        TransactionStatus status = transactionManager.getTransaction(null);
        // Transaction has started, now write business logic
        try{
            // Initial set of DB operations
            System.out.println("Insert Query run1");
            System.out.println("Update Query run2");

            // Business logic done if completed successfully, commit
            this.transactionManager.commit(status);
        }catch(Exception e){
            // Rollback in case of exception or failure
            this.transactionManager.rollback(status);
        }

        if(status.isCompleted()){
            System.out.println("Transaction is completed");
        }

        return "Approach 1";
    }
}
