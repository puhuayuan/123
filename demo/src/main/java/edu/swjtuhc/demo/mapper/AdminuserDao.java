package edu.swjtuhc.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Tuser;
@Mapper
public interface AdminuserDao {
	public AdminUser selectadminUser(String aname,String apassword);

	public void inserUser(String aname, String apassword);

	public List<AdminUser> queryUserByUsername(String username);

	


	
	
}
