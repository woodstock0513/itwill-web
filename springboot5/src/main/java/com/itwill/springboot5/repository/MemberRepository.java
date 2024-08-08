package com.itwill.springboot5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itwill.springboot5.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
//	select * 
//	from members m join member_roles r on m.id = r.member_id
//	where m.username = ?;
	@EntityGraph(attributePaths = "roles") //roles: member table의 필드 이름(근데 테이블임)
	Optional<Member> findByUsername(String username); //id중복체크
	
	
}
