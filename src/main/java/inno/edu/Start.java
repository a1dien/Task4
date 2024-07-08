package inno.edu;

import inno.edu.repo.UserRepository;
import inno.edu.services.FileService;
import inno.edu.services.ParseRecordService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import inno.edu.model.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "inno.edu")
@EnableTransactionManagement(proxyTargetClass = true)
public class Start {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = SpringApplication.run(Start.class,args);
    }



}
