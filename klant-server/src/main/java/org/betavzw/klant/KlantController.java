package org.betavzw.klant;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KlantController {

	@Inject
	KlantRepository repository;
	
	@GetMapping("/{id}")
	public Klant findById(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	@GetMapping("/")
	public List<Klant> findAll(){
		return repository.findAll();
	}
}
