package edu.swjtuhc.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.swjtuhc.demo.model.News;
import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.serviceImpl.TuserServiceImpl;

@RequestMapping("/show")
@Controller
public class TuserController {
	@Autowired
	 private TuserServiceImpl tuserServiceImpl;
	 
	
	public ModelAndView getIndex(Map<String, Object> map) {
	    List<Tuser> list = new ArrayList<Tuser>();     // 获取区域列表
	    list = tuserServiceImpl.getListUser();
	    map.put("list", list);
	    return new ModelAndView("index3", map);
	}
	@RequestMapping(value = "/queryAlluser", method=RequestMethod.POST)
	@ResponseBody
	public List<News> getAlluser() {
	    
	   List<News> list=new ArrayList<News>();
	    list =  tuserServiceImpl.getAlluser();
	   
	    return list;
	}
	
	/**
	 * 根据用户名得到用户信息
	 * @return 
	 */
	@RequestMapping(value = "/querybyName", method=RequestMethod.POST)
	 @ResponseBody
	public  List<Tuser> getUserName(@RequestParam("userName") String userName) {
	    
	    List<Tuser> list = new ArrayList<Tuser>();
	    list = tuserServiceImpl.getUserName(userName);
	   
	    return list;
	}

	/**
	 * 根据id获取用户信息
	 */
	@RequestMapping(value = "/querybyId", method = RequestMethod.GET)
	@ResponseBody
	public Tuser getUserById(int userId) {
	    Map<String, Object> mm = new HashMap<String, Object>();
	    Tuser tuser =tuserServiceImpl.getUserId(userId);
	    mm.put("user", tuser);
	    return tuser;
	}

	/**
	 * 更新用户
	 */
	@RequestMapping(value = "/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, @RequestParam("userId") int userId) {
	    Tuser tuser = tuserServiceImpl.getUserId(userId);
	    tuser.setUserName(userName);
	    tuser.setPassWord(passWord);
	    tuserServiceImpl.updateUser(tuser);
	    return "success";
	}

	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int userId) {
	    tuserServiceImpl.deleteUser(userId);
	    return userId+"已删除";
	}

	/**
	 * 添加用户
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Tuser save(String userName, String passWord) {
	    Tuser tuser = new Tuser();
	    tuser.setUserName(userName);
	    tuser.setPassWord(passWord);
	    tuserServiceImpl.insertUser(tuser);
	    return tuser;
	}
	
	
	
	
}
