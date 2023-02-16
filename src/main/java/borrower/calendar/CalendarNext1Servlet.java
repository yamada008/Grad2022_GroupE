package borrower.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserBean;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/CalendarNext")
public class CalendarNext1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
        HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		
		if (req.getParameter("logout") != null) { // ログアウトの場合
			user.logout();
			session.removeAttribute("user");
			req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
			resp.sendRedirect(req.getHeader("Referer"));
		}
		
		// 戻る位置の比較値を設定する
		int num = 1;
		req.setAttribute("num", num);
		
		// 選択された農地のidを取得して、リクエストスコープに保存
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/calendarNext1.jsp").forward(req, resp);
	}
}