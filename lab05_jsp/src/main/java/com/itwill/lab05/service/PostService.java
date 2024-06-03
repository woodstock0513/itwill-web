package com.itwill.lab05.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.repository.PostDao;
import com.itwill.lab05.repository.UserDao;

import jakarta.servlet.http.HttpSession;

//MVC 아키텍쳐에서 Service(Business layer)를 담당하는 클래스
//영속성 계층=Pesistence(Repository) layer(=dao)의 기능을 사용해서 비즈니스 로직을 구현하는 객체
//Controller(Web) layer에게 비즈니스 로직 결과를 리턴
public enum PostService {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	//persistence later의 기능들을 사용하기 위해서
	private final PostDao postDao = PostDao.INSTANCE;
	private final UserDao userDao = UserDao.INSTANCE;
	
	public List<Post> read(){
		log.debug("read");
		
		List<Post> list = postDao.select();
		log.debug("list size = {}",list.size());
		
		return list;
	}
	
	public int create(Post post) {
		log.debug("create ; Post={}",post);
		
		//repository 계층의 메서드를 사용해서 DB 테이블에 행을 삽입
		int result = postDao.insert(post);
		log.debug("insert result ={}", result);
		
		//TODO: userDao 메서드 호출(users points 컬럼)
		String author = post.getAuthor(); //=userid
		int result2 = userDao.updatePoints(1, author);
		log.debug("update result = {}",result2);
		return result;
	}
	
	public Post read(int id) {
		log.debug("read() ; id={}",id);
		
		//영속성 계층의 메서드를 호출해서 DB 테이블에서 id로 검색하는 sql 실행
		Post post = postDao.select(id);
		log.debug("{}",post);
		
		return post; //컨트롤러에게 검색한 Post 객체 리턴
	}
	
	public int delete(int id) {
		log.debug("delete(id={})",id);
		int result = postDao.delete(id);
		log.debug("delete result = {}",result);
		return result;
	}
	
	public int update(Post post) {
		log.debug("update({})",post);
		int result = postDao.update(post);
		log.debug("update result = {}",result);
		return result;
	}
}
