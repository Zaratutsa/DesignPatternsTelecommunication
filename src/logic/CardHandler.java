package logic;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CardHandler extends PaymentHandler 
{
	public void handleRequest(String request) 
	{
		if ((request.equalsIgnoreCase("Card"))) 
		{
			JTextField card = new JTextField();
			System.out.println("CardHandler handles " + request);
			
			int answer = JOptionPane.showOptionDialog(null, new Object[]
			{
					"Enter your credit card number:", card
			},
			"CardHandler", JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(answer == JOptionPane.OK_OPTION)
			{
				System.out.println("Card number: \t" + card.getText() + "\n");
			}
		} 
		else
		{
			System.out.println("CardHandler doesn't handle " + request);
			if (successor != null) 
			{
				successor.handleRequest(request);
			}
		}
	}
}