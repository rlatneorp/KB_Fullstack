<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

    <h1>EL 실습</h1>

    사용자 아이디 : ${userid}<br>
    사용자 비밀번호 : ${passwd}<br>

    ${login.name} / ${login.passwd}
</body>
</html>
