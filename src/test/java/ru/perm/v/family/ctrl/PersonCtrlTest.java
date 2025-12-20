package ru.perm.v.family.ctrl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.perm.v.family.service.PersonService;

import lombok.val;
import ru.perm.v.family.dto.PersonDto;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.service.PersonService;

import java.util.List;

@AutoConfigureMockMvc
//@ContextConfiguration(classes = {PersonCtrl.class, PersonService.class})
@WebMvcTest
class PersonCtrlTest {

    private final String urlPerson = "/person";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @Test
    void echo() throws Exception {
        String mes = "aaa";
        MvcResult result = mockMvc.perform(get( urlPerson + "/echo/" + mes)
            .contentType(MediaType.TEXT_PLAIN)
            .accept(MediaType.ALL))
            .andExpect(status().isOk())
            .andReturn();
        String res = result.getResponse().getContentAsString();
        assertEquals(mes, res);
    }

    @Test
    void getById() throws Exception {
        Long ID = 100L;
        String NAME = "name";
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(ID);
        personEntity.setName(NAME);
        when(personService.getById(100L)).thenReturn(personEntity);

        MvcResult result = mockMvc.perform(get(urlPerson + "/id/" + ID))
                .andExpect(status().isOk())
                .andReturn();
        PersonDto personDto = new ObjectMapper().readValue(result.getResponse().getContentAsString(), PersonDto.class);

        assertEquals(new PersonDto(ID, NAME), personDto);
    }
}
