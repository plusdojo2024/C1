package servlet;

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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ContributionsDao;
import model.Contributions;
import model.Users;

/**
 * Servlet implementation class ContributionServlet
 */
@WebServlet("/ContributionServlet")
@MultipartConfig
public class ContributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投稿ページにフォワードする
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//クエリパラメータを取得
		int Rikishi_id = Integer.parseInt(request.getParameter("rikishi_id"));

		//リクエストスコープに格納
		request.setAttribute("Rikishi_id", Rikishi_id);

		//投稿ページへフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contribution.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		Users User = (Users) session.getAttribute("user_id");
		String User_id = User.getUser_id();
		String text = request.getParameter("text");
		request.setAttribute("text", text);

		//クエリパラメータを取得
		int Rikishi_id = Integer.parseInt(request.getParameter("Rikishi_id"));

		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=request.getPart("pict");
		//ファイル名を取得
		//String filename=part.getSubmittedFileName();//ie対応が不要な場合
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/upload");
		//データベースに保存するパス名
		String filepath= "upload/" + filename;

		//データベースに保存されるパス確認
		System.out.println(filepath);


		//書き込みは[filepath]とはちょっと異なるパス名となっている(これがサーバーを動かしているコピー先のパス名となっているのでわかりずらい)
		//C1/uploadのファイルを開くとアップロードされた画像は見つからないが、表示するときにはコピー先で探すので、とってこれるようになっている
		part.write(path + File.separator + filename);
		//request.setAttribute("filepath", filepath);

		//投稿処理
		ContributionsDao cDao = new ContributionsDao();
		cDao.insert(new Contributions(User_id, Rikishi_id, filepath, text));

		//投稿ページへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contribution.jsp");
		dispatcher.forward(request, response);

	}

}
