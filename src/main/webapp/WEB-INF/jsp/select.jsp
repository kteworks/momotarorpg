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
<jsp:include page="/WEB-INF/jsp/headerselect.jsp"/>
<main class="start">
<h2 class="select">キャラクター選択</h2>

	<div class="selectimg">
		<img class="anim-box" src="<%= request.getContextPath() %>/images/bainin.png" alt="#">
	</div>
	<div  class="selecthanashi">
		<p>
		むかしむかしあるところに、、、<br>
		とりあえず、倒しにいくのじゃ！<br>
		選ぶがよい！！<br>
		</p>
	</div>
<div class="select">
<form action="/rpg/JobServlet" method="post">
<div>

	<div class="selectmomo">
		<p class="select bold">ももたろう</p>
		<br>
		<p class="select bold"><img class="select" src="<%= request.getContextPath() %>/images/momotaro.png" alt="#"></p>
		<br>
		<p class="select bold">HP：&nbsp;&nbsp;高い</p>
		<p class="select bold">MP：&nbsp;&nbsp;高い</p>
		<br>
        <div class="selectlist">
        	<button class="select" type="submit" name="cName" value="ももたろう">選択</button>
        </div>
	</div>
	<div class="selectkin">
		<p class="select bold">きんたろう</p>
		<br>
		<p class="select bold"><img class="select" src="<%= request.getContextPath() %>/images/kintaro.png" alt="#"></p>
		<br>
		<p class="select bold">攻撃：高い</p>
		<p class="select bold"></p>
		<br>
        <div class="selectlist">
        	<button class="select" type="submit" name="cName" value="きんたろう">選択</button>
        </div>
	</div>
	<div class="selectura">
		<p class="select bold">うらたろう</p>
		<br>
		<p class="select bold"><img class="select" src="<%= request.getContextPath() %>/images/urataro.png" alt="#"></p>
		<br>
		<p class="select bold">防御：高い</p>
		<p class="select bold">早さ：高い</p>
		<br>
        <div class="selectlist">
        	<button class="select" type="submit" name="cName" value="うらたろう">選択</button>
        </div>
	</div>

</div>
</form>
</div>
</main>
</body>
</html>