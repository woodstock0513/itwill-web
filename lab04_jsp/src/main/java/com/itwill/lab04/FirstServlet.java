package com.itwill.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
    	System.out.println("FirstServlet 생성");
        //super(); 생략가능 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //was(web application server) : 웹 요청(request), 응답(response)을 처리하는 프로그램
    //doGet(): get방식의 요청이 왔을 때 was가 호출하는 메서드
    //doPost(): post 방식의 요청이 왔을 때 was가 호출하는 메서드
    // 파라미터 request : 클라이언트가 서버로 보낸 요청의 정보, 기능들을 갖는 객체
    //파라미터 response : 서버가 클라이언트로 보낼 응답의 정보, 기능들을 갖는 객체.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("FirstServlet::doGet() 호출");
    	
    	response.setContentType("text/html; charset=UTF-8");
    	//텍스트!!!! html!!!! not test!!    		
    	
		response.getWriter() //html 문서를 만드는 코드. 만들어서  response한것!
			.append("<!doctype html>")
			.append("<html>")
			.append("<head>")
			.append("<meta charset='UTF-8'/>") //작은 따옴표! 
			//html은 "", '' 구분하지 않음.jsp에서는 ''로 써야함. 왜냐면 자바가 ""를 문자열로 인식하기 때문
			.append("<title>Servlet</title>")
			.append("</head>")
			.append("<body>")
			.append("<h1>첫번째 servlet</h1>")
			.append("<a href = '/lab04'>index page</a>")
			.append("</body>")
			.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    //서블릿 새로 만들땐 서버 재시작해야함. 만들고나서는 안해도됨
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
