package logic;

public class CardOffer extends Offer 
{
	@Override
	public void setType()
	{
		type = "Card";
	}
	
	@Override
	public void setPeriod() 
	{
		period = 12;
	}

	@Override
	public void setPrice() 
	{
		price = 39.99;
	}

	@Override
	public void setPriceMinute()
	{
		priceMinute = 0.5;
	}

	@Override
	public void setPriceSms()
	{
		priceSms = 0.1;
	}

	@Override
	public void setInternet() 
	{
		internet = 1;
	}

	@Override
	public void setFreeMinutes() 
	{
		freeMinutes = 100;
	}

	@Override
	public String getDesceiption() {
		return "CardOffer";
	}
}
