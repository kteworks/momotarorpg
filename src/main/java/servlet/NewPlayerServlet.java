package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.Account;

@WebServlet("/NewPlayerServlet")
public class NewPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		Account login = new Account (name, pass);
		RegisterDAO dao = new RegisterDAO();
		Account account = dao.Register(login);
		
		if(account != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
							
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/select.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("errorMsg", "登録出来ませんでした。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/register.jsp");
			dispatcher.forward(request, response);
		}
	}
}

 