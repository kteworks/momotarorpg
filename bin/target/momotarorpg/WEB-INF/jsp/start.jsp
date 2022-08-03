<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/images/peach.png" sizes="16x16" />
<meta charset="UTF-8">
<title>rpg</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body class="start">
<jsp:include page="/WEB-INF/jsp/headerStart.jsp"/>
<main class="start">
<div class="start">
<a class="start"  href="<%= request.getContextPath() %>/jsp/nanido.jsp">スタート</a>
<a class="start"  href="<%= request.getContextPath() %>/jsp/status.jsp">ステータス</a>
<a class="start"  href="<%= request.getContextPath() %>/jsp/shop.jsp">ショップ</a>
<a class="start"  href="LogoutServlet">ログアウト</a>
</div>
</main>
</body>
</html>