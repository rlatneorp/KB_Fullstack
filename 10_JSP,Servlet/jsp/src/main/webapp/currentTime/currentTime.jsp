<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>스크립트릿 실습</title>
</head>
<body>
    <h1>현재 날짜 출력 실습</h1>
<%--    html코드 내에 자바 코드를 넣어주는 걸 스크릭트릿이라고 한다--%>
<%
    Date d = new Date();

    int sum = 0;
    for(int i = 0; i < 10; i++){
        sum += i;
    }
    Date d2 = null;
%>
현재날짜 : <%= d%> <br>
1~10의 합 : <%= sum %> <br>

<% if(d2 != null){ %>
    <%= d2%>
<%}%>

</body>
</html>
