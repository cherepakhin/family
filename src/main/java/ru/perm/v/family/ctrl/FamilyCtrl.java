package ru.perm.v.family.ctrl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер семьи
 */
@RestController
@RequestMapping("/family")
@Slf4j
@Validated
@AllArgsConstructor
public class FamilyCtrl {
    /**
     * Эхо контроллер для теста
     *
     * @param mes сообщение для теста. Любая строка.
     * @return принятое сообщение
     */
    @GetMapping("/echo/{mes}")
    public String echo(@PathVariable String mes) {
        log.info("Request \"echo\" received: {}", mes);
        return mes;
    }
}
