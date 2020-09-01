package edu.psu.sweng861;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	AppController appController;
	
	
	@Before
	public void setUp() throws Exception {
		mockMvc.MockMvcBuilders.standAloneSetup(appController).build();
	}

	@Test
	public void test() {
		
	}

}
