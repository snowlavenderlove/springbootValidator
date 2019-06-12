package com.xue.entity.http;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserReqBean {
	/**
	 * 在实体类上写上相关验证信息
	 */
    private Integer id;
    @NotEmpty(message = "用户名不能为空！")
    private String name;
    @Size(min=3,max=10,message = "密码长度在3到10位")
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

	@Override
	public String toString() {
		return "UserReqBean [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
    
    

}
