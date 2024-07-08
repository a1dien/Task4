package inno.edu;

import inno.edu.services.SaveComp;
import inno.edu.services.FileService;
import inno.edu.services.Keys;
import inno.edu.services.ParseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class Logic implements ApplicationRunner {
    @Autowired
    private FileService fileService;

    @Autowired
    private ParseRecordService parseRecordService;

    @Autowired
    private SaveComp saveComp;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Получили список строк разделенных переводом строки из всех файлов
        List<String> records = fileService.readDir();
        //Причесали данные и разложили в список Maps
        List<Map<Keys, Object>> recordsMap = parseRecordService.parseString(records);
        //Сохранили в базу
        saveComp.save(recordsMap);
    }
}
