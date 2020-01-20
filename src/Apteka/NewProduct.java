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

public class NewProduct implements ActionListener {
	
	private JButton dodaj, wyczysc, anuluj;

	private JTextField produkt, ilosc, cenaszt;
	
	private JFrame frame;
	

	private Jack link;
	
	public NewProduct(Jack link) {
		
		this.link = link;

		
		frame = new JFrame();
		
		frame.setTitle("Dodaj produkt");
		frame.setSize(550, 570);
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
		
		labRef = new JLabel("Produkt:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		produkt = new JTextField();
		produkt.setPreferredSize(new Dimension(200,30));
		panRef.add(produkt);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
			
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Iloœæ");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		ilosc = new JTextField();
		ilosc.setPreferredSize(new Dimension(200,30));
		panRef.add(ilosc);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Cena szt.");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		
		cenaszt = new JTextField();
		cenaszt.setPreferredSize(new Dimension(200,30));
		panRef.add(cenaszt);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		allpart.add(part1);
		frame.add(allpart, BorderLayout.CENTER);
		
		JPanel part3 = new JPanel();
		part3.setBackground(new Color(210,220,255));
		part3.setBorder(new EmptyBorder(10,10,60,10));
		
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(this);
		dodaj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		dodaj.setForeground(Color.white);
		dodaj.setBackground(new Color(80,100,255));
		dodaj.setContentAreaFilled(false);
		dodaj.setOpaque(true);
		
		part3.add(dodaj);
		
		
		wyczysc = new JButton("Wyczyœæ");
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
			produkt.setText("");
			ilosc.setText("");
			cenaszt.setText("");
		}
		else if(source == dodaj) {
			String prod = produkt.getText();
			String ilos = ilosc.getText();
			String cena = cenaszt.getText();
			try {
				link.addSprzedaz(prod, ilos, cena);
				Realization.tab = link.selectZeSprzedazy();
				Realization.mtblCalendar.addRow(Realization.tab[Realization.tab.length - 1]);	
				for(int i = 0; i < Realization.tab.length; i++) {
					for(int j = 0; j < 5; j++) {
						Realization.table.setValueAt(Realization.tab[i][j], i, j);
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
