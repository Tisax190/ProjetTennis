package be.zrt.pojo;

import java.util.ArrayList;

public class Equipe {
	private ArrayList<Joueur> membreEquipe;

	public Equipe(ArrayList<Joueur> membreEquipe) {
		this.membreEquipe = membreEquipe;
	}
	public String toString()
	{
		String tmp="";
		for (Joueur joueur : membreEquipe) {
			tmp+=joueur+" ";
		}
		return tmp;
	}
}
