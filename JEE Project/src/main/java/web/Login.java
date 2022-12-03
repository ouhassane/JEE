package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.SingletonConnection;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String Login = request.getParameter("Login");
		String Password = request.getParameter("Password");
		Connection conn = SingletonConnection.getConnection();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_MVC_CAT","root","");
		PreparedStatement pst = conn.prepareStatement("SELECT id FROM admin where Login = ? AND Password = ?");
		pst.setString(1,Login);
		pst.setString(2, Password);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			RequestDispatcher rd = request.getRequestDispatcher("saisieBook.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
			rd.forward(request, response);
		}
		rs.close();
		pst.close();
		conn.close();
		}catch(Exception e){
			System.out.print(e);
		}

	}

}
