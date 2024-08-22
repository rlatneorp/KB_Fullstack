<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Insert Title here</title>
</head>
<body>
    <h1>/security/member page</h1>

    <form action="/security/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="로그아웃">
    </form>
</body>
</html>
