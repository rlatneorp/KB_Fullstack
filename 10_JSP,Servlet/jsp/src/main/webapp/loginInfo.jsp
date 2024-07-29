<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 입력 파라미터 출력</h1>
    <%
        String userid = request.getParameter("userid");
        String Password = request.getParameter("Password");
        int age = Integer.parseInt(request.getParameter("age"));
    %>
아이디값: <%= userid%><br>
비밀번호: <%= Password%> <br>
나이 : <%= age%>
</body>
</html>
