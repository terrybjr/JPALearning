package com.jpa.demo.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.demo.jpa.entity.Employee;
@Repository // indicates to spring that this bean is a repo
@Transactional // lets us actually manipulate the data
public class EmployeeRepo {
	
	@Autowired
	EntityManager em;
	
	// find by id
	public Employee findByID(long id) {
		return em.find(Employee.class, id);
	}
	// save employee
	public Employee save(Employee employee) {
		if(employee.getId() == null) {
			// new employee
			em.persist(employee);
		} else {
			// updated employee
			em.merge(employee);
		}
		return employee;
	}
	// delete by id
	
	// retrieve all
	public List<Employee> findAll() {
		TypedQuery<Employee> namedQuery = em.createNamedQuery("find_all_employees", Employee.class);
		return namedQuery.getResultList();
	}
}
