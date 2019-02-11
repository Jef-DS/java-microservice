package org.betavzw.verzekering;



public class VerzekeringEngine {
	public int berekenPremie(Verzekeringnemer verzekerde) {
		int premie = 100;
		if (verzekerde.getGeslacht().equals(Geslacht.man)) {
			premie += 10;
		}
		if (verzekerde.getLeeftijd() > 43) {
			premie += 20;
		}
		return premie;
	}
}
