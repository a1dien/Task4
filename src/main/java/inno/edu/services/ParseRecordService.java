package inno.edu.services;

import inno.edu.check.AppCheck;
import inno.edu.check.DateCheck;
import inno.edu.check.FIOCheck;
import inno.edu.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

@Component
public class ParseRecordService {
    private String nameFile;

    @Autowired
    private DateCheck dateCheck;

    @Autowired
    private FIOCheck fioCheck;

    @Autowired
    private AppCheck appCheck;

    //Структура текстового файла - список полей разделенных пробелом
    //Имя файла
    //UserName
    //Фамилия
    //Имя
    //Отчество
    //Дата
    //Устройство
    @Loggable
    public List<Map<Keys, Object>> parseString(List<String> records) {
        List<Map<Keys, Object>> parseRecords = new ArrayList<>();
        for (String record : records) {
            try {
                Map<Keys, Object> result = new HashMap<>();
                String[] list = record.split(" ");
                this.nameFile = list[0];
                result.put(Keys.USERNAME, list[1]);
                result.put(Keys.FIO,
                        fioCheck.capitilizeString(list[2]) + " " +
                                fioCheck.capitilizeString(list[3]) + " " +
                                fioCheck.capitilizeString(list[4]));
                result.put(Keys.DATE, dateCheck.convertStringToTimeStamp(list[5]));
                result.put(Keys.APPLICATION, appCheck.checkApplication(list[6]));
                parseRecords.add(result);
                System.out.println(list[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                //Если не хватает данных, то заносим данные в лог
                errorRecord(e.toString());
            } catch (IllegalArgumentException | ParseException e) {
                errorRecord(e.toString());
            }

        }
        return parseRecords;
    }

    @Loggable
    private void errorRecord(String exception) {
        System.out.println("Ошибка во время разбора записи из файла: " + this.nameFile
                + " " + exception);
    }

}
