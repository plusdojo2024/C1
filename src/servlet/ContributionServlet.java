package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ContributionsDao;

/**
 * Servlet implementation class ContributionServlet
 */
@WebServlet("/ContributionServlet")
@MultipartConfig
public class ContributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContributionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投稿ページにフォワードする
		/*// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contribution.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=request.getPart("pict");
		//ファイル名を取得
		String filename=part.getSubmittedFileName();//ie対応が不要な場合				String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/img");
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		//書き込み
		part.write(path+File.separator+filename);

		//投稿処理
		ContributionsDao cDao = new ContributionsDao();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contribution.jsp");
		dispatcher.forward(request, response);

	}

}
