<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>404</title>
    <style>
        @keyframes flicker {
            0%, 19%, 21%, 23%, 25%, 54%, 56%, 100% {
                opacity: 1;
            }
            20%, 24%, 55% {
                opacity: 0.4;
            }
            22% {
                opacity: 0.6;
            }
        }

        @keyframes neonGlow {
            0%, 100% {
                text-shadow: 0 0 10px #00ffcc, 0 0 20px #00ffcc, 0 0 30px #00ffcc, 0 0 40px #00ffcc, 0 0 50px #00ffcc, 0 0 75px #00ffcc;
            }
            50% {
                text-shadow: 0 0 5px #00ffcc, 0 0 10px #00ffcc, 0 0 15px #00ffcc, 0 0 20px #00ffcc, 0 0 25px #00ffcc, 0 0 40px #00ffcc;
            }
        }

        body {
            font-family: 'Courier New', Courier, monospace;
            background: linear-gradient(180deg, #1e3c72 0%, #2a5298 100%);
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #00ffcc;
            text-align: center;
        }

        .container {
            background: rgba(0, 0, 0, 0.85);
            padding: 40px 60px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 255, 204, 0.5);
            animation: flicker 1.5s infinite, neonGlow 5s alternate infinite;
        }

        h1, h3 {
            margin: 0;
            line-height: 1.5;
        }

        h1 {
            font-size: 4em;
            color: #00ffcc;
            animation: flicker 1.5s infinite, neonGlow 5s alternate infinite;
        }

        h3 {
            font-size: 1.5em;
            color: #00cccc;
            text-shadow: 0 0 5px #00cccc, 0 0 10px #00cccc, 0 0 15px #00cccc;
            animation: flicker 2s infinite;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>404</h1>
    <h3>요청하신 페이지가 존재하지 않습니다</h3>
</div>
</body>
</html>
