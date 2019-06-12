package com.xue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xue.entity.http.UserReqBean;
import com.xue.entity.http.UserResBean;
import com.xue.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginHtml")
	public String loginHtml(){
		
		return "loginHtml";
	}
	
	@RequestMapping("/registerHtml")
	public String registerHtml(){
		
		return "registerHtml";
	}
	/**
	 * 注意的是@Valid 和 BindingResult 是一 一对应的
	 * 如果有多个@Valid，那么每个@Valid后面都需要添加BindingResult用于接收bean中的校验信息
	 */
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@Valid @RequestBody UserReqBean inparam,BindingResult bingdingResult){
		
		if(bingdingResult.hasErrors()){
			List<ObjectError> ls=bingdingResult.getAllErrors();  
            for (int i = 0; i < ls.size(); i++) {  
                System.out.println("error:"+ls.get(i));  
            }
		}
		
		UserResBean res = userService.login(inparam);
		
		System.out.println(inparam);
		
		if(null != res){
			return "登陆成功,用户名："+res.getName()+"   密码"+res.getPwd();
		}else{
			return "登陆失败";
		}
		
		
	}
	/**
	 * 注意的是@Valid 和 BindingResult 是一 一对应的
	 * 如果有多个@Valid，那么每个@Valid后面都需要添加BindingResult用于接收bean中的校验信息
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(@Valid @RequestBody UserReqBean inparam,BindingResult bingdingResult){
		
		System.out.println("进入入口--------------------------");
		
		if(bingdingResult.hasErrors()){
			List<ObjectError> ls=bingdingResult.getAllErrors();  
            for (int i = 0; i < ls.size(); i++) {  
                System.out.println("error:"+ls.get(i));  
            }
		}
		
		int result = userService.register(inparam);
		
		if(0 != result){
			return "注册成功";
			
		}else{
			return "注册失败";
		}
		
		
	}
	



}

