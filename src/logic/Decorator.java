package logic;

public abstract class Decorator extends Offer {
	protected Offer offer;
	
	public Decorator(Offer offer){
		this.offer=offer;
	}
	
}
