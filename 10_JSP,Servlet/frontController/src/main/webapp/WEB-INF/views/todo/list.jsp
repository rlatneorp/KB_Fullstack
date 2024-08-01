<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo 목록 보기</title>
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
                transform: translateY(-10px);
            }
            60% {
                transform: translateY(-5px);
            }
        }

        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.1);
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
            flex-direction: column;
            align-items: center;
            padding: 20px;
            min-height: 100vh;
            color: #333;
        }

        h1 {
            font-size: 3em;
            color: #ff6f61;
            animation: fadeInUp 1s ease-in-out;
            margin-bottom: 20px;
        }

        .todo-list {
            width: 100%;
            max-width: 500px;
            background: #fff;
            border-radius: 20px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.1);
            padding: 20px;
            animation: fadeInUp 1s ease-in-out;
        }

        .todo-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 20px 0;
            border-bottom: 1px solid #f0f0f0;
            text-align: center;
        }

        .todo-item:last-child {
            border-bottom: none;
        }

        .todo-item p {
            margin: 0;
            padding: 0;
        }

        .todo-item a {
            text-decoration: none;
            color: #ffa500;
            margin-left: 20px;
            transition: color 0.3s ease, transform 0.3s ease;
        }

        .todo-item a:hover {
            color: #ff7f50;
            transform: scale(1.1);
        }

        .actions {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            width: 100%;
        }

        .actions a {
            display: inline-block;
            padding: 12px 24px;
            background-color: #ffa500;
            color: #fff;
            text-decoration: none;
            border-radius: 30px;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: bounce 1s infinite;
        }

        .actions a:hover {
            background-color: #ff7f50;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<h1>Todo 목록 보기</h1>
<div class="todo-list">
    <c:forEach items="${todoList}" var="t">
        <div class="todo-item">
            <tr>
                <td>
                    ${t}
                </td>
                <td>
                    <a href="view">상세보기</a>
                </td>
            </tr>
        </div>
    </c:forEach>
</div><br>
<div class="actions">
    <a href="create">새 Todo</a>
</div>
</body>
</html>
