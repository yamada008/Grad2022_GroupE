package borrower.produce;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/produce")
public class ProduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ProduceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	String strDate = request.getParameter("start_date");

    	GetProduceListLogic getProduceListLogic = new GetProduceListLogic();
		List<Produce> produceList = getProduceListLogic.execute(strDate);
		request.setAttribute("produceList", produceList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Borrower/produce.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");

		 HttpSession session = request.getSession();
		 Produce produce = (Produce) session.getAttribute("produce");

         PostProduceLogic postProduceLogic = new PostProduceLogic();
         postProduceLogic.execute(produce);
         
         String strDate = request.getParameter("start_date");

 		GetProduceListLogic getProduceListLogic = new GetProduceListLogic();
		List<Produce> produceList = getProduceListLogic.execute(strDate);
		request.setAttribute("produceList", produceList);

 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Borrower/produce.jsp");
		dispatcher.forward(request, response);



//		 String forward = "/SotsukenE/produce";
//		 response.sendRedirect(forward);
		 
	}
}