<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../layouts/header.jsp"%>
<h1 class="page-header my-4"><i class="far fa-file-alt"></i> ${board.title}</h1>
<div class="d-flex justify-content-between">
    <div><i class="fas fa-user"></i> ${board.writer}</div>
    <div>
        <i class="fas fa-clock"></i>
        <fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
    </div>
</div>

<div class="text-end">
<%--    BoardDTO의 attaches 리스트를 돌면서 하나씩 file이라는 이름으로 꺼낸다--%>
    <c:forEach var="file" items="${board.attaches}">
        <div class="attach-file-item">
<%--            파일을 다운로드할 수 있는 링크 생성--%>
            <a href="/board/download/${file.no}" class="file-link">
<%--                디스크 아이콘, 파일 원본명, 파일 사이즈 출력--%>
                <i class="fa-solid fa-floppy-disk"></i>
                    ${file.filename} (${file.fileSize})<br>
            </a>
        </div>
    </c:forEach>
</div>

<hr>
<div>
    <pre>${board.content}</pre>
</div>
<div class="mt-4">
    <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
    <a href="update?no=${board.no}" class="btn btn-primary"><i class="far fa-edit"></i> 수정</a>
    <a href="#" class="btn btn-primary delete"><i class="fas fa-trash-alt"></i> 삭제</a>
</div>
<form action="delete" method="post" id="deleteForm">
    <input type="hidden" name="no" value="${board.no}"/>
</form>
<script src="/resources/js/board.js"></script>
<%@include file="../layouts/footer.jsp"%>

