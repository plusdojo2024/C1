package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import dao.RikishiesDao;
import dao.UsersDao;
import model.Contributions;
import model.Rikishies;
import model.Users;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//リクエストスコープを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();

		//クエリパラメータを取得
		int id = Integer.parseInt(request.getParameter("rikishi_id"));

		//各種情報を取得する
		UsersDao users = new UsersDao();
		List<Users> usersList = users.select_other(new Users(User_id));
		request.setAttribute("usersList", usersList);

		RikishiesDao rikishies = new RikishiesDao();
		List<Rikishies> rikishiesList = rikishies.select(new Rikishies(id));
		request.setAttribute("rikishiesList", rikishiesList);

		// 各部屋ページにフォワードする
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
		int Rikishi_id = Integer.parseInt(request.getParameter("rikishi_id"));

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
		request.setAttribute("filename", filename);
		System.out.println(filename);

		//投稿処理
		ContributionsDao cDao = new ContributionsDao();
		cDao.insert(new Contributions(User_id, Rikishi_id, filename, text));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contribution.jsp");
		dispatcher.forward(request, response);

	}

}
