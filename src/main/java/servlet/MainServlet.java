package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDAO;
import model.Account;
import model.Player;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		PlayerDAO dao = new PlayerDAO();
		Player player = dao.initializePlayer(account);
		session.setAttribute("player", player);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		PlayerDAO dao = new PlayerDAO();
		Player player = dao.initializePlayer(account);
		session.setAttribute("player", player);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
		dispatcher.forward(request, response);
	}
}
