<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@page import="javax.servlet.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Confirmation Admin	
</div>
<div class="card-body">
<div class="form-group">
<form action=Login method=post >
<table>

<label class="control-label">Login :</label>
<input type="text" name="Login" class="form-control" />
<label class="control-label">Password :</label>
<input type="password" name="Password" class="form-control"/>
<tr><td><input type ="submit" value = "submit"></td></tr>
</table>
</form>
</div>
<div>

</div>
</div>
</div>
</div>
</div>
</body>
</html>