package borrower;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/produce")
public class ProduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ProduceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



    	GetProduceListLogic getProduceListLogic = new GetProduceListLogic();
		List<Produce> produceList = getProduceListLogic.execute();
		request.setAttribute("produceList", produceList);



		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Borrower/produce.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");

		 int id = Integer.parseInt(request.getParameter("id"));
         String name = request.getParameter("name");
         String sowStart = request.getParameter("sowStart");
         String sowEnd = request.getParameter("sowEnd");
         String plantingStart = request.getParameter("plantingStart");
         String plantingEnd = request.getParameter("plantingEnd");
         String harvestStart = request.getParameter("harvestStart");
         String harvestEnd = request.getParameter("harvestEnd");

         Produce produce = new Produce(id, name, sowStart, sowEnd, plantingStart, plantingEnd);
         PostProduceLogic postProduceLogic = new PostProduceLogic();
         postProduceLogic.execute(produce);

 		GetProduceListLogic getProduceListLogic = new GetProduceListLogic();
		List<Produce> produceList = getProduceListLogic.execute();
		request.setAttribute("produceList", produceList);

 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Borrower/produce.jsp");
		dispatcher.forward(request, response);



//		 String forward = "/SotsukenE/produce";
//		 response.sendRedirect(forward);
		 
	}
}