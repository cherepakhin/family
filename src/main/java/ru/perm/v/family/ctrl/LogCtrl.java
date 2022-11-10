package ru.perm.v.family.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.family.ctrl.exception.InternalException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * REST Контроллер получения логов
 */
@RestController
@Slf4j
public class LogCtrl {

    // Каталог микросервиса
    @Value("${user.dir}")
    String basedir;

    /**
     * Получение протокола работы
     *
     * @return содержимое файла
     * @throws IOException файл не найден
     */
    @GetMapping(value = {"/log"})
    public String getLog() {
        String pathFileLog = basedir + File.separator + "log/app.log";
        File current = new File(pathFileLog);
        log.info("Reading log: " + current.getAbsolutePath());
        String logContent = "";
        try {
            logContent = new String(Files.readAllBytes(current.toPath()));
        } catch (Exception e) {
            throw new InternalException("Error reading log file: " + pathFileLog);
        }
        return logContent;
    }
}
