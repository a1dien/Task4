package inno.edu.check;

import org.springframework.stereotype.Component;

@Component
public class AppCheck {
    public String checkApplication(String input) {
        if (input.equals("web") || input.equals("mobile")) return input;
        return "other " + input;
    }
}
