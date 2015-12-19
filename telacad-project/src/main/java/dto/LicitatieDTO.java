package ro.fabio.dto;

import java.io.Serializable;

public class LicitatieDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4971435647849537511L;
	private int id_licitatie;
	private String user_licitatie;
	private int pret_licitatie;
	private int pret_pornire_licitatie;
	public int getId_licitatie() {
		return id_licitatie;
	}
	public void setId_licitatie(int id_licitatie) {
		this.id_licitatie = id_licitatie;
	}
	public String getUser_licitatie() {
		return user_licitatie;
	}
	public void setUser_licitatie(String user_licitatie) {
		this.user_licitatie = user_licitatie;
	}
	public int getPret_licitatie() {
		return pret_licitatie;
	}
	public void setPret_licitatie(int pret_licitatie) {
		this.pret_licitatie = pret_licitatie;
	}
	public int getPret_pornire_licitatie() {
		return pret_pornire_licitatie;
	}
	public void setPret_pornire_licitatie(int pret_pornire_licitatie) {
		this.pret_pornire_licitatie = pret_pornire_licitatie;
	}
	
	
	
}
