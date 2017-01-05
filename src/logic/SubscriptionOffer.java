package logic;

public class SubscriptionOffer extends Offer 
{
	@Override
	public void setType()
	{
		type = "Subscription";
	}
	
	@Override
	public void setPeriod() 
	{
		period = 24;
	}

	@Override
	public void setPrice() 
	{
		price = 69.99;
	}

	@Override
	public void setPriceMinute()
	{
		priceMinute = 0.3;
	}

	@Override
	public void setPriceSms()
	{
		priceSms = 0.01;
	}

	@Override
	public void setInternet() 
	{
		internet = 5;
	}

	@Override
	public void setFreeMinutes() 
	{
		freeMinutes = 500;
	}

	@Override
	public String getDesceiption() {
		return "SubscriptionOffer";
	}
}
