package be.zrt.pojo;

public class Court {
	private int nbrSpect;
	private Boolean estCouvert;
	private String typeDeSurface;

	public Court(int nbrSpect, Boolean estCouvert, String typeDeSurface) {
		this.nbrSpect = nbrSpect;
		this.estCouvert = estCouvert;
		this.typeDeSurface = typeDeSurface;
	}
}
