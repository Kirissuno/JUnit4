package com.app.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.app.res.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author robfilip
 * Integracion
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonaTest {
	
	@Autowired
	private MockMvc mvc;
	
//	@Ignore
	@Test
	public void testBSelectAll() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.get("/persona")
				.accept(MediaType.APPLICATION_JSON_UTF8))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[*].tlfn").isNotEmpty());
	}
	
//	@Ignore
	@Test
	public void testEBorrar() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders.delete("/persona/{id}", 22) )
	        .andExpect(status().isOk());
	}

	@Test
	@Before
	public void testACrear() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .post("/persona")
	      .content(asJsonString(new Persona("Robert","12312","Arache","22",21,1.7)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.tlfn").exists());
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
		
//	@Ignore
	@Test
	public void testCUpdate() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .put("/persona/{tlfn}", "22")
	      .content(asJsonString(new Persona("Oktay","Conde","22",2,2)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Oktay"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.apellidos").value("Conde"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.tlfn").value("22"));
	}
	
//	@Ignore
	@Test
	public void testDSelect() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/persona/{tlfn}", "22")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
}