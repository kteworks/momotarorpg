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
<h2 class="select">フィールド選択</h2>

	<div class="selectimg">
		<img class="anim-box" src="<%= request.getContextPath() %>/images/bainin.png" alt="#">
	</div>
	<div  class="selecthanashi">
		<p>
		どこにしようかな、、、<br>
		とりあえず、倒しにいくのじゃ！<br>
		選ぶがよい！！<br>
		</p>
	</div>
<div class="select">
<form action="/QuestServlet" method="post">
<div>

	<div class="selectmomo">
		<p class="select bold">アトランティス</p>
		<br>
		<p class="select bold"><img class="select" src="<%= request.getContextPath() %>/images/tinbotsu.png" alt="#"></p>
		<br>
		<p class="select bold">EASY</p>
		<p class="select bold">推奨Lv１～</p>
		<br>
        <div class="selectlist">
        	<button class="select" type="submit" name="difficulty" value="easy">選択</button>
        </div>
	</div>
	<div class="selectkin">
		<p class="select bold">ジャングル</p>
		<br>
		<p class="select bold"><img class="select" src="<%= request.getContextPath() %>/images/mori2.png" alt="#"></p>
		<br>
		<p class="select bold">NORMAL</p>
		<p class="select bold">推奨Lv２～</p>
		<br>
        <div class="selectlist">
        	<button class="select" type="submit" name="difficulty" value="normal">選択</button>
        </div>
	</div>
	<div class="selectura">
		<p class="select bold">鬼ヶ島</p>
		<br>
		<p class="select bold"><img class="select" src="<%= request.getContextPath() %>/images/umiumi.png" alt="#"></p>
		<br>
		<p class="select bold">HARD</p>
		<p class="select bold">推奨Lv３～</p>
		<br>
        <div class="selectlist">
        	<button class="select" type="submit" name="difficulty" value="hard">選択</button>
        </div>
	</div>

</div>
</form>
</div>
</main>
</body>
</html>