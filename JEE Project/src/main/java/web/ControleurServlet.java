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
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
ImybookDao metier;
@Override
public void init() throws ServletException {
metier = new mybookDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
String path=request.getServletPath();
if (path.equals("/index.do"))
{
request.getRequestDispatcher("Books.jsp").forward(request,response);
}
else if (path.equals("/chercher.do"))
{
String motCle=request.getParameter("motCle");
mybookModele model= new mybookModele();
model.setMotCle(motCle);
List<mybook> mybooks = metier.mybooksParMC(motCle);
model.setmybooks(mybooks);
request.setAttribute("model", model);
request.getRequestDispatcher("Books.jsp").forward(request,response);
}
else if (path.equals("/saisie.do") )
{
request.getRequestDispatcher("saisiemybook.jsp").forward(request,response);
}
else if (path.equals("/save.do") && request.getMethod().equals("POST"))
{
String NomOuvrage=request.getParameter("NomOuvrage");
String Matiere = (request.getParameter("Matiere"));
String Niveau = (request.getParameter("Niveau"));
String Lire = (request.getParameter("Lire"));
mybook p = metier.save(new mybook(NomOuvrage,Matiere,Niveau, Lire));
request.setAttribute("produit", p);
request.getRequestDispatcher("confirmation.jsp").forward(request,response);
}
else if (path.equals("/supprimer.do"))
{
Long id= Long.parseLong(request.getParameter("id"));
metier.deletemybook(id);
response.sendRedirect("chercher.do?motCle=");
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}
@Override
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
}
}