package com.citi.module;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.citi.module.controller.CitiController;
import com.citi.module.service.CitiServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityApplicationTests {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private CitiController citiController;
	
	@Autowired
	CitiServiceImpl citiService;
	
	@Mock
	CitiServiceImpl mockCitiService;
	
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(citiController).build();
	}
	
	@Test
	public void testCitiController() throws Exception {
		when(mockCitiService.verifyCitiesConnected("Boston", "New York")).thenReturn("Yes");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/connected")
				.param("origin", "Boston")
				.param("destination", "New York")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getCitiNameTest() {
		String connected = citiService.verifyCitiesConnected("Boston", "New York");
		assertEquals(connected, "Yes");
	}
	
	@Test
	public void getCitiNameNotPresent1Test() {
		String connected = citiService.verifyCitiesConnected("Boston", "Boston");
		assertEquals(connected, "Yes");
	}
	@Test
	public void getCitiNameNotPresent2Test() {
		String connected = citiService.verifyCitiesConnected("New York", "New York");
		assertEquals(connected, "Yes");
	}
	@Test
	public void getCitiNameNotPresent3Test() {
		String connected = citiService.verifyCitiesConnected("AA", "BB");
		assertEquals(connected, "No");
	}
	
	@Test
	public void getCitiNameNotPresent4Test() {
		String connected = citiService.verifyCitiesConnected("New York", "XXX");
		assertEquals(connected, "No");
	}
	

}
