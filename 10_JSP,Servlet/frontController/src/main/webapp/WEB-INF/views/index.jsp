<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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

        @keyframes bounce {
            0%, 20%, 50%, 80%, 100% {
                transform: translateY(0);
            }
            40% {
                transform: translateY(-15px);
            }
            60% {
                transform: translateY(-7px);
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
            overflow: hidden;
        }
        .container {
            background: #fff;
            padding: 40px 60px;
            border-radius: 20px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeInUp 1s ease-in-out, pulse 2s infinite;
        }
        .container:hover {
            animation: bounce 1s;
        }
        h1 {
            font-size: 3em;
            margin-bottom: 20px;
            color: #ff6f61;
            animation: fadeInUp 1.2s ease-in-out;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 15px 30px;
            background-color: #ffa500;
            color: #fff;
            text-decoration: none;
            font-size: 1.2em;
            border-radius: 30px;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: fadeInUp 1.4s ease-in-out, pulse 2s infinite;
        }
        a:hover {
            background-color: #ff7f50;
            transform: scale(1.1);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>FrontController</h1>
    <a href="/todo/list">Todo 목록보기</a>
</div>
</body>
</html>
