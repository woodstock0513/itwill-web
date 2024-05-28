package com.itwill.lab05.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.repository.PostDao;

//MVC 아키텍쳐에서 Service(Business layer)를 담당하는 클래스
//영속성 계층=Pesistence(Repository) layer(=dao)의 기능을 사용해서 비즈니스 로직을 구현하는 객체
//Controller(Web) layer에게 비즈니스 로직 결과를 리턴
public enum PostService {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	//persistence later의 기능들을 사용하기 위해서
	private final PostDao postDao = PostDao.INSTANCE;
	
	public List<Post> read(){
		return postDao.select();
	}
	
}
