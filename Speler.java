package BlackJack;

import java.util.Scanner;

public class Speler {
	boolean doorspelen = true;
	
	void opening() {
		System.out.println("Welkom bij Blackjack\n");
		Scanner scanner = new Scanner(System.in);

		int keuzeMenu = 0;
		while (keuzeMenu != 2) {
			System.out.println("Toets 1 om te spelen\nof\nToets 2 om afsluiten\n");
			keuzeMenu = scanner.nextInt();
			switch (keuzeMenu) {
			case 1:
				start();
				break;
			case 2:
				doorspelen = false;
				einde();
				break;
			default:
				System.out.println("Toets een geldige knop aub!");
			}
		} 
	}
	void start() {
		Kaartendeck kaartdeck = new Kaartendeck();
		kaartdeck.hetDeck();
		kaartdeck.deckSchudden();
		kaartdeck.toonEersteKaart();
	}
	void einde() {
		System.out.println("Tot de volgende keer!");
	}
}
