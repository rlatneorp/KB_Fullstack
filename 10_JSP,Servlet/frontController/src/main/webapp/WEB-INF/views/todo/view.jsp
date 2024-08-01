<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo 보기</title>
    <style>
        @keyframes fadeInUp {
            0% {
                opacity: 0;
                transform: translateY(20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.05);
            }
            100% {
                transform: scale(1);
            }
        }

        @keyframes bgSunshine {
            0% {
                background-position: 0% 0%;
            }
            50% {
                background-position: 100% 100%;
            }
            100% {
                background-position: 0% 0%;
            }
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #ffeb3b, #ff9800, #ff5722);
            background-size: 300% 300%;
            animation: bgSunshine 15s ease infinite;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #fff;
            overflow: hidden;
        }

        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px 60px;
            border-radius: 20px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeInUp 1s ease-in-out;
        }

        h1 {
            font-size: 3em;
            margin-bottom: 20px;
            color: #ff5722;
            animation: fadeInUp 1s ease-in-out;
        }

        .actions {
            margin-bottom: 20px;
        }

        .actions a {
            display: inline-block;
            margin: 10px 15px;
            padding: 15px 30px;
            background-color: #ff9800;
            color: #fff;
            text-decoration: none;
            border-radius: 30px;
            font-size: 1.2em;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: pulse 2s infinite;
        }

        .actions a:hover {
            background-color: #ff5722;
            transform: scale(1.1);
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 15px 30px;
            background-color: #ff5722;
            color: #fff;
            border: none;
            border-radius: 30px;
            font-size: 1.2em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: pulse 2s infinite;
        }

        input[type="submit"]:hover {
            background-color: #e64a19;
            transform: scale(1.1);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Todo 보기</h1>
    <div class="actions">
        <a href="list">목록보기</a>
        <a href="update">수정하기</a>
    </div>
    <form action="delete" method="POST">
        <input type="submit" value="삭제">
    </form>
</div>
</body>
</html>
