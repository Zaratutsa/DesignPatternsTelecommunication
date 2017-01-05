package logic;
import javax.swing.JOptionPane;

public class CashTransferHandler extends PaymentHandler 
{
	public void handleRequest(String request) 
	{
		if (request.equalsIgnoreCase("Cash")) 
		{
			System.out.println("CashTransferHandler handles " + request);
			
			JOptionPane.showMessageDialog(null, "1111 2222 3333 4444", "ACCOUNT NUMBER", JOptionPane.INFORMATION_MESSAGE);
		} 
		else
		{
			System.out.println("CashTransferHandler doesn't handle " + request);
			if (successor != null) 
			{
				successor.handleRequest(request);
			}
		}
	}
}