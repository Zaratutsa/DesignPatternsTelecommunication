package logic;

import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dbaccess.*;

public class FrameComposit {
	
	public  FrameComposit() {
		DBManager db = new DBManager();
		String compositeDeviceType = "";
		JFrame mainFrame = null;
		JPanel controlPanel;
		JCheckBox compositeCheckBox = new JCheckBox("Select");
		Composite c1 = new Composite();

		String[] o = new String[] { "Phones", "Tablets", "Laptops" };
		JList<String> list = new JList<String>(o);

		int answer = JOptionPane.showOptionDialog(null,
				new Object[] { "Type: ", new JScrollPane(list), compositeCheckBox }, "Select type of device",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (answer == JOptionPane.OK_OPTION) {
			if (list.isSelectedIndex(0))
				compositeDeviceType = "Phones";
			if (list.isSelectedIndex(1))
				compositeDeviceType = "Tablets";
			if (list.isSelectedIndex(2))
				compositeDeviceType = "Laptops";

			try {
				ResultSet result = db.con.getQuery("Select * from Device WHERE type ='" + compositeDeviceType + "'");
				while (result.next()) {
					Device device = new Device();
					device.setId(result.getInt(1));
					device.setName(result.getString(2));
					device.setPrice(result.getDouble(3));
					device.setType(result.getString(4));
					c1.add(device);
				}

				mainFrame = new JFrame("COMPOSITE");
				mainFrame.setBounds(300, 200, 650, 450);

				controlPanel = new JPanel();
				controlPanel.setLayout(new FlowLayout());

				mainFrame.add(controlPanel);
				mainFrame.setVisible(true);

				JLabel label = new JLabel("");
				label.setText(c1.data());
				label.setFont(new Font("Serif", Font.PLAIN, 18));
				label.setOpaque(true);
				controlPanel.add(label);

//				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.setVisible(true);

				if (compositeCheckBox.isSelected()) {
					JTextField indexField = new JTextField();

					answer = JOptionPane.showOptionDialog(null, new Object[] { "Index: ", indexField },
							"ID of device in composite", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, null, null);
					if (answer == JOptionPane.OK_OPTION) {
						try {
							Component dev = c1.getComponent(Integer.parseInt(indexField.getText()) - 1);
							JOptionPane.showMessageDialog(null, dev.data(), "ITERATOR",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception ex) {
							System.err.println("Error in Device: " + ex);
						}
					}
				}
			} catch (Exception ex) {
				System.out.println("Error in Database: " + ex);
			}
		}
	}

}
