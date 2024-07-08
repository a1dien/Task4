package inno.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

@SpringBootApplication(scanBasePackages = "inno.edu")
@EnableTransactionManagement(proxyTargetClass = true)
public class Start {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = SpringApplication.run(Start.class,args);
    }



}
