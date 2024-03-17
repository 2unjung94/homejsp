<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생관리</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  #btn-wrap{
    display: flex;
  }
</style>
</head>
<body>
  <h1>학생관리</h1>
  <div>
    <button type="button" id="add">신규학생등록</button>
  </div>
  <hr>
  <div>
    <span>평균</span>
    <input type="text" placeholder="begin">
    <span>~</span>
    <input type="text" placeholder="end">
    <button type="submit">조회</button>
    <button type="submit">전체조회</button>
  </div>
  <hr>
  <div class="avg-list"></div>
  
  <hr>
  
  <div class="stu-list">
  <table border="1">
  <caption>전체 학생 ${total}명</caption>
    <thead>
      <tr>
        <td>학번</td><td>성명</td><td>국어</td><td>영어</td><td>수학</td><td>평균</td><td>학점</td><td>버튼</td>
      </tr>
    </thead>
    <tbody>
      <c:if test="${empty studentList}">
        <tr>
          <td colspan="8">등록된 학생이 없습니다.</td>
        </tr>
      </c:if>
      
      <c:if test="${not empty studentList}">
        <c:forEach items="${studentList}" var="student">
          <tr>
            <td>${student.stu_no}</td>
            <td>${student.name}</td>
            <td>${student.kor}</td>
            <td>${student.eng}</td>
            <td>${student.math}</td>
            <td>${student.ave}</td>
            <td>${student.mark}</td>
            <td>
              <div id="btn-wrap">
                <button type="button" class="btn-detail">상세</button>
                <button type="button" class="btn-remove">삭제</button>
              </div>
            </td>

        </c:forEach>
        <tr>
          <td colspan="5">전체평균</td>
          <td>평균값</td>
          <td colspan="2">    </td>
        </tr>
      </c:if>
      
    </tbody>
    <tfoot>
    </tfoot>
  </table>
  </div>
  <script>
    $('#add').on('click', (evt)=>{
    	location.href='${contextPath}/student/write.do';
    })
  </script>
  
  <script>
    const btnRemove = $('.btn-remove')
  </script>
</body>
</html>