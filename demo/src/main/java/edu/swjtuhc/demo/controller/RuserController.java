package edu.swjtuhc.demo.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.service.RuserService;
import edu.swjtuhc.demo.serviceImpl.RuserServiceImpl;
import net.sf.json.JSONObject;

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
	    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
	    @ResponseBody
	    public JSONObject doLogin(@RequestBody Tuser tuser){
	    	JSONObject result=new JSONObject();
	        Tuser user1 = ruserserviceimpl.selectUser(tuser.getUserName(),tuser.getPassWord());
	        System.out.print(user1);
	         if(user1==null){
	             result.put("msg","");
	            return result;
	         }else {
	             result.put("msg", "登入成功");
	             return result;
	         }
	    }
	    @RequestMapping(value = "/doregist",method = RequestMethod.POST)
	    @ResponseBody
	    public Map doRegist(@RequestBody Tuser tuser) {
	    	boolean flag = ruserserviceimpl.chkUsrNameExists(tuser.getUserName());
            Map result=new HashedMap();
	    	if (flag) {
	    		
	    		ruserserviceimpl.inserUser(tuser.getUserName(), tuser.getPassWord());
	  	      
		        result.put("msg","注册成功");
		        return result;
			}else {
				result.put("msg","用户名重复，请重新输入");
		        return result;
				
			}
//	        
//	    	Map result = new HashedMap();
//	    	int i=ruserserviceimpl.register(tuser);
//	    	result.put("state", String.valueOf(i));
//			return result.toString();
	    }
	    

	    
	
}
