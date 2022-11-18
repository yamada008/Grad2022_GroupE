<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap Sample</title>
	<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
<div class="container px-4 px-lg-5 my-div-style">
    <div class="row gx-4 gx-lg-5 justify-content-center">
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
			<dd><input type="text" class="form-control input-sm" name="userId" value="" placeholder="希望IDを入力" /></dd>
			<dt><label for="userPass" class="control-label">パスワード：</label></dt>
			<dd><input type="password" class="form-control input-sm" name="userPass" value="" /></dd>
			<dt><label for="userName" class="control-label">お名前：</label></dt>
			<dd><input type="text" class="form-control input-sm" name="userName" value="" placeholder="本名を入力" /></dd>
		</dl>
				<input type="submit" name="register" value="新規登録" class="btn btn-success" />
		<a class="btn btn-danger"  href="/SotsukenE/">キャンセル</a>

		</c:otherwise>
		</c:choose>
		</form>
		</div>
	</div>
			<jsp:include page="/WEB-INF/jsp/index.jsp"/>
	</body>
</html>