<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인 입력 화면</h1>
<form action="loginInfo.jsp" method="get">
    <fieldset>
        <lengend>로그인 폼</lengend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input type="text" name="userid">
            </li>
            <li>
                <label for="Password">비밀번호</label>
                <input type="password" name="Password">
            </li>
            <li>
                <label>나이</label>
                <input type="number" name="age">
            </li>
            <li>
                <input type="submit" value="전송">
            </li>
        </ul>
    </fieldset>

</form>

</body>
</html>
