package com.gdu.stu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.stu.common.ActionForward;
import com.gdu.stu.service.StudentService;
import com.gdu.stu.service.StudentServiceImpl;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentService studentService = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  
	  // 요청 주소
	  String requestURI = request.getRequestURI();
	  String contextPath = request.getContextPath();
	  String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());
	  
	  ActionForward actionForward = null;
	  request.setCharacterEncoding("UTF-8");
	  
	  switch(urlMapping) {
	  case "/student/list.do":
	    actionForward = studentService.getStudentList(request);
	    break;
	  case "/student/write.do":
	    actionForward = new ActionForward("/student/write.jsp", false);
	    break;
	  case "/student/register.do":
	    actionForward = studentService.addStudent(request);
	    break;
	  case "/main.do":
	    actionForward = new ActionForward("/index.jsp", false);
	    break;
	  }
	  
	  response.setContentType("text/html; charset=UTF-8");
	  response.setCharacterEncoding("UTF-8");
	  if(actionForward != null) {
	    if(actionForward.isRedirect()) {
	      response.sendRedirect(actionForward.getView());
	    }else {
	      request.getRequestDispatcher(actionForward.getView()).forward(request, response);
	    }
	  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
