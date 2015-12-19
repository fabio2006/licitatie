package ro.fabio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fabio.entity.Obiect;
import ro.fabio.entity.User;
import ro.fabio.repository.LicitatieRepository;
import ro.fabio.repository.ObiectRepository;

@Service
@Transactional
public class ObiectService {

	@Autowired
	private LicitatieRepository licitatieRepository;

	@Autowired
	private ObiectRepository obiectRepository;
	
	
	public List<Obiect> findAll() {
		return obiectRepository.findAll();
	}

	public Obiect findOne(int id) {
		return obiectRepository.findOne(id);
	}
	
	

	public void save(Obiect obiect) {
		

		obiectRepository.save(obiect);
	}

	
	public void delete(int id) {
		obiectRepository.delete(id);
	}

	public Obiect findOne(String name) {
		return obiectRepository.findByName(name);
	}

}
