package com.verizon.sba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.sba.TestUtil.TestUtil;
import com.verizon.sba.model.Order;
import com.verizon.sba.restapi.OrderApi;
import com.verizon.sba.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrderApi.class)
public class OrderApiTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private OrderService orderServiceMock;
	

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}

	
	
	@Test
	public void testGetOrderById() throws Exception {
		assertThat(this.orderServiceMock).isNotNull();
		int orderId = 7;
	

		Order order=new Order();
		order.setTitle("T40");
		order.setTimeSlot("1PM-3PM");
		order.setOrderId(orderId);
		order.setName("Kushal");
		order.setMobileNumber("9129064310");
		order.setDateOfRequest(LocalDate.of(2018, 10, 25));
		order.setAddress("SRT 953 Sanathnagar");
		when(orderServiceMock.getOrderById(orderId)).thenReturn(order);

		mockMvc.perform(get("/order/7")).andExpect(status().isOk()).andDo(print());

	}
	@Test
	public void testAddOrder() throws Exception {
		assertThat(this.orderServiceMock).isNotNull();

		Order order = new Order();

		
		order.setTitle("T40");
		order.setTimeSlot("1PM-3PM");
		
		order.setName("Kushal");
		order.setMobileNumber("9129064310");
		
		order.setAddress("SRT 953 Sanathnagar");


		Order ordernew = new Order();

		
		ordernew.setTitle("T40");
		ordernew.setTimeSlot("1PM-3PM");
		ordernew.setOrderId(7);
		ordernew.setName("Kushal");
		ordernew.setMobileNumber("9129064310");
		
		ordernew.setAddress("SRT 953 Sanathnagar");

		

		when(orderServiceMock.addOrder(Mockito.any(Order.class))).thenReturn(ordernew);

		mockMvc.perform(post("/order").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(order))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

	}

}
