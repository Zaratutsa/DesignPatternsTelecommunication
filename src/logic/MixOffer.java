package logic;

public class MixOffer extends Offer 
{	
	@Override
	public void setType()
	{
		type = "Mix";
	}
	
	@Override
	public void setPeriod() 
	{
		period = 48;
	}

	@Override
	public void setPrice() 
	{
		price = 25.0;
	}

	@Override
	public void setPriceMinute()
	{
		priceMinute = 0.9;
	}

	@Override
	public void setPriceSms()
	{
		priceSms = 0.2;
	}

	@Override
	public void setInternet() 
	{
		internet = 1;
	}

	@Override
	public void setFreeMinutes() 
	{
		freeMinutes = 50;
	}

	@Override
	public String getDesceiption() {
		return "MixOffer";
	}
}
