package logic;

public class AveragePromotion implements Strategy
{
	@Override
	public double checkPromotion(int amount)
	{
		if ((amount >= 25) && (amount < 50)) 
		{
			return 10;
		} 
		else 
		{
			return 0;
		}
	}
}
