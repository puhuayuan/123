package edu.swjtuhc.demo.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.swjtuhc.demo.mapper.TuserDao;
import edu.swjtuhc.demo.model.News;
import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.service.TuserService;


@Service
public class TuserServiceImpl implements TuserService{
	@Autowired
     TuserDao tuserDao;

    public List<Tuser> getListUser(){
        return tuserDao.queryUser();
    }

    public void deleteUser(int userId){
        tuserDao.deleteUser(userId);
    }

    public void insertUser(Tuser user) {
         tuserDao.insertUser(user);
    }

    public Tuser getUserId(int userId){
        return tuserDao.getUserId(userId);
    }

    public void updateUser(Tuser tuser){
         tuserDao.updateUser(tuser);
    }

    public List<Tuser> getUserName (String userName){
        return tuserDao.getUserName(userName);
    }

    public int countUser(){
    	return tuserDao.countUser();
    	}

    public Tuser Login(String userName,String passWord){
        return tuserDao.userLogin(userName,passWord);
    }

    public List<Tuser> findUserByPage(){
        List<Tuser> allUser = tuserDao.queryUser();//全部商品
        return allUser;
    }

	public List<News> getAlluser() {
		// TODO Auto-generated method stub
		return tuserDao.getAlluser();
	}

	




}
