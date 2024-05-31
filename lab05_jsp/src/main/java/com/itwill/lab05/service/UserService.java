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

	// TODO: 회원가입에 필요한 메서드. (userDao의 insert 호출)
	public int createAccount(User user) {
		log.debug("createAccount({})", user);
		int result = userDao.insert(user);
		return result;
	}

	public User signIn(String userid, String password) {
		log.debug("signIn(userid = {}, password = {})", userid, password);
		
		//DTO
		User dto = User.builder().password(password).userid(userid).build();
		User user = userDao.selectByUseridAndPassword(dto);
		log.debug("로그인 결과 = {}",user);
		
		return user;
	}
}
