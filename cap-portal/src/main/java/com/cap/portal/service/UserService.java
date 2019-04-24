package com.cap.portal.service;

import com.cap.pojo.CapUser;

public interface UserService {

	CapUser getUserByToken(String token);
}
