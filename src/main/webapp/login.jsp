<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Login Page</title>
    
</head>
<body style=" background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('image/wallpaperflare.com_wallpaper (12).jpg')">
    
    <div class="login-container">
    <h1>Login</h1>
        <form action="logIn" method="get">
            <label for="email">UserID:</label>
            <input type="text" id="userID" name="userID" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="date_of_birth" required><br>
<%@ include file="message.jsp" %>

            <button type="submit" id="login1">Login</button>
         
        </form><br>
           <a href="facultyLogin.jsp"><button id="login">Login as faculty</button></a>
    </div>
  
    
</body>
</html>