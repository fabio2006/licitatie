package ro.fabio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;

@Entity
public class Oferta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6590495859234322471L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@DecimalMin("0")
	private float amount;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="licitatie_id")
	private Licitatie licitatie;

	
}
