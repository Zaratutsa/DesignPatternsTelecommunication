package dbaccess;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigDB extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String PATH = "external/dbconf.dat";

	private ToolsFile fileObj;

	private JLabel[] label;
	private JTextField[] filed;

	public ConfigDB() {
		this.setBounds(300, 300, 300, 300);
		this.setTitle("DB Conf");
		this.setLayout(new BorderLayout());

		// Panel Config
		JPanel pan = new JPanel();
		label = getLabel();
		filed = getTextField();

		pan.setLayout(new GridLayout(5, 2));

		for (int i = 0; i < 5; i++) {
			pan.add(label[i]);
			pan.add(filed[i]);
		}
		JButton but = new JButton("Change");
		but.addActionListener(new ListenForButton());

		this.add(pan, BorderLayout.CENTER);
		this.add(but, BorderLayout.SOUTH);

		fileObj = new ToolsFile();
		fileObj.readFile(PATH, filed);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private JLabel[] getLabel() {
		JLabel[] lab = new JLabel[5];

		lab[0] = new JLabel("dbUrl");
		lab[1] = new JLabel("dbName");
		lab[2] = new JLabel("dbLogin");
		lab[3] = new JLabel("dbPass");
		lab[4] = new JLabel("dbDriver");
		return lab;
	}

	private JTextField[] getTextField() {
		JTextField[] fil = new JTextField[5];
		fil[0] = new JTextField(20);
		fil[1] = new JTextField(20);
		fil[2] = new JTextField(20);
		fil[3] = new JTextField(20);
		fil[4] = new JTextField(20);
		return fil;
	}

	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DataOutputStream custOutput =  ToolsFile.createFile(PATH);
			fileObj.writeFile(filed,custOutput);

			try {
				custOutput.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "An I/O Error Occurred :" + e, "INSERT", JOptionPane.ERROR_MESSAGE);

				// Closes the program

				System.exit(0);
			}
		}

	}
}
