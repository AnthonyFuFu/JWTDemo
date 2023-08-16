package com.tw.AnthonyFu.service;

import java.util.List;

import com.tw.AnthonyFu.model.Employee;

public interface EmployeeService {
	public List<Employee> list();

	public void save(Employee employee);

	public Employee get(String id);

	public void update(Employee employee);

	public void delete(int id);
}