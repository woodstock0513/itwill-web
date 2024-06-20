package com.itwill.spring2.repository;

public interface UserDao {
	
	User selectByUserid(String Userid);
	
	int insert(User user);

}
