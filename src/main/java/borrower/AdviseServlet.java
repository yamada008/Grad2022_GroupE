package borrower;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/advise")
public class AdviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdviseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	String Date = request.getParameter("start_date");
    	String Type = request.getParameter("type");

    	GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
		List<Advise> adviseList = getAdviseListLogic.execute(Date, Type);
		request.setAttribute("adviseList", adviseList);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Borrower/advise.jsp");
		dispatcher.forward(request, response);
        
//        if(adviseList != null) {
//       	 request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
//        } else {
//       	 request.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(request, response);
//        }

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 
		 HttpSession session = request.getSession();
		 Advise advise = (Advise) session.getAttribute("advise");
         
         PostAdviseLogic postAdviseLogic = new PostAdviseLogic();
         postAdviseLogic.execute(advise);
         
         String Date = request.getParameter("start_date");
         String Type = request.getParameter("type");
         
         GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
         List<Advise> adviseList = getAdviseListLogic.execute(Date, Type);
         request.setAttribute("adviseList", adviseList);
         
//         request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
         
         if(adviseList != null) {
        	 request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
         } else {
        	 request.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(request, response);
         }
         
         
		
//		 String forward = "/SotsukenE/advise";
//		 response.sendRedirect(forward);
		 
	}
}