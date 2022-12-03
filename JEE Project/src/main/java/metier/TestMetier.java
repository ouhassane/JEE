package metier;
import java.util.List;
public class TestMetier {
public static void main(String[] args) {
MetierImpl metier= new MetierImpl();
List<mybook> mybooks = metier.getmybookParMotCle("HP");
for (mybook p : mybooks)
System.out.println(p.getNomOuvrage());
}
}