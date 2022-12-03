package dao;
import java.util.List;
import metier.mybook;
public class TestDao {
public static void main(String[] args) {
mybookDaoImpl pdao= new mybookDaoImpl();
mybook bok= pdao.save(new mybook("tout en un 1","math","hh"));
System.out.println(bok);
List<mybook> mybooks =pdao.mybooksParMC("TOUT");
for (mybook p : mybooks)
System.out.println(p);
}
}