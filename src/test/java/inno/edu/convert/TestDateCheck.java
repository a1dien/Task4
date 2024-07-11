package inno.edu.convert;

import inno.edu.check.DateCheck;
import inno.edu.services.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestDateCheck {
    @Autowired
    private DateCheck dateCheck;
    private String line = "tst.txt test тестов Тест тестович 01.01.2001 mobile";
    private Date date = new Date(101, 0, 1);


    @Test
    void testConvertDate() throws ParseException {
        assertEquals(
                dateCheck.checkString(line).get(Keys.DATE),
                new Timestamp(date.getTime())
        );
    }
}
