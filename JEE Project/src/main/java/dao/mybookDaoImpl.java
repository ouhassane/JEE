package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.mybook;
public class mybookDaoImpl implements ImybookDao {
@Override
public mybook save(mybook p) {
Connection conn=SingletonConnection.getConnection();
try {
PreparedStatement ps= conn.prepareStatement("INSERT INTO mybook(NomOuvrage,Matiere,Niveau) VALUES(?,?,?)");
ps.setString(1, p.getNomOuvrage());
ps.setString(2, p.getMatiere());
ps.setString(3, p.getNiveau());
ps.executeUpdate();
PreparedStatement ps2= conn.prepareStatement
("SELECT MAX(Id) as MAX_ID FROM mybook");
ResultSet rs =ps2.executeQuery();
if (rs.next()) {
p.setId(rs.getLong("MAX_ID"));
}
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public List<mybook> mybooksParMC(String mc) {
List<mybook> mybooks= new ArrayList<mybook>();
Connection conn=SingletonConnection.getConnection();
try {
PreparedStatement ps= conn.prepareStatement("select * from mybook where NomOuvrage LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
mybook p = new mybook();
p.setId(rs.getLong("ID_mybook"));
p.setNomOuvrage(rs.getString("NomOuvrage"));
p.setMatiere(rs.getString("Matiere"));
p.setNiveau(rs.getString("Niveau"));
p.setLire(rs.getString("Lire"));
mybooks.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return mybooks;
}
@Override
public mybook getmybook(Long id) {
Connection conn=SingletonConnection.getConnection();
mybook p = new mybook();
try {
PreparedStatement ps= conn.prepareStatement("select * from mybook where ID = ?");
ps.setLong(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
p.setId(rs.getLong("ID"));
p.setNomOuvrage(rs.getString("NomOuvrage"));
p.setMatiere(rs.getString("Matiere"));
p.setNiveau(rs.getString("Niveau"));
p.setLire(rs.getString("Lire"));
}
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public mybook updatemybook(mybook p) {
Connection conn=SingletonConnection.getConnection();
try {
PreparedStatement ps= conn.prepareStatement("UPDATE mybookS SET NomOuvrage=?,Matiere=? WHERE ID_mybook=?");
ps.setString(1, p.getNomOuvrage());
ps.setString(2, p.getMatiere());
ps.setLong(3, p.getId());
ps.setString(4, p.getNiveau());
ps.setString(5, p.getLire());
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public void deletemybook(Long id) {
Connection conn=SingletonConnection.getConnection();
try {
PreparedStatement ps= conn.prepareStatement("DELETE FROM mybookS WHERE ID = ?");
ps.setLong(1, id);
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}