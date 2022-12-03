package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MetierImpl implements ImetierCatalogue {
@Override
public List<mybook> getmybookParMotCle(String mc) {
List<mybook> mybooks= new ArrayList<mybook>();
Connection conn=SingletonConnection.getConnection();
try {
PreparedStatement ps= conn.prepareStatement("select * from mybook where Niveau LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
mybook p = new mybook();
p.setId(rs.getLong("ID"));
p.setNomOuvrage(rs.getString("NOM_OUVRAGE"));
p.setMatiere(rs.getString("MATIERE"));
p.setNiveau(rs.getString("NIVEAU"));
mybooks.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return mybooks;
}
@Override
public void addmybook(mybook p) {
// TODO Auto-generated method stub
}
}