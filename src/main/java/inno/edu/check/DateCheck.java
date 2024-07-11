package inno.edu.check;

import inno.edu.services.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class DateCheck extends AbstractCheck{

    @Autowired
    public DateCheck() {
    }

    @Override
    public Map<Keys, Object> checkString(String stringFromFile) throws ParseException {
        Map<Keys, Object> result = new HashMap<>();
        String[] list = stringFromFile.split(" ");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date parsedDate = dateFormat.parse(list[5]);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

        result.put(Keys.DATE, timestamp);
        return result;
    }
}
