<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="borrower.calendar.CalendarDAO" %>
<% CalendarDAO dao = new CalendarDAO(); %>
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
                <a class="navbar-brand" href="/SotsukenE/CalendarNext">イチから始める農業</a>
                <a class="nav-link" href="/SotsukenE/CalendarNext?logout=true">Log Out</a>
            </div>
        </nav>
        <!-- Masthead-->
       
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
            <div class="container">
                <div class="row">
                	<div class=col>
                		<div class="col-auto">
                			<%-- EndConfServlet.javaへ値を送る --%>
                			<form action="/SotsukenE/endConf" method="get">
                				<input type="hidden" name="id" value="${id }">
                				<input type="hidden" name="num" value="${num }">
                				<p><input type="submit" value="作業終了"></p>
                			</form>
                		</div><br>
                		<div class="col-auto">
                			<%-- Calendar1Servlet.javaへ値を送る --%>
                			<form action="/SotsukenE/Calendar" method="get">
                				<input type="hidden" name="num" value="${num }">
                				<p><input type="submit" value="カレンダーを見る"></p>
                			</form>
                		</div>
                	</div>
                </div>
            </div>
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