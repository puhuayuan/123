package edu.swjtuhc.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.demo.mapper.RuserDao;
import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Ruser;
import edu.swjtuhc.demo.model.Tuser;
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
 
    public Tuser selectUser(String userName,String passWord) {
        
        System.out.println(userName+" "+userName);
        return ruserdao.selectUser(userName,passWord);
        
    }

	public boolean chkUsrNameExists(String userName) {
		// TODO Auto-generated method stub
		List<Tuser> list = ruserdao.queryUserByUsername(userName);
		if(list.size()==0)
			return true;
		else {
			return false;
		}
	}
//	 public int register(Tuser tuser) {
//		 
//		  tuser=ruserdao.selectUserByUsername(tuser.getUserName());
//		 int i;
//		 if (tuser==null) {
//			i=ruserdao.insertTuser(tuser);
//		}else {
//			i=2;
//		}
//		return i;
//		 
//	 }

	@Override
	public int register(Tuser tuser) {
		// TODO Auto-generated method stub
		return 1;
	}
    
}
