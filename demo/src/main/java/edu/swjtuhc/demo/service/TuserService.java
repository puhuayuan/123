package edu.swjtuhc.demo.service;

import java.util.List;

import edu.swjtuhc.demo.model.Tuser;

public interface TuserService {
	/**
     * 得到用户列表
     * @return
     */
    List<Tuser> getListUser();

    /**
     * 删除用户
     * @param userId
     * @return
     */
    void deleteUser(int userId);

    void insertUser(Tuser user);

    Tuser getUserId(int userId);

    void updateUser(Tuser user);

    List<Tuser> getUserName (String userName);

    Tuser Login(String userName,String passWord);

    int countUser();

    List<Tuser> findUserByPage();


}
