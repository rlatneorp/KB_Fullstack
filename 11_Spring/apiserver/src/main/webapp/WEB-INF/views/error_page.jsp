<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<%--http://localhost:8080/sample/ex04?name=aaa&age=11--%>
<%--예외 강제 발생.--%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
    <h4>
        <c:out value="${exception.getMessage()}"></c:out>
    </h4>

    <ul>
        <c:forEach items="${exception.getStackTrace()}" var="stack">
            <li>
                <c:out value="${stack}"></c:out>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
