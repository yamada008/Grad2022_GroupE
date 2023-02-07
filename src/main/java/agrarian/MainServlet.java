package agrarian;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public MainServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("WEB-INF/jsp/Agrarian/form.jsp").forward(request, response);
		
	}
}