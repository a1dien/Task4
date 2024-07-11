package inno.edu.convert;

import inno.edu.check.FIOCheck;
import inno.edu.services.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestFioCheck {

    @Autowired
    private FIOCheck fioCheck;

    private String string = "tst.txt test тестов Тест тестович 01.01.2001 mobile";
    private String string2 = "tst.txt test Тестов2 Тест2 тестович2 01.01.2001 mobile";

    @Test
    void testFioCheck() throws ParseException {
        assertEquals(fioCheck.checkString(string).get(Keys.FIO), "Тестов Тест Тестович");
        assertEquals(fioCheck.checkString(string2).get(Keys.FIO), "Тестов2 Тест2 Тестович2");
    }
}
