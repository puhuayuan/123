package edu.swjtuhc.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.demo.mapper.UserMapper;
import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.model.User;

import edu.swjtuhc.demo.model.UserInfo;
import edu.swjtuhc.demo.service.UserService;
import edu.swjtuhc.utils.DataUtils;
import edu.swjtuhc.utils.UUIDUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return UserInfo 用户信息
     */
    @Override
    public UserInfo login(String userName, String password){
        if (userName ==null || password == null){
            //TODO异常处理后续完成
            System.out.println("用户名或密码为空！");
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        UserInfo userInfo = userMapper.selectByNameAndPwd(user);
        if (userInfo == null){
            //TODO异常处理后续完成
            System.out.println("用户名或密码错误");
        }
        return userInfo;
    }

    /**
     * 用户注册
     * @param userName 用户名
     * @param password 密码
     */
    @Override
    public  void  register(String userName,String password){
        if (userName ==null || password == null){
            //TODO异常处理后续完成
            System.out.println("用户名或密码为空！");
        }
        
        String pkUserId = UUIDUtils.getPkUUID();
        String uuId = UUIDUtils.getUserUUID();
        Date registerTime = DataUtils.getCurrentDate();
        User user = new User();
        user.setPkUserId(pkUserId);
        user.setUuid(uuId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRegistTime(registerTime);
        int count = 0;
        count = userMapper.insert(user);
        if (count == 0){
            //TODO异常处理后续完成
            System.out.println("新增用户失败");
        }
    }
    @Override
    public  AdminUser adminlogin(String Aname,String Apassword) {
    	 if (Aname ==null || Apassword == null){
             //TODO异常处理后续完成
             System.out.println("用户名或密码为空！");
         }
    	 
    	 AdminUser adminUser=new AdminUser();
    	 adminUser.setAname(Aname);
    	 adminUser.setApassword(Apassword);
		
		 AdminUser adminuser = userMapper.selectByAdminUserNameAndPwd(Aname, Apassword);
	        if (adminuser == null){
	            //TODO异常处理后续完成
	            System.out.println("用户名或密码错误");
	        }
	        return adminuser;
	}
    
    public  AdminUser  adminregister(String Aname,String Apassword){
    	 AdminUser adminuser=new AdminUser();
         adminuser=userMapper.inseradminUser(Aname,Apassword);
              
        return adminuser;
		
}
    public boolean chkUsrNameExists(String userName) {
    	List<User> list = userMapper.queryUserByUsername(userName);
		if(list.size()==0)
			return true;
		else {
			return false;
		}
    }
}