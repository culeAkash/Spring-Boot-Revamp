package spring.boot.revamp.transactions.programmatic.approach2;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
public class Approach2AppConfig {

//    @Bean(name = "approach2transactionManager")
//    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }


    @Bean(name = "approach2transactionTemplate")
    public TransactionTemplate transactionTemplate(PlatformTransactionManager approach2transactionManager){
        TransactionTemplate transactionTemplate = new TransactionTemplate(approach2transactionManager);
        // Set propagation Level
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return  transactionTemplate;
    }

}
