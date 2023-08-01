package com.tw.AnthonyFu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.tw.AnthonyFu.dao.EmployeeDao;
import com.tw.AnthonyFu.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// 查詢所有員工(shows欄位為0的才顯示)
	public List<Employee> list() {
		String sql = "select employee_id, employee_name, employee_email, employee_gender, employee_department, employee_birth, employee_shows from employee;";
		List<Employee> listemployees = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		return listemployees;
	}

	// 新增員工
	public void save(Employee employee) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("employee").usingColumns("employee_name", "employee_email", "employee_gender",
				"employee_department", "employee_birth");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		insertActor.execute(param);
	}

	// 查詢單個員工(回顯)
	public Employee get(String id) {
		String sql = "select * from employee where employee_id = ?";
		Object[] args = { id };
		Employee employee = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class), args);
		return employee;
	}

	// 更新員工信息
	public void update(Employee employee) {
		String sql = "UPDATE employee SET employee_name=:employee_name, employee_email=:employee_email, employee_gender=:employee_gender, employee_department=:employee_department, employee_birth=:employee_birth WHERE employee_id=:employee_id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	// 刪除員工(不會真的刪除，更改shows欄位，不顯示)
	public void delete(int id) {
		String sql = "UPDATE employee SET employee_shows=1 WHERE employee_id=?";
		jdbcTemplate.update(sql, id);
	}
}
