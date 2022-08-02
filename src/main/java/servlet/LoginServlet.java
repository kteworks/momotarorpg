package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");		
		Account login = new Account(name, pass);
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		
		if(account != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			if(account.getJob_id() == -1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/select.jsp");
				dispatcher.forward(request, response);
			} else {
			response.sendRedirect("MainServlet");
			}
		}
		else
		{
			request.setAttribute("errorMsg", "ログイン出来ませんでした。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
