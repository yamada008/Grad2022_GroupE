package borrower;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agrarian.controller.ControllerDAO;
import user.UserBean;

/**
 * Servlet implementation class BorrowerSerblet
 */
@WebServlet("/landNext")
public class LandNextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LandNextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		ControllerDAO dao = new ControllerDAO();
		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		
		if (req.getParameter("logout") != null) { // ログアウトの場合
			user.logout();
			session.removeAttribute("user");
			req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
			resp.sendRedirect(req.getHeader("Referer"));
		}
		
		// 選択された農地のidを取得して、リクエストスコープに保存
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		// 選択された農地を貸出し中に設定する
		dao.execSQL("UPDATE Controllerdb SET JUDG = 1 WHERE ID = '" + id + "'");
		
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/landNext.jsp").forward(req, resp);
	}
}
