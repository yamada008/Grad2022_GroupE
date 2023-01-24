package borrower.calendar;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import borrower.advise.Advise;

@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	public CalendarServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
	
		String s_year=req.getParameter("year");
		String s_month=req.getParameter("month");
		CalendarLogic logic=new CalendarLogic();
		MyCalendar mc=null;
		if(s_year != null && s_month != null) {
			int year =Integer.parseInt(s_year);
			int month=Integer.parseInt(s_month);
			if(month==0) {
				month=12;
				year--;
			}
			if(month==13) {
				month=1;
				year++;
			}
			//年と月のクエリパラメーターが来ている場合にはその年月でカレンダーを生成する
			mc=logic.createMyCalendar(year,month);
		}else {
			//クエリパラメータが来ていないときは実行日時のカレンダーを生成する。
			mc=logic.createMyCalendar();
		}
		//リクエストスコープに格納
		req.setAttribute("mc", mc);
		
//		HttpSession session = req.getSession();
//		Advise advise = (Advise) session.getAttribute("advise");
		
		int strId = Integer.parseInt(req.getParameter("select"));
        String strDate = req.getParameter("startDate");
        
        GetSelectListLogic getSelectListLogic = new GetSelectListLogic();
		Advise select = getSelectListLogic.execute(strId, strDate);
		req.setAttribute("select", select);
		
		try {
			CalendarCalc.date(strDate, select);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
        GetCalendarListLogic getCalendarListLogic = new GetCalendarListLogic();
        List<CalendarBean> calendarList = getCalendarListLogic.execute();
        req.setAttribute("calendarList", calendarList);
		
		//viewにフォワード
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/Borrower/calendar.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("text/html;charset=UTF-8");
		 
		 HttpSession session = req.getSession();
		 CalendarBean calendar = (CalendarBean) session.getAttribute("calendarBean");
         
         PostCalendarLogic postCalendarLogic = new PostCalendarLogic();
         postCalendarLogic.execute(calendar);
         
         int strId = Integer.parseInt(req.getParameter("select"));
         String strDate = req.getParameter("startDate");
         
//		 Advise advise = (Advise) session.getAttribute("advise");
         
         PostSelectLogic postSelectLogic = new PostSelectLogic();
         postSelectLogic.execute(calendar);
         
         GetSelectListLogic getSelectListLogic = new GetSelectListLogic();
         Advise select = getSelectListLogic.execute(strId, strDate);
         req.setAttribute("select", select);
         
         try {
			CalendarCalc.date(strDate, select);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
         
         GetCalendarListLogic getCalendarListLogic = new GetCalendarListLogic();
         List<CalendarBean> calendarList = getCalendarListLogic.execute();
         req.setAttribute("calendarList", calendarList);
         
         RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/Borrower/calendar.jsp");
         rd.forward(req, resp);
		 
	}
}