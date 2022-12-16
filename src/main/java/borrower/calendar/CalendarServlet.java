package borrower.calendar;

import java.io.IOException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_year=request.getParameter("year");
		String s_month=request.getParameter("month");
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
		request.setAttribute("mc", mc);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int strId = Integer.parseInt(request.getParameter("select"));
//		String strDate = request.getParameter("start_date");
		
		GetSearchListLogic getSearchListLogic = new GetSearchListLogic();
		List<Advise> searchList = getSearchListLogic.execute(strId);
		request.setAttribute("searchList", searchList);
		
		GetCalcListLogic getCalcListLogic = new GetCalcListLogic();
		List<Search> extractList = getCalcListLogic.execute();
		request.setAttribute("extractList", extractList);
		
		//viewにフォワード
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/Borrower/calendar.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 
		 HttpSession session = request.getSession();
		 Advise advise = (Advise) session.getAttribute("advise");
         
         PostSearchLogic postSearchLogic = new PostSearchLogic();
         postSearchLogic.execute(advise);
         
         int strId = Integer.parseInt(request.getParameter("select"));
//        String strDate = request.getParameter("start_date");
         
         GetSearchListLogic getSearchListLogic = new GetSearchListLogic();
         List<Advise> searchList = getSearchListLogic.execute(strId);
         request.setAttribute("searchList", searchList);
         
         Search search = (Search) session.getAttribute("search");
// 		 CalcDAO dao = new CalcDAO();
         
//         try {
//        	 CalendarCalc.date(strDate, (Advise) searchList);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
         
 		 PostCalcLogic postCalcLogic = new PostCalcLogic();
 		 postCalcLogic.execute(search);
 		 
 		 GetCalcListLogic getCalcListLogic = new GetCalcListLogic();
		 List<Search> extractList = getCalcListLogic.execute();
		 System.out.println(extractList);
		 request.setAttribute("extractList", extractList);
 		
         
         request.getRequestDispatcher("WEB-INF/jsp/Borrwer/calendar.jsp").forward(request, response);
		 
	}
}