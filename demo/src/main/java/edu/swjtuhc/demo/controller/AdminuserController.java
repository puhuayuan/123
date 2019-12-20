package edu.swjtuhc.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.swjtuhc.demo.model.AdminUser;
import edu.swjtuhc.demo.model.Tuser;
import edu.swjtuhc.demo.serviceImpl.AdminuserServiceImpl;
import edu.swjtuhc.demo.serviceImpl.TuserServiceImpl;

@RequestMapping("/adminuser")
@Controller
public class AdminuserController {
	@Autowired
    private AdminuserServiceImpl adminuserserviceimpl;
   
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
 
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
    @RequestMapping(value = "/admindologin",method = RequestMethod.GET)
    @ResponseBody
    public String doLogin(AdminUser adminuser,Map<String,Object> map){
        AdminUser adminuser1 = adminuserserviceimpl.selectadminUser(adminuser.getAname(),adminuser.getApassword());
        System.out.print(adminuser1);
         if(adminuser1==null){
             map.put("msg", "密码或账号错误!");
            return "fail";
         }else {
             map.put("msg", "登入成功");
             return "success";
         }
    }
    @RequestMapping(value = "/admindoregist",method = RequestMethod.GET)
    @ResponseBody
    public String doRegist(AdminUser adminuser,Map<String,Object> map) {
        adminuserserviceimpl.inserUser(adminuser.getAname(), adminuser.getApassword());
      
        map.put("msg","注册成功");
        return "success";
    }
    

}
