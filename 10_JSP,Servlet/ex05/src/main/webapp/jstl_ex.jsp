<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL 테스트</h1
    <c:if test="${empty user}">
        <a href="#">로그인</a> | <a href="#"> 회원가입</a>
    </c:if>
    <c:if test="${!empty user}">
        ${user.name} | <a href="/logout"> 로그아웃</a>
    </c:if>

    <c:if test="${role == 'ADMIN'}">관리자</c:if>
    <c:if test="${role != 'ADMIN'}">일반회원</c:if>

    <table>
      <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
          <td>${state.index}</td>
          <td>${member.name}</td>
          <td>${member.userid}</td>
        </tr>
      </c:forEach>
    </table>
  <br>
</body>
</html>
