<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규학생등록</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .btn-wrap{
    display: flex;
  }
</style>
</head>
<body>
  <h1>신규학생등록 화면</h1>
  <div>
    <form action="${contextPath}/student/register.do" 
     method="POST"
     id="frm-register">
      <div>
        <label for="name">이름</label>
        <input id="name"  name="name" type="text">  
      </div>
      <div>
        <label for="kor">국어</label>
        <input id="kor" name="kor" type="text">
      </div>
      <div>
        <label for="eng">영어</label>
        <input id="eng" name="eng" type="text">
      </div>
      <div>
        <label for="math">수학</label>
        <input id="math" name="math" type="text">
      </div>
      <hr>
      <div class="btn-wrap">
        <button type="submit">작성완료</button>
        <button type="reset">다시작성</button>
        <button type="button" id="btn-list">목록보기</button>
      </div>
    </form>
    
  </div>
  
  <script>
    document.getElementById('frm-register').addEventListener('submit', (evt)=>{
    	const name = document.getElementById('name');
    	if(name.value.trim() == ''){
    		alert('제목은 필수입니다.')
    		name.focus();
    	  evt.preventDefault();
    	  return;
    	}
    })
  </script>
</body>
</html>