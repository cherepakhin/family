package ru.perm.v.family.ctrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {FamilyCtrl.class})
@WebMvcTest
public class FamilyCtrlTest {

    @Autowired
    private MockMvc mockMvc;
    private final String root = "/family";

    @Test
    void echo() throws Exception {
        String mes = "aaa";
        MvcResult result = mockMvc.perform(get(root + "/echo/" + mes)
                        .contentType(MediaType.TEXT_PLAIN)
                        .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andReturn();
        String res = result.getResponse().getContentAsString();
        assertEquals(mes, res);
    }
}
