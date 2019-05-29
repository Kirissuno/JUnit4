package com.impl;

import com.interfaces.CalculatorService;
import com.interfaces.DataService;

public class CalculatorServiceImpl implements CalculatorService {

	private DataService dataservice;
	
	@Override
	public double calculateAverage() {
		int [] numbers = dataservice.getListOfNumbers();
		double avg = 0;
		for (int i : numbers) {
			avg+=i;
		}
		return  (numbers.length > 0) ? avg / numbers.length : 0;
	}
	
	public void setDataService(DataService data) {
		this.dataservice = data;
	}
	
}
