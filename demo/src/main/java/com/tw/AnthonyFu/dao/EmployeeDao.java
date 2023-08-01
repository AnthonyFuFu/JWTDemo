package com.tw.AnthonyFu.dao;

import java.util.List;

import com.tw.AnthonyFu.model.Employee;

public interface EmployeeDao {
	public List<Employee> list();

	public void save(Employee employee);

	public Employee get(String id);

	public void update(Employee employee);

	public void delete(int id);
}
