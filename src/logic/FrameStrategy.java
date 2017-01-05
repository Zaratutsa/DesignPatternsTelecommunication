package logic;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logic.AveragePromotion;
import logic.HighestPromotion;
import logic.LowestPromotion;
import logic.Strategy;
import logic.TopUp;



public class FrameStrategy {
	
	public  FrameStrategy() {
		JTextField amountField = new JTextField();
		int amount = 0;

		int answer = JOptionPane.showOptionDialog(null, new Object[] { "Amount: ", amountField }, "TOP-UP",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (answer == JOptionPane.OK_OPTION) {
			try {
				amount = Integer.parseInt(amountField.getText());
			} catch (Exception ex) {
				System.err.println("Error in Offer: " + ex);
			}
		}

		double promotion;

		Strategy lowestPromotion = new LowestPromotion();
		TopUp topUp = new TopUp(amount, lowestPromotion);

		if ((promotion = topUp.getResult()) > 0) {
			JOptionPane.showMessageDialog(null, "Amount= " + topUp.getAmount() + " \tPromotion= " + promotion,
					"Promotion", JOptionPane.INFORMATION_MESSAGE);
		} else {
			Strategy averagePromotion = new AveragePromotion();
			topUp.setStrategy(averagePromotion);

			if ((promotion = topUp.getResult()) > 0) {
				JOptionPane.showMessageDialog(null, "Amount= " + topUp.getAmount() + " \tPromotion= " + promotion,
						"Promotion", JOptionPane.INFORMATION_MESSAGE);
			} else {
				Strategy highestPromotion = new HighestPromotion();
				topUp.setStrategy(highestPromotion);

				if ((promotion = topUp.getResult()) > 0) {
					JOptionPane.showMessageDialog(null, "Amount= " + topUp.getAmount() + " \tPromotion= " + promotion,
							"Promotion", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
