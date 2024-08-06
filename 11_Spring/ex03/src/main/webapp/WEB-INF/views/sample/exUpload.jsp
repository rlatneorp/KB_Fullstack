<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="submit"/>
        </div>
    </form>
</body>
</html>
