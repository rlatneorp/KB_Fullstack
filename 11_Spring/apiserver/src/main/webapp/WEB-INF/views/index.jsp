<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE>
<html>
<head>
    <meta charset ="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>환영합니다.</h1>
    <sec:authorize access="isAnonymous()">
        <a href="/security/login">로그인 페이지</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <form action="/security/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="로그아웃"/>
        </form>
    </sec:authorize>

    <br><br>
    <a href="/security/admin">어드민 페이지</a>
    <a href="/security/member">멤버 페이지</a>
    <a href="/security/all">공용 페이지</a>

</body>
</html>
