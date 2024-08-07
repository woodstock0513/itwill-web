package com.itwill.springboot5.domain;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.NaturalId;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter @ToString(callSuper = true) //부모클래스의 필드를 포함시킬 지 말 지
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
//onlyExplicitlyIncluded 속성 : @EqualsAndHashCode.Include 애너테이션이 설정된 필드만 사용
//callSuper 속성: superclass의 equals(), hashcode() 메서드를 사용할 것인 지 여부
@Builder
@Entity
@Table(name = "members")
public class Member extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@EqualsAndHashCode.Include //username 필드를 equals()와 hashcode()를 재정의 할 때 사용
	@NaturalId //unique 제약조건
	@Basic(optional = false) //not null 제약 조건
	@Column(updatable = false) //변경 불가 update쿼리의 set절에서 제외
	private String username;
	
	@Basic(optional = false)
	private String password;
	
	@Basic(optional = false)
	private String email;
	
	
	@Builder.Default //Builder 패턴에서도 null이 아닌 HashSet<>객체로 초기화될 수 있도록
	@ToString.Exclude //toString에서 제외
	@ElementCollection (fetch = FetchType.LAZY) //연관 테이블(member_roles)을 사용하기 위해.
	@Enumerated(EnumType.STRING) //DB테이블에 저장될 때 상수(enum)의 이름(문자열)을 사용
	private Set<MemberRole> roles = new HashSet<>(); //null이되면안됨
//	entity이름이 member, set 이름이 roles -> 테이블명 : member_roles
	
	//roles이 null이면 밑의 메서드에서 exception 발생함... -> null이 되지 않ㄷㅎㅀㄱ
	public Member addRole(MemberRole role) {
		roles.add(role); //Set<>에 원소 추가
		return this;
	}
	
	public Member removeRole(MemberRole role) {
		roles.remove(role);
		return this;
	}
	
	
	public Member clearRoles() {
		roles.clear(); //Set<>의 모든 원소를 지움
		return this;
	}
	
	
	
}
