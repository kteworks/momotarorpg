<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/images/peach.png" sizes="16x16" />
<meta charset="UTF-8">
<title>rpg</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<main class="login">
<div class="login">
<h1 class="login">ももたろうRPG(仮)</h1>
 <a class="login" href="<%= request.getContextPath() %>/jsp/login.jsp">ログイン</a><br>
 <a class="login" href="<%= request.getContextPath() %>/jsp/register.jsp" >新規登録へ</a>
</div>
</main>
</body>
</html>