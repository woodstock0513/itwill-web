package com.itwill.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */
//서블릿 url 매핑 방법
// 1. web.xml (배포관리자, deployment descriptor)에서 <servlet>, <servlet-mapping>으로 설정하거나
// 2. 서블릿 클래스에서 @WebServlet 애노테이션으로 설정
// (주의) 두 방식 중 하나의 방식으로만 설정해야함.!!
@WebServlet(name = "secondServlet", urlPatterns = {"/ex2"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SecondServlet::doGet() 호출");
		
		//WAS가 클라이언트로 보내는 컨텐트 타입 설정(response)
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out =response.getWriter();
		out.append("<html>")
			.append("<body>")
			.append("<h1>두번째 servlet</h1>")
			.append("<a href = '/lab04'>index page</a>")
			.append("</body>")
			.append("</html>");		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
