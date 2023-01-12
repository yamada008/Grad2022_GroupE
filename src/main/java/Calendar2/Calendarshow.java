package Calendar2;


import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
//@WebServlet(urlPatterns = {"/","/home"})
@WebServlet("/showCal")
public class Calendarshow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		
		req.setAttribute("cdate", c);

		req.getRequestDispatcher("WEB-INF/jsp/calendar/showCal.jsp").forward(req, resp);
	}
}

///showCal?year=2001&month=10
//データが入っていないので入れる
//年 月 日　始めた月　終わりの月　始める日　終わりの日　作物ID　userID　種まき　概要