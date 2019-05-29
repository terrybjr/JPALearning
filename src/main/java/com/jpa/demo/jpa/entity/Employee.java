package com.jpa.demo.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
//import javax.persistence.MappedSuperclass;
@Entity
@NamedQuery(name="find_all_employees", query = "select e from Employee e")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {
	static String DEFAULT_NAME = "Unknown";
	public Employee() {
		this(DEFAULT_NAME);
	}
	public Employee(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract double pay();
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
