package com.xue.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xue.entity.http.UserReqBean;
import com.xue.entity.http.UserResBean;
import com.xue.entity.model.User;
import com.xue.repository.dao.UserMapper;
import com.xue.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int register(UserReqBean data) {
		
		int result = 0;
		
		User user = new User();
		user.setName(data.getName());
		user.setPwd(data.getPwd());
		
		try {
			result = userMapper.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public UserResBean login(UserReqBean data) {
		UserResBean res = null;
		res = new UserResBean();
		User user = null;
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("name", data.getName());
		
		params.put("pwd", data.getPwd());
		
		
		try {
			 user = userMapper.selectUser(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(null != user){
			res.setName(user.getName());
			res.setPwd(user.getPwd());
			
			return res;
		}
		
		
		
		return res;
	}
	
	

}

