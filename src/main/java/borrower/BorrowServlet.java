package borrower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Bean;
import user.GetUserListLogic;
import user.UserBean;

/**
 * Servlet implementation class BorrowerSerblet
 */
@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowServlet() {
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
		GetUserListLogic getUserListLogic = new GetUserListLogic();
		List<UserBean> UserList = getUserListLogic.execute();
		req.setAttribute("UserList", UserList);
		
		List<Bean> BeanList = new ArrayList<Bean>();
		BeanList.add(new Bean("borrower"));
		req.setAttribute("BeanList", BeanList);
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/borrow.jsp").forward(req, resp);
	}
}
