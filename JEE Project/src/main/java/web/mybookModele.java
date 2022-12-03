package web;
import java.util.ArrayList;
import java.util.List;
import metier.mybook;
public class mybookModele {
private String motCle;
List<mybook> mybooks = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<mybook> getmybooks() {
return mybooks;
}
public void setmybooks(List<mybook> mybooks) {
this.mybooks = mybooks;
}
}