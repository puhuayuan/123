package edu.swjtuhc.demo.controller;
//json格式数据
//restful 风格

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.demo.model.SysUser;
import edu.swjtuhc.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
       @RequestMapping("/getAll")
       public List<SysUser> getAll(){
    	
    		   return userService.getAllUsers();
    	   }
       }
