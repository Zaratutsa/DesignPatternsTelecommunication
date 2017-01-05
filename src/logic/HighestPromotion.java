package logic;
public class HighestPromotion implements Strategy
{
	@Override
	public double checkPromotion(int amount)
	{
		if (amount >= 50) 
		{
			return 15;
		} 
		else 
		{
			return 0;
		}
	}
}