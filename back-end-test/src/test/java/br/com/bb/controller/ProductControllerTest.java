package br.com.bb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.bb.Application;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProductControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    public void listByCategoryAlimentos() throws Exception {
        mockMvc.perform(get("/product/listByCategory/1"))
        	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$", hasSize(2)))
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].name", is("Arroz")))
	        .andExpect(jsonPath("$[1].id", is(2)))
	        .andExpect(jsonPath("$[1].name", is("Feijão")));
    }

	@Test
	public void listByCategoryEletrodomésticos() throws Exception {
		mockMvc.perform(get("/product/listByCategory/2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].id", is(3)))
		.andExpect(jsonPath("$[0].name", is("Aspirador de pó")))
		.andExpect(jsonPath("$[1].id", is(4)))
		.andExpect(jsonPath("$[1].name", is("Batedeira")))
		.andExpect(jsonPath("$[2].id", is(5)))
		.andExpect(jsonPath("$[2].name", is("Liquidificador")));
	}

	@Test
	public void listByCategoryMóveis() throws Exception {
		mockMvc.perform(get("/product/listByCategory/3"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].id", is(6)))
		.andExpect(jsonPath("$[0].name", is("Sofá")))
		.andExpect(jsonPath("$[1].id", is(7)))
		.andExpect(jsonPath("$[1].name", is("Mesa")))
		.andExpect(jsonPath("$[2].id", is(8)))
		.andExpect(jsonPath("$[2].name", is("Estante")));
	}
	
	@Test
	public void findAvgPriceValue() throws Exception {
		mockMvc.perform(get("/product/findAvgPriceValue"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is(293.36125)));
	}
	
	@Test
    public void listByCategoryAlimentosPrices() throws Exception {
        mockMvc.perform(get("/product/listByCategory/1"))
        	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$", hasSize(2)))
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].name", is("Arroz")))
	        .andExpect(jsonPath("$[0].value", is(12.9)))
	        .andExpect(jsonPath("$[1].id", is(2)))
	        .andExpect(jsonPath("$[1].name", is("Feijão")))
        	.andExpect(jsonPath("$[1].value", is(7.89)));
    }
	
	@Test
	public void listByCategoryEletrodomésticosPrices() throws Exception {
		mockMvc.perform(get("/product/listByCategory/2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].id", is(3)))
		.andExpect(jsonPath("$[0].name", is("Aspirador de pó")))
		.andExpect(jsonPath("$[0].value", is(337.80)))
		.andExpect(jsonPath("$[1].id", is(4)))
		.andExpect(jsonPath("$[1].name", is("Batedeira")))
		.andExpect(jsonPath("$[1].value", is(145.9)))
		.andExpect(jsonPath("$[2].id", is(5)))
		.andExpect(jsonPath("$[2].name", is("Liquidificador")))
		.andExpect(jsonPath("$[2].value", is(229.9)));
	}
	
	@Test
	public void listByCategoryMóveisPrices() throws Exception {
		mockMvc.perform(get("/product/listByCategory/3"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].id", is(6)))
		.andExpect(jsonPath("$[0].name", is("Sofá")))
		.andExpect(jsonPath("$[0].value", is(782.5)))
		.andExpect(jsonPath("$[1].id", is(7)))
		.andExpect(jsonPath("$[1].name", is("Mesa")))
		.andExpect(jsonPath("$[1].value", is(500.0)))
		.andExpect(jsonPath("$[2].id", is(8)))
		.andExpect(jsonPath("$[2].name", is("Estante")))
		.andExpect(jsonPath("$[2].value", is(330.0)));
	}
	
}
