package com.itwill.lab05.repository;
//mvc 아키텍쳐에서 model 역할 클래스.
//DB의 posts 테이블 컬럼 구조와 같은 클래스

import java.time.LocalDateTime;

public class Post {
	private Integer id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createdTime; // 컬럼이름은 created_time
	private LocalDateTime modifiedTime; // 컬럼이름은 modified_time
	
	public Post(Integer id, String title, String content, String author, LocalDateTime createdTime,
			LocalDateTime modifiedTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + "]";
	}

	// builder 패턴
	public static PostBuilder builder() {
		return new PostBuilder(); //여기서만 객체 생성 가능.
	}
	
	public static class PostBuilder  { // 내부 클래스
		private Integer id;
		private String title;
		private String content;
		private String author;
		private LocalDateTime createdTime; // 컬럼이름은 created_time
		private LocalDateTime modifiedTime; // 컬럼이름은 modified_time
		
		private PostBuilder() {}
		
		public PostBuilder id(Integer id) { //아규먼트를 전달받아서
			this.id = id; //필드에 저장하고
			return this; //객체를 리턴(id만 바뀐 객체)
		}
		
		public PostBuilder title(String title) {
			this.title = title;
			return this;
		}
		
		 public PostBuilder content(String content) {
			 this.content = content;
			 return this;
		}
		 
		 public PostBuilder author(String author) {
			this.author = author;
			return this;
		}
		 
		 public PostBuilder createdTime(LocalDateTime createdTime) {
			this.createdTime = createdTime;
			return this;
		}
		 
		public PostBuilder modifiedTime(LocalDateTime modifiedTime) {
			this.modifiedTime=modifiedTime;
			return this;
		}
		
		public Post build() {
			return new Post(id, title, content, author, createdTime, modifiedTime);
		}
		
	}
	
	
	
}
