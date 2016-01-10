package br.com.exemplo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TesteApplication.class)
@WebAppConfiguration
public class TesteApplicationTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	public void deveAcessarPessoa() throws Exception {
		mvc.perform(get("/pessoa")
				.accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk());
	}

	@Test
	public void deveAddPessoa() throws Exception {
		mvc.perform(post("/pessoa/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(getJson()))
                .andExpect(status().isOk());
	}

	@Test
	public void deveTrazerPessoa() throws Exception {
		mvc.perform(get("/pessoa/findById/2")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void deveTrazerPessoaAll() throws Exception {
		mvc.perform(get("/pessoa/all")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	private String getJson() {
		return "{\n" +
				"  \"id\" : \"1\",\n" +
				"  \"nome\" : \"thiago\",\n" +
				"  \"idade\"  : 29\n" +
				"}";
	}
}
