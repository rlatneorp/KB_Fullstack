<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>새 Todo 생성</title>
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
            background: linear-gradient(135deg, #ffe6e6, #ffefba, #ffcccb);
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
            background: #fff;
            padding: 40px 60px;
            border-radius: 20px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeInUp 1s ease-in-out;
        }

        h1 {
            font-size: 3em;
            margin-bottom: 20px;
            color: #ff6f61;
            animation: fadeInUp 1s ease-in-out;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="submit"] {
            padding: 15px 30px;
            background-color: #ffa500;
            color: #fff;
            border: none;
            border-radius: 30px;
            font-size: 1.2em;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: pulse 2s infinite;
        }

        input[type="submit"]:hover {
            background-color: #ff7f50;
            transform: scale(1.1);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>새 Todo 생성</h1>
    <form method="POST">
        <div>
           제목 <label>
                <input id="title" type="text" name="title"/>
            </label>
        </div><br>
        <div>
            내용 <label>
            <textarea id="content" name="content" ></textarea>
        </label>
        </div>
        <input type="submit" value="제출">
    </form>
</div>
</body>
</html>
