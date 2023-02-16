package borrower;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorrowerSerblet
 */
@WebServlet("/endConf")
public class EndConf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndConf() {
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
		
		// 戻る位置の比較値を取得して、リクエストスコープに保存
		String num = req.getParameter("num");
		req.setAttribute("num", num);
		
		// 選択された農地のidを取得して、リクエストスコープに保存
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/endConf.jsp").forward(req, resp);
	}
}
