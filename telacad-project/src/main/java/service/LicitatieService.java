package ro.fabio.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ro.fabio.entity.Licitatie;
import ro.fabio.entity.Role;
import ro.fabio.entity.User;
import ro.fabio.repository.LicitatieRepository;
import ro.fabio.repository.ObiectRepository;
import ro.fabio.repository.UserRepository;

@Service
@Transactional
public class LicitatieService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LicitatieRepository licitatieRepository;
	
	
	public List<Licitatie> findAll() {
		return licitatieRepository.findAll();
	}

	public Licitatie findOne(int id) {
		return licitatieRepository.findOne(id);
	}
	
	
	

	public void save(Licitatie licitatie, User owner) {
		
		licitatie.setOwner(owner);
		

		licitatieRepository.save(licitatie);
	}

	
	public void delete(int id) {
		licitatieRepository.delete(id);
	}

	public Licitatie findOne(String description) {
		return licitatieRepository.findByDescription(description);
	}

}
