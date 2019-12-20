package edu.swjtuhc.demo.service;

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Ruser;

public interface AdminuserService {
	public boolean inserUser(String aname,String apassword);
	 
    public AdminUser selectadminUser(String aname,String apassword);
}
