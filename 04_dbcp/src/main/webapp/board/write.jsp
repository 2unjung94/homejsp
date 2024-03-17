<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성화면</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

<div>
  <form id="frm-register"
        method="POST"
        action=" ${contextPath}/board/register.brd">
    <div>
      <label for="title">제목</label>
      <input type="text" id="title" name="title">
    </div>
    <div>
      <textarea rows="5" cols="50" name="contents"></textarea>
    </div>
    <div>
      <button type="submit">작성완료</button>
      <button type="reset">초기화</button>
      <button type="button" id="btn-list">목록보기</button>
    </div>
  </form>
</div>
<script>

  document.getElementById('frm-register').addEventListener('submit', (evt)=>{
    const title = document.getElementById('title');
    if(title.value.trim() === ''){  // 빈문자열, 순수하게 공백으로만 작성된 제목 거르기
      alert('제목은 필수입니다.');
      title.focus();
      evt.preventDefault();
      return;
    }
  })

</script>
</body>
</html>