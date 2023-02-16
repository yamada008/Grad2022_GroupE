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
        			<input type="hidden" name="id" value="${id }">
        			<input type="hidden" name="i" value="${i }">
        			<%-- 前月へ移動 --%>
        			<a href="?startDate=${startDate }&selectId=${selectId }&id=${id }&i=${i }&year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>">前月</a>
        			<c:forEach var="day" items="${dayList }">
        			<%-- 当月へ移動 --%>
        			<a href="?startDate=${startDate }&selectId=${selectId }&id=${id }&i=${i }&year=${day.toyear }&month=${day.tomonth }">当月</a>
        			</c:forEach>
        			<%-- 翌月へ移動 --%>
        			<a href="?startDate=${startDate }&selectId=${selectId }&id=${id }&i=${i }&year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>">翌月</a>
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
        			<c:forEach var="Date" items="${dateList }">
        			
        			<c:choose>
        				<%-- 今日であることを比較する --%>
        				<c:when test="${Date.toyear eq Calendar.d_year && Date.tomonth eq Calendar.d_month && Date.today eq Calendar.d_day }">
        				<td class="today">
        				<c:out value="${Calendar.d_day}"></c:out>
        				<c:forEach var="select" items="${selectList }">
        					<%-- 作物の期間に今月が含まれていることを比較する --%>
        					<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
        					<c:choose>
        					
        						<%-- 作物の開始月と終了月が同じ場合 --%>
        						<c:when test="${select.startMonth eq select.endMonth }">
        						<%-- 作物の開始日と終了日の間に作物名を記入する --%>
        						<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
        						<c:forEach var="list" items="${list }">
        						<c:choose>
        							<%-- 作業が種まきの場合 --%>
        							<c:when test="${select.title == list.sow }">
        							<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が植付の場合 --%>
        							<c:when test="${select.title == list.planting }">
        							<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が収穫の場合 --%>
        							<c:when test="${select.title == list.harvest }">
        							<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        						</c:choose>
        						</c:forEach>
        						</c:if>
        						</c:when>
        						
        						<%-- 今月が作物の開始月と同じ場合 --%>
        						<c:when test="${Calendar.d_month eq select.startMonth }">
        						<%-- 作物の開始日以降に作物名を記入する --%>
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
								
								<%-- 今月が作物の終了月と同じ場合 --%>
								<c:when test="${Calendar.d_month eq select.endMonth }">
								<%-- 作物の終了日以前に作物名を記入する --%>
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
								
								<%-- 今月が作物の開始月でも終了月でもない場合 --%>
								<c:otherwise>
								<%-- 空白以外の場所に作物名を記入する --%>
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
						</c:when>
						
						<c:otherwise>
						<td>
						<c:out value="${Calendar.d_day}"></c:out>
						<c:forEach var="select" items="${selectList }">
							<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
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
							
							<c:when test="${Calendar.d_month eq select.startMonth }">
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
							
							<c:when test="${Calendar.d_month eq select.endMonth }">
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
						</c:otherwise>
					</c:choose>
					
					</c:forEach>
					</c:if>
					</c:forEach>
					</c:forEach>
				</tr>
				
				<%-- 第二週を表示 --%>
				<tr>
        			<%-- カレンダー一覧を表示する --%>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="8" end="14" step="1" var="i">
        			<%-- ひと月の日数と比較する --%>
        			<c:if test="${Calendar.num == i }">
        			<c:forEach var="Date" items="${dateList }">
        			
        			<c:choose>
        				<%-- 今日であることを比較する --%>
        				<c:when test="${Date.toyear eq Calendar.d_year && Date.tomonth eq Calendar.d_month && Date.today eq Calendar.d_day }">
        				<td class="today">
        				<c:out value="${Calendar.d_day}"></c:out>
        				<c:forEach var="select" items="${selectList }">
        					<%-- 作物の期間に今月が含まれていることを比較する --%>
        					<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
        					<c:choose>
        					
        						<%-- 作物の開始月と終了月が同じ場合 --%>
        						<c:when test="${select.startMonth eq select.endMonth }">
        						<%-- 作物の開始日と終了日の間に作物名を記入する --%>
        						<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
        						<c:forEach var="list" items="${list }">
        						<c:choose>
        							<%-- 作業が種まきの場合 --%>
        							<c:when test="${select.title == list.sow }">
        							<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が植付の場合 --%>
        							<c:when test="${select.title == list.planting }">
        							<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が収穫の場合 --%>
        							<c:when test="${select.title == list.harvest }">
        							<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        						</c:choose>
        						</c:forEach>
        						</c:if>
        						</c:when>
        						
        						<%-- 今月が作物の開始月と同じ場合 --%>
        						<c:when test="${Calendar.d_month eq select.startMonth }">
        						<%-- 作物の開始日以降に作物名を記入する --%>
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
								
								<%-- 今月が作物の終了月と同じ場合 --%>
								<c:when test="${Calendar.d_month eq select.endMonth }">
								<%-- 作物の終了日以前に作物名を記入する --%>
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
								
								<%-- 今月が作物の開始月でも終了月でもない場合 --%>
								<c:otherwise>
								<%-- 空白以外の場所に作物名を記入する --%>
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
						</c:when>
						
						<c:otherwise>
						<td>
						<c:out value="${Calendar.d_day}"></c:out>
						<c:forEach var="select" items="${selectList }">
							<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
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
							
							<c:when test="${Calendar.d_month eq select.startMonth }">
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
							
							<c:when test="${Calendar.d_month eq select.endMonth }">
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
						</c:otherwise>
					</c:choose>
					
					</c:forEach>
					</c:if>
					</c:forEach>
					</c:forEach>
				</tr>
				
				<%-- 第三週を表示 --%>
				<tr>
        			<%-- カレンダー一覧を表示する --%>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="15" end="21" step="1" var="i">
        			<%-- ひと月の日数と比較する --%>
        			<c:if test="${Calendar.num == i }">
        			<c:forEach var="Date" items="${dateList }">
        			
        			<c:choose>
        				<%-- 今日であることを比較する --%>
        				<c:when test="${Date.toyear eq Calendar.d_year && Date.tomonth eq Calendar.d_month && Date.today eq Calendar.d_day }">
        				<td class="today">
        				<c:out value="${Calendar.d_day}"></c:out>
        				<c:forEach var="select" items="${selectList }">
        					<%-- 作物の期間に今月が含まれていることを比較する --%>
        					<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
        					<c:choose>
        					
        						<%-- 作物の開始月と終了月が同じ場合 --%>
        						<c:when test="${select.startMonth eq select.endMonth }">
        						<%-- 作物の開始日と終了日の間に作物名を記入する --%>
        						<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
        						<c:forEach var="list" items="${list }">
        						<c:choose>
        							<%-- 作業が種まきの場合 --%>
        							<c:when test="${select.title == list.sow }">
        							<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が植付の場合 --%>
        							<c:when test="${select.title == list.planting }">
        							<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が収穫の場合 --%>
        							<c:when test="${select.title == list.harvest }">
        							<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        						</c:choose>
        						</c:forEach>
        						</c:if>
        						</c:when>
        						
        						<%-- 今月が作物の開始月と同じ場合 --%>
        						<c:when test="${Calendar.d_month eq select.startMonth }">
        						<%-- 作物の開始日以降に作物名を記入する --%>
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
								
								<%-- 今月が作物の終了月と同じ場合 --%>
								<c:when test="${Calendar.d_month eq select.endMonth }">
								<%-- 作物の終了日以前に作物名を記入する --%>
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
								
								<%-- 今月が作物の開始月でも終了月でもない場合 --%>
								<c:otherwise>
								<%-- 空白以外の場所に作物名を記入する --%>
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
						</c:when>
						
						<c:otherwise>
						<td>
						<c:out value="${Calendar.d_day}"></c:out>
						<c:forEach var="select" items="${selectList }">
							<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
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
							
							<c:when test="${Calendar.d_month eq select.startMonth }">
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
							
							<c:when test="${Calendar.d_month eq select.endMonth }">
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
						</c:otherwise>
					</c:choose>
					
					</c:forEach>
					</c:if>
					</c:forEach>
					</c:forEach>
				</tr>
				
				<%-- 第四週を表示 --%>
				<tr>
        			<%-- カレンダー一覧を表示する --%>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="22" end="28" step="1" var="i">
        			<%-- ひと月の日数と比較する --%>
        			<c:if test="${Calendar.num == i }">
        			<c:forEach var="Date" items="${dateList }">
        			
        			<c:choose>
        				<%-- 今日であることを比較する --%>
        				<c:when test="${Date.toyear eq Calendar.d_year && Date.tomonth eq Calendar.d_month && Date.today eq Calendar.d_day }">
        				<td class="today">
        				<c:out value="${Calendar.d_day}"></c:out>
        				<c:forEach var="select" items="${selectList }">
        					<%-- 作物の期間に今月が含まれていることを比較する --%>
        					<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
        					<c:choose>
        					
        						<%-- 作物の開始月と終了月が同じ場合 --%>
        						<c:when test="${select.startMonth eq select.endMonth }">
        						<%-- 作物の開始日と終了日の間に作物名を記入する --%>
        						<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
        						<c:forEach var="list" items="${list }">
        						<c:choose>
        							<%-- 作業が種まきの場合 --%>
        							<c:when test="${select.title == list.sow }">
        							<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が植付の場合 --%>
        							<c:when test="${select.title == list.planting }">
        							<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が収穫の場合 --%>
        							<c:when test="${select.title == list.harvest }">
        							<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        						</c:choose>
        						</c:forEach>
        						</c:if>
        						</c:when>
        						
        						<%-- 今月が作物の開始月と同じ場合 --%>
        						<c:when test="${Calendar.d_month eq select.startMonth }">
        						<%-- 作物の開始日以降に作物名を記入する --%>
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
								
								<%-- 今月が作物の終了月と同じ場合 --%>
								<c:when test="${Calendar.d_month eq select.endMonth }">
								<%-- 作物の終了日以前に作物名を記入する --%>
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
								
								<%-- 今月が作物の開始月でも終了月でもない場合 --%>
								<c:otherwise>
								<%-- 空白以外の場所に作物名を記入する --%>
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
						</c:when>
						
						<c:otherwise>
						<td>
						<c:out value="${Calendar.d_day}"></c:out>
						<c:forEach var="select" items="${selectList }">
							<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
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
							
							<c:when test="${Calendar.d_month eq select.startMonth }">
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
							
							<c:when test="${Calendar.d_month eq select.endMonth }">
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
						</c:otherwise>
					</c:choose>
					
					</c:forEach>
					</c:if>
					</c:forEach>
					</c:forEach>
				</tr>
				
				<%-- 第五週を表示 --%>
				<tr>
        			<%-- カレンダー一覧を表示する --%>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="29" end="35" step="1" var="i">
        			<%-- ひと月の日数と比較する --%>
        			<c:if test="${Calendar.num == i }">
        			<c:forEach var="Date" items="${dateList }">
        			
        			<c:choose>
        				<%-- 今日であることを比較する --%>
        				<c:when test="${Date.toyear eq Calendar.d_year && Date.tomonth eq Calendar.d_month && Date.today eq Calendar.d_day }">
        				<td class="today">
        				<c:out value="${Calendar.d_day}"></c:out>
        				<c:forEach var="select" items="${selectList }">
        					<%-- 作物の期間に今月が含まれていることを比較する --%>
        					<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
        					<c:choose>
        					
        						<%-- 作物の開始月と終了月が同じ場合 --%>
        						<c:when test="${select.startMonth eq select.endMonth }">
        						<%-- 作物の開始日と終了日の間に作物名を記入する --%>
        						<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
        						<c:forEach var="list" items="${list }">
        						<c:choose>
        							<%-- 作業が種まきの場合 --%>
        							<c:when test="${select.title == list.sow }">
        							<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が植付の場合 --%>
        							<c:when test="${select.title == list.planting }">
        							<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が収穫の場合 --%>
        							<c:when test="${select.title == list.harvest }">
        							<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        						</c:choose>
        						</c:forEach>
        						</c:if>
        						</c:when>
        						
        						<%-- 今月が作物の開始月と同じ場合 --%>
        						<c:when test="${Calendar.d_month eq select.startMonth }">
        						<%-- 作物の開始日以降に作物名を記入する --%>
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
								
								<%-- 今月が作物の終了月と同じ場合 --%>
								<c:when test="${Calendar.d_month eq select.endMonth }">
								<%-- 作物の終了日以前に作物名を記入する --%>
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
								
								<%-- 今月が作物の開始月でも終了月でもない場合 --%>
								<c:otherwise>
								<%-- 空白以外の場所に作物名を記入する --%>
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
						</c:when>
						
						<c:otherwise>
						<td>
						<c:out value="${Calendar.d_day}"></c:out>
						<c:forEach var="select" items="${selectList }">
							<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
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
							
							<c:when test="${Calendar.d_month eq select.startMonth }">
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
							
							<c:when test="${Calendar.d_month eq select.endMonth }">
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
						</c:otherwise>
					</c:choose>
					
					</c:forEach>
					</c:if>
					</c:forEach>
					</c:forEach>
				</tr>
				
				<%-- 第六週を表示 --%>
				<tr>
        			<%-- カレンダー一覧を表示する --%>
        			<c:forEach var="Calendar" items="${CalendarDateList}">
        			<c:forEach begin="36" end="42" step="1" var="i">
        			<%-- ひと月の日数と比較する --%>
        			<c:if test="${Calendar.num == i }">
        			<c:forEach var="Date" items="${dateList }">
        			
        			<c:choose>
        				<%-- 今日であることを比較する --%>
        				<c:when test="${Date.toyear eq Calendar.d_year && Date.tomonth eq Calendar.d_month && Date.today eq Calendar.d_day }">
        				<td class="today">
        				<c:out value="${Calendar.d_day}"></c:out>
        				<c:forEach var="select" items="${selectList }">
        					<%-- 作物の期間に今月が含まれていることを比較する --%>
        					<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
        					<c:choose>
        					
        						<%-- 作物の開始月と終了月が同じ場合 --%>
        						<c:when test="${select.startMonth eq select.endMonth }">
        						<%-- 作物の開始日と終了日の間に作物名を記入する --%>
        						<c:if test="${Calendar.d_day >= select.startD && Calendar.d_day <= select.endD }">
        						<c:forEach var="list" items="${list }">
        						<c:choose>
        							<%-- 作業が種まきの場合 --%>
        							<c:when test="${select.title == list.sow }">
        							<a href="#!" class="button-sow"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が植付の場合 --%>
        							<c:when test="${select.title == list.planting }">
        							<a href="#!" class="button-planting"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        							<%-- 作業が収穫の場合 --%>
        							<c:when test="${select.title == list.harvest }">
        							<a href="#!" class="button-harvest"><c:out value="${select.name }"></c:out></a>
        							</c:when>
        						</c:choose>
        						</c:forEach>
        						</c:if>
        						</c:when>
        						
        						<%-- 今月が作物の開始月と同じ場合 --%>
        						<c:when test="${Calendar.d_month eq select.startMonth }">
        						<%-- 作物の開始日以降に作物名を記入する --%>
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
								
								<%-- 今月が作物の終了月と同じ場合 --%>
								<c:when test="${Calendar.d_month eq select.endMonth }">
								<%-- 作物の終了日以前に作物名を記入する --%>
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
								
								<%-- 今月が作物の開始月でも終了月でもない場合 --%>
								<c:otherwise>
								<%-- 空白以外の場所に作物名を記入する --%>
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
						</c:when>
						
						<c:otherwise>
						<td>
						<c:out value="${Calendar.d_day}"></c:out>
						<c:forEach var="select" items="${selectList }">
							<c:if test="${Calendar.d_month ge select.startMonth && Calendar.d_month le select.endMonth && Calendar.d_year eq select.startYear && Calendar.d_year eq select.endYear}">
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
							
							<c:when test="${Calendar.d_month eq select.startMonth }">
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
							
							<c:when test="${Calendar.d_month eq select.endMonth }">
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
						</c:otherwise>
					</c:choose>
					
					</c:forEach>
					</c:if>
					</c:forEach>
					</c:forEach>
				</tr>
				
				</table><br>
				
				<%-- CalendarNextServlet.javaへ値を送る --%>
				<form action="/SotsukenE/calendarNext" method="get">
					<input type="hidden" name="startDate" value="${startDate }">
					<input type="hidden" name="selectId" value="${selectId }">
					<input type="hidden" name="id" value="${id }">
					<p><input type="submit" value="TOP"></p>
				</form><br>
				<%-- iが1の場合ProduceSearchServlet.javaへ移動 --%>
				<c:if test="${i == 1 }">
					<a class="nav-link" href="/SotsukenE/produce_search?id=${id }">やり直し</a>
				</c:if>
			</div>
			<%-- それぞれの作業に割り当てている色を表示 --%>
			<p class="sow">種まき<p>
			<p class="planting">植付</p>
			<p class="harvest">収穫</p>
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