package edu.swjtuhc.demo.service;


import edu.swjtuhc.demo.model.Tuser;

public interface RuserService {
	
	public boolean inserUser(String username,String password);
	 
    public Tuser selectUser(String userName,String passWord);
    public int register(Tuser tuser);
}
