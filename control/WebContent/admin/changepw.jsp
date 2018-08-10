<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ministere de l'Agriculture RDC_Admin_account_ChangePW</title>
<link rel="stylesheet" type="text/css" href="../original1.css">


</head>
<body class="body">
   <div class="header">
          <p class="c1">République Démocratique du Congo<img class="c11" src="../emblem3.jpg" alt="Pineapple" "></p>
          <p class="c1">Cabinet du Ministre de l'agriculture</p>              
    </div>
        <h4>Changer password or email</h4>
        
        <form name="updatepw" action="../Updatepw" method="POST">
            
            Password  :<input type="text" name="password" size="20" value=""><br>
            Email  :<input type="text" name="email" size="20" value=""><br>
            <input type="submit" value="submit">
        </form>

</body>
</html>