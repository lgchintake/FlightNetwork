package com.flight.network.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.flight.network.utility.AbstractTest;

public class DiscountServiceControllerTest extends AbstractTest{

	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	
	@Test
	public void getDiscountTest() throws Exception {
		String uri = "/discount/Premium/3500";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.equals("Final discounted amount is: 3050.0"));
	}
}
