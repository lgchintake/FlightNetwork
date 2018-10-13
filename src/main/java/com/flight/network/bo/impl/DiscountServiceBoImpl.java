package com.flight.network.bo.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.network.ExceptionLogger;
import com.flight.network.beans.CSVBean;
import com.flight.network.bo.DiscountServiceBo;
import com.flight.network.dao.DiscountServiceDao;

@Service
public class DiscountServiceBoImpl implements DiscountServiceBo{
	
	private static final Logger LOGGER = LogManager.getLogger(DiscountServiceBoImpl.class);

	@Autowired
	DiscountServiceDao discountServiceDao;
	
	@Override
	public double getDiscount(String userType, double amount) throws ExceptionLogger {
		List<CSVBean> csvData = discountServiceDao.getCsvData(userType, amount);
		double discountAmount = 0;
		for(CSVBean csv: csvData) {
			LOGGER.info(csv);
			double slabDiscountAmount = 0;
			if(amount >= csv.getEnd()) {
				slabDiscountAmount = csv.getEnd() - csv.getStart();
			} else {
				slabDiscountAmount = amount - csv.getStart();				
			}
			LOGGER.debug("Discounted value per slab is: ", slabDiscountAmount * csv.getDiscountPer()/100);
			discountAmount = discountAmount + (slabDiscountAmount * csv.getDiscountPer()/100);
		}
		return amount - discountAmount;
	}
}
