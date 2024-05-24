package com.itwill.lab04.filter;

import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterEx
 */

//필터 요청 주소 매핑 설정 (둘 중 하나만 !)
//(1) web.xml(deployment descriptor) 파일에서 <filter><filter-mapping> 태그에서 설정하거나
//(2) @Webfilter 애너테이션으로 설정
// 필터 체인이 있을 때, 필터들이 실행되는 순서는 web.xml에 설정된 순서들로 실행됨
// 실제로 xml에서 필터 순서가 바뀌면 실행순서(콘솔에 뜨는) 순서도 달라짐
// 근대 애너테이션으로 하면 태그 순서가 어떻게 들어갈 지 모르기 때문에 filter는 xml에 정리하는게 나아보임!

public class FilterEx extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterEx() {
        System.out.println("FilterEx 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
    	// WAS가 종료될 때 생성된 필터 객체를 소멸시키기 위해서 호출하는 메서드.
		System.out.println("FilterEx::destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("FilterEx chain.doFilter() 호출 전");
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("FilterEx chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FilterEx::init() 호출");
	}

}
