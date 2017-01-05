package logic;


public class Facade {
	
	public void ShowComposit(){
		new FrameComposit();
	}
	
	public void showStrategy(){
		new FrameStrategy(); 
	}
	
	public void showDecorator(){
		new FrameDcorator(); 
	}
	
	public void showChain(){
		new FrameChain(); 
	}
}
