<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection</title>
<link rel="stylesheet" type="text/css" href="../original1.css">
</head>
<body class="body">

    <div class="header">
          <p class="c1">République Démocratique du Congo<img class="c11" src="../emblem3.jpg" alt="Pineapple" "></p>
          <p class="c1">Cabinet du Ministre de l'agriculture</p>              
    </div>
   <div class="c4">Mise a jour du site</div>
   <br>
   <div class="c4">Connection</div>
   <form action="j_security_check" method="POST">
    <div id="loginBox">
        <p><strong style="color:blue;font-size: 20px;margin-left:25px">user name:</strong>
            <input type="text" size="10" style="height:25px;font-size:10pt;" name="j_username"></p>
        <p><strong style="color:blue;font-size: 20px;margin-left:25px">password:</strong>
            <input type="password" size="10" style="height:25px;font-size:10pt;" name="j_password"></p>
        <p><input type="submit" value="Connecter" style="color:yellow;font-size: 20px; background-color:blue;background: linear-gradient(to bottom right, blue, #F5F5F9);border-radius: 20%;border-color:gray;font-size: 20px;margin-left:25px;"></p>
    </div>
</form>
</body>
</html>