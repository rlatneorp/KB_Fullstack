<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>getParameter 실습</h1>
<%--    <form action="login" method="get">--%>
<%--    login만 명시하는 것은 서블릿과 연결해주겠다는 의미--%>
    <form action="login" method="post">
        <fieldset>
            <legend>로그인 폼</legend>
            <ul>
                <li><label for="userid">아이디</label>
                    <input type="text" id="userid" name="userid"></li>
                <li><label for="passwd">비밀번호</label>
                    <input type="password" id="passwd" name="passwd"></li>
                <li><input type="submit" value="전송"></li>
            </ul>
        </fieldset>
    </form>
</body>
</html>
