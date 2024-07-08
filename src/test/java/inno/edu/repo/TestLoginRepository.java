package inno.edu.repo;

import inno.edu.check.DateCheck;
import inno.edu.model.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestLoginRepository {
    @Autowired
    private LoginRepository loginRepository;
    private Login testLogin;
    private Date date = new Date(101, 0, 1);

    @BeforeEach
    public void setUp() throws ParseException {

        testLogin = new Login();
        testLogin.setAccessDate(new Timestamp(date.getTime()));
        testLogin.setApplication("web");
        testLogin.setUserId(1000L);
        loginRepository.save(testLogin);
    }

    @AfterEach
    public void tearDown() {
        loginRepository.delete(testLogin);
    }

    @Test
    void findUser() {
        Login savedLogin = loginRepository.findById(testLogin.getId()).orElse(null);
        assertNotNull(savedLogin);
        assertEquals(testLogin.getAccessDate(), savedLogin.getAccessDate());
        assertEquals(testLogin.getUserId(), savedLogin.getUserId());
        assertEquals(testLogin.getApplication(), savedLogin.getApplication());
    }

}
