package agrarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agrarian.controller.ControllerBean;
import agrarian.controller.GetControllerListLogic;

/**
 * Servlet implementation class AgrarianServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  req.setCharacterEncoding("UTF-8");
		  resp.setContentType("text/html;charset=UTF-8");
		  
		  // 農地一覧を取得して、リクエストスコープに保存
		  GetControllerListLogic getControllerListLogic = new GetControllerListLogic();
		  List<ControllerBean> ControllerList = getControllerListLogic.execute();
		  req.setAttribute("ControllerList", ControllerList);
		
		  // ログインしているユーザーIDの設定
		  String name = "agrarian";
		  req.setAttribute("name", name);
		  
		  req.getRequestDispatcher("WEB-INF/jsp/Agrarian/result3.jsp").forward(req, resp);
	  }
}
