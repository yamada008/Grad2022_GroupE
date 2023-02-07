package agrarian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgrarianServlet
 */
@WebServlet("/Main1")
public class Main1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		String word = request.getParameter("word");
		String breadth = request.getParameter("breadth");
		
		request.setAttribute("userID", userID);
		request.setAttribute("name", name);
		request.setAttribute("word", word);
		request.setAttribute("breadth", breadth);
		request.getRequestDispatcher("WEB-INF/jsp/Agrarian/result.jsp").forward(request, response);
	}
	
}
