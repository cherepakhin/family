package ru.perm.v.family.ctrl;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import ru.perm.v.family.ctrl.exception.InternalException;

@RestController("/echo")
public class EchoCtrl {
    final Logger logger = Logger.getLogger(EchoCtrl.class.getName());

    @GetMapping("/{msg}")
    @ApiOperation(value = "Test controller", notes = "Echo")
    public String echo(@PathVariable(name = "msg", required = true) String msg) {
        if(msg.length() > 10) {
            throw new InternalException("Message too long");
        }
        logger.info("EchoCtrl.echo: " + msg);
        return msg;
    }
}
