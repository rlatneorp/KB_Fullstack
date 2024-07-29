<%--예외가 발생했을 경우 error.jsp 호출, errorPage 속성에 명시--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>exception 실습</title>
</head>
<body>
    <%
        // 0으로 나누어 예외 발생
        int n = 4 / 0;
    %>
</body>
</html>
