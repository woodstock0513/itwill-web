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

@WebServlet(name = "postCreateController", urlPatterns = {"/post/create"})
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostCreateController.class);
	private static final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		
		//새 글 작성 폼(양식)을 view(jsp)로 이동
		req.getRequestDispatcher("/WEB-INF/views/post/create.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");
		
		//req로 받은 정보들을 res로 보내야함
		//요청에 포함된 정보(제목, 내용, 작성자)을 읽음.
		//req.getParameter(arg) 메섣의 arg는 요청 파라미터의 이름 (name 속성 값)이다.
		String title = req.getParameter("title"); //create.jsp에서 제목의 이름이 title이니까!
		String content = req.getParameter("content");
		String author = req.getParameter("author");
		Post post = Post.builder().author(author).title(title).content(content).build();
		
		log.debug("post = {}",post);
		
		//서비스 객체의 메서드를 호출시켜 db에 저장
		int result = postService.create(post);
		
		//목록 페이지로 이동
		String url = req.getContextPath()+"/post/list";
		log.debug("redirect : "+url);
		resp.sendRedirect(url);
//		resp.sendRedirect("/lab05/post/list"); 이렇게 쓰기보단 위의 방식으로!
		//PRG (Post-Redirect-Get)
		
	}

}