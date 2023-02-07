<%@page import="borrower.calendar.MyCalendar"%>
<%@page import="borrower.calendar.CalendarDAO" %>
<%@page import="borrower.calendar.CalendarDateBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% MyCalendar mc=(MyCalendar)request.getAttribute("mc"); %>
<% CalendarDAO dao = new CalendarDAO(); %>
<% CalendarDateBean calendarDate = (CalendarDateBean) request.getAttribute("calendarDate"); %>
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
                <a class="navbar-brand" href="/SotsukenE/calendarNext">イチから始める農業</a>
            </div>
        </nav>
        <!-- Icons Grid-->
        <section class="bg-light text-center">
        <div id="container">
    <h1><%=mc.getYear() %>年<%=mc.getMonth() %>月のカレンダー</h1>
    <p>
    <input type="hidden" name="startDate" value="${startDate }">
    <input type="hidden" name="selectId" value="${selectId }">
		　<a href="?startDate=${startDate }&selectId=${selectId }&year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>">前月</a>
    	<a href="?startDate=${startDate }&selectId=${selectId }&year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>">翌月</a>
    </p>
    <table class=" bg-light">
      <tr>
        <th>日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th>土</th>
      </tr>
      
     <tr>
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarDateList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="1" end="7" step="1" var="i">
		<c:if test="${Calendar.num == i }">
		
		<td>
			<c:out value="${Calendar.d_day}"></c:out>
			<c:forEach var="select" items="${selectList }">
			<c:if test="${ToDay.tomonth ge select.startMonth && ToDay.tomonth le select.endMonth 
				&& ToDay.toyear eq select.startYear && ToDay.toyear eq select.endYear}">
			<c:choose>
			<c:when test="${select.startMonth eq select.endMonth }">
				<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.startMonth }">
				<c:if test="${Calendar.d_day >= select.startD}">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.endMonth }">
				<c:if test="${Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${Calendar.d_day != null }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</td>
		
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
		</c:forEach>
	</tr>

	<tr>
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarDateList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="8" end="14" step="1" var="i">
		<c:if test="${Calendar.num == i }">
		
		<td>
			<c:out value="${Calendar.d_day}"></c:out>
			<c:forEach var="select" items="${selectList }">
			<c:if test="${ToDay.tomonth ge select.startMonth && ToDay.tomonth le select.endMonth 
				&& ToDay.toyear eq select.startYear && ToDay.toyear eq select.endYear}">
			<c:choose>
			<c:when test="${select.startMonth eq select.endMonth }">
				<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.startMonth }">
				<c:if test="${Calendar.d_day >= select.startD}">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.endMonth }">
				<c:if test="${Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${Calendar.d_day != null }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</td>
		
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
		</c:forEach>
	</tr>

	<tr>	
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarDateList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="15" end="21" step="1" var="i">
		<c:if test="${Calendar.num == i }">
		
		<td>
			<c:out value="${Calendar.d_day}"></c:out>
			<c:forEach var="select" items="${selectList }">
			<c:if test="${ToDay.tomonth ge select.startMonth && ToDay.tomonth le select.endMonth 
				&& ToDay.toyear eq select.startYear && ToDay.toyear eq select.endYear}">
			<c:choose>
			<c:when test="${select.startMonth eq select.endMonth }">
				<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.startMonth }">
				<c:if test="${Calendar.d_day >= select.startD}">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.endMonth }">
				<c:if test="${Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${Calendar.d_day != null }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</td>
		
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
		</c:forEach>
	</tr>

	<tr>
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarDateList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="22" end="28" step="1" var="i">
		<c:if test="${Calendar.num == i }">
		
		<td>
			<c:out value="${Calendar.d_day}"></c:out>
			<c:forEach var="select" items="${selectList }">
			<c:if test="${ToDay.tomonth ge select.startMonth && ToDay.tomonth le select.endMonth 
				&& ToDay.toyear eq select.startYear && ToDay.toyear eq select.endYear}">
			<c:choose>
			<c:when test="${select.startMonth eq select.endMonth }">
				<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.startMonth }">
				<c:if test="${Calendar.d_day >= select.startD}">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.endMonth }">
				<c:if test="${Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${Calendar.d_day != null }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</td>
		
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
		</c:forEach>
	</tr>
	
	<tr>
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarDateList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="29" end="35" step="1" var="i">
		<c:if test="${Calendar.num == i }">
		
		<td>
			<c:out value="${Calendar.d_day}"></c:out>
			<c:forEach var="select" items="${selectList }">
			<c:if test="${ToDay.tomonth ge select.startMonth && ToDay.tomonth le select.endMonth 
				&& ToDay.toyear eq select.startYear && ToDay.toyear eq select.endYear}">
			<c:choose>
			<c:when test="${select.startMonth eq select.endMonth }">
				<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.startMonth }">
				<c:if test="${Calendar.d_day >= select.startD}">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.endMonth }">
				<c:if test="${Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${Calendar.d_day != null }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</td>
		
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
		</c:forEach>
	</tr>
	
	<tr>
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarDateList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="36" end="42" step="1" var="i">
		<c:if test="${Calendar.num == i }">
		
		<td>
			<c:out value="${Calendar.d_day}"></c:out>
			<c:forEach var="select" items="${selectList }">
			<c:if test="${ToDay.tomonth ge select.startMonth && ToDay.tomonth le select.endMonth 
				&& ToDay.toyear eq select.startYear && ToDay.toyear eq select.endYear}">
			<c:choose>
			<c:when test="${select.startMonth eq select.endMonth }">
				<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.startMonth }">
				<c:if test="${Calendar.d_day >= select.startD}">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:when test="${ToDay.tomonth eq select.endMonth }">
				<c:if test="${Calendar.d_day <= select.endD }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${Calendar.d_day != null }">
				<c:forEach var="list" items="${list }">
				<c:choose>
				<c:when test="${select.title == list.sow }">
				<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.planting }">
				<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
				</c:when>
				<c:when test="${select.title == list.harvest }">
				<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:if>
			</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</td>
		
		</c:if>
		</c:forEach>
		</c:if>
		</c:forEach>
		</c:forEach>
	</tr>
    </table>
    <br>
    <form action="/SotsukenE/calendarNext" method="get">
    <input type="hidden" name="startDate" value="${startDate }">
    <input type="hidden" name="selectId" value="${selectId }">
    <p><input type="submit" value="TOP"></p></form>
    <!-- <br><a class="nav-link" href="/SotsukenE/produce_search">戻る</a> -->
  </div><!-- end container-->
  <!--<c:forEach var="select" items="${ selectList }">
  <c:if test="${ select.id != null }">
  <c:out value="${select.name}"></c:out><br>
  </c:if>
  </c:forEach>-->
  <p class="sow">種まき<p>
  <p class="planting">植付</p>
  <p class="harvest">収穫</p>
        </section>
        <!-- Call to Action-->
     
      <!-- Footer-->
        <footer class="footer bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                        <p class="text-muted small mb-4 mb-lg-0"></p>
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