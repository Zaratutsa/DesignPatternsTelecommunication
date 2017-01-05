package logic;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Offer;

public class ShowFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Offer ofer;
	
	public ShowFrame(Offer ofer){
		this.ofer=ofer;
		this.setBounds(300, 100, 400, 400);
		this.setTitle("Finish");
		setLayout(new GridLayout(6, 1));
		
		JLabel lab1,lab2,lab3,lab4;
		lab1=new JLabel("Oferta :"+ofer.getDesceiption());
		lab2=new JLabel("price :"+ofer.getPrice());
		lab3=new JLabel("priceMinute :"+ofer.getPriceMinute());
		lab4=new JLabel("priceSms :"+ofer.getPriceSms());
		
		this.add(lab1);
		this.add(lab2);
		this.add(lab3);
		this.add(lab4);
		
		this.setVisible(true);		
	}

}
