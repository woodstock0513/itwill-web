package com.itwill.springboot5.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Builder 
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter @ToString @EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "comments")
public class Comment extends BaseTimeEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ToString.Exclude //toString에 제외
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post; //postId 대신,,
	
	@Basic(optional = false) //not null
	private String ctext;
	
	@Basic(optional = false) //not null
	private String writer;
}