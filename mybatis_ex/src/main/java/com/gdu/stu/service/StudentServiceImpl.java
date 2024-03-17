package com.gdu.stu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdu.stu.common.ActionForward;
import com.gdu.stu.dao.StudentDao;
import com.gdu.stu.dao.StudentDaoImpl;
import com.gdu.stu.dto.StudentDto;

public class StudentServiceImpl implements StudentService {

  
  private StudentDao studentDao = StudentDaoImpl.getInstance();
  
  @Override
  public ActionForward addStudent(HttpServletRequest request) {

    String name = request.getParameter("name");
    String kor = request.getParameter("kor");
    String eng = request.getParameter("eng");
    String math = request.getParameter("math");
    StudentDto stuDto = StudentDto.builder()
                            .name(name)
                            .kor(Integer.parseInt(kor))
                            .eng(Integer.parseInt(eng))
                            .math(Integer.parseInt(math)).build();
    int insertCount = studentDao.insertStudent(stuDto);
    
    String view = null;
    if(insertCount == 1) {
      view = request.getContextPath() + "/student/list.do";
    }else if(insertCount == 0) {
      view = request.getContextPath() + "/main.do";
    }
    return new ActionForward(view, true);
  }

  @Override
  public ActionForward getStudentList(HttpServletRequest request) {
    int total = studentDao.getStudentCount();
    List<StudentDto> studentList = studentDao.selectStudentList(null);
    request.setAttribute("total", total);
    request.setAttribute("studentList", studentList);
    return new ActionForward("/student/list.jsp", false);
  }

  @Override
  public ActionForward getStudentByNo(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward editStudent(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward modifyStudent(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward removeStudent(HttpServletRequest request) {
    String param = request.getParameter("student_no");
    int student_no = 0;
    if(!param.isEmpty()) {
      student_no = Integer.parseInt(param);
    }
    int deleteCount = studentDao.deleteStudent(student_no);
    
    String view = null;
    if(deleteCount == 0) {
      view=request.getContextPath() + "/main.do";
    }else {
      view = request.getContextPath() + "/student/list.do";
    }
    return new ActionForward(view, true);
  }

  @Override
  public ActionForward removeStudents(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
