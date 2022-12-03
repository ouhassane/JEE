package web;
import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.ImybookDao;
import dao.mybookDaoImpl;
import metier.mybook;

/**
 * Servlet implementation class chercher
 */
@WebServlet("/chercher")
public class chercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImybookDao metier;
		metier = new mybookDaoImpl();
		mybookModele model= new mybookModele();
		String action = request.getParameter("action");
		if(action != null){
			if(action.equals("Recherche")) {
				String motCle=request.getParameter("motCle");
				List<mybook> mybooks = metier.mybooksParMC(motCle);
				request.setAttribute("model", model);
				request.getRequestDispatcher("Books.jsp").forward(request,response);

			}
		
	}else {
		
		String motCle=request.getParameter("motCle");
		model.setMotCle(motCle);
		List<mybook> mybooks = metier.mybooksParMC(motCle);
		model.setmybooks(mybooks);
		request.setAttribute("model", model);
		request.getRequestDispatcher("Books.jsp").forward(request,response);

	}
	}
}
