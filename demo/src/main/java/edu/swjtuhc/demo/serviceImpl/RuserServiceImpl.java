package edu.swjtuhc.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.demo.mapper.RuserDao;
import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Ruser;
import edu.swjtuhc.demo.service.RuserService;


@Service
public class RuserServiceImpl implements RuserService{
	@Autowired
    private RuserDao ruserdao;
 
//	public boolean registUser(String username,String password) {
//		boolean isFlag = checkUsernameExists(username);
//		if (isFlag):
//			this.inserUserString (username,password);
//	}
 
    public boolean inserUser(String username, String password) {
         ruserdao.inserUser(username,password);
         return true;
    }
 
    public Ruser selectUser(String username,String password) {
        
        System.out.println(username+" "+username);
        return ruserdao.selectUser(username,password);
        
    }
    
}
