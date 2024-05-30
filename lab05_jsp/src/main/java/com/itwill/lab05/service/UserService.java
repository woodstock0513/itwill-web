package com.itwill.lab05.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.repository.UserDao;

//서비스(비즈니스) r계층 싱글턴 객체
public enum UserService {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private UserDao userDao = UserDao.INSTANCE;
	
	//TODO: 회원가입에 필요한 메서드. (userDao의 insert 호출)
	public int createAccount(User user) {
		log.debug("createAccount({})", user);
		int result = userDao.insert(user);
		return result;
	}
	
}
