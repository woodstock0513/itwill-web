package com.itwill.spring2.repository;

import java.util.List;

public interface PostDao {
	
	//post-mapper.xml에서 id="selectOrderByIdDesc"인 SQL을 실행하는 메서드.
	List<Post> selectOrderByIdDesc();
	//interface 만들었으니 impl 만들어야함.. 하지미ㅏㄴ 안함
	
	Post selectById(Integer id); // int로 써도 상관 X
	
	int insertPost(Post post);
	
	int updatePost(Post post);
	
	int deletePost(int id);
}
