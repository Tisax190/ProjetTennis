package be.zrt.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Tournoi {
	ArrayList<Ordennancement> typeTournoi;
	ArrayList<Joueur> listeJoueurHomme;
	ArrayList<Joueur> listejoueurFemme;

	public Tournoi(ArrayList<Ordennancement> typeTournoi) {
		this.typeTournoi = typeTournoi;
	}

	public Tournoi() {
		ArrayList<Ordennancement> tmpList = new ArrayList<Ordennancement>();
		tmpList.add(new Ordennancement("simpleHomme", 5));
		tmpList.add(new Ordennancement("simpleFemme", 3));
		tmpList.add(new Ordennancement("doubleHomme", 3));
		tmpList.add(new Ordennancement("doubleFemme", 3));
		tmpList.add(new Ordennancement("mixte", 3));
		generationListeJoueur();
	}

	private void generationListeJoueur() {
		String nomFich = "nomHomme.txt";
		String ligne;
		try (BufferedReader entree = new BufferedReader(new FileReader(nomFich))) {
			while ((ligne = entree.readLine()) != null) {
				System.out.println(ligne);
				//this.listeJoueurHomme.add(new Joueur())
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
