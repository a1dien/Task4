package inno.edu.check;

import inno.edu.services.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Order(30)
@Component
public class AppCheck extends AbstractCheck{

    @Autowired
    public AppCheck() {}

    @Override
    public Map<Keys, Object> checkString(String stringFromFile) throws ParseException {
        Map<Keys, Object> result = new HashMap<>();
        String[] list = stringFromFile.split(" ");
        if (list[6].equals("web") || list[6].equals("mobile")) {
            result.put(Keys.APPLICATION, list[6]);
        } else {
            result.put(Keys.APPLICATION, "other " + list[6]);
        }
        return result;
    }
}
