package logic;

public class TopUp 
{
	private int amount;
	private Strategy strategy;

	public TopUp(int amount, Strategy strategy) 
	{
		this.amount = amount;
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) 
	{
		this.strategy = strategy;
	}

	public int getAmount() 
	{
		return amount;
	}

	public double getResult() 
	{
		return strategy.checkPromotion(amount);
	}
}
