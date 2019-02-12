package org.betavzw.klant;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KlantController {
	private static final Logger LOGGER = LoggerFactory.getLogger(KlantController.class);
	@Inject
	KlantRepository repository;
	
	@GetMapping("/{id}")
	public Klant findById(@PathVariable int id) {
		LOGGER.info("klant opgevraagd met id " + id);
		return repository.findById(id).orElse(null);
	}
	@GetMapping("/")
	public List<Klant> findAll(){
		LOGGER.info("Alle klanten opgevraagd");
		return repository.findAll();
	}
}
