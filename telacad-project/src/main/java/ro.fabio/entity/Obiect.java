package ro.fabio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import ro.fabio.annotation.UniqueUsername;

@Entity
public class Obiect implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8513026733369981813L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, message = "Numele trebuie sa fie mai mare de 3 caractere!")
	@Column(unique = true)
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name="licitatie_id")
	private Licitatie licitatie;
	
//	@OneToMany(mappedBy = "obiect", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
//	private List<Image> images;


	public Integer getId() {
		return id;
	}


	


//	public List<Image> getImages() {
//		return images;
//	}
//
//
//
//
//
//	public void setImages(List<Image> images) {
//		this.images = images;
//	}





	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Licitatie getLicitatie() {
		return licitatie;
	}


	public void setLicitatie(Licitatie licitatie) {
		this.licitatie = licitatie;
	}
	
	
}
