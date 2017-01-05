package logic;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PayPalHandler extends PaymentHandler 
{
	public void handleRequest(String request) 
	{
		if (request.equalsIgnoreCase("PayPal")) 
		{
			System.out.println("PayPalHandler handles " + request);
			
			JTextField login = new JTextField();
			JTextField pass = new JTextField();
			System.out.println("CardHandler handles " + request);
			
			int answer = JOptionPane.showOptionDialog(null, new Object[]
			{
					"Login:", login, "Password: ", pass
			},
			"Log in to PAYPAL:", JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(answer == JOptionPane.OK_OPTION)
			{
				System.out.println("Login: \t" + login.getText() + "\n");
			}
		} 
		else 
		{
			System.out.println("PayPalHandler doesn't handle " + request);
			if (successor != null) 
			{
				successor.handleRequest(request);
			}
		}
	}
}
