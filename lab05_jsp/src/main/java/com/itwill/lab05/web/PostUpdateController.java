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

@WebServlet(name = "postUpdateController", urlPatterns = {"/post/update"})
public class PostUpdateController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostUpdateController.class);
	private final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");
		
		//폼에서 제출된 글번호, 제목, 내용을 요청 파라미터에서 읽음
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content  = req.getParameter("content");
		
		Post post = Post.builder().content(content).id(id).title(title).build();
		log.debug("{}",post);
		
		//service 이용 post 업데이트
		postService.update(post);		
		
		//상세보기 화면으로 redirect
		String url = req.getContextPath()+"/post/details?id="+ id;
		log.debug("redirect to {}",url);
		resp.sendRedirect(url);
	}
}
