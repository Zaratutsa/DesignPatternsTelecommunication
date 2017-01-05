package logic;


public class Apple extends Decorator{

	public Apple(Offer offer) {
		super(offer);
	}
	
	
	public void setDesceiption(String desceiption) {
		setType();
		setPrice();
		setPrice();
		setPriceMinute();
		this.desceiption = offer.getDesceiption()+"  +Apple IOX 10.1";
	}
	
	@Override
	public String getDesceiption() {
		return this.desceiption = offer.getDesceiption()+"  +Apple IOX 10.1";
	}
	
	@Override
	public void setType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPeriod() {
		this.period-=5;
	}

	@Override
	public void setPrice() {
		this.price+=200;		
	}

	@Override
	public void setPriceMinute() {
		this.priceMinute-=0.1;
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
