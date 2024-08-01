<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo 수정</title>
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

        @keyframes bgWave {
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
            background: linear-gradient(135deg, #e0f7fa, #b2ebf2, #80deea);
            background-size: 300% 300%;
            animation: bgWave 15s ease infinite;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px 60px;
            border-radius: 20px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            animation: fadeInUp 1s ease-in-out;
        }

        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
            color: #4fc3f7;
            animation: fadeInUp 1s ease-in-out;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 12px 24px;
            background-color: #4fc3f7;
            color: #fff;
            border: none;
            border-radius: 30px;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: pulse 2s infinite;
        }

        input[type="submit"]:hover {
            background-color: #29b6f6;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Todo 수정</h1>
    <form method="POST">
        <input type="submit" value="제출">
    </form>
</div>
</body>
</html>
