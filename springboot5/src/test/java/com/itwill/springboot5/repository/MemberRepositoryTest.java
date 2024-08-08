package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.itwill.springboot5.domain.Member;
import com.itwill.springboot5.domain.MemberRole;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberRepositoryTest {
	
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired //bean어쩌고 해서 주입받을 수 있는 것임...
	//spring container가 해줌
	private PasswordEncoder passwordEncoder;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(memberRepo).isNotNull();
		log.info(memberRepo.toString());
		
		assertThat(passwordEncoder).isNotNull();
		log.info(passwordEncoder.toString());
	}
	
	@Test
	public void testSave() {
		//엔터티 객체를 DB members 테이블에 저장
		
		
		Member m = Member.builder().username("admin")
				.password(passwordEncoder.encode("0000")).email("admin@naver.com").build();
		
//		m.addRole(MemberRole.USER);
		m.addRole(MemberRole.ADMIN);
		log.info("save 호출 전 = {}, {}",m,m.getRoles());
		m = memberRepo.save(m); //저장한 걸 m에 저장
		//-> members테이블과 member_roles 테이블에 insert하는 쿼리 
		// 하나의 메서드로 2개의 테이블에 insert 하는 것!!
		//연관관계가 있는 테이블일 때 가능
		log.info("save 호출 후 = {}, {}",m, m.getRoles());
	}
	
//	@Test @Transactional - fetch type이 lazy라서..
	public void testFindAll() {
		List<Member> list = memberRepo.findAll();
		//members랑 member_roles 테이블에서 정보를 가져옴
		list.forEach((x)-> log.info("{}, {}",x, x.getRoles()));
		
	}
	
//	@Test
	public void testFindByUsername() {
		Member mem = memberRepo.findByUsername("test1").orElseThrow();
		log.info("mem = {} / {}",mem, mem.getRoles());
		
		Member mem2 = memberRepo.findByUsername("test2").get();
		log.info("mem2 = {} / {}", mem2, mem2.getRoles());
	}
	

}
