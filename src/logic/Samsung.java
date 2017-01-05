package logic;

public class Samsung extends Decorator {

	public Samsung(Offer offer) {
		super(offer);
	}

	@Override
	public String getDesceiption() {
		setType();
		setPrice();
		setPrice();
		setPriceMinute();
		return this.desceiption = offer.getDesceiption() + "  +Samsung Galaxy S3";
	}

	@Override
	public void setType() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPeriod() {
		this.period -= 5;
	}

	@Override
	public void setPrice() {
		this.price += 200;
	}

	@Override
	public void setPriceMinute() {
		this.priceMinute -= 0.1;
	}

	@Override
	public void setPriceSms() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setInternet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFreeMinutes() {
		// TODO Auto-generated method stub

	}

}
