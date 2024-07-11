package inno.edu.check;

import inno.edu.services.Keys;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Map;

@Component
public abstract class AbstractCheck {
    public abstract Map<Keys, Object> checkString(String stringFromFile) throws ParseException;

}
