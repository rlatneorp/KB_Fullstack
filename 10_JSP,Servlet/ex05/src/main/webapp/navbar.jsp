<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<hr>
<%--세션 쪽에 user 정보 넣어줘야 user 값 받아오기가 가능--%>
<%--user 값이 null이라면 로그인, 회원가입 화면 보여주기--%>
<c:if test="${empty user}">
    <a href="/login_form.jsp">로그인</a> | <a href="#"> 회원가입</a>
</c:if>
<%--user 값이 null이 아니면 user이름, 로그아웃 화면 보여주기--%>
<c:if test="${!empty user}">
    <a href="/info">${user.userid}</a>의 정보 | <a href="/logout"> 로그아웃</a>
</c:if>
<hr>

