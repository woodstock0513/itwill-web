package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.repository.User;
import com.itwill.spring2.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor //의존성 주입
@Service
public class UserService {
	private final UserDao userDao;
	
	
	//아이디 중복체크
	public boolean checkUserid(String userid) { //중복X = 사용가능 = true
		log.debug("checkUserid(userid = {})", userid);
		
		User user = userDao.selectByUserid(userid);
		if (user == null) { //userid가 일치하는 레코드가 없음 -> 사용가능
			return true;
		} else { //userid가 일치하는 레코드가 있음 -> 중복!!!!
			return false;
		}
		
	}
	
	
	
	
}
