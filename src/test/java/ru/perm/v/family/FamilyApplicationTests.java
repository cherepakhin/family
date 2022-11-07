package ru.perm.v.family;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.perm.v.family.ctrl.FamilyCtrl;

import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest
class FamilyApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
