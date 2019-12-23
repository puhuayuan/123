package edu.swjtuhc.demo.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.UserInfo;
import edu.swjtuhc.demo.service.UserService;

//json格式数据
//restful 风格


@RequestMapping("/zhou")
@Controller
public class UserController {
	 @Autowired
	    UserService userService;

	    /**
	     * 跳转到登录测试页面
	     * @return 登录页面
	     */
	    @RequestMapping(value = {"user/loginPage"})
	    public String loginHtml(){
	        return "user/login";
	    }

	    /**
	     * 跳转到注册测试页面
	     * @return 注册页面
	     */
	    @RequestMapping(value = {"user/registerPage"})
	    public String registerPage(){
	        return "user/register";
	    }

	    /**
	     * 用户注册
	     */
	    @RequestMapping(value = {"user/register"})
	    @ResponseBody
	    public String register(String userName,String password){
	        //TODO异常处理后续完成
	    	boolean flag = userService.chkUsrNameExists(userName);
	    	if (flag) {
	    		userService.register(userName,password);
		        System.out.println("注册成功");
		        return "注册成功";
			}else {
				return "用戶名重复，请重新输入用户名";
			}
	        
	    }

	    /**
	     * 用户登录
	     */
	    @RequestMapping(value = {"user/login"})
	    @ResponseBody
	    public ArrayList<UserInfo> login(String userName,String password){
	        UserInfo userInfo = userService.login(userName,password);
	        ArrayList list = new ArrayList<>();
	        if(userInfo == null){
	            //TODO异常处理后续完成
	            return null;
	        }else {
	            System.out.println("登录用户信息："+userInfo.toString());
	        }
	        list.add(userInfo);
	        UserInfo userInfo2 = new UserInfo();
	        BeanUtils.copyProperties(userInfo, userInfo2);
	        userInfo2.setUserName(userName);
	        list.add(userInfo2);
	        return list;
	    }
	    /**
	     * 管理员登录
	     */
	    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	    @ResponseBody
	    public ArrayList<AdminUser> adminLogin(String Aname,String Apassword){
	    	AdminUser adminUser=userService.adminlogin( Aname,Apassword);
	    	ArrayList list =new ArrayList();
	    	if(Aname == null){
	            //TODO异常处理后续完成
	            return null;
	        }else {
	            System.out.println("登录用户信息："+adminUser.toString());
	        }
	    	 list.add(adminUser);
	    	 return list;
	    }
	    
	    /**
	     * 管理员注册
	     */
	    @RequestMapping(value = {"user/adminregister"})
	    @ResponseBody
	    public String adminregister(String Aname,String Apassword){
	        //TODO异常处理后续完成
	        userService.adminregister(Aname,Apassword);
	        System.out.println("注册成功");
	        return "注册成功";
	    }
	    
       }
