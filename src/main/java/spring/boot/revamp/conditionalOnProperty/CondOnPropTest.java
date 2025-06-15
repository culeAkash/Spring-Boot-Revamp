package spring.boot.revamp.conditionalOnProperty;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class CondOnPropTest {


    private final SqlConnection sqlConnection;
    private final NoSqlConnection noSqlConnection;

    @Autowired
    public CondOnPropTest(Optional<SqlConnection> sqlConnectionOptional,Optional<NoSqlConnection> noSqlConnectionOptional){
        this.sqlConnection = sqlConnectionOptional.orElse(null);
        this.noSqlConnection = noSqlConnectionOptional.orElse(null);
    }


    @PostConstruct
    public void init(){
        System.out.println("CondOnPropTest Bean initialized");
        System.out.println("The object sqlConnection is null: " + Objects.isNull(sqlConnection));
        System.out.println("The object noSqlConnection is null: " + Objects.isNull(noSqlConnection));
    }
}
