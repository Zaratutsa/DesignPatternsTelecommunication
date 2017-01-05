package logic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Apple;
import logic.Offer;
import logic.OfferFactory;
import logic.Samsung;

public class FrameDcorator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Offer ofer = null;
	private static int card = 1;
	private static JPanel cards;
	private static CardLayout layout;

	private JButton but1, but2, but3;
	
	JLabel lab1,lab2,lab3,lab4;
	JTextField fil1,fil2,fil3,fil4;

	public FrameDcorator() {
		this.setBounds(300, 100, 600, 600);
		this.setTitle("Frame");

		but1 = new JButton("CardOffer");
		but2 = new JButton("MixOffer");
		but3 = new JButton("SubscriptionOffer");
		but1.addActionListener(new Action());
		but2.addActionListener(new Action());
		but3.addActionListener(new Action());

		layout = new CardLayout();
		cards = new JPanel(layout);
		JPanel oferrPan = new JPanel();
		oferrPan.add(but1);
		oferrPan.add(but2);
		oferrPan.add(but3);
		oferrPan.setLayout(new GridLayout(4, 1));

		lab1=new JLabel("Ofert : ");
		lab2=new JLabel("SMS : ");
		lab3=new JLabel("Internet : ");
		lab4=new JLabel("Price : ");
		fil1=new JTextField();
		fil2=new JTextField();
		fil3=new JTextField();
		fil4=new JTextField();
		JPanel pan =new JPanel();
		
		pan.setLayout(new GridLayout(6, 2));
		pan.add(lab1);
		pan.add(fil1);
		pan.add(lab2);
		pan.add(fil2);
		pan.add(lab3);
		pan.add(fil3);
		pan.add(lab4);
		pan.add(fil4);

		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPan();
			}
		});
		JButton b3 = new JButton("Show");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ShowFrame(ofer);
			}
		});
		JButton b4 = new JButton("Samsung");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ofer=new Samsung(ofer);
			}
		});
		JButton b5 = new JButton("Apple");
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ofer=new Apple(ofer);
			}
		});
		pan.setBackground(Color.YELLOW);
		pan.add(b2);
		pan.add(b3);
		pan.add(b4);
		pan.add(b5);
		
		cards.add(oferrPan, "===0===");
		cards.add(pan, "===1===");
		this.add(cards);
		
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	static void setPan() {
		layout.show(cards, "===" + card + "===");
		card++;
		card %= 2;
	}
	
	 private void initPan(){
		 fil1.setText(ofer.getDesceiption());
		 fil2.setText(Double.toString(ofer.getPriceSms()));
		 fil3.setText(Double.toString(ofer.getInternet()));
		 fil4.setText(Double.toString(ofer.getPrice()));
	 }

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == but1){
				ofer=OfferFactory.factory("Card");
				initPan();
				setPan();
			}
			else if (e.getSource() == but2){
				ofer=OfferFactory.factory("Mix");
				initPan();
				setPan();
			}
			else if (e.getSource() == but3){
				ofer=OfferFactory.factory("Subscription");
				initPan();
				setPan();
			}
		}

	}
}
