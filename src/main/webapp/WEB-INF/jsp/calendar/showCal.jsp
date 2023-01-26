<%@page import="Calendar2.CalendarBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import="java.util.*" %>
	<!-- import="java.util.*,jp.ac.o_hara.site.calendar.*"%> -->
<%! Calendar c = Calendar.getInstance(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <jsp:useBean id="user" scope="session"
	class="user.UserBean" />-->
<%
CalendarBean calendar2 = (CalendarBean) request.getAttribute("CalendarBean");
%>
<table>
<caption>
	<a href="?year=<%= calendar2.getd_year() %>&month=<%= calendar2.getd_month() -1 %>)">前月</a>
	<%=calendar2.getd_year()%>年<%=calendar2.getd_month() %>月
	<a href="year=<%= calendar2.getd_year() %>&month=<%= calendar2.getd_month()+1 %>)">翌月</a>
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
<%
	int nStartDay = c.get(Calendar.DAY_OF_WEEK), nEndDate = c
			.getActualMaximum(Calendar.DATE);
%>
		<c:forEach var="ToDay" items= "${ToDayList}">
		<c:forEach var="Calendar" items="${CalendarList}">
		<c:if test="${ToDay.d_month == Calendar.d_month }">
<tr>
	<c:forEach var="Id" items="${IdList}">
	
		<c:if test="${Id != null }">
		<c:choose>
		<c:when test="${ToDay.d_dat == Calendar.d_day }">
		<td class="today"><c:out value="${Calendar.d_day}"></c:out></td>
		</c:when>
		<c:otherwise><td><c:out value="${Calendar.d_day }"></c:out></td></c:otherwise>
		</c:choose>
	</c:if>
	</c:forEach>
	
</tr>

</c:if>
</c:forEach>
</c:forEach>
</table>