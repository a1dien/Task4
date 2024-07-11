package inno.edu.services;

import inno.edu.check.AbstractCheck;
import inno.edu.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

@Component
public class ParseRecordService {
    private String nameFile;
    @Autowired
    private CheckService checkService;

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
        //Для каждой строки
        for (String record : records) {
            try {
                //Для каждого слова
                Map<Keys, Object> result = new HashMap<>();
                for (int i = 0; i< countString(record); i++) {
                    for (AbstractCheck check : checkService.getAbstractChecks()) {
                        result.putAll(check.checkString(record));
                    }
                }
            } catch (IllegalArgumentException | ParseException | ArrayIndexOutOfBoundsException e) {
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

    public int countString(String record) {
        String trim = record.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split("\\s+").length;
    }

}
