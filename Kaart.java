package BlackJack;

public class Kaart {
	String kleur;
	String waarde;
	int kaartwaarde;
	
	@Override
	public String toString() {
		return kleur + " " + waarde;
	}
}
