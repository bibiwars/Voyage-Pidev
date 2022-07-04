package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.services.IVoyageService;

@RestController
@Api(tags = "Gestion des Voyages")
@RequestMapping("/Voyage")
public class VoyageRestController {

	@Autowired
	IVoyageService VoyageService;

	@ApiOperation(value = "")
	@GetMapping("/view")
	public List<Voyage> getAllChats() {
		List<Voyage> list = VoyageService.getAllVoyages();
		return list;
	}

	@PostMapping("/add")
	public Voyage addChat(@RequestBody Voyage v) {
		return VoyageService.addVoyage(v);
	}

	@PutMapping("/modify/{id}")
	public Voyage modifyClient(@PathVariable("id") Long id, @RequestBody Voyage voyage) {
		return VoyageService.modifyVoyage(id, voyage);
	}

	@DeleteMapping("/delete/{id}")
	public void removeClient(@PathVariable("id") Long id) {
		VoyageService.deleteVoyage(id);
	}

}
