<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,model.Quest,servlet.BattleServlet" %>
    <% 
    Quest quest = (Quest) session.getAttribute("quest"); 
	Integer lv = (Integer)session.getAttribute("lv");
	String errorMsg = (String) request.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/images/peach.png" sizes="16x16" />
<meta charset="UTF-8">
<% if(quest.getpRemainHP() <= 0){ %>
<meta http-equiv="refresh" content="4; URL=<%=request.getContextPath() %>/jsp/gameover.jsp">
<% } %>
<title>rpg</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body class="battle" background="<%= request.getContextPath() %>/images/${quest.getEnemy().getType() }_h.png" style="width:100vw; height: 100vh; background-repeat:no-repeat; background-size:cover;">
<jsp:include page="/WEB-INF/jsp/headerStart.jsp"/>
<main class="battle">
<div class="battle">
<div class="battleimg">
<div class="hp"><p>HP</p><progress class="teki" value="${quest.geteRemainHP() }" max="${quest.getEnemy().getStatus()[3]}"></progress></div>
<img class="anim-box" src="<%= request.getContextPath() %>/images/${quest.getEnemy().getType() }.png" alt="てき" title="${quest.getEnemy().getType() }">
</div>
<div class="container">
      	<p class="bold">ステータス</p>
        <p class="lv">Lv：${player.getLv()}</p>
        <p class="lv">HP：${quest.getpRemainHP()}</p><br>
        <progress class="user" value="${quest.getpRemainHP() }" max="${quest.getPlayer().getStatus()[3]}"></progress>
        <p class="lv">MP：${quest.getpRemainMP()}</p>
</div>
<div class="battlelist">
<form action="/BattleServlet" method="post">
<button class="battle" type="submit" name="action" value="攻撃">たたかう</button>
<button class="battle" type="submit" name="action" value="魔法攻撃">まほう</button>
<div class="battleitem">
  <p class="battle">アイテム</p>
  <div class="itemlist">
  	<div class="itemsu">
		<% if(quest.getPlayer().getItem()[0] != 0) {%>
		<button class="battle" type="submit" name="action" value="0" title="攻撃力UP！">みたらしだんご</button>
		<p id="su">${quest.getPlayer().getItem()[0]}</p>
		<% } %>
	</div>
	<div class="itemsu">
		<% if(quest.getPlayer().getItem()[1] != 0) {%>
  		<button class="battle" type="submit" name="action" value="1" title="防御力UP！">きびだんご</button>
  		<p id="su">${quest.getPlayer().getItem()[1]}</p>
  	<% } %>
	</div>
	<div class="itemsu">
  		<% if(quest.getPlayer().getItem()[2] != 0) {%>
  		<button class="battle" type="submit" name="action" value="2" title="すばやさUP！">あんだんご</button>
  		<p id="su">${quest.getPlayer().getItem()[2]}</p>
   	<% } %>
	</div>
	<div class="itemsu">
  		<% if(quest.getPlayer().getItem()[3] != 0) {%>
  		<button class="battle" type="submit" name="action" value="3" title="HP回復">にくだんご</button>
  		<p id="su">${quest.getPlayer().getItem()[3]}</p>
  	<% } %>
	</div>
	<div class="itemsu">
  		<% if(quest.getPlayer().getItem()[4] != 0) {%>
  		<button class="battle" type="submit" name="action" value="4" title="MP回復">くさだんご</button>
  		<p id="su">${quest.getPlayer().getItem()[4]}</p>

  	<% } %>
	</div>
	<div class="itemsu">
	<% if(quest.getPlayer().getItem()[5] != 0) {%>
  		<button class="battle" type="submit" name="action" value="5" title="攻撃力or防御力orすばやさがランダムでUP！">どろだんご</button>
  		<p id="su">${quest.getPlayer().getItem()[5]}</p>
  		<% } %>
	</div>
</div>
</div>

  <label class="open" for="pop-up">にげる</label>
<input type="checkbox" id="pop-up">
<div class="overlay">
	<div class="window">
		にげました。村へ戻ります。<br><br>
	<button id="battleesc" type="submit" name="action" value="逃げる">OK</button>
	</div>
</div>
</form>
</div>
<div class="battlecomment">
<p><% int n = 0;for(String str : quest.getBattlelog()) { %>
<span style="animation: animtext 0s steps(1) <%= ++n %>s 1 normal both;">
<%= str %></span><br>
 <% } %></p>
</div>
</div>
<%if(quest.getStage() == 3){ %>
	<% if(lv != null){ %>
		<% if(errorMsg == null) { %>
		<div class="overlaypt">
		<% } else { %>
		<div style="display: block;z-index: 9999;background-color: #00000070;position: fixed;width: 100vw;top: 0%;left: 0%;transform: translate(0%, 0%);height: 100vh;overflow:visible">
		<% } %>
	
	<div class="battlept">
	<form action="/StatusServlet" method="post" oninput="resultpt.value=Number(${quest.getAccount().getSkillPoint()}) - (Number(atk.value) + Number(def.value) + Number(spd.value));">
 	<div class="battleptcomment">
	<p>おめでとうございます！ボスに勝利しました！！<br>
	レベルが上がりました！！ステータスポイントを割り振ってください。<br>
	※余ったポイントは別途ステータス画面で割り振ることができます。</p>
	<p>残り<output name="resultpt">${quest.getAccount().getSkillPoint()}</output>pt</p>
	<p>攻撃<input class="battlept" type="number" name="atk" value="0" min="0" max="${quest.getAccount().getSkillPoint()}">pt<br></p>
	<p>防御<input class="battlept" type="number" name="def" value="0" min="0" max="${quest.getAccount().getSkillPoint()}">pt<br></p>
	<p>速さ<input class="battlept" type="number" name="spd" value="0" min="0" max="${quest.getAccount().getSkillPoint()}">pt<br></p>
	<p class="errorpt">${errorMsg}</p>
	<button class="battlesubmit" type="submit" name="jsp" value="/QuestServlet">ポイントを割り振る</button>
	</div>
	</form>
	</div>
	</div>
	<% }else if(lv == null && quest.geteRemainHP() <= 0){ %>
	<div class="overlaynext">
	<div class="battlenext">
		<div class="battlenextcomment">
		<form action="/QuestServlet" method="post">
			<p>おめでとうございます！<br>
			ボスに勝利しました！！<br>
			村へ戻ります。<br>
			<input class="battlenext" type="submit" value="OK">
		</form>
		</div>
	</div>
	<% if(errorMsg == null) { %>
	</div>
	<% } else { %>
	</div>
	<% }  %>
	<% } %>
<%}else{ %>
	<% if(lv != null){ %>
	<% if(errorMsg == null) { %>
	<div class="overlaypt">
	<% } else { %>
	<div style="display: block;z-index: 9999;background-color: #00000070;position: fixed;width: 100vw;top: 0%;left: 0%;transform: translate(0%, 0%);height: 100vh;overflow:visible">
	<% } %>
	<div class="battlept">
	<form action="/StatusServlet" method="post" oninput="resultpt.value=Number(${quest.getAccount().getSkillPoint()}) - (Number(atk.value) + Number(def.value) + Number(spd.value));">
	<div class="battleptcomment">
	<p>勝利おめでとうございます！<br>
		レベルが上がりました！！<br>
	ステータスポイントを割り振ってください。<br>
	※余ったポイントは別途ステータス画面で割り振ることができます。</p>
	<p>残り<output name="resultpt">${quest.getAccount().getSkillPoint()}</output>pt</p>
	<p>攻撃<input class="battlept" type="number" name="atk" value="0" min="0" max="${quest.getAccount().getSkillPoint()}">pt<br></p>
	<p>防御<input class="battlept" type="number" name="def" value="0" min="0" max="${quest.getAccount().getSkillPoint()}">pt<br></p>
	<p>速さ<input class="battlept" type="number" name="spd" value="0" min="0" max="${quest.getAccount().getSkillPoint()}">pt<br></p>
	<p class="errorpt">${errorMsg}</p>
	<button class="battlesubmit" type="submit" name="jsp" value="jsp/battle.jsp">ポイントを割り振る</button>
	</div>
	</form>
	</div>
	</div>
	<% }else if(lv == null && quest.geteRemainHP() <= 0){ %>
	<div class="overlaynext">
	<div class="battlenext">
		<div class="battlenextcomment">
		<form action="/QuestServlet" method="post">
			<p>勝利おめでとうございます！<br>
			次のバトルへ移動します。<br>
			<input class="battlenext" type="submit" value="OK">
		</form>
		</div>
	</div>
	<% if(errorMsg == null) { %>
	</div>
	<% } else { %>
	</div>
	<% } %>
	<% } %>
<% } %>
</main>
 </body>
</html>