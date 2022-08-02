<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
<div class="header">
	<div class="headerchild">
    <h2 class="header">${account.name}&nbsp;さん</h2>
    </div>
    <div class="headerchild">
      <ul class="header">
        <li class="header">キャラクター：${player.job_name}</li>
        <li class="header">Lv：${player.getLv()}</li>
        <li class="header">所持金：${player.money}&nbsp;java</li>
      </ul>
    </div>
</div>
</header>