package com.flight.network.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.flight.network.ExceptionLogger;
import com.flight.network.beans.CSVBean;
import com.flight.network.dao.DiscountServiceDao;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Repository
public class DiscountServiceDaoImpl implements DiscountServiceDao {

	private static final Logger LOGGER = LogManager.getLogger(DiscountServiceDaoImpl.class);

	@Override
	public List<CSVBean> getCsvData(String userType, double amount) throws ExceptionLogger {
		List<CSVBean> csvRecords = new ArrayList<CSVBean>();
		ClassLoader classLoader = new DiscountServiceDaoImpl().getClass().getClassLoader();

		try {
			File file = new File(classLoader.getResource("discount.csv").getFile());
			FileReader filereader = new FileReader(file);
			String[] nextRecord;

			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();

			while ((nextRecord = csvReader.readNext()) != null) {
				CSVBean csvBean = new CSVBean();
				if (userType.equals(nextRecord[0]) && amount > Double.parseDouble(nextRecord[1])) {
					csvBean.setUserType(userType);
					csvBean.setStart(Double.parseDouble(nextRecord[1]));
					csvBean.setEnd(Double.parseDouble(nextRecord[2]));
					csvBean.setDiscountPer(Double.parseDouble(nextRecord[3]));
					csvRecords.add(csvBean);
				}
			}
			csvReader.close();
		} catch (IOException | NumberFormatException e) {
			LOGGER.error(e.getMessage());
			throw new ExceptionLogger(e.getMessage()); 
		}

		return csvRecords;
	}

}
