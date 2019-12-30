package edu.swjtuhc.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import edu.swjtuhc.demo.model.Tuser;
@Mapper
public interface RuserDao {
	public void inserUser(String userName,String passWord);
	 
	   public Tuser selectUser(String userName,String passWord);

	public List<Tuser> queryUserByUsername(String userName);
//	   public Tuser selectUserByUsername(String userName);
//	   public int insertTuser(Tuser tuser);

	
}