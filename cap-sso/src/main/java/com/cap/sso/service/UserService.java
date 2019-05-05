package com.cap.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.common.pojo.TaotaoResult;
import com.cap.pojo.CapUser;

public interface UserService {

	TaotaoResult checkData(String content, Integer type);
	TaotaoResult createUser(CapUser user);
	TaotaoResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	TaotaoResult getUserByToken(String token);
	TaotaoResult userLogout(HttpServletRequest request, HttpServletResponse response, String token);
}
