package spring.boot.revamp.jpaExamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.revamp.jpaExamples.plainJDBCExample.PlainJDBCUserDAO;
import spring.boot.revamp.jpaExamples.springBootJdbcExample.User;
import spring.boot.revamp.jpaExamples.springBootJdbcExample.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jpaTesting")
public class JpaTestController {


    private PlainJDBCUserDAO plainJDBCUserDAO = new PlainJDBCUserDAO();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/plain-jdbc-test")
    public String testPlainJdbc(){
        plainJDBCUserDAO.createTable();
        plainJDBCUserDAO.createUser("Akash",25);
        plainJDBCUserDAO.createUser("Amit",27);
        return plainJDBCUserDAO.getAllUsers();
    }

    @GetMapping("/spring-boot-jdbc-test")
    public String testSpringBootJdbc(){
        try {
            System.out.println("Creating table...");
            userRepository.createTable();

            System.out.println("Inserting user...");
            userRepository.insertUser("Akash", 25);
            userRepository.insertUser("Amit", 27);

            System.out.println("Fetching users...");
            List<User> users = userRepository.getUsers();
            users.forEach(System.out::println);

            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "FAILURE: " + e.getMessage();
        }
    }
}
