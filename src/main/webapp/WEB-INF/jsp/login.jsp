<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="margin: 100px;">

<form name="f" action="/Security/login" method="post">

<p style="color: red;">${error }</p>
<p style="color: green;">${message }</p>
UserName:<input type="text" name="username"><br><br>

Password:<input type="text" name="password"><br><br>
<br><br>
<input type="submit" value="Login">

</form>

</body>
</html>