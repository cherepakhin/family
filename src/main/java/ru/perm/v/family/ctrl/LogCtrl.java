package ru.perm.v.family.ctrl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @param path путь к файлу логов
     * @return содержимое файла
     * @throws IOException файл не найден
     */
    @GetMapping(value = {"/log"})
    public String getLog(
        @RequestParam(name = "path", defaultValue = "log/app.log") String path)
        throws IOException {
        File current = new File(basedir + File.separator + path);
        log.info(current.getAbsolutePath());
        return new String(Files.readAllBytes(current.toPath()));
    }
}
