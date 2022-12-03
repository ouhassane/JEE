package metier;
import java.io.Serializable;
public class mybook implements Serializable{
private Long Id;
private String NomOuvrage;
private String Matiere;
private String Niveau;
private String Lire;
public mybook() {
super();
}
public mybook(String NomOuvrage, String Matiere, String Niveau, String Lire) {
super();
this.NomOuvrage = NomOuvrage;
this.Matiere = Matiere;
this.Niveau = Niveau;
this.Lire = Lire;
}
public Long getId() {
return Id;
}
public void setId(Long Id) {
this.Id = Id;
}
public String getNomOuvrage() {
return NomOuvrage;
}
public void setNomOuvrage(String NomOuvrage) {
this.NomOuvrage = NomOuvrage;
}
public String getMatiere() {
return Matiere;
}
public void setMatiere(String Matiere) {
this.Matiere = Matiere;
}
public String getNiveau() {
return Niveau;
}
public void setNiveau(String Niveau) {
this.Niveau = Niveau;
}
public String getLire() {
return Lire;
}
public void setLire(String Lire) {
this.Lire = Lire;
}
@Override
public String toString() {
	return "mybook [Id=" + Id + ", NomOuvrage=" + NomOuvrage + ", Matiere=" + Matiere + ", Niveau=" + Niveau + ", Lire=" + Lire + "]";
}

}

