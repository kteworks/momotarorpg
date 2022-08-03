<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/images/peach.png" sizes="16x16" />
<meta charset="UTF-8">
<title>RPG</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<main class="login">
	<div class="login">
	<h2 class="login">ログイン</h2>
	<form action="/LoginServlet" method="post">
	<table class="login">
		<tr class="login">
			<td class="login">ユーザーID</td>
			<td class="logininput"><input class="login" type="text" name="name"></td>
		</tr>
		<tr class="login">
			<td class="login">パスワード</td>
			<td class="logininput"><input class="login" type="password" name="pass"></td>
		</tr>
	</table>
	<div class="loginbutton">
	<input  class="loginbutton" type="submit" value="ログイン">
	<a class="loginbutton" href="<%= request.getContextPath() %>/index.jsp">TOP画面へ</a><br>
	</div>
	</form>

	<p class="error">${errorMsg}</p>
	</div>
</main>
</body>
</html>