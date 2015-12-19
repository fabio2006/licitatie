package ro.fabio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGE")
public class Image implements Serializable {
	@Id
    @GeneratedValue
    @Column(name = "IMAGE_ID")
	private int id;
	
//	private CommonsMultipartFile fileData;
	private String name;
	
	@OneToOne
	@JoinColumn(name="licitatie_id")
	private Licitatie licitatie;
	
    
	
	public Licitatie getLicitatie() {
		return licitatie;
	}
	public void setLicitatie(Licitatie licitatie) {
		this.licitatie = licitatie;
	}
	private byte[] data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	

	
	
}
