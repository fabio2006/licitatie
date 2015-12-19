package ro.fabio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fabio.entity.Image;
import ro.fabio.entity.Obiect;
import ro.fabio.repository.ImageRepository;

@Service
@Transactional
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	public Image findOne(int id) {
		return imageRepository.findOne(id);
	}
	
	

	public void save(Image image) {
		

		imageRepository.save(image);
	}

	
	public void delete(int id) {
		imageRepository.delete(id);
	}

	public Image findOne(String name) {
		return imageRepository.findByName(name);
	}

}
