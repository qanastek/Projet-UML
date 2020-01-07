package src.fr.univavignon.ceri.application.models;

public class Difficulty {
	
	public String name;
	public int nbrPirates;
	
	public Difficulty(String name, int nbrPirates) {
		this.name = name;
		this.nbrPirates = nbrPirates;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
