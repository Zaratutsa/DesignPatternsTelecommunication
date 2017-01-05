package logic;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dbaccess.DBManager;
import dbaccess.Transaction;

public class FrameChain {

	public FrameChain() {
		DBManager db=new DBManager();
		PaymentHandler chain = setUpChain();

		JTextField transactionName = new JTextField();
		JTextField transactionDescription = new JTextField();
		JTextField transactionPrice = new JTextField();
		JTextField transactionDate = new JTextField();
		String transactionPayment = "";

		String[] o = new String[] { "Card", "PayPal", "Cash" };
		JList<String> list = new JList<String>(o);

		int answer = JOptionPane.showOptionDialog(null,
				new Object[] { "Name: ", transactionName, "Description: ", transactionDescription, "Price: ",
						transactionPrice, "Date: ", transactionDate, "Payment form: ", new JScrollPane(list) },
				"Transaction", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (answer == JOptionPane.OK_OPTION) {
			if (list.isSelectedIndex(0))
				transactionPayment = "Card";
			if (list.isSelectedIndex(1))
				transactionPayment = "PayPal";
			if (list.isSelectedIndex(2))
				transactionPayment = "Cash";

			try {
				db.addTransaction(transactionName.getText(), transactionDescription.getText(),
						Float.parseFloat(transactionPrice.getText()), transactionDate.getText(), transactionPayment);

				Transaction trans = new Transaction();
				trans.setId(1);
				trans.setName(transactionName.getText());
				trans.setDescr(transactionDescription.getText());
				trans.setPrice(Float.parseFloat(transactionPrice.getText()));
				trans.setDate(transactionDate.getText());
				trans.setPayment(transactionPayment);

				chain.handleRequest(trans.getPayment());
			} catch (Exception ex) {
				System.err.println("Error in Transaction: " + ex);
			}
		}
	}

	public static PaymentHandler setUpChain() {
		PaymentHandler cardHandler = new CardHandler();
		PaymentHandler payPalHandler = new PayPalHandler();
		PaymentHandler cashHandler = new CashTransferHandler();

		cardHandler.setSuccessor(payPalHandler);
		payPalHandler.setSuccessor(cashHandler);

		return cardHandler;
	}
}
