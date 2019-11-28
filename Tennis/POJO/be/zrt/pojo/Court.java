package be.zrt.pojo;

import java.util.Random;

public class Court {
	private int nbrSpect;
	private Boolean estCouvert;
	private String typeDeSurface;

	public Court(int nbrSpect, Boolean estCouvert, String typeDeSurface) {
		this.nbrSpect = nbrSpect;
		this.estCouvert = estCouvert;
		this.typeDeSurface = typeDeSurface;
	}

	public Court() {
		Random rdm = new Random();
		this.nbrSpect = rdm.nextInt();
		this.estCouvert = true;
		this.typeDeSurface = "Terre battue";
	}
}
