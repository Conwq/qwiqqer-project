<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Qwiqqer Posts</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: white;
        }

        header {
            background-color: #ffffff;
            border-bottom: 1px solid #000000;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
        }

        #logo {
            font-size: 24px;
        }

        #menu {
            width: 10%;
            border-right: 1px solid #000000;
            padding: 20px;
        }

        #content {
            width: 80%;
            margin: 20px auto;
            border: 1px solid #000000;
            padding: 20px;
        }

        footer {
            background-color: #ffffff;
            border-top: 1px solid #000000;
            text-align: center;
            padding: 10px;
            position: absolute;
            bottom: 0;
            width: 100%;
        }

        #search {
            width: 100%;
            text-align: center;
        }

        #login-button {
            background-color: orange;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<header>
    <div id="logo">
        <img src="logo.png" alt="Qwiqqer Logo" style="width: 50px; height: 50px;">
        Qwiqqer
    </div>
    <div id="search">
        <input type="text" placeholder="Search">
    </div>
    <div>
        <button id="login-button">Log in</button>
    </div>
</header>
<div id="menu">
    <a href="#">Главная</a>
    <a href="#">Профиль</a>
    <a href="#">Настройки</a>
    <a href="#">Выход</a>
</div>
<div id="content">
    <div class="post">
        <h2>Заголовок поста 1</h2>
        <p>Это текст первого поста. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
    <div class="post">
        <h2>Заголовок поста 2</h2>
        <p>Это текст второго поста. Ut cursus justo in est cursus posuere.</p>
    </div>
    <div class="post">
        <h2>Заголовок поста 3</h2>
        <p>Это текст третьего поста. Vestibulum suscipit felis in sem tristique vehicula.</p>
    </div>
</div>
<footer>
    &copy; 2023 Qwiqqer. All rights reserved.
</footer>
</body>
</html>
