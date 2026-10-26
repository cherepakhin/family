package ru.perm.v.family.ctrl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.perm.v.family.service.PersonService;

import ru.perm.v.family.dto.PersonDto;
import ru.perm.v.family.entity.PersonEntity;

@AutoConfigureMockMvc
// тесты работают и без ContextConfiguration
// Замена @SpringBootTest на @ContextConfiguration:
// Это позволяет загружать только необходимую конфигурацию для тестов.
@ContextConfiguration(classes = {PersonCtrl.class, PersonService.class})
@WebMvcTest
class PersonCtrlMyTest {

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

    // Test with Mockito .thenReturn(personEntity)
    @Test
    void getByIdWithMockitoThenReturn() throws Exception {
        Long ID = 100L;
        String NAME = "name";
        String PHONE = "phone";
        PersonEntity personEntity = new PersonEntity();
        personEntity.setN(ID);
        personEntity.setName(NAME);
        personEntity.setPhone(PHONE);
        Mockito.when(personService.getByN(ID)).thenReturn(personEntity);
        MvcResult result = mockMvc.perform(get(urlPerson + "/n/" + ID))
                .andExpect(status().isOk())
                .andReturn();
        PersonDto personDto = new ObjectMapper().readValue(result.getResponse().getContentAsString(), PersonDto.class);

        assertEquals(new PersonDto(ID, NAME, PHONE), personDto);
    }

    // Test with Mockito doReturn(personEntity)...
    @Test
    void getByIdWithMockitoDoReturn() throws Exception {
        Long N = 100L;
        String NAME = "name";
        String PHONE = "phone";
        PersonEntity personEntity = new PersonEntity();
        personEntity.setN(N);
        personEntity.setName(NAME);
        personEntity.setPhone(PHONE);
        doReturn(personEntity).when(personService).getByN(N);
        MvcResult result = mockMvc.perform(get(urlPerson + "/n/" + N))
                .andExpect(status().isOk())
                .andReturn();
        PersonDto personDto = new ObjectMapper().readValue(result.getResponse().getContentAsString(), PersonDto.class);

        assertEquals(new PersonDto(N, NAME, PHONE), personDto);
    }
}
