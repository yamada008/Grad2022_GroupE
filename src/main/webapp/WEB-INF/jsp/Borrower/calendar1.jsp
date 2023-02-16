<%@page import="borrower.calendar.MyCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% MyCalendar mc=(MyCalendar)request.getAttribute("mc"); %>
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
        <link href="css/styles3.css" rel="stylesheet" />
        <link rel="stylesheet"  href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
        <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
        <link rel="stylesheet"  href="css/calendar.css">
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-light bg-light static-top">
            <div class="container">
                <a class="navbar-brand" href="/SotsukenE/borrow">イチから始める農業</a>
            </div>
        </nav>
        <!-- Icons Grid-->
        <section class="bg-light text-center">
        	<div id="container">
        		<h1><%=mc.getYear() %>年<%=mc.getMonth() %>月のカレンダー</h1>
        		<p>
        			<input type="hidden" name="num" value="${num }">
        			<%-- 前月へ移動 --%>
        			<a href="?num=${num}&year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>&num=${num}">前月</a>
        			<c:forEach var="day" items="${dayList }">
        			<%-- 当月へ移動 --%>
        			<a href="?num=${num}&year=${day.toyear }&month=${day.tomonth }">当月</a>
        			</c:forEach>
        			<%-- 翌月へ移動 --%>
        			<a href="?num=${num}&year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>">翌月</a>
        		</p>
        		
        		<table class=" bg-light">
        		
        		<%-- 曜日を表示 --%>
        		<tr>
        			<th>日</th>
        			<th>月</th>
        			<th>火</th>
        			<th>水</th>
        			<th>木</th>
        			<th>金</th>
        			<th>土</th>
        		</tr>
        		
        		<%-- 第一週を表示 --%>
        		<tr>
        			<%-- カレンダー一覧を表示する --%>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="1" end="7" step="1" var="i">
        			<%-- ひと月の日数と比較する --%>
        			<c:if test="${Calendar.num == i }">
        			
        			<td><c:out value="${Calendar.d_day}"></c:out></td>
        			
        			</c:if>
        			</c:forEach>
        			</c:forEach>
        		</tr>
        		
        		<%-- 第二週を表示 --%>
        		<tr>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="8" end="14" step="1" var="i">
        			<c:if test="${Calendar.num == i }">
        			
        			<td><c:out value="${Calendar.d_day}"></c:out></td>
        			
        			</c:if>
        			</c:forEach>
        			</c:forEach>
        		</tr>
        		
        		<%-- 第三週を表示 --%>
        		<tr>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="15" end="21" step="1" var="i">
        			<c:if test="${Calendar.num == i }">
        			
        			<td><c:out value="${Calendar.d_day}"></c:out></td>
        			
        			</c:if>
        			</c:forEach>
        			</c:forEach>
        		</tr>
        		
        		<%-- 第四週を表示 --%>
        		<tr>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="22" end="28" step="1" var="i">
        			<c:if test="${Calendar.num == i }">
        			
        			<td><c:out value="${Calendar.d_day}"></c:out></td>
        			
        			</c:if>
        			</c:forEach>
        			</c:forEach>
        		</tr>
        		
        		<%-- 第五週を表示 --%>
        		<tr>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="29" end="35" step="1" var="i">
        			<c:if test="${Calendar.num == i }">
        			
        			<td><c:out value="${Calendar.d_day}"></c:out></td>
        			
        			</c:if>
        			</c:forEach>
        			</c:forEach>
        		</tr>
        		
        		<%-- 第六週を表示 --%>
        		<tr>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="36" end="42" step="1" var="i">
        			<c:if test="${Calendar.num == i }">
        			
        			<td><c:out value="${Calendar.d_day}"></c:out></td>
        			
        			</c:if>
        			</c:forEach>
        			</c:forEach>
        		</tr>
        		
        		</table><br>
        		
        		<c:choose>
        			<%-- numが0の場合BorrowServlet.javaへ移動 --%>
        			<c:when test="${num == 0 }">
        			<a href="/SotsukenE/borrow">TOP</a>
        			</c:when>
        			<%-- numが1の場合CalendarNext1Servlet.javaへ移動 --%>
        			<c:when test="${num == 1 }">
        			<a href="/SotsukenE/CalendarNext">TOP</a>
        			</c:when>
        		</c:choose>
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