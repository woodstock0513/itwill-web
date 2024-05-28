package com.itwill.lab05.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;


public class CharacterEncodingFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;
	private String encoding;
	private static final Logger log = LoggerFactory.getLogger(CharacterEncodingFilter.class);
	
	//WAS가 filter 객체를 생성한 후 filter의 초기화 작업을 하기 위해서 호출하는 메서드
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//web.xml에서 filter의 param-name을 아규먼트로 전달하면 filter의 param-value를 리턴해줌.(리턴값으로 UTF-8이 나옴!)
		encoding = filterConfig.getInitParameter("encoding"); //encoding = UTF-8
		//filter의 init은 생성자가 호출되면 바로 호출됨
		
		log.debug("init: encoding={}",encoding);
	}
	
	
	//filter chain(->서블릿)으로 진행하기 위해서 was가 호출하는 메서드. 이게 실행되면 서블릿으로 이동함.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 서블릿으로 보내기 전에 하는 일들 (요청을 서블릿으로 처리하기 전에 공통적으로 해야하는 일들)
		// 요청 객체의 문자열 인코딩 타입을 설정(UTF-8) 
		request.setCharacterEncoding(encoding);
		
		// 다음 filter chain을 진행 (-> 서블릿 메서드(doGet, doPost)가 호출됨)
		chain.doFilter(request, response);
		
		//filter가 없으면 서블릿 메서드 실행할때마다 인코딩 타입을 다 설정해줘여함!
	}
	
	
	
}
