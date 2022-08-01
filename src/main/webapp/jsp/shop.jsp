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
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<main class="start">
<h2 class="shop">アイテムショップ</h2>

	<div class="shopimg">
		<img class="anim-box" src="<%= request.getContextPath() %>/images/bainin.png" alt="#">
	</div>
	<div  class="shophanashi">
		<p>
		よう来たね。<br>
		ゆっくりして、、、、<br>
		早く選んで戦え！！<br>
		</p>
	</div>
<div class="shop">
<form action="/rpg/ShopServlet" method="post">
<div>

	<div class="shopmitarashi">
		<p class="shop bold">みたらしだんご</p>
		<p class="shop bold"><img class="shop" src="<%= request.getContextPath() %>/images/mitarashi.png" title="攻撃力UP！"></p>
		<p class="shop bold">値段：100&nbsp;java</p>
		<p class="shop bold">所持：${player.item[0]}&nbsp;こ</p>
		<br>
        <div class="shoplist">
        	<button class="shop" type="submit" name="iName" value="0" title="所持上限3個">選択</button>
        </div>
	</div>
		<div class="shopkibi">
		<p class="shop bold">きびだんご</p>
		<p class="shop bold"><img class="shop" src="<%= request.getContextPath() %>/images/kibi.png" title="防御力UP！"></p>
		<p class="shop bold">値段：100&nbsp;java</p>
		<p class="shop bold">所持：${player.item[1]}&nbsp;こ</p>
		<br>
        <div class="shoplist">
        	<button class="shop" type="submit" name="iName" value="1" title="所持上限3個">選択</button>
        </div>
	</div>
	<div class="shopan">
		<p class="shop bold">あんだんご</p>
		<p class="shop bold"><img class="shop" src="<%= request.getContextPath() %>/images/an.png" title="すばやさUP！"></p>
		<p class="shop bold">値段：100&nbsp;java</p>
		<p class="shop bold">所持：${player.item[2]}&nbsp;こ</p>
		<br>
        <div class="shoplist">
        	<button class="shop" type="submit" name="iName" value="2" title="所持上限3個">選択</button>
        </div>
	</div>
		<div class="shopniku">
		<p class="shop bold">にくだんご</p>
		<p class="shop bold"><img class="shop" src="<%= request.getContextPath() %>/images/niku.png" title="HP回復"></p>
		<p class="shop bold">値段：100&nbsp;java</p>
		<p class="shop bold">所持：${player.item[3]}&nbsp;こ</p>
		<br>
        <div class="shoplist">
        	<button class="shop" type="submit" name="iName" value="3" title="所持上限3個">選択</button>
        </div>
	</div>
		<div class="shopkusa">
		<p class="shop bold">くさだんご</p>
		<p class="shop bold"><img class="shop" src="<%= request.getContextPath() %>/images/kusa.png" title="MP回復"></p>
		<p class="shop bold">値段：100&nbsp;java</p>
		<p class="shop bold">所持：${player.item[4]}&nbsp;こ</p>
		<br>
        <div class="shoplist">
        	<button class="shop" type="submit" name="iName" value="4" title="所持上限3個">選択</button>
        </div>
	</div>
	<div class="shopdoro">
		<p class="shop bold">どろだんご</p>
		<p class="shop bold"><img class="shop" src="<%= request.getContextPath() %>/images/doro.png" title="攻撃力or防御力orすばやさがランダムでUP！"></p>
		<p class="shop bold">値段：100&nbsp;java</p>
		<p class="shop bold">所持：${player.item[5]}&nbsp;こ</p>
		<br>
        <div class="shoplist">
        	<button class="shop" type="submit" name="iName" value="5" title="所持上限3個">選択</button>
        </div>
	</div>


</div>
</form>
</div>

<div class="error">
<p class="error">${errorMsg}</p>
<p class="success">${msg}</p>
</div>

</main>
</body>
</html>