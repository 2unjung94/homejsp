package com.gdu.stu.service;

import javax.servlet.http.HttpServletRequest;

import com.gdu.stu.common.ActionForward;

public interface StudentService {
  ActionForward addStudent(HttpServletRequest request);
  ActionForward getStudentList(HttpServletRequest request);   // 리스트보기
  ActionForward getStudentByNo(HttpServletRequest request);   // 상세보기
  ActionForward editStudent(HttpServletRequest request);      // 편집 화면(편집기) 보여주는 서비스
  ActionForward modifyStudent(HttpServletRequest request);    // 편집 후 화면 보여주는 서비스
  ActionForward removeStudent(HttpServletRequest request);
  ActionForward removeStudents(HttpServletRequest request);
}
