package ro.fabio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.fabio.entity.Licitatie;
import ro.fabio.entity.User;

public interface LicitatieRepository extends JpaRepository<Licitatie, Integer>{

	Licitatie findByDescription(String description);
	Licitatie findByOwner(User owner);


}
