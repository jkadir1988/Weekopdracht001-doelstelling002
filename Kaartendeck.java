package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kaartendeck {
	String[] typeKaart = { "S", "H", "R", "K" };
	String[] rangKaart = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int[] kaartWaarde = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
	static ArrayList<Kaart> deckKaarten = new ArrayList<Kaart>();
	static int beginWaarde;
	static int getrokkenWaarde;
	static int totaal;
	static boolean doorspelen = true;

	void hetDeck() {	
		intro();
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
			System.out.println("\nJe totale score is " + totaleWaarde);
			beginWaarde = totaleWaarde;
			deckKaarten.remove(0);
			System.out.println();
		} else if (totaleWaarde == 21) {
			System.out.println("\nGewonnen, Blackjack!\nWilt u nog een keer spelen?\n");
			Dealer.doorspelen = false;
		} else {
			System.out.println("\nJe totale score is " + totaleWaarde);
			System.out.println("\nVerloren!\nWilt u nog een keer spelen?\n");
			Dealer.doorspelen = false;
		}

	}

	static void verwijderKaart() {
		deckKaarten.remove(0);
	}
	void intro() {
		System.out.println("Regels:\nElk kaart heeft zijn eigen waarde.\nKaarten 2 t/m 10 hebben de waarde idem de kaartnummer\nKaarten met een plaatje (Boer, Koningin, Koning) zijn tien punten waard\nAce is 11 punten waard.\n");
		
		System.out.println(
				"S staat voor Schoppen\nH staat voor Harten\nR staat voor Ruiten\nK staat voor Klaver\n"
				+ "\nSpeel zovaak je wilt tot je 21 punten in totaal hebt gehaald!\n"
				+ "\nDit zijn de kaarten: \n");	
	}

}
