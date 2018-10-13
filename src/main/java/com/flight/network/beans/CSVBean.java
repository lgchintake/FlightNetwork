package com.flight.network.beans;

public class CSVBean {

	String userType;
	double start;
	double end;
	double discountPer;

	public CSVBean() {

	}

	public CSVBean(String userType, double start, double end, double discountPer) {
		this.userType = userType;
		this.start = start;
		this.end = end;
		this.discountPer = discountPer;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public double getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(double discountPer) {
		this.discountPer = discountPer;
	}

	@Override
	public String toString() {
		return "CSVBean [userType=" + userType + ", start=" + start + ", end=" + end + ", discountPer=" + discountPer
				+ "]";
	}
}
