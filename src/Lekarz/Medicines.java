package Lekarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Medicines  implements ActionListener
{
	private JButton b3;
	
	Medicines()
	{
		MainWindowDoctor.panel3 = new JPanel();
		MainWindowDoctor.panel3.setBackground(new Color(210,220,255));
		
		JPanel all = new JPanel();
		all.setBackground(new Color(210,220,255));
		all.setLayout(new GridLayout(2, 1));
		
		JPanel gora = new JPanel();
		gora.setBackground(new Color(210,220,255));
		
		
		JPanel dol = new JPanel();
		dol.setLayout(new BorderLayout());
		dol.setBackground(new Color(210,220,255));
		
		JLabel labRef = new JLabel("Naciœniêcie przycisku spowoduje otwarcie strony z kompendium leków.");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		b3 = new JButton("Otwórz stronê (w przegl¹darce internetowej)");
		b3.setPreferredSize(new Dimension(50,50));
		b3.setForeground(Color.white);
		b3.setBackground(new Color(80,100,255));
		b3.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		gora.add(labRef);//, BorderLayout.CENTER
		dol.add(b3, BorderLayout.CENTER);//, BorderLayout.SOUTH
		
		all.add(gora);
		all.add(dol);
		
		b3.addActionListener(this);

		MainWindowDoctor.panel3.add(all);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		URI theURI;
		try {
			theURI = new URI("http://www.swiat-zdrowia.pl/leki/");
			java.awt.Desktop.getDesktop().browse(theURI);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	
}