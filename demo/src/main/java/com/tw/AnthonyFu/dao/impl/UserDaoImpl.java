package com.tw.AnthonyFu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tw.AnthonyFu.dao.UserDao;
import com.tw.AnthonyFu.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public User login(User user) {
		Object args[] = new Object[2];
		args[0] = user.getMember_name();
		args[1] = user.getMember_password();
		try {
			String sql = "select member_id, member_name, member_password from member where member_name = ? and member_password = ?";
			User userData = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), args);
			return userData;
		} catch (Exception e) {
			return null;
		}
	}
}