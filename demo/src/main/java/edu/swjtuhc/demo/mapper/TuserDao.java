package edu.swjtuhc.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.demo.model.News;
import edu.swjtuhc.demo.model.Tuser;
@Mapper
public interface TuserDao {
	    List<Tuser> queryUser();

	    void deleteUser(int userId);

	    void insertUser(Tuser tuser);

	    Tuser getUserId(int userId);

	    void updateUser(Tuser tuser);

	    List<Tuser> getUserName(String userName);

	    Tuser userLogin(String userName,String passWord);

	    int countUser();

		List<News> getAlluser();

	
}
