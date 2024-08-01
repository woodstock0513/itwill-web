package com.itwill.springboot5.repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.domain.QPost;
import com.itwill.springboot5.dto.PostSearchRequestDto;
import com.querydsl.core.BooleanBuilder;
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

	@Override
	public List<Post> searchByTitle(String keyword) {
		log.info("searchByTitle(keyword={})",keyword);
		
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post); //select * from Post
		query.where(post.title.containsIgnoreCase(keyword)); //where
		query.orderBy(post.id.desc()); //order by 

		/* 이런식으로 연결해서도 가능
		JPQLQuery<Post> query = from(post) //select * from Post
				.where(post.title.containsIgnoreCase(keyword)) //where
				.orderBy(post.id.desc()); //order by 
		*/
		List<Post> list =query.fetch();
		
		return list;
	}

	@Override
	public List<Post> searchByContent(String keyword) {
		log.info("searchByContent(keyword={})",keyword);
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post);
		query.where(post.content.containsIgnoreCase(keyword))
		.orderBy(post.id.asc());
		return query.fetch();
	}

	@Override
	public List<Post> searchByTitleOrContent(String keyword) {
		log.info("searchByTitleOrContent(keyword={})",keyword);
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post)
				.where(post.title.containsIgnoreCase(keyword).or(post.content.containsIgnoreCase(keyword)));
		
		
		return query.fetch();
	}

	@Override
	public List<Post> searchByModifiedTime(LocalDateTime from, LocalDateTime to) {
		log.info("searchByModifiedTime(from={}, to={})",from,to);
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post)
//				.where(post.modifiedTime.after(from).and(post.modifiedTime.before(to)))
				.where(post.modifiedTime.between(from, to))
				.orderBy(post.id.desc());
//				.where(post.modifiedTime.before(to));
		return query.fetch();
	}

	@Override
	public List<Post> searchByAuthorAndTitle(String author, String title) {
		log.info("searchByAuthorAndTitle(author={}, title={})",author, title);
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post)
				.where(post.author.eq(author)
						.and(post.title.containsIgnoreCase(title)))
				.orderBy(post.id.desc());
		return query.fetch();
	}

	@Override
	public List<Post> searchByCategory(PostSearchRequestDto dto) {
		log.info("searchByCategory(dto={})",dto);
		String category = dto.getCategory();
		String keyword = dto.getKeyword();
		
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post);
		
		// where() 메서드의 아규먼트인 BooleanExpression 객체를 생성할 수 있는 객체
		BooleanBuilder builder = new BooleanBuilder();
		switch(category) {
		case "t":
			builder.and(post.title.containsIgnoreCase(keyword));
			break;
		case "c":
			builder.and(post.content.containsIgnoreCase(keyword));
			break;	
		case "tc":
			builder.and(post.title.containsIgnoreCase(keyword))
			.or(post.content.containsIgnoreCase(keyword));
			break;	
		case "a":
			builder.and(post.author.containsIgnoreCase(keyword));
			break;	
		}
		
		query.where(builder).orderBy(post.id.desc());
		return query.fetch();
	}

	@Override
	public List<Post> searchByKeywords(String[] keywords) {
		log.info("searchByKeywords(keyword={})",Arrays.asList(keywords));
		QPost post = QPost.post;
		JPQLQuery<Post> query  = from(post);
		BooleanBuilder builder = new BooleanBuilder();
		for (String k : keywords) {
			builder.or(post.title.containsIgnoreCase(k)
						.or(post.content.containsIgnoreCase(k))
						);
		}
		query.where(builder).orderBy(post.id.desc());
		return query.fetch();
	}

	@Override
	public Page<Post> searchByKeywords(String[] keywords, Pageable pageable) {
		log.info("searchByKeywords(keyword={},pageable={})",Arrays.asList(keywords),pageable);
		QPost post = QPost.post;
		JPQLQuery<Post> query = from(post);
		BooleanBuilder builder = new BooleanBuilder();
		for (String k: keywords) {
			builder.or(post.title.containsIgnoreCase(k).or(post.content.containsIgnoreCase(k)));
		}
		query.where(builder); //여기서 정렬 X orderBy XX
		// Paging & Sorting
		getQuerydsl().applyPagination(pageable, query);
		
		//한페이지에 표시할 데이터를 fetch
		List<Post> list = query.fetch();
		
		//전체 레코드 개수를 fetch
		long count = query.fetchCount();
		
		//Page<T> 객체를 생성
		Page<Post> page = new PageImpl<>(list, pageable, count);
		
		return page;
	}
	
	

}
