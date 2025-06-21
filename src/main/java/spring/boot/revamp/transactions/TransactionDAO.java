package spring.boot.revamp.transactions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class TransactionDAO {


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void dbOperationWithPropagation(){
        boolean isTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();

        System.out.println("*******************************************");
        System.out.println("Is active: " + isTransactionActive);
        System.out.println("Transaction name: " + currentTransactionName);
        System.out.println("*******************************************");
    }
}
