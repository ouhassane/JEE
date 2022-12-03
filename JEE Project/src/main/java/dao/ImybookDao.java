package dao;
import java.util.List;
import metier.mybook;
public interface ImybookDao {
public mybook save(mybook p);
public List<mybook> mybooksParMC(String mc);
public mybook getmybook(Long Id); public mybook updatemybook(mybook p);
public void deletemybook(Long Id);
}