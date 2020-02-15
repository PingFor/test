<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Login</title>
</head>
<body>
	<form action="/TestProject/login" method="post">		
		<table>
			<tr>
				<td>帳號:</td><td><input type="text" name="user"></td>
			</tr>			    
			<tr>
			    <td>密碼:</td><td><input type="text" name="password"></td>
			</tr>
			<tr>
			    <td>儲存密碼</td><td><input type="checkbox" name="isSave" value="True"></td>
			</tr>
			<tr>
				<td>${Msg}</td>				
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>