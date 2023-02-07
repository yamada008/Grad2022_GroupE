package agrarian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserBean;

/**
 * Servlet implementation class AgrarianServlet
 */
@WebServlet("/agrarian")
public class AgrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgrarianServlet() {
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
		
		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		
		if (req.getParameter("logout") != null) { // ログアウトの場合
			user.logout();
			session.removeAttribute("user");
			req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
			resp.sendRedirect(req.getHeader("Referer"));
		}
		
		req.getRequestDispatcher("WEB-INF/jsp/Agrarian/agrarian.jsp").forward(req, resp);
	}
}
