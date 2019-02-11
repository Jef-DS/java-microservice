package org.betavzw.klant;

import java.time.LocalDate;

public class Klant {
	private int id;
	private String voornaam;
	private String achternaam;
	private LocalDate geboortedatum;
	private boolean geslacht;
	public Klant(int id, String voornaam, String achternaam, LocalDate geboortedatum, boolean geslacht) {
		super();
		this.id = id;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.geslacht = geslacht;
	}
	public int getId() {
		return id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}
	public LocalDate getGeboortedatum() {
		return geboortedatum;
	}

	public boolean isGeslacht() {
		return geslacht;
	}

	public int getLeeftijd() {
		LocalDate vandaag = LocalDate.now();
		int leeftijd = vandaag.getYear() - geboortedatum.getYear();
		LocalDate verjaardag = LocalDate.of(vandaag.getYear(), geboortedatum.getMonth(), geboortedatum.getDayOfMonth());
		if (verjaardag.compareTo(vandaag) > 0) leeftijd--;
		return leeftijd;
	}
}
