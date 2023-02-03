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
		
		HttpSession session = req.getSession();
		CalendarDateBean calendarDate = (CalendarDateBean) session.getAttribute("calendar");
		req.setAttribute("calendarDate", calendarDate);
		
//		logic.createMyCalendar();
		
		GetCalendarDateListLogic getCalendarDateListLogic = new GetCalendarDateListLogic();
		List<CalendarDateBean> CalendarDateList = getCalendarDateListLogic.execute();
		req.setAttribute("CalendarDateList",CalendarDateList);
		
		GetToDayListLogic getToDayListLogic = new GetToDayListLogic();
		List<CalendarDateBean> ToDayList = getToDayListLogic.execute();
		req.setAttribute("ToDayList",ToDayList);
		
		String selectId = req.getParameter("selectId");
		int Id = Integer.parseInt(selectId);
        String strDate = req.getParameter("startDate");
        
        GetSelectListLogic getSelectListLogic = new GetSelectListLogic();
		Advise select = getSelectListLogic.execute(Id, strDate);
		req.setAttribute("select", select);
		
		try {
			CalendarCalc.date(strDate, select);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
        GetCalendarListLogic getCalendarListLogic = new GetCalendarListLogic();
        List<CalendarBean> selectList = getCalendarListLogic.execute();
        req.setAttribute("selectList", selectList);
        req.setAttribute("startDate", strDate);
        req.setAttribute("selectId", selectId);
		
		//viewにフォワード
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/Borrower/calendar.jsp");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("text/html;charset=UTF-8");
		 
		 HttpSession session = req.getSession();
		 CalendarDateBean calendarDate = (CalendarDateBean) session.getAttribute("CalendarDateBean");
		 CalendarBean calendar = (CalendarBean) session.getAttribute("calendarBean");
		 
		 PostCalendarDateLogic postCalendarDateLogic = new PostCalendarDateLogic();
         postCalendarDateLogic.execute(calendarDate);
         
         PostToDayLogic postToDayLogic = new PostToDayLogic();
         postToDayLogic.execute(calendarDate);
         
         PostCalendarLogic postCalendarLogic = new PostCalendarLogic();
         postCalendarLogic.execute(calendar);
         
         String selectId = req.getParameter("select");
         int Id = Integer.parseInt(selectId);
         String strDate = req.getParameter("startDate");
         
//		 Advise advise = (Advise) session.getAttribute("advise");
         
         PostSelectLogic postSelectLogic = new PostSelectLogic();
         postSelectLogic.execute(calendar);
         
         GetSelectListLogic getSelectListLogic = new GetSelectListLogic();
         Advise select = getSelectListLogic.execute(Id, strDate);
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
         req.setAttribute("startDate", strDate);
         req.setAttribute("selectId", selectId);
         RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/Borrower/calendar.jsp");
         rd.forward(req, resp);
		 
	}
}