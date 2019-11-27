package be.zrt.pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordennancement {
	private int nbrDeSetGagnant;
	private String typeDeTournoi; // simple H/F || double || mixte
	private ArrayList<Equipe> listeDesEquipe;
	private ArrayList<Match> listeDesMatchs;

	public Ordennancement(ArrayList<Match> listeDesMatchs) {
		this.listeDesMatchs = listeDesMatchs;
	}

	public Ordennancement(String typeDeTournoi, int nbrDeSetGagnant) {
		this.typeDeTournoi = typeDeTournoi;
		this.nbrDeSetGagnant = nbrDeSetGagnant;
	}

}
