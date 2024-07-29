<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>스크립트 실습</title>
</head>
<body>
    <h1>현재 날짜 출력 실습</h1>
<%
    Date d = new Date();

    int sum = 0;
    for(int i = 0; i < 10; i++){
        sum += i;
    }
%>
현재날짜 : <%= d%> <br>
1~10의 합 : <%= sum %>
</body>
</html>
