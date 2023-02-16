<%@page import="borrower.advise.Advise"%>
<%@page import="borrower.advise.AdviseDAO" %>
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
                <a class="navbar-brand" href="/SotsukenE/borrow">イチから始める農業</a>
            </div>
        </nav>
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
        	<%-- CalendarServlet.javaへ値を送る --%>
        	<form action="/SotsukenE/calendar" method="get">
        		<input type="hidden" name="startDate" value="${startDate }">
        		<input type="hidden" name="id" value="${id }">
        		<input type="hidden" name="i" value="${i }">
        		<div class="row">
        			<div class=col>
        				<div class="col-auto">
        					<%-- 条件に合ったおすすめ作物一覧を表示する --%>
        					<c:forEach var="advise" items="${ adviseList }">
        						<label><input type="radio" name="selectId" value="${advise.id}" >
        						<c:out value="${advise.name1}"></c:out><br>
        						<c:out value="${advise.name2}"></c:out><br>
        						<c:out value="${advise.name3}"></c:out></label><br><br>
        					</c:forEach>
        				<p><input type="submit" value="選択"></p>
        				</div>
        			</div>
        		</div>
        	<br><a class="nav-link" href="/SotsukenE/produce_search?id=${id }">戻る</a>
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