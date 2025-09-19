package ru.perm.v.family.ctrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EchoCtrl.class)
@ContextConfiguration(classes = { EchoCtrl.class })
public class EchoCtrlMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEcho() throws Exception {
        mockMvc.perform(get("/message"))
                .andExpect(status().isOk())
                .andExpect(content().string("message"));
    }

    @Test
    public void bigLengthMessageCheckStatus() throws Exception {
        // lenght message more 10
        String message = "12345678901";

        mockMvc.perform(get("/" + message)).andExpect(status().isInternalServerError());
    }
}
