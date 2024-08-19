<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather App</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
            transition: background-color 1s ease;
        }

        .weather-container {
            background: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            padding: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 300px;
            width: 100%;
            position: relative;
            transition: background-color 1s ease;
        }

        .weather-container h2 {
            font-size: 2em;
            margin-bottom: 10px;
            color: #1e3c72;
        }

        .weather-container img {
            vertical-align: middle;
            width: 50px;
            height: 50px;
        }

        .weather-description {
            font-size: 1.2em;
            margin-bottom: 15px;
        }

        .temperature {
            font-size: 1.5em;
            margin-bottom: 5px;
            color: #ff8c00;
        }

        .humidity {
            font-size: 1em;
            color: #555;
        }

        /* Seasonal pastel backgrounds */
        .spring {
            background-color: #f8e1f4;
        }

        .summer {
            background-color: #fff4b3;
        }

        .fall {
            background-color: #ffd1a9;
        }

        .winter {
            background-color: #d4ebf2;
        }

        /* Faster and more dynamic seasonal animations */
        @keyframes summerAnimation {
            0% { background-color: #fff4b3; }
            50% { background-color: #ffdb4d; }
            100% { background-color: #fff4b3; }
        }

        @keyframes winterAnimation {
            0% { background-color: #d4ebf2; }
            50% { background-color: #b3d9ea; }
            100% { background-color: #d4ebf2; }
        }

        @keyframes springAnimation {
            0% { background-color: #f8e1f4; }
            50% { background-color: #f5c3ed; }
            100% { background-color: #f8e1f4; }
        }

        @keyframes fallAnimation {
            0% { background-color: #ffd1a9; }
            50% { background-color: #ffab66; }
            100% { background-color: #ffd1a9; }
        }

        .spring-animation {
            animation: springAnimation 4s infinite alternate;
        }

        .summer-animation {
            animation: summerAnimation 4s infinite alternate;
        }

        .fall-animation {
            animation: fallAnimation 4s infinite alternate;
        }

        .winter-animation {
            animation: winterAnimation 4s infinite alternate;
        }
    </style>
</head>
<body>
<div class="weather-container">
    <h2>${city}</h2>
    <div class="weather-description">
        오늘의 날씨: ${weather.weather[0].description} <img src="${iconUrl}" alt="Weather icon"/>
    </div>
    <div class="temperature">온도: ${weather.main.temp}°</div>
    <div class="humidity">습도: ${weather.main.humidity}%</div>
</div>

<script>
    function setSeasonalTheme() {
        const month = new Date().getMonth();
        const weatherContainer = document.querySelector('.weather-container');
        const body = document.body;

        if (month >= 2 && month <= 4) { // Spring (March, April, May)
            weatherContainer.classList.add('spring', 'spring-animation');
            body.classList.add('spring');
        } else if (month >= 5 && month <= 7) { // Summer (June, July, August)
            weatherContainer.classList.add('summer', 'summer-animation');
            body.classList.add('summer');
        } else if (month >= 8 && month <= 10) { // Fall (September, October, November)
            weatherContainer.classList.add('fall', 'fall-animation');
            body.classList.add('fall');
        } else { // Winter (December, January, February)
            weatherContainer.classList.add('winter', 'winter-animation');
            body.classList.add('winter');
        }
    }

    setSeasonalTheme();
</script>

</body>
</html>
