package be.zrt.controller;

import be.zrt.pojo.Ordennancement;
import be.zrt.pojo.Tournoi;

public class Main {
	public static void main(String[] args) {
		Tournoi rolandGarros = Tournoi.getInstance();
		for (Ordennancement x : rolandGarros.getTypeTournoi()) {
			rolandGarros.jouer();

		}

	}
}
