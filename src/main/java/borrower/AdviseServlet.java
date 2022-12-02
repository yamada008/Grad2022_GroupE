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

    	GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
		List<Advise> adviseList = getAdviseListLogic.execute();
		request.setAttribute("adviseList", adviseList);
		
//		AdviseDAO dao = AdviseDAO.getInstance();
//		String strDate = request.getParameter("start_date");
//        
//        List<Advise> cropsList = dao.search(strDate);
//        request.setAttribute("cropsList", cropsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Borrower/advise.jsp");
		dispatcher.forward(request, response);
        
//        if(cropsList != null) {
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
		 AdviseDAO dao = AdviseDAO.getInstance();
         
         PostAdviseLogic postAdviseLogic = new PostAdviseLogic();
         postAdviseLogic.execute(advise);
         
         GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
         List<Advise> adviseList = getAdviseListLogic.execute();
         request.setAttribute("adviseList", adviseList);
         
         String strDate = request.getParameter("start_date");
         
         List<Advise> cropsList = dao.search(strDate);
         request.setAttribute("cropsList", cropsList);
         
         
//         request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
         
         if(cropsList != null) {
        	 request.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(request, response);
         } else {
        	 request.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(request, response);
         }
         
         
		
//		 String forward = "/SotsukenE/advise";
//		 response.sendRedirect(forward);
		 
	}
}