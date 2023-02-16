package borrower.advise;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/advise")
public class AdviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdviseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
    	// 開始日を取得して、リクエストスコープに保存
    	String strDate = req.getParameter("start_date");
		req.setAttribute("startDate", strDate);
    	
		// 選択したテンプレートを取得
    	String Type = req.getParameter("type");
    	
    	// 選択された農地のidを取得して、リクエストスコープに保存
    	String id = req.getParameter("id");
		req.setAttribute("id", id);
    	
		// 戻る位置の比較値を設定する
    	int i = 1;
    	req.setAttribute("i", i);

    	// おすすめ作物一覧を取得して、リクエストスコープに保存
    	GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
		List<Advise> adviseList = getAdviseListLogic.execute(strDate, Type);
		req.setAttribute("adviseList", adviseList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/Borrower/advise.jsp");
		dispatcher.forward(req, resp);
        
//        if(adviseList != null) {
//       	 req.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(req, resp);
//        } else {
//       	 req.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(req, resp);
//        }

	}
}