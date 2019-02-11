package org.betavzw.verzekering;


import org.betavzw.verzekering.client.VerzekeringnemerReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerzekeringController {
	@Autowired
	private VerzekeringEngine engine;
	@Autowired
	private VerzekeringnemerReader reader;
	@GetMapping("/{id}")
	public int getPremie(@PathVariable("id") int id) {
		Verzekeringnemer verzekerde = reader.getVerzekeringNemer(id);
		int premie = engine.berekenPremie(verzekerde);
		return premie;
	}
	
}
