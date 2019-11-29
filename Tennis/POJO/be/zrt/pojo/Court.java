package be.zrt.pojo;

import java.util.Random;

public class Court {
	private int nbrSpect;
	private Boolean estCouvert;
	private String typeDeSurface;
	private int num;

	public Court(int nbrSpect, Boolean estCouvert, String typeDeSurface) {
		this.nbrSpect = nbrSpect;
		this.estCouvert = estCouvert;
		this.typeDeSurface = typeDeSurface;
	}

	public Court(int num) {
		Random rdm = new Random();
		this.nbrSpect = rdm.nextInt(500);
		this.num = num;
		this.estCouvert = true;
		this.typeDeSurface = "Terre battue";
	}

	public int getSpectateur() {
		return this.nbrSpect;
	}

	public int getNumCourt() {
		return this.num;
	}

	public String toString() {
		return Integer.toString(this.num);
	}
}
