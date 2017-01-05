package logic;

public abstract class Offer {
	protected int id;
	protected String type;
	protected int period;
	protected double price;
	protected double priceMinute;
	protected double priceSms;
	protected int internet;
	protected int freeMinutes;
	protected int status;
	protected String desceiption;

	abstract public String getDesceiption();

//	public void setDesceiption(String desceiption) {
//		this.desceiption = desceiption;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public int getPeriod() {
		return this.period;
	}

	public double getPrice() {
		return this.price;
	}

	public double getPriceMinute() {
		return this.priceMinute;
	}

	public double getPriceSms() {
		return this.priceSms;
	}

	public int getInternet() {
		return this.internet;
	}

	public int getFreeMinutes() {
		return this.freeMinutes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + "  TYPE: " + this.type + "  PERIOD: " + this.period + "  PRICE:" + this.price
				+ "  PRICE MINUTE: " + this.priceMinute + "  PRICE SMS: " + this.priceSms + "  INTERNET: "
				+ this.internet + "  FREE MINUTES: " + this.freeMinutes + "  STATUS: " + this.status;
	}

	public abstract void setType();

	public abstract void setPeriod();

	public abstract void setPrice();

	public abstract void setPriceMinute();

	public abstract void setPriceSms();

	public abstract void setInternet();

	public abstract void setFreeMinutes();
}
