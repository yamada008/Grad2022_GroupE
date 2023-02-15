package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserNew
 */
@WebServlet("/UserNew")
public class UserNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		UserDAO udao = new UserDAO(); 
		
		String name =req.getParameter("name");
		String id =req.getParameter("id");
		String pass =req.getParameter("pass");
		
//		UserBean ub = new UserBean();
//		ub.setRealName(name);
//		ub.setUserId(id);
//		ub.setPass(pass);
		
		
		req.setAttribute("name",name);
		req.setAttribute("id",id);
		req.setAttribute("pass", pass);
		
		UserBean ub = new UserBean(id, name, pass );
		udao.create(ub);
		
	}
}
