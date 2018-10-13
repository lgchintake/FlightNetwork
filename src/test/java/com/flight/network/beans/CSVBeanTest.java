package com.flight.network.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CSVBeanTest {

	private CSVBean csvBean;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		csvBean = new CSVBean();
	}

	@Test
	public void CSVBeanGetterSetterTest() {
		csvBean.setDiscountPer(10);
		csvBean.setEnd(3000);
		csvBean.setStart(2000);
		csvBean.setUserType("Standard");
		assertEquals(10.0, csvBean.getDiscountPer(), DELTA);
		assertEquals(3000.0, csvBean.getEnd(), DELTA);
		assertEquals(2000.0, csvBean.getStart(), DELTA);
		assertEquals("Standard", csvBean.getUserType());
	}
	
	@Test
	public void CSVBeanConstructorTest(){
		csvBean = new CSVBean("Preminum", 500, 1000, 20);
		assertEquals("[userType=Premium, start=500.0, end=1000.0, discountPer=20.0]", csvBean.toString());
	}
}
