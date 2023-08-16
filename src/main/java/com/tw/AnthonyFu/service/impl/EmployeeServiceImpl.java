package com.tw.AnthonyFu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.AnthonyFu.dao.EmployeeDao;
import com.tw.AnthonyFu.model.Employee;
import com.tw.AnthonyFu.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> list() {
		return employeeDao.list();
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public Employee get(String id) {
		return employeeDao.get(id);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
	}
}