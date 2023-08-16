package com.tw.AnthonyFu.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggerGroups;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.AnthonyFu.model.User;
import com.tw.AnthonyFu.service.UserService;
import com.tw.AnthonyFu.utils.JWTUtils;

@CrossOrigin
@RestController

public class UserController {
	private final org.slf4j.Logger log = LoggerFactory.getLogger(LoggerGroups.class);
	@Autowired
	private UserService userservice;

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		// 紀錄用戶名和密碼
		log.info("用戶名:[{}]", user.getMember_name());
		log.info("密碼:[{}]", user.getMember_password());
		Map<String, Object> map = new HashMap<>();
		try {
			// 登入成功
			User userdb = userservice.login(user);
			// 放入payload的值
			Map<String, String> pauload = new HashMap<>();
			pauload.put("id", userdb.getMember_id());
			pauload.put("name", userdb.getMember_name());
			// 生成JWT的令牌
			String token = JWTUtils.getToken(pauload);
			// 返回token
			map.put("state", true);
			map.put("msg", "認證成功");
			map.put("token", token);
			// map和狀態碼200返回瀏覽器
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			// 認證失敗
			map.put("state", false);
			map.put("msg", e.getMessage());
			// map和狀態碼401返回瀏覽器
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
	}
}