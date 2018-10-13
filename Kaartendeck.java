package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Kaartendeck {
	String[] typeKaart = { "S", "H", "R", "K" };
	String[] rangKaart = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int[] kaartWaarde = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
	static ArrayList<Kaart> deckKaarten = new ArrayList<Kaart>();
	static int beginWaarde;
	static int getrokkenWaarde;
	static int totaal;

	void hetDeck() {
		for (int indexType = 0; indexType < typeKaart.length; indexType++) {
			for (int indexRang = 0; indexRang < rangKaart.length; indexRang++) {
				Kaart kaart = new Kaart();
				kaart.kleur = typeKaart[indexType];
				kaart.waarde = rangKaart[indexRang];
				kaart.kaartwaarde = kaartWaarde[indexRang];
				deckKaarten.add(kaart);
			}
		}
	}

	void deckSchudden() {
		Collections.shuffle(deckKaarten);
		System.out.println(deckKaarten + "\n");
	}

	void toonEersteKaart() {
		System.out.println("U start met de volgende kaarten: " + "\nEerste kaart is: " + deckKaarten.get(0)
				+ "\nTweede kaart is: " + deckKaarten.get(1));
		beginWaarde = (deckKaarten.get(0).kaartwaarde + deckKaarten.get(1).kaartwaarde);
		System.out.println("De totale waarde is: " + beginWaarde);
		Dealer dealer = new Dealer();
		dealer.starten();
	}

	static void geefKaart() {
		System.out.println("Je hebt de " + deckKaarten.get(2) + " gekregen");
		getrokkenWaarde = deckKaarten.get(2).kaartwaarde;
		int totaleWaarde = beginWaarde + getrokkenWaarde;
		totaal = totaleWaarde;
		if (totaleWaarde < 21) {
			System.out.println("Je totale score is " + totaleWaarde);
			beginWaarde = totaleWaarde;
			deckKaarten.remove(0);
			System.out.println();
		} else if (totaleWaarde == 21) {
			System.out.println("Gewonnen, Blackjack!");
			Dealer.doorspelen = false;
		} else {
			System.out.println("Je totale score is " + totaleWaarde);
			System.out.println("Verloren!");
			Dealer.doorspelen = false;
		}

	}

	static void verwijderKaart() {
		deckKaarten.remove(0);
	}

}
