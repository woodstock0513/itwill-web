package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postDetailsController", urlPatterns = {"/post/details"}) //쿼리 스트링 앞부분까지만 써주면 됨
public class PostDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostDetailsController.class);
	
	private final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("doGet()");
		
		//쿼리 스트링에 포함된 request 파라미터(id값)를 읽어야지 몇번 글인지 알 수 잇음!!
		int id = Integer.parseInt(req.getParameter("id"));
		log.debug("id={}",id);
		
		//서비스 계층의 메서드를 호출해서 해당 id의 포스트 정보를 db에서 읽어옴
		Post post = postService.read(id);
		
		//Post 객체를 뷰(jsp)에게 전달 
		req.setAttribute("post", post);
		
		//view로 이동 (forward방식)
		req.getRequestDispatcher("/WEB-INF/views/post/details.jsp").forward(req, resp);
		
		
	}
	

}
