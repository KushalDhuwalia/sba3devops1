package com.verizon.sba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.verizon.sba.model.Plan;
import com.verizon.sba.restapi.Pacakgeapi;
import com.verizon.sba.service.PackageService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Pacakgeapi.class)
public class PackageApiTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private PackageService packServiceMock;
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}
	
	@Test
	public void testGetAllpackages() throws Exception {
		assertThat(this.packServiceMock).isNotNull();

		List<Plan> planList = new ArrayList<>();
		planList.add(new Plan());

		when(packServiceMock.getAllPackages()).thenReturn(planList);

		mockMvc.perform(get("/package")).andExpect(status().isOk()).andDo(print());

	}

	
}
