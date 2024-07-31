<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    int age = 10; // 지역변수
    request.setAttribute("age", 40); // request scope
%>
<head>
    <title>Title</title>
</head>
<body>
<%--스크립트릿 언어--%>
<%--지역 변수를 가져온다--%>
    변수 age : <%= age %> <br>
<%--EL(Expression Language)--%>
<%--작은 범위부터 타고 올라가면서 해당 값을 찾는다--%>
    EL age : ${age}
</body>
</html>
