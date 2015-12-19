package ro.fabio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.fabio.entity.Licitatie;
import ro.fabio.entity.Obiect;
import ro.fabio.entity.User;

public interface ObiectRepository extends JpaRepository<Obiect, Integer>{

	Obiect findByName(String name);
	Obiect findByLicitatie(Licitatie licitatie);


}
