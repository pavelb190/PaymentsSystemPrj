<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App Login Form&copy;</title>
</head>
<body>
	<form action="?controller=login" method="POST">
		<table border="1">
			<tr>
				<td>User: </td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="pswd" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Login >>" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>