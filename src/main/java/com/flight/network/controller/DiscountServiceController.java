package com.flight.network.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.network.bo.DiscountServiceBo;

@Controller
public class DiscountServiceController {
	private static final Logger LOGGER = LogManager.getLogger(DiscountServiceController.class);
	
	@Autowired
	DiscountServiceBo disocuntServiceBo;
	
	@GetMapping("/discount/{userType}/{amount}")
	@ResponseBody
	public String getDiscount(@PathVariable("userType") String userType, @PathVariable("amount") double amount) {
		String finalMessage;
		try {
			double finalDiscountedAmount = disocuntServiceBo.getDiscount(userType, amount);
			LOGGER.info("Final discounted amount is: "+finalDiscountedAmount);
			finalMessage = "Final discounted amount is: "+finalDiscountedAmount;
		} catch (Exception e) {
			LOGGER.error("Unable to process user request internal error");
			finalMessage = "Unable to process user request due to internal error, come back after some time";
		}
		return finalMessage;
	}
}
