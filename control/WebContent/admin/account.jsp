<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ministere de l'Agriculture RDC_Admin_account</title>
<link rel="stylesheet" type="text/css" href="../original1.css">

</head>
<body class="body">
<div class="header">
          <p class="c1">République Démocratique du Congo<img class="c11" src="../emblem3.jpg" alt="Pineapple" "></p>
          <p class="c1">Cabinet du Ministre de l'agriculture</p>              
    </div>
   <div class="c4">Bienvenu</div>
   <br>
   
   <form name="change pw" action="changepw.jsp" method="POST">
            <div id="Changepw">
             <p><input type="submit" value="Changepw"> </p>   
            </div>
        </form>
   
   <form name="logout" action="../Logout" method="POST">
            <div id="Logout">
             <p><input type="submit" value="Logout" style="margin-left:15px;color:yellow;font-size: 20px; background-color:blue;background: linear-gradient(to bottom right, blue, #F5F5F9);border-radius: 20%;border-color:gray"> </p>   
            </div>
        </form>
 <table border="5" bordercolor= blue align="center">
<caption>Account Details</caption>
<tr>
	<th>AccountID</th>
	<th>User Name</th>
	<th>Password</th>
	
	<th>Account Status</th>
	<th>Account OPS Status</th>
	<th>Group Name</th>
</tr>  
   <%
Connection con = null;
String url = "jdbc:mysql://localhost:3306/agri";
String driver ="com.mysql.jdbc.Driver";
String userName ="enfant1";
String password="!Muepu$2016!";
int sumcount =0;
Statement st;


String username= request.getRemoteUser();

String query = "select * from accountadmin where user_name = '"+ username+"'";
try{
	Class.forName(driver).newInstance();
	con = DriverManager.getConnection(url,userName,password);
	
	
	st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	
%>
<%
while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>

<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
</tr>
<%} %>
<%
}
catch(Exception e){
	e.printStackTrace();
}
%>




</table>

 <form name="Modifier" action="../faces/admin/acceuil.xhtml" method="POST">
            <div id="Modifier">
             <p><input type="submit" value="Modifier" style="margin-left:15px;color:yellow;font-size: 20px; background-color:blue;background: linear-gradient(to bottom right, blue, #F5F5F9);border-radius: 20%;border-color:gray"> </p>   
            </div>
        </form>
 

</body>
</html>