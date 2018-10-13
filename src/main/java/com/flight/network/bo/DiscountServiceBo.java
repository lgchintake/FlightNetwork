package com.flight.network.bo;

public interface DiscountServiceBo {

	double getDiscount(String userType, double amount) throws Exception;

}
