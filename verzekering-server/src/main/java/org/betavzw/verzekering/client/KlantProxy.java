package org.betavzw.verzekering.client;

import org.betavzw.verzekering.Klant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="klant-server")
public interface KlantProxy{
	@GetMapping("/{id}")
	Klant getKlant(@PathVariable("id")int id);
}

