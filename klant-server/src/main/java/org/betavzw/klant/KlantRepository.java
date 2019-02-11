package org.betavzw.klant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



public class KlantRepository {
	private List<Klant> klanten = new ArrayList<>();
	public void add(Klant klant) {
		klanten.add(klant);
	}
	public Optional<Klant> findById(int id) {
		Optional<Klant> klant = klanten.stream().filter(k -> k.getId() == id).findFirst();
		return klant;
		
	}
	public List<Klant> findAll(){
		return Collections.unmodifiableList(klanten);
	}
}
