package borrower;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agrarian.controller.ControllerDAO;
import borrower.calendar.CalendarDAO;

/**
 * Servlet implementation class BorrowerSerblet
 */
@WebServlet("/end")
public class End extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public End() {
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
		ControllerDAO collDAO = new ControllerDAO();
		CalendarDAO calDAO = new CalendarDAO();
		
		// 選択された農地のidを取得して、リクエストスコープに保存
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		// 選択された農地を貸出し可能に設定する
		collDAO.execSQL("UPDATE Controllerdb SET JUDG = 0 WHERE ID = '" + id + "'");
		
		// 選択したおすすめ作物一覧を削除する
		calDAO.execSQL("DELETE FROM CALENDARTBL");
		
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/end.jsp").forward(req, resp);
	}
}
