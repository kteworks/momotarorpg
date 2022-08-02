<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Account,model.Player" %>
    <% Account account = (Account) session.getAttribute("account");
       Player player = (Player) session.getAttribute("player");
       String msg = (String) session.getAttribute("msg");
       int sp = account.getSkillPoint();%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/images/peach.png" sizes="16x16" />
<meta charset="UTF-8">
<title>rpg</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<main class="status">
<h2 class="status">ステータス</h2>
<div class="status">
	<div class="statusimg">
	<% String name="";switch(account.getJob_id()){case 0:name="momotaro";break;case 1:name="kintaro";break;case 2:name="urataro";break;} %>
		<img class="anim-box" src="<%= request.getContextPath() %>/images/<%= name %>.png" alt="たろう" title="たろう">
	</div>
	<div class="statususer">
		<p class="status bold">キャラクター：${player.job_name}</p>
		<p class="status">Lv：${player.getLv()}</p>
		<p class="status">Ex：${player.exp}</p>
		<p class="status">所持金：${player.money}&nbsp;java</p>
		<p class="status">HP：${player.status[3]}</p>
		<p class="status">MP：${player.status[4]}</p>
		<% if(sp != 0) {%><form action="/StatusServlet" method="post" oninput="resultpt.value=Number(${account.getSkillPoint()}) - (Number(atk.value) + Number(def.value) + Number(spd.value));"><% } %>
		<p class="status">攻撃：${player.status[0]}<% if(sp != 0) {%><input type="number" name="atk" min="0" max="${account.getSkillPoint()}" value="0" style="width: 4.6em;float: right;"><% } %></p>
		<p class="status">防御：${player.status[1]}<% if(sp != 0) {%><input type="number" name="def" min="0" max="${account.getSkillPoint()}" value="0" style="width: 4.6em;float: right;"><% } %></p>
		<p class="status">早さ：${player.status[2]}<% if(sp != 0) {%><input type="number" name="spd" min="0" max="${account.getSkillPoint()}" value="0" style="width: 4.6em;float: right;"><% } %></p>
		<% if(sp != 0) {%><p class="status">残りSP:<output name="resultpt">${account.getSkillPoint()}</output><button type="submit" name="jsp" value="jsp/status.jsp" style="float: right;">割り当て</button></p>
		<p class="error" style="width: calc(100% - 30px);">${errorMsg}</p>
		</form><% } %>
	</div>
	<div class="statusitem">
		<p class="statusitem bold">アイテム</p>
		<p class="statusitem" title="攻撃力UP！">みたらし団子：${player.item[0]}</p>
		<p class="statusitem" title="防御力UP！">きび団子：${player.item[1]}</p>
		<p class="statusitem" title="すばやさUP！">あん団子：${player.item[2]}</p>
		<p class="statusitem" title="HP回復">にく団子：${player.item[3]}</p>
		<p class="statusitem" title="MP回復">くさ団子：${player.item[4]}</p>
		<p class="statusitem" title="全ステータスUP！">どろ団子：${player.item[5]}</p>
	</div>
</div>
</main>
</body>
</html>