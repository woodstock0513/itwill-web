package com.itwill.springboot5.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.domain.QPost;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostQuerydslImpl extends QuerydslRepositorySupport
	implements PostQuerydsl	{
	//상속을 받았는데 기본생성자가 없어서 하위클래스에서 명시적으로 호출해준 것
	//엔터티 클래스를 아규먼트로 주면 됨
	public PostQuerydslImpl() {
		super(Post.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Post searchById(Long id) {
		log.info("searchById(id={})",id);
		QPost post = QPost.post; //이게먼데
		JPQLQuery<Post> query = from(post);
		query.where(post.id.eq(id)); //원래 있던 query + where id = ?
		Post entity = query.fetchOne();//결과를 가져올 땐 엔터티 타입으로
		return entity;
	}

}
