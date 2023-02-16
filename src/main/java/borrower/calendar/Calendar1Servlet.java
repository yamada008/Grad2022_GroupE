package borrower.calendar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calendar")
public class Calendar1Servlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	public Calendar1Servlet() {
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
		
		// カレンダー一覧を取得して、リクエストスコープに保存
		GetCalendarDateListLogic getCalendarDateListLogic = new GetCalendarDateListLogic();
		List<CalendarDateBean> CalendarDateList = getCalendarDateListLogic.execute();
		req.setAttribute("CalendarDateList",CalendarDateList);
		
		// 戻る位置の比較値を取得して、リクエストスコープに保存
		String num = req.getParameter("num");
        req.setAttribute("num", num);
        
        Calendar cal=Calendar.getInstance();
        // 今日の日付を取得して、リストに入れる
        List<CalendarDateBean> dayList = new ArrayList<CalendarDateBean>();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        dayList.add(new CalendarDateBean(year, month, day));
        req.setAttribute("dayList", dayList);
		
		//viewにフォワード
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/Borrower/calendar1.jsp");
		rd.forward(req, resp);
	}
}