package inno.edu.services;

import inno.edu.logging.Loggable;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@NoArgsConstructor
public class FileService {
    @Value("${dir.path}")
    private String dirPath;

    public FileService(String dirPath) {
        this.dirPath = dirPath;
    }

    @SneakyThrows
    @Loggable
    public List<String> readDir() {
        List<String> records = new ArrayList<>();
        File folder = new File(dirPath);
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    //Добавляем в начало имя файла, откуда взяли запись
                    //Если будет ошибка при разборе, необходимо логгировать
                    String line = file.getName() + " " + scanner.nextLine();
                    records.add(line);
                }
                scanner.close();
            }
        }
        return records;
    }
}
