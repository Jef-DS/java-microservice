package org.betavzw.verzekering;



import org.betavzw.verzekering.client.VerzekeringnemerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerzekeringController {
	private static final Logger LOGGER = LoggerFactory.getLogger(VerzekeringController.class);
	@Autowired
	private VerzekeringEngine engine;
	@Autowired
	private VerzekeringnemerReader reader;
	@GetMapping("/{id}")
	public int getPremie(@PathVariable("id") int id) {
		LOGGER.info("Premie berekenen van " + id);
		Verzekeringnemer verzekerde = reader.getVerzekeringNemer(id);
		int premie = engine.berekenPremie(verzekerde);
		return premie;
	}
	
}
