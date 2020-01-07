package src.fr.univavignon.ceri.application.models;

public class MapSize {
	
	public String name;
	public int nbrTiles;
	
	public MapSize(String name, int nbrTiles) {
		this.name = name;
		this.nbrTiles = nbrTiles;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
