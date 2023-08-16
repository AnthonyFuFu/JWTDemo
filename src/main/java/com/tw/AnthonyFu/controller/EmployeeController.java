package com.tw.AnthonyFu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggerGroups;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.tw.AnthonyFu.model.Employee;
import com.tw.AnthonyFu.service.EmployeeService;
import com.tw.AnthonyFu.utils.JWTUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "員工控制器")
public class EmployeeController {
	private final org.slf4j.Logger log = LoggerFactory.getLogger(LoggerGroups.class);
	@Autowired
	EmployeeService employeeService;

	// 查詢所有員工返回列表頁面 
	@ApiOperation(value = "查詢所有員工", httpMethod = "GET", notes = "進行查詢所有員工")
	@GetMapping("/emps")
	public ResponseEntity<?> list(HttpServletRequest request) {
		//取Header的Token出來
		List<Employee> listemail = employeeService.list();
		String autBearertoken = request.getHeader("AUTHORIZATION");
		String trimtoken = autBearertoken.replace("Bearer", "");
		String token = trimtoken.trim();
		//解除加密
		DecodedJWT verify = JWTUtils.verify(token);
		//記錄在log
		log.info("用戶id:[{}]", verify.getClaim("id").asString());
		log.info("用戶name:[{}]", verify.getClaim("name").asString());
		return new ResponseEntity<Object>(listemail, HttpStatus.OK);
	}

	// 員工添加 
	@PostMapping("/emp")
	@ApiOperation(value = "新增員工", httpMethod = "POST", notes = "進行新增員工 時間格式:2022-07-11")
	// SpringMVC自動將參數和入參對象的屬性進行一一綁定;要求了請求參數的名字和javaBean入參的對象裡面的屬性名是一樣的 
	public ResponseEntity<?> addEmp(@RequestBody Employee employee) {
		System.out.println("保存的員工信息:" + employee);
		// 保存員工 
		employeeService.save(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//員工修改
	@PutMapping("/empput")
	@ApiOperation(value = "員工修改頁面", httpMethod = "PUT", notes = "這邊進行修改 並要提交員工ID")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		// @RequestBody Employee employee 轉Javabean
		// @RequestBody String employee 取JSON對象
		// @RequestBody List<Employee> employee 取JSON數組
		System.out.println("修改的員工數據:" + employee);
		// for(Employee employeelist:list){ 
		//         System.out.println(employeelist); 
		//     } 
		// System.out.println(employee.get(0).getName()); 
		employeeService.update(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// 員工刪除 (不會真的刪除)
	@DeleteMapping("/emp/{id}")
	@ApiOperation(value = "員工刪除頁面", httpMethod = "DELETE", notes = "進行員工刪除用ID進行之後會改成假刪除")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
