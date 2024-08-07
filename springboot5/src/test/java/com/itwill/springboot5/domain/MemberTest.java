package com.itwill.springboot5.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
public class MemberTest {
	
	
	@Test
	public void testEqualsAndHashCode() {
		Member mem1 = Member.builder().id(1L).username("admin").password("1111").email("aaa@naver.com").build();
		log.info("mem1 = {}",mem1);
		
		Member mem2 = Member.builder().id(2L).username("admin").password("2222").email("bbb@naver.com").build();
		log.info("mem2 = {}",mem2);
		
		assertThat(mem1).isEqualTo(mem2);
		//mem1.equals(mem2); 리턴 값이 true인 지 테스트! -> true
		//equals에서 비교하는 것이 username뿐이긴 때문
	}
	
}
