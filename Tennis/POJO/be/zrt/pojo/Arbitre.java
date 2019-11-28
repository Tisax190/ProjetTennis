package be.zrt.pojo;

import java.util.ArrayList;

import be.zrt.dao.ArbitreDAO;

public class Arbitre extends Personne {

	public Arbitre(String nom, String prenom, String sexe) {
		super(nom, prenom, sexe);
	}
	public ArrayList<Arbitre> fetchArbitre()
	{
		ArbitreDAO bdd = new ArbitreDAO();
		return bdd.getArbitre();
	}
}
