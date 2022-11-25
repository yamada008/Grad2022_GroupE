<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="user.UserBean" scope="session" />
<link href="css/styles.css" rel="stylesheet" />

<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">
			<span class="glyphicon glyphicon-user"></span>&nbsp;ユーザー</h3>
	</div>
	<div class="container px-4 px-lg-5 my-div-style">
    <div class="row gx-4 gx-lg-5 justify-content-center">
       
           <h1 class="mb-3" style="text-align: center">ログイン画面</h1>
		<form method="post" action="./user">
		<c:choose>
		<c:when test="${ user.isAuth() }">
			<p>ようこそ!、${ user.getUserId() }さん</p>
			<a class="btn btn-default" href="/SotsukenE/">トップへ</a>
			<%--<input type="submit" class="btn btn-default" name="logout" value="ログアウト" /> --%>
		</c:when>
		<c:otherwise>
			<dl>
				<dt><label for="userId" class="control-label">ユーザーID：</label></dt>
				<dd><input type="text" class="form-control input-sm" name="userId" value="" /></dd>
				<dt><label for="userPass" class="control-label">パスワード：</label></dt>
				<dd><input type="password" class="form-control input-sm" name="userPass" value="" /></dd>
			</dl>
			<input type="submit" class="btn btn-success" name="login" value="ログイン" />
			<a class="btn btn-primary float-right" href="./user?register=true">新規登録</a>
		</c:otherwise>
		</c:choose>
		</form>
		<jsp:include page="/WEB-INF/jsp/index.jsp"/>
		</div>
	</div>
</div>
<%-- --%>