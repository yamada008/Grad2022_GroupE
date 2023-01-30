package Calendar2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class CalenderDispServlet
 */
@WebServlet("/showCal")
public class CalenderDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
//		Calendar cal=Calendar.getInstance();
		
		HttpSession session = req.getSession();
		CalendarBean calendar2 = (CalendarBean) session.getAttribute("calendar2");
		req.setAttribute("calendar2",calendar2 );
//		CalendarBean d_year = (CalendarBean) session.getAttribute("d_year");
//		CalendarBean d_month = (CalendarBean) session.getAttribute("d_month");
		
		
		
//		int d_year = (int)req.getSession().getAttribute("d_year");
//		int d_month = (int)req.getSession().getAttribute("d_month");
//		int month = d_month - 1;
//		int year = d_year;
		
		CalendarLogic logic = new CalendarLogic();
		 logic.createMyCalendar();
		
		
		
		GetCalendar2ListLogic getCalendar2ListLogic = new GetCalendar2ListLogic();
		List<CalendarBean> CalendarList = getCalendar2ListLogic.execute();
		req.setAttribute("CalendarList",CalendarList);
		
		
		List<Integer> IdList = new ArrayList<Integer>();
		for(int i = 1;i <= 7; i++) {
			IdList.add(i);
		}
		req.setAttribute("IdList", IdList);
		
		GetToDayListLogic getToDayListLogic = new GetToDayListLogic();
		List<CalendarBean> ToDayList = getToDayListLogic.execute();
		req.setAttribute("ToDayList",ToDayList);
//			Calendar c = Calendar.getInstance();
//			c.set(year,month, 1);
//			req.setAttribute("cdate", c);
			req.getRequestDispatcher("/WEB-INF/jsp/calendar/showCal.jsp").forward(req, resp);

		
//		Calendar c = Calendar.getInstance();
//		
//		int year = calendar2.getd_year();
//		int month = calendar2.getd_month();
//		PrintWriter out=resp.getWriter();
//		Calendar c = Calendar.getInstance();
//		out.println("year：" + c.get(Calendar.YEAR));
//        out.println("month：" + c.get(Calendar.MONTH)); 
//        out.println("DATE：" + c.get(Calendar.DATE));      
//		c.set(year,month-1 ,1);
//		req.setAttribute("cdate", c);
//		req.getRequestDispatcher("/WEB-INF/jsp/calendar/showCal.jsp").forward(req, resp);
		}
		
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
//		
//		HttpSession session = req.getSession();
//		CalendarBean calendar2 = (CalendarBean) session.getAttribute("calendar2");
//		
//		int year = Integer.parseInt(req.getParameter("year"));
//		int month = Integer.parseInt(req.getParameter("month"));
//		if(calendar2!= null) {
//		
//		Calendar c = Calendar.getInstance();
//		c.set(year, month-1, 1);
//		
//		req.setAttribute("cdate", c);
//		}
//		//req.getRequestDispatcher("/WEB-INF/jsp/calendar/showCal.jsp").forward(req, resp);
//	}
}
