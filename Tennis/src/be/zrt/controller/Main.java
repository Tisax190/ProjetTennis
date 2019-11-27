package be.zrt.controller;

import be.zrt.pojo.Ordennancement;
import be.zrt.pojo.Tournoi;

public class Main {
	public static void main(String[] args) {
		Tournoi rolandGarros = Tournoi.getInstance();
		int cpt=0;
		while (true) {
			for (Ordennancement  x: rolandGarros.getTypeTournoi()) {
				x.generationMatch();
				cpt++;
				System.out.println("Génération tour : "+ cpt);
			}
			rolandGarros.ordreDesMatchs();
			rolandGarros.jouer();
		}
		
	}
}
