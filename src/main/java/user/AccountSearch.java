//package user;
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class AccountDAO2
// */
//@WebServlet("/AccountSearch")
//public class AccountSearch extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AccountSearch() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//
//    }
//
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        String id = req.getParameter("id");
//        String pass = req.getParameter("pass");
//
//        // login.jspから受け取ったログインIDとpassをビーンズにセット
//        UserBean ab = new UserBean();
//        ab.setUserId(id);
//        ab.setPass(pass);
//
//        // アカウントの有無を検索
//        // 検索したアカウント情報を取得
//        UserDAO ad = new UserDAO();
//        boolean returnAb = ad.create(ab);
//
//        if(returnAb == true) {
//            // セッションにアカウント情報＆ロールを登録
//            HttpSession session = req.getSession();
//            session.setAttribute("user", returnAb);
//
//            req.getRequestDispatcher("loginSuccess.jsp").forward(req, resp);
//
//        } else {
//        req.getRequestDispatcher("error.jsp").forward(req, resp);
//        }
//    }
//}