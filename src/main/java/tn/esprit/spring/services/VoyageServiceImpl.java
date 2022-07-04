package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;

@Service
@Slf4j
public class VoyageServiceImpl implements IVoyageService {

	@Autowired
	VoyageRepository VoyageRepository;

	@Override
	public List<Voyage> getAllVoyages() { 
		List<Voyage> list=null;
		try {
			list= VoyageRepository.findAll();
		} catch (Exception e) {
			log.error("++++++++++++++++++ Error : " + e );
		}
		return list;
	}

	@Override
	public Voyage addVoyage(Voyage v) {
		try {
			VoyageRepository.save(v);
			
		} catch (Exception e) {
			log.error("++++++++++++++++++ Error : " + e );
		}
		return v;
	}

	@Override
	public Voyage modifyVoyage(Long id, Voyage v) {
		Voyage vv = new Voyage();
		try {
			vv = VoyageRepository.getById(id);
			vv = v;
			VoyageRepository.save(vv);
			
		} catch (Exception e) {
			log.error("++++++++++++++++++ Error : " + e );
		}
		return vv;
	}

	@Override
	public void deleteVoyage(Long id) {
		try {
			VoyageRepository.deleteById(id);
		} catch (Exception e){
			log.error("++++++++++++++++++ Error : " + e );
		}
	}

}
