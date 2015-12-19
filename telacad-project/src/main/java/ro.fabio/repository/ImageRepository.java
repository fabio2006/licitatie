package ro.fabio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ro.fabio.entity.Image;
import ro.fabio.entity.Licitatie;

public interface ImageRepository extends JpaRepository<Image, Integer>{
	Image findByName(String name);
}
