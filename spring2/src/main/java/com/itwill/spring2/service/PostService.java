package com.itwill.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring2.repository.Post;
import com.itwill.spring2.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 스프링 컨테이너에 서비스 컴포넌트로 등록
@RequiredArgsConstructor //final 필드들을 초기화하는 아규먼트를 갖는 생성자
public class PostService {
	
	//애너테이션을 사용한 의존성 주입(DI)
//	@Autowired 	private PostDao postDao; 
	
	//생성자에 의한 의존성 주입
	// (1) final 필드 선언. (2) final 필드를 초기화하는 생성자 작성.
	private final PostDao postDao;
//	근데 굳이 이렇게 안 만들고, 애너테이션 하나 추가하면 됨
//	public PostService(PostDao postDao) { //postservice 만들면서, postDao 가져옴! 
//		this.postDao = postDao;
//	}
	
	public List<Post> read(){
		log.debug("read()");
		return postDao.selectOrderByIdDesc();
	}
	
	
	
	
	
}
