package com.xue.service;

import com.xue.entity.http.UserReqBean;
import com.xue.entity.http.UserResBean;

public interface UserService {
	
//	增
	
	public int register(UserReqBean user);
//  查
	
	public UserResBean login(UserReqBean user);

}
