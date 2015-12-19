package ro.fabio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Licitatie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7226294021835326601L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, max = 32)
	private String title;

	@Size(min = 0, max = 1024)
	private String description;
	
	@OneToOne(mappedBy = "licitatie", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Image image;
	
	@Column(name = "start_planificat")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
	private Date startTime;
	
	@Column(name = "start_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
	private Date start;
	
	@Column(name = "sfarsit")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
	private Date endTime;
	
	@NotNull
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private LicitatieStatus status;
	
	@DecimalMin("0")
	private float startPrice;
	
	@DecimalMin("0")
	private float currentPrice;
	
	private boolean active;
	
//	@OneToMany(mappedBy = "licitatie", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
//	private List<Oferta> oferte;

	
	
	
//	@OneToMany(mappedBy = "licitatie", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
//	private List<Obiect> obiecte;
//	
	
	@OneToOne
	@JoinColumn(name="owner_id")
	private User owner;
	
	
	
	public  Licitatie() {
		// TODO Auto-generated constructor stub
	}
	
//	public void addOferta(Oferta oferta)
//	{
//		oferta.setlicitatie(this);
//		oferte.add(oferta);
//	}
//
//	public void removeOferta(Oferta oferta)
//	{
//		oferta.setlicitatie(null);
//		oferte.remove(oferta);
//	}
//	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public float getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(float startPrice) {
		this.startPrice = startPrice;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	 public static enum LicitatieStatus {
		    CREATED, PLANNED, IN_PROGRESS, CLOSED
	 }
//	 public Oferta addOferta(float callPrice) {
//		    if (oferte == null) {
//		      oferte = new ArrayList<Oferta>();
//		    }
//		    Oferta item = new Oferta(oferte.size() + 1, callPrice);
//		    oferte.add(item);
//		    return item;
//		  }

	  public void start(Date startDate) {
	    status = LicitatieStatus.IN_PROGRESS;
	    start = startDate;
	  }

	  public void end(Date endDate) {
	    status = LicitatieStatus.CLOSED;
	    endTime = endDate;
	  }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	

	

	
	
	
	
}
