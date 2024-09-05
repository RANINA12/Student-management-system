<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Faculty Login Page</title>
    <style type="text/css">
    
    body{
    background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('image/wallpaperflare.com_wallpaper (12).jpg');
    }
    
    
    </style>
</head>
<body>
    
    <div class="login-container">
    <h1>Login</h1>
        <form action="facultylogin" method="get">
            <label for="text">Name:</label>
            <input type="text" id="userID" name="userID" required><br>
            <label for="password">ComputerCode:</label>
            <input type="password" id="password" name="code" required><br>
            <%@ include file="message.jsp" %>
            <button type="submit" id=login1>Login as faculty</button>
         
        </form><br>
    </div>
</body>
</html>