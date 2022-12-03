package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String NomOuvrage = request.getParameter("NomOuvrage");
		String Matiere = request.getParameter("Matiere");
		String Niveau = request.getParameter("Niveau");
		String Lire = request.getParameter("Lire");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_MVC_CAT","root","");
			PreparedStatement pst = conn.prepareStatement("INSERT INTO mybook(NomOuvrage, Matiere, Niveau, Lire) VALUES(?, ?, ?, ?)");
			pst.setString(1,NomOuvrage);
			pst.setString(2, Matiere);
			pst.setString(3,Niveau);
			pst.setString(4, Lire);
			pst.executeUpdate();
			response.sendRedirect("Books.jsp");

			pst.close();
			conn.close();
			}catch(Exception e){
				System.out.print(e);
			}
	}

}
