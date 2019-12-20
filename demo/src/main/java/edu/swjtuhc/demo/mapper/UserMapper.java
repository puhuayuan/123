package edu.swjtuhc.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.User;
import edu.swjtuhc.demo.model.UserInfo;

@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(String pkUserId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String pkUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 
     * 通过用户名与密码查询用户信息
     * @param record
     * @return
     */
    public UserInfo selectByNameAndPwd(User record);

	AdminUser selectByAdminUserNameAndPwd(String Aname,String Apassword);

	AdminUser inseradminUser(String Aname, String Apassword);

	
}
