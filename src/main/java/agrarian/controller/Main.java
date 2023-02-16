package agrarian.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Main")
@MultipartConfig
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/view/form.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ControllerDAO con = new ControllerDAO(); 
		
		String userId=req.getParameter("userId");
		String name=req.getParameter("name");
		String word=req.getParameter("word");
		String breadth=req.getParameter("breadth");
		
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=req.getPart("pict");
		//ファイル名を取得
		//String filename=part.getSubmittedFileName();//ie対応が不要な場合
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/upload");
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		//書き込み
		part.write(path+File.separator+filename);
		req.setAttribute("userId",userId);
		req.setAttribute("name",name);
		req.setAttribute("word", word);
		req.setAttribute("breadth", breadth);
		req.setAttribute("filename", filename);
		
		// 取得した値をデータベースに格納する
		ControllerBean controller = new ControllerBean(1, userId, name, word,breadth,filename,0 );
		con.create(controller);
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/jsp/view/result.jsp");
		rd.forward(req, resp);
	}
}