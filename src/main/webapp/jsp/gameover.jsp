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


<main class="gameover">


<div class="gameovercomment">
<p class="line-1 anim-typewriter1">気づいた時には、目の前は真っ暗だった。</p>
<p class="line-2 anim-typewriter2">だがそこから先に進むことはない。</p>
<p class="line-3 anim-typewriter3">どのくらい時がたったのだろう。</p>
<p class="line-4 anim-typewriter4">100年くらいまでは数えていたが、それももうやめた。</p>
<p class="line-5 anim-typewriter5">死ぬことはできない、意識を無くすこともできない。</p>
<p class="line-6 anim-typewriter6">ただ時間を１秒１秒、じっくり認識させられながら、時だけが過ぎていくのだった。</p>
</div>

<a href="<%=request.getContextPath() %>/MainServlet">戻る</a>

</main>

</body>
</html>