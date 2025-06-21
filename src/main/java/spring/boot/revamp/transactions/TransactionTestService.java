package spring.boot.revamp.transactions;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class TransactionTestService {

    @Autowired
    private TransactionDAO dao;

    @Transactional
    public void updateUser(){
        System.out.println("Is Transaction Active: " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Current Transaction Name: " + TransactionSynchronizationManager.getCurrentTransactionName());

        System.out.println("Some initial DB operations");

        dao.dbOperationWithPropagation();

        System.out.println("Some final DB operations");
    }
}
