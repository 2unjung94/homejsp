package com.gdu.stu.dao;

import java.util.List;
import java.util.Map;

import com.gdu.stu.dto.StudentDto;



public interface StudentDao {
  int insertStudent(StudentDto stuDto);
  int updateStudent(StudentDto stuDto);
  int deleteStudent(int stu_no);    // 삭제할 게시글 번호만 필요
  List<StudentDto> selectStudentList(Map<String, Object> params);    // 게시글 리스트
  int getStudentCount();          // 게시글 총 개수
  StudentDto selectStudentByNo(int stu_no);   // 상세보기
}
