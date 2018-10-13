package BlackJack;

import java.util.Scanner;

public class Dealer {
	static boolean doorspelen = true;
	Scanner tekstInvoeren = new Scanner(System.in);

	void starten() {
		while (doorspelen) {
			toonMenu();
			System.out.println("Geef uw keuze aan");
			String invoer = tekstInvoeren.nextLine();
			verwerkenInvoer(invoer);

		}
	}

	void toonMenu() {
		System.out.println("\n1. Kies 'k' om een kaart");
		System.out.println("2. Kies 'p' om te passen");
		System.out.println("3. Kies 'q' om te stoppen");
	}

	void verwerkenInvoer(String deInvoer) {
		switch (deInvoer) {
		case "k":
			Kaartendeck.geefKaart();
			Kaartendeck.verwijderKaart();
			break;
		case "p":
			System.out.println("Pas !");
			System.out.println(Kaartendeck.totaal);
			break;
		case "q":
			doorspelen = false;
			System.out.println("Ik stop !");
			break;

		}
	}
	
}
