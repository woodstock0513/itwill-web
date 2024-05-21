package com.itwill.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FowardServlet
 */
@WebServlet (name = "fowardServlet", urlPatterns = {"/ex3"})
public class FowardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override //was가 doGet을 호출할때 자신의 req,res를 보내주는것
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FowardServlet::doGet() 호출");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//요청이 오면 WAS는 web.xml 또는 @WebServlet 에서 설정된 url-mapping에 따라서
		//요청을 처리할 수 있는 servlet 클래스 객체의 메서드(doGet, doPost)를 호출.
		//servlet에서는 HTML 코드를 작성해서 응답을 보내면 됨.
		//근데,, 서블릿에서 html 작성하는 것은 너무 번거로움,,
		// -> 서블릿이 jsp로 요청을 전달하고 jsp가 html 코드를 작성하는 것이 낫겟다!
		// 전달만 잘 하면 됨.
		request.getRequestDispatcher("example.jsp").forward(request, response);
		
		// foward 방식의 웹페이지 이동
		// - 같은 was의 웹 앱플리케이션 안에서만 페이지를 이동하는 방식
		// - 최초 요청 주소가 바뀌지 않음 (ex3 유지!)
		// - request, response 객체가 유지됨 (servlet의 req,res와 jsp의 req,res가 같음)
		// - 다른 was 또는 다른 웹 애플리케이션의 페이지로는 foward할 수 없음.
		
	}

}
