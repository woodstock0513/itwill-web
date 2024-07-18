package com.itwill.springboot1.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.springboot1.dto.Author;
import com.itwill.springboot1.dto.Book;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/")  //contextPath로 들어오는 get방식 요청을 처리하는 메서드
	public String home(Model model) {
		log.info("home()");
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("currentTime", now);
		
		Author author  = Author.builder().firstName("마이클").lastName("샌델").build();
		Book book  = Book.builder().id(0).title("정의란 무엇인가").author(author).build();
		
		model.addAttribute("book", book);
		log.info("book = {}",book);
		
		return "index"; //view의 이름을 리턴
		//src/main/resources/templates/리턴값.html 을 찾음
	}
	
	@GetMapping("/book/list")
	public void bookList(Model model) {
		log.info("bookList()");
		//도서 목록 더비 데이터를 저장하기 위한 리스트
		ArrayList<Book> list = new ArrayList<>();
		
		//더미 데이터 5개 리스트에 저장
		for (int i = 0 ; i<5;i++) {
			Book book = Book.builder().id(i).title("Title-"+i)
					.author(Author.builder().firstName("Name-"+i).lastName("LastName").build()).build();
			list.add(book);
		}
		Book b = Book.builder().id(20).title("명급리").build();
		list.add(b);
		
		//도서 목록을 뷰에 전달
		model.addAttribute("bookList",list);
		
		//return type이 void인 경우 뷰의 이름은 요청 주소와 같음.
	}
	
	

}
