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
        <title>1から始める農業</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet"  href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
        <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
        <link rel="stylesheet"  href="css/calendar.css">
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-light bg-light static-top">
            <div class="container">
                <a class="navbar-brand" href="/SotsukenE/borrow">1から始める農業</a>
            </div>
        </nav>
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
        <div id="container">
    <h1><%=mc.getGengou() %>年<%=mc.getMonth() %>月のカレンダー</h1>
    <p>
		　<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>">前月</a>
    	<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>">翌月</a>
    </p>
    <table>
      <tr>
        <th>日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th>土</th>
      </tr>
      <%int i = 0; %>
      <%for(String[] row: mc.getData()){ %>
      <tr>
      	<%for(String col:row) {%>
      		<%if (col.startsWith("*")){ %>
      			<td class="today"><p><%=col.substring(1)%></p>
      			<c:forEach var="calendar" items="${ calendarList }">
      			<c:if test="${calendar.startYear == mc.getYear() && calendar.startMonth == mc.getMonth() }">
      			<c:if test="${calender.startD <= i && calemdar.endD >= i }">
      			<a href="#!"><button><c:out value="${calendar.title}"></c:out></button></a>
      			</c:if></c:if></c:forEach></td>
      		<%}else{ %>
      			<td><p><%=col %></p>
      			<c:forEach var="calendar" items="${ calendarList }">
      			<c:if test="${calendar.startYear == mc.getYear() && calendar.startMonth == mc.getMonth() }">
      			<c:if test="${calender.startD <= i && calemdar.endD >= i }">
      			<a href="#!"><button><c:out value="${calendar.title}"></c:out></button></a>
      			</c:if></c:if></c:forEach></td>
      		<%} %>
      		<%i++; %>
      	<%} %>
      </tr>
      <%} %>
    </table>
    <br><a class="nav-link" href="/SotsukenE/produce_search">戻る</a>
  </div><!-- end container-->
  <c:forEach var="calendar" items="${ calendarList }">
  <c:if test="${ calendar.id != null }">
  <c:out value="${calendar.name}"></c:out><br>
  </c:if>
  </c:forEach>
        </section>
        <!-- Call to Action-->
     
      <!-- Footer-->
        <footer class="footer bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                        <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2022. All Rights Reserved.</p>
                    </div>
                </div>
            </div>
        </footer>
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