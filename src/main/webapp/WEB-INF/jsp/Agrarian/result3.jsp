<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>イチから始める農業</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-light bg-light static-top">
            <div class="container">
                <a class="navbar-brand" href="/SotsukenE/agrarian">イチから始める農業</a>
            </div>
        </nav>
        <!-- Icons Grid-->
        <section class="bg-light text-center">
        <%-- EditNextServlet.javaへ値を送る --%>
        <form action="/SotsukenE/editNext" method="get">
            <div class="container">
                <div class="row">
                    <div class=col>
                         <div class="col-auto">
                         	<table class=" bg-light">
                         		<%-- 自分が投稿した農地一覧を表示する --%>
                         		<c:forEach var="Coll" items="${ControllerList }">
                         			<c:if test="${Coll.userId == name }">
                         				<tr>
                         					<th><input type="radio" name="id" value="${Coll.id}" ><br></th>
                         					<th>
                         						<p>ユーザーID:<c:out value="${Coll.userId }"></c:out></p>
                         						<p>名前:<c:out value="${Coll.name }"></c:out></p>
                         						<p>住所:<c:out value="${Coll.word }"></c:out></p>
                         						<p>広さ：<c:out value="${Coll.breadth }"></c:out></p>
                         						<p>畑の写真:<br><img src="/SotsukenE/upload/${Coll.filename }" class="example"></p>
                         					</th>
                         				</tr>
                         			</c:if>
                         		</c:forEach>
                         	</table>
                         	<p><input type="submit" value="確認"></p>
                         </div>
                    </div>
                </div>
            </div>
            </form>
        </section>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>