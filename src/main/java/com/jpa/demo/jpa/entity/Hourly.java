package com.jpa.demo.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Hourly extends Employee {
	private final static double DEFAULT_HOURLY_RATE = 27;
	private double hourlyRate;
	public Hourly() {
		this(DEFAULT_HOURLY_RATE);
	}
	public Hourly(double hourlyRate){
		super();
		this.hourlyRate = hourlyRate;
	}
	public Hourly(String name, double hourlyRate) {
		super(name);
		this.hourlyRate = hourlyRate;
	}
	
	
	public void sethourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public double gethourlyRate() {
		
		return 0;
	}
	@Override
	public double pay() {
		return hourlyRate * 80;
	}
}
