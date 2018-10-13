package com.flight.network.dao;

import java.util.List;

import com.flight.network.ExceptionLogger;
import com.flight.network.beans.CSVBean;

public interface DiscountServiceDao {

	List<CSVBean> getCsvData(String userType, double amount) throws ExceptionLogger;

}
