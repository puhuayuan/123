package edu.swjtuhc.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.demo.model.Ruser;
@Mapper
public interface RuserDao {
	public void inserUser(String username,String password);
	 
	   public Ruser selectUser(String username,String password);
	   

}
