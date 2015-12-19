package ro.fabio.entity;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class LicitatieItem {
	  @Id
	  @GeneratedValue
	  private Long id;

	  @Column(name = "item_no", nullable = false)
	  private int itemNumber;

	  @Column(length = 200, nullable = false)
	  private String name;

	  @Column(name = "call_price", precision = 10, scale = 2)
	  private float callPrice;

	  @Column(name = "bid", precision = 10, scale = 2)
	  private float currentBid;

	  @Column
	  @Enumerated(EnumType.STRING)
	  private LicitatieItemStatus status;
	 
	  public LicitatieItem(){}
	  
	  public LicitatieItem(int itemNumber, float callPrice) {
	    this.itemNumber = itemNumber;
	    this.callPrice = callPrice;
	    this.status = status.OPEN;
	  }

	  public static enum LicitatieItemStatus {
	    OPEN, IN_PROGRESS, SOLD, NOT_SOLD
	  }

	  public int getItemNumber() {
	    return itemNumber;
	  }

	  public LicitatieItemStatus getStatus() {
	    return status;
	  }

	  public void setCallPrice(float callPrice) {
	    this.callPrice = callPrice;
	  }

	  public float getCallPrice() {
	    return callPrice;
	  }

	  public float getHighestBid() {
	    return currentBid != 0L ? currentBid : callPrice;
	  }

	  void activate() {
	    if (status != status.OPEN) {
	      throw new IllegalStateException("Licitatia nu este in starea " + status.OPEN);
	    }
	    this.status = status.IN_PROGRESS;
	  }

	  

	  public void bid(float bid) {
	    if (status != status.IN_PROGRESS) {
	      throw new IllegalStateException("Item is in wrong status:" + status);
	    }
	    this.currentBid = bid;
	    this.status = status.IN_PROGRESS;
	  }
}
