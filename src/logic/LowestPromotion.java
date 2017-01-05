package logic;
public class LowestPromotion implements Strategy
{
	@Override
	public double checkPromotion(int amount)
	{
		if (amount < 25) 
		{
			return 5;
		} 
		else 
		{
			return 0;
		}
	}
}
