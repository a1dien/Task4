package inno.edu.convert;

import inno.edu.check.FIOCheck;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestFioCheck {

    @Autowired
    private FIOCheck fioCheck;

    private String string = "тест";
    private String string2 = "Тест";

    @Test
    void testFioCheck() {
        assertEquals(fioCheck.capitilizeString(string), "Тест");
        assertEquals(fioCheck.capitilizeString(string2), "Тест");
    }
}
