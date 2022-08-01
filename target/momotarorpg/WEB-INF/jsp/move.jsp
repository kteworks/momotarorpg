<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Quest" %>
    <% Quest quest = (Quest) session.getAttribute("quest"); 
    int diff = 1, stage = 1;
    if(quest.getDifficulty().equals("easy")) {
    	diff = 1;
    } else if(quest.getDifficulty().equals("normal")) {
    	diff = 2;
    } else if(quest.getDifficulty().equals("hard")) {
    	diff = 3;
    }
    if(quest.getStage()==1){
    	stage = 1;
    }else if(quest.getStage()==2){
    	stage = 2;
    }if(quest.getStage()==3){
    	stage = 3;
    }
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/images/peach.png" sizes="16x16" />
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3.5;URL=<%=request.getContextPath() %>/jsp/battle.jsp">
<title>rpg</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>

<main>
<% int i=1; if(i != 0){ %>
<img class="move2-1" src="<%= request.getContextPath() %>/images/loading/<%= diff %>-<%= stage %>.png" alt="#"  style="width:100vw; height: 100vh; background-repeat:no-repeat; background-size:cover;">
<% } %>
<img src="<%= request.getContextPath() %>/images/momo.png" class="keyframe0 animation" alt="#" style="float:left">

</main>
</body>
</html>