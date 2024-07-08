package inno.edu.convert;

import inno.edu.check.AppCheck;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestAppCheck {

    @Autowired
    private AppCheck appCheck;

    private String check1 = "mobile";
    private String check2 = "web";
    private String check3 = "check";


    @Test
    void testCheckApplication() {
        assertEquals(appCheck.checkApplication(check1), check1);
        assertEquals(appCheck.checkApplication(check2), check2);
        assertEquals(appCheck.checkApplication(check3), "other " + check3);
    }
}
