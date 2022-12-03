<%@page import="metier.SingletonConnection"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ page import = "java.sql.*"
%>
<%@ page import = "metier.*"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Recherche des Ouvrages
</div>
<div class="card-body">
<form action="chercher" method="get">
<label>Mot Clé</label>
<input type="text" name="motCle"  />        <!--value="${model.motCle}"-->
<tr><td><input type ="submit" value = "Rechercher" name="action"></td></tr>
</form>
<table class="table table-striped">
<tr>
<th>ID</th><th>Nom Ouvrage</th><th>Matiere</th><th>Niveau</th><th>Lire</th>
</tr>
<%
Connection conn = SingletonConnection.getConnection();
try {
Class.forName("com.mysql.jdbc.Driver");
conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_MVC_CAT","root","");
PreparedStatement pst = conn.prepareStatement("SELECT * FROM mybook");
ResultSet rs = pst.executeQuery();
while(rs.next()){
	%>
	<tr>
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td ><a href=<%=rs.getString(5) %>><%=rs.getString(5) %></a></td>
	</tr>
	<%
}
rs.close();
pst.close();
conn.close();
}catch(Exception e){
	System.out.print(e);
}
%>

</table>
</div>
</div>
</div>
</body>
</html>