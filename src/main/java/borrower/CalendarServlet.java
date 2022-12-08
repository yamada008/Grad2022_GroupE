package borrower;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
         
         PostAdviseLogic postAdviseLogic = new PostAdviseLogic();
         postAdviseLogic.execute(advise);
         
         String Date = request.getParameter("start_date");
         String Type = request.getParameter("type");
         int id = Integer.parseInt(request.getParameter("${advise.id}"));
         
         GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
         List<Advise> adviseList = getAdviseListLogic.execute(Date, Type);
         request.setAttribute("adviseList", adviseList);
         
//         request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
         
         if(adviseList != null) {
        	 request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
         } else {
        	 request.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(request, response);
         }
         
         
		
//		 String forward = "/SotsukenE/advise";
//		 response.sendRedirect(forward);
		 
	}
}