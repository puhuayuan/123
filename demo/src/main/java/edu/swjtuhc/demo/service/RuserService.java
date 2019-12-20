package edu.swjtuhc.demo.service;

import edu.swjtuhc.demo.model.Ruser;

public interface RuserService {
	
	public boolean inserUser(String username,String password);
	 
    public Ruser selectUser(String username,String password);
}
