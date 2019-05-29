package com.jpa.demo.jpa;

import java.text.NumberFormat;
import java.util.List;

import javax.swing.text.NumberFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.demo.jpa.entity.Employee;
import com.jpa.demo.jpa.entity.Hourly;
import com.jpa.demo.jpa.entity.Salaried;
import com.jpa.demo.jpa.repository.EmployeeRepo;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepo employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Salaried s1 = new Salaried("Brian", 40000);
		Salaried s2 = new Salaried("Shelby", 50000);
		Hourly h1 = new Hourly("Tim", 12);
		Hourly h2 = new Hourly("Linda", 15);
		employeeRepo.save(s1);
		employeeRepo.save(s2);
		employeeRepo.save(h1);
		employeeRepo.save(h2);
		List<Employee> employees = employeeRepo.findAll();
		// in old java
		for (Employee employee : employees) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			System.out.println("Paying " + employee.getName() + " : " + formatter.format(employee.pay()) + "\n");
		}
		// in lambda form
		employees.stream().forEach(e -> System.out.println("Paying " + e.getName() + " : " 
				+ NumberFormat.getCurrencyInstance().format(e.pay()) + "\n"));
		
		
		
	}

}
