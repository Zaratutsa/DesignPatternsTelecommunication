package bisnes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import logic.Facade;
import dbaccess.DBManager;

public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Facade facade=null;
	
	public Frame(){
		this.setBounds(300, 100, 400, 400);
		this.setTitle("Frame");
		this.setLayout(new FlowLayout());
		this.facade=new Facade();
		
		JButton b1 = new JButton("Check Device");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				facade.ShowComposit();
			}
		});
		
		JButton b2 = new JButton("Add Limit");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				facade.showStrategy();
			}
		});
		
		JButton b3 = new JButton("Oferts");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				facade.showDecorator();
			}
		});
		
		JButton b4 = new JButton("Pay");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				facade.showChain();
			}
		});
		
		JButton b5 = new JButton("Config");
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DBManager().configDB();				
			}
		});
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
