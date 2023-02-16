package borrower.calendar;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// カレンダー一覧を取得して、リクエストスコープに保存
		GetCalendarDateListLogic getCalendarDateListLogic = new GetCalendarDateListLogic();
		List<CalendarDateBean> CalendarDateList = getCalendarDateListLogic.execute();
		req.setAttribute("CalendarDateList",CalendarDateList);
		
		// おすすめ作物一覧を取得して、リクエストスコープに保存
		GetCalendarListLogic getCalendarListLogic = new GetCalendarListLogic();
        List<CalendarBean> selectList = getCalendarListLogic.execute();
        req.setAttribute("selectList", selectList);
        
        // 選択された農地のidを取得して、リクエストスコープに保存
        String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		// 選択されたおすすめ作物のidを取得して、リクエストスコープに保存
		String selectId = req.getParameter("selectId");
		int Id = Integer.parseInt(selectId);
		req.setAttribute("selectId", selectId);
		
		// 開始日を取得して、リクエストスコープに保存
        String strDate = req.getParameter("startDate");
        req.setAttribute("startDate", strDate);
        
        // 戻る位置の比較値を取得して、リクエストスコープに保存
        String i = req.getParameter("i");
        req.setAttribute("i", i);
        
        // おすすめ作物を取得して、リクエストスコープに保存
        GetSelectListLogic getSelectListLogic = new GetSelectListLogic();
		Advise select = getSelectListLogic.execute(Id, strDate);
		req.setAttribute("select", select);
		
		List<CalendarDateBean> dateList = new ArrayList<CalendarDateBean>();
		try {
			// 作業を行う日を計算し、開始日をint型にして取得する
			dateList = CalendarCalc.date(strDate, select);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		req.setAttribute("dateList", dateList);
        
		// 作業の名称をリストに入れる
        List<CalendarBean> list = new ArrayList<CalendarBean>();
        list.add(new CalendarBean("種まき", "植付", "収穫"));
        req.setAttribute("list", list);
		
        // 今日の日付を取得して、リストに入れる
        Calendar cal=Calendar.getInstance();
        List<CalendarDateBean> dayList = new ArrayList<CalendarDateBean>();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        dayList.add(new CalendarDateBean(year, month, day));
        req.setAttribute("dayList", dayList);
        
		//viewにフォワード
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/Borrower/calendar.jsp");
		rd.forward(req, resp);
	}
}