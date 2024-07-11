package inno.edu.convert;

import inno.edu.check.AppCheck;
import inno.edu.services.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestAppCheck {

    @Autowired
    private AppCheck appCheck;

    private String line = "tst.txt test тестов Тест тестович 01.01.2001 mobile";
    private String line2 = "tst.txt test тестов Тест тестович 01.01.2001 web";
    private String line3 = "tst.txt test тестов Тест тестович 01.01.2001 check";
    private String check1 = "mobile";
    private String check2 = "web";
    private String check3 = "check";


    @Test
    void testCheckApplication() throws ParseException {
        assertEquals(appCheck.checkString(line).get(Keys.APPLICATION), check1);
        assertEquals(appCheck.checkString(line2).get(Keys.APPLICATION), check2);
        assertEquals(appCheck.checkString(line3).get(Keys.APPLICATION), "other " + check3);
    }
}
