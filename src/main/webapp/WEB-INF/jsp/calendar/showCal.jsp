<%@page import="Calendar2.CalendarBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import="java.util.*" %>
	<!-- import="java.util.*,jp.ac.o_hara.site.calendar.*"%> -->
<%! Calendar c = Calendar.getInstance(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <jsp:useBean id="user" scope="session"
	class="user.UserBean" />-->
<%
CalendarBean calendar2 = (CalendarBean) request.getAttribute("calendar2");
%>
<table>
<caption>
<c:forEach var="ToDay" items= "${ToDayList}">
	<c:if test="${ToDay.toyear != null }">
	<a href="/SotsukenE/showCal/">
	<input type="hidden" name="toyear" value="${ToDay.toyear }">
	<input type="hidden" name="tomonth" value="${ToDay.tomonth -1}">前月</a>
	<c:out value="${ToDay.toyear }"></c:out>年<c:out value="${ToDay.tomonth }"></c:out>月
	<a href="/SotsukenE/showCal/">
	<input type="hidden" name="toyear" value="${ToDay.toyear }">
	<input type="hidden" name="tomonth" value="${ToDay.tomonth +1}">翌月</a>
	</c:if>
	</c:forEach>
</caption>

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
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="1" end="7" step="1" var="i">
		
		<c:if test="${Calendar.num == i }">
		<c:choose>
		<c:when test="${ToDay.today == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
		</c:if>
		
		</c:forEach>
	</c:if>
	</c:forEach>
</c:forEach>
	
</tr>

<tr>
		
		
		
	
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="8" end="14" step="1" var="i">
		
		<c:if test="${Calendar.num == i }">
		<c:choose>
		<c:when test="${ToDay.today == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
		</c:if>
		
		</c:forEach>
	</c:if>
	</c:forEach>
</c:forEach>
		
	
</tr>

<tr>
		
		
		
	
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="15" end="21" step="1" var="i">
		
		<c:if test="${Calendar.num == i }">
		<c:choose>
		<c:when test="${ToDay.today == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
		</c:if>
		
		</c:forEach>
	</c:if>
	</c:forEach>
</c:forEach>
		
	
</tr>

<tr>
		
		
		
	
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="22" end="28" step="1" var="i">
		
		<c:if test="${Calendar.num == i }">
		<c:choose>
		<c:when test="${ToDay.today == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
		</c:if>
		
		</c:forEach>
	</c:if>
	</c:forEach>
</c:forEach>
	
</tr>
	
	
	<tr>
		
		
		
	
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="29" end="35" step="1" var="i">
		
		<c:if test="${Calendar.num == i }">
		<c:choose>
		<c:when test="${ToDay.today == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
		</c:if>
		
		</c:forEach>
	</c:if>
	</c:forEach>
</c:forEach>
	
</tr>
	
	
	<tr>
		
		
		
	
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.tomonth == Calendar.d_month }">
		<c:forEach begin="36" end="42" step="1" var="i">
		
		<c:if test="${Calendar.num == i }">
		<c:choose>
		<c:when test="${ToDay.today == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
		</c:if>
		
		</c:forEach>
	</c:if>
	</c:forEach>
</c:forEach>
	
</tr>

</table>