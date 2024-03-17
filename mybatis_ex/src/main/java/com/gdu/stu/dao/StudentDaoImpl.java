package com.gdu.stu.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gdu.stu.dto.StudentDto;

public class StudentDaoImpl implements StudentDao {

  private SqlSessionFactory factory = null;
  
  private static StudentDao studentDao = new StudentDaoImpl();
  private StudentDaoImpl() {
    try {
      String resource = "com/gdu/stu/config/mybatis-config.xml";
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static StudentDao getInstance() {
    return studentDao;
  }
  @Override
  public int insertStudent(StudentDto stuDto) {
    SqlSession sqlSession = factory.openSession(false);    
    int insertCount = sqlSession.insert("com.gdu.stu.dao.student_t.insertStudent", stuDto);
    if(insertCount == 1) {
      sqlSession.commit();
    }
    sqlSession.close();
    return insertCount;
  }

  @Override
  public int updateStudent(StudentDto stuDto) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteStudent(int stu_no) {
    SqlSession sqlSession = factory.openSession(false);
    int deleteCount = sqlSession.delete("com.gdu.stu.dao.student_t.deleteStudent", stu_no);
    if(deleteCount == 1) {
      sqlSession.commit();
    }
    sqlSession.close();
    return deleteCount;
  }

  @Override
  public List<StudentDto> selectStudentList(Map<String, Object> params) {
    SqlSession sqlSession = factory.openSession();
    List<StudentDto> studentDto = sqlSession.selectList("com.gdu.stu.dao.student_t.selectStudentList");
    sqlSession.close();
    return studentDto;
  }

  @Override
  public int getStudentCount() {
    SqlSession sqlSession = factory.openSession();
    int total = sqlSession.selectOne("com.gdu.stu.dao.student_t.getStudentCount");
    sqlSession.close();
    return total;
  }

  @Override
  public StudentDto selectStudentByNo(int stu_no) {
    // TODO Auto-generated method stub
    return null;
  }

}
