package logic;
public abstract class PaymentHandler 
{
	protected PaymentHandler successor;

	public void setSuccessor(PaymentHandler successor) 
	{
		this.successor = successor;
	}
	
	public PaymentHandler getHandler()
	{
		return this.successor;
	}

	public abstract void handleRequest(String request);
}
