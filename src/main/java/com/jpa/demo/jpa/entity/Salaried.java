package com.jpa.demo.jpa.entity;

import javax.persistence.Entity;

@Entity // defines that this bean is being used as an entity

public class Salaried extends Employee {
	private final static double DEFAULT_SALARY = 100000;
	private double salary;
	public Salaried() {
		this(DEFAULT_SALARY);
	}
	public Salaried(double salary){
		super();
		this.salary = salary;
	}
	public Salaried(String name, double salary) {
		super(name);
		this.salary = salary;
	}
	
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		
		return 0;
	}
	@Override
	public double pay() {
		return salary / 24;
	}

}
