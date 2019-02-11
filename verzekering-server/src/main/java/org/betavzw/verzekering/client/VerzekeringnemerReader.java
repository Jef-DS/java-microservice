package org.betavzw.verzekering.client;



import org.betavzw.verzekering.Geslacht;
import org.betavzw.verzekering.Klant;
import org.betavzw.verzekering.Verzekeringnemer;
import org.springframework.beans.factory.annotation.Autowired;


public class VerzekeringnemerReader {
	@Autowired
	private KlantProxy klantServer;
	
	public Verzekeringnemer getVerzekeringNemer(int id) {
		Klant klant = klantServer.getKlant(id);
		Verzekeringnemer verzekeringnemer = new Verzekeringnemer();
		verzekeringnemer.setLeeftijd(klant.getLeeftijd());
		Geslacht geslacht = klant.isGeslacht()?Geslacht.man:Geslacht.vrouw;
		verzekeringnemer.setGeslacht(geslacht);
		return verzekeringnemer;
	}
}

