package be.zrt.pojo;

public class Joueur extends Personne {
	public Joueur(String nom, String prenom, String sexe) {
		super(nom, prenom, sexe);
	}
	public String toString()
	{
		return nom;
	}
	public String getNom()
	{
		return this.nom;
	}
	public String getPrenom()
	{
		return this.nom;
	}
}
