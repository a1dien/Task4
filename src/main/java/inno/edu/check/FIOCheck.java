package inno.edu.check;

import inno.edu.services.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FIOCheck extends AbstractCheck{
    @Autowired
    public FIOCheck() {
    }

    @Override
    public Map<Keys, Object> checkString(String stringFromFile) throws ParseException {
        Map<Keys, Object> result = new HashMap<>();
        String[] list = stringFromFile.split(" ");
        String line = "";
        for (int i = 2; i < 5; i++) {
            line +=
                    list[i].substring(0,1).toUpperCase()
                            + list[i].substring(1) + " ";
        }

        result.put(Keys.FIO, line.replaceAll("\\s+$", ""));
        return result;
    }

}
