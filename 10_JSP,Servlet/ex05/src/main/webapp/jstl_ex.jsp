<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL 테스트</h1>
<%--    다른 문서를 삽입해야할 때 include 사용--%>
    <%@ include file="navbar.jsp" %>
<%--    <jsp:include page="navbar.jsp"/>--%>

<%--    c:if - test에 있는 조건이 true일 경우 해당 요소가 보여진다--%>
<%--    권한이 관리자인 경우--%>
    <c:if test="${role == 'ADMIN'}">관리자</c:if>
<%--    권한이 관리자가 아닌 경우--%>
    <c:if test="${role != 'ADMIN'}">일반회원</c:if>


    <table>
<%--    members 리스트를 하나씩 꺼내와서 member라는 이름으로 사용하겠다--%>
<%--    state라는 이름으로 루프 내부의 정보를 사용 가능--%>
        <c:forEach var="member" items="${members}" varStatus="state">
            <tr>
    <%--    state 내에 있는 정보는 루프 정보로 우리가 만든 변수가 아님--%>
              <td>${state.index}</td>
    <%--    우리가 만든 member 클래스로 접근하는 변수--%>
              <td>${member.name}</td>
              <td>${member.userid}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    ${today}<br>
    <fmt:formatDate value="${today}" type="date"/><br>
    <fmt:formatDate value="${today}" type="time"/><br>
    <fmt:formatDate value="${today}" type="both"/><br>
    <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
    <fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short"/><br>
    <fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/><br>
    <fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss"/><br>
</body>
</html>
