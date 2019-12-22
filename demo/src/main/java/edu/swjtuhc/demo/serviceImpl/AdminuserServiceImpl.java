package edu.swjtuhc.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.demo.mapper.AdminuserDao;
import edu.swjtuhc.demo.mapper.RuserDao;
import edu.swjtuhc.demo.mapper.TuserDao;
import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Ruser;
import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.service.AdminuserService;

@Service
public class AdminuserServiceImpl implements AdminuserService {
	@Autowired
    private AdminuserDao adminuserdao;
   
//	public boolean registUser(String username,String password) {
//		boolean isFlag = checkUsernameExists(username);
//		if (isFlag):
//			this.inserUserString (username,password);
//	}
 
    public boolean inserUser(String aname, String apassword) {
         adminuserdao.inserUser(aname,apassword);
         return true;
    }
 
   
	public AdminUser selectadminUser(String aname, String apassword) {
		// TODO Auto-generated method stub
		System.out.println(aname+" "+aname);
        return adminuserdao.selectadminUser(aname,apassword);
        
	}

	public boolean chkUsrNameExists(String username) {
		List<AdminUser> list = adminuserdao.queryUserByUsername(username);
		if(list.size()==0)
			return true;
		else {
			return false;
		}
	}
	
}
