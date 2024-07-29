<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> 방문자수 설정하기 화면</h1>
    <%! int count;%>
<%--    ServletContext 객체인 application을 이용해서 countValue라는 속성에 count 값을 설정--%>
    <%
        count++;
        application.setAttribute("countValue", count);
    %>
    현재 방문자 수 : <%= count%>
</body>
</html>
