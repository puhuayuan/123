package edu.swjtuhc.demo.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.service.RuserService;
import edu.swjtuhc.demo.serviceImpl.RuserServiceImpl;

@RequestMapping("/zou")
@Controller
public class RuserController {
	 @Autowired
	    private RuserServiceImpl ruserserviceimpl;
	 
	    @RequestMapping("/login")
	    public String login(){
	        return "login";
	    }
	 
	    @RequestMapping("/regist")
	    public String regist(){
	        return "regist";
	    }
	    @RequestMapping(value = "/dologin",method = RequestMethod.GET)
	    @ResponseBody
	    public String doLogin(Tuser tuser,Map<String,Object> map){
	        Tuser user1 = ruserserviceimpl.selectUser(tuser.getUserName(),tuser.getPassWord());
	        System.out.print(user1);
	         if(user1==null){
	             map.put("msg", "密码或账号错误!");
	            return "fail";
	         }else {
	             map.put("msg", "登入成功");
	             return "success";
	         }
	    }
	    @RequestMapping(value = "/doregist",method = RequestMethod.GET)
	    @ResponseBody
	    public String doRegist(Tuser tuser,Map<String,Object> map) {
	    	boolean flag = ruserserviceimpl.chkUsrNameExists(tuser.getUserName());
	    	if (flag) {
	    		ruserserviceimpl.inserUser(tuser.getUserName(), tuser.getPassWord());
	  	      
		        map.put("msg","注册成功");
		        return "success";
			}else {
				return "用户名重复，请重新输入";
			}
	        
	    }
	    

	    
	
}
