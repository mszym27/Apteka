package Apteka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logowanie.ErrorMessage;
import logowanie.Jack;


public class ModifyOrder implements ActionListener {
	
	private JButton dodaj, wyczysc, anuluj;

	private JTextField Nazwa, Telefon, Ulica, Nr_Mieszkania, Kod_Pocztowy, Miasto;
	
	private JFrame frame;

	private String ID, nazw, tele, ulic, nrmie, kodp, mias;
	private Jack link;
	
	public ModifyOrder(String ID, String nazw, String tele, String ulic, String nrmie, String kodp, String mias, Jack link) {
		
		this.ID = ID;
		
		this.link = link;
		
		this.nazw = nazw;
		this.tele = tele;
		this.ulic = ulic;
		this.nrmie = nrmie;
		this.kodp = kodp;
		this.mias = mias;
		
		frame = new JFrame();
		
		frame.setTitle("Modyfikuj dostawcê");
		frame.setSize(550, 650);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		frame.setResizable(false);
		
		frame.setLayout(new BorderLayout());
		
		JPanel allpart = new JPanel();
		allpart.setBackground(new Color(210,220,255));
		allpart.setBorder(new EmptyBorder(50,10,10,10));
		
		JPanel part1 = new JPanel();
		part1.setBackground(new Color(210,220,255));
		part1.setPreferredSize(new Dimension(350,500));
		part1.setLayout(new GridLayout(7,1));
		
		JPanel panRef;
		JLabel labRef;

		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Nazwa:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Nazwa = new JTextField();
		Nazwa.setPreferredSize(new Dimension(200,30));
		panRef.add(Nazwa);

		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Telefon:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Telefon = new JTextField();
		Telefon.setPreferredSize(new Dimension(200,30));
		panRef.add(Telefon);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
			
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Ulica");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		
		Ulica = new JTextField();
		Ulica.setPreferredSize(new Dimension(200,30));
		panRef.add(Ulica);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Numer ulicy");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		
		Nr_Mieszkania = new JTextField();
		Nr_Mieszkania.setPreferredSize(new Dimension(200,30));
		panRef.add(Nr_Mieszkania);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Kod pocztowy:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Kod_Pocztowy = new JTextField();
		Kod_Pocztowy.setPreferredSize(new Dimension(200,30));
		panRef.add(Kod_Pocztowy);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
			
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Miasto:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		 
		Miasto = new JTextField();
		Miasto.setPreferredSize(new Dimension(200,30));
		panRef.add(Miasto);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
			
		
		allpart.add(part1);
		frame.add(allpart, BorderLayout.CENTER);
		
		JPanel part3 = new JPanel();
		part3.setBackground(new Color(210,220,255));
		part3.setBorder(new EmptyBorder(10,10,60,10));
		
		dodaj = new JButton("Modyfikuj");
		dodaj.addActionListener(this);
		dodaj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		dodaj.setForeground(Color.white);
		dodaj.setBackground(new Color(80,100,255));
		dodaj.setContentAreaFilled(false);
		dodaj.setOpaque(true);
		
		part3.add(dodaj);
		
		
		wyczysc = new JButton("Cofnij");
		wyczysc.addActionListener(this);
		wyczysc.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		wyczysc.setForeground(Color.white);
		wyczysc.setBackground(new Color(80,100,255));
		wyczysc.setContentAreaFilled(false);
		wyczysc.setOpaque(true);
		
		part3.add(wyczysc);
		
		anuluj = new JButton("Anuluj");
		anuluj.addActionListener(this);
		anuluj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		anuluj.setForeground(Color.white);
		anuluj.setBackground(new Color(80,100,255));
		anuluj.setContentAreaFilled(false);
		anuluj.setOpaque(true);
		
		part3.add(anuluj);
		
		Nazwa.setText(nazw);
		Telefon.setText(tele);
		Ulica.setText(ulic);
		Nr_Mieszkania.setText(nrmie);
		Kod_Pocztowy.setText(kodp);
		Miasto.setText(mias);
		
		frame.add(part3, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source == anuluj) {
			frame.dispose();
		}
		else if(source == wyczysc) {
			Nazwa.setText(nazw);
			Telefon.setText(tele);
			Ulica.setText(ulic);
			Nr_Mieszkania.setText(nrmie);
			Kod_Pocztowy.setText(kodp);
			Miasto.setText(mias);
		}
		else if(source == dodaj) {
			String nazw = Nazwa.getText();
			String tele = Telefon.getText();
			String ulic = Ulica.getText();
			String nrmie = Nr_Mieszkania.getText();
			String kodp = Kod_Pocztowy.getText();
			String mias = Miasto.getText();
			try {
				link.updateOrder(ID, nazw, tele, ulic, nrmie, kodp, mias);
				Orders.tab = link.selectZDostawcow();
				Orders.mtblCalendar.addRow(Orders.tab[Orders.tab.length - 1]);	
				for(int i = 0; i < Orders.tab.length; i++) {
					for(int j = 0; j < 7; j++) {
						Orders.table.setValueAt(Orders.tab[i][j], i, j);
					}
				}
				frame.dispose();
			} catch (SQLException e) {
				new ErrorMessage("Niew³aœciwe dane.");
				e.printStackTrace();
			}
		}
	}
	
}

