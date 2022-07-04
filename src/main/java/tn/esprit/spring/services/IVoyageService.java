package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Voyage;


public interface IVoyageService {

	List<Voyage> getAllVoyages();
	Voyage addVoyage(Voyage v);
	Voyage modifyVoyage(Long id, Voyage v);
	void deleteVoyage(Long id);

}
