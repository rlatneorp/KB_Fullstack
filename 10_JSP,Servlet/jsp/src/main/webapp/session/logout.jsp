<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: PM 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--사용자 세션을 종료시킨 후 다시 로그인 화면으로 리디렉트--%>
    <%
        session.invalidate();
        response.sendRedirect("loginForm.html");
    %>

</body>
</html>
