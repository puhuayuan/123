package edu.swjtuhc.demo.service;

import java.util.List;

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.User;
import edu.swjtuhc.demo.model.UserInfo;

public interface UserService {
	 /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return UserInfo 用户信息
     */
    public UserInfo login(String userName,String password);

    /**
     * 用户注册
     * @param userName 用户名
     * @param password 密码
     */
    public  void  register(String userName,String password);


	public  AdminUser adminlogin(String Aname,String Apassword);
	
	public  AdminUser adminregister(String Aname,String Apassword);
}
