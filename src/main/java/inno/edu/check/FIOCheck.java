package inno.edu.check;

import org.springframework.stereotype.Component;

@Component
public class FIOCheck {

    public String capitilizeString(String input) {
        return input.substring(0,1).toUpperCase() + input.substring(1);
    }
}
