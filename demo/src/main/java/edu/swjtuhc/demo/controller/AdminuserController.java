package edu.swjtuhc.demo.controller;

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

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.serviceImpl.AdminuserServiceImpl;
import edu.swjtuhc.demo.serviceImpl.TuserServiceImpl;
import net.sf.json.JSONObject;

@RequestMapping("/adminuser")
@Controller
public class AdminuserController {
	@Autowired
    private AdminuserServiceImpl adminuserserviceimpl;
   
    
    @RequestMapping(value = "/admindologin",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject doLogin(@RequestBody AdminUser adminuser){
    	JSONObject result=new JSONObject();
        AdminUser adminuser1 = adminuserserviceimpl.selectadminUser(adminuser.getAname(),adminuser.getApassword());
        System.out.print(adminuser1);
        if(adminuser1==null){
            result.put("msg", "密码或账号错误!");
           return result;
        }else {
            result.put("msg", "登入成功");
            return result;
        }
    }
    @RequestMapping(value = "/admindoregist",method = RequestMethod.POST)
    @ResponseBody
    public Map doRegist(@RequestBody AdminUser adminuser) {
    	 Map result=new HashedMap();
    	boolean flag = adminuserserviceimpl.chkUsrNameExists(adminuser.getAname());
    	if(flag){
    		adminuserserviceimpl.inserUser(adminuser.getAname(), adminuser.getApassword());
            result.put("msg","注册成功");
            return result;
    	}else {
    		adminuserserviceimpl.inserUser(adminuser.getAname(), adminuser.getApassword());
            result.put("msg","用户名已经存在，请修改用户名！");
            return result;
    	}
        
    }
    

}
