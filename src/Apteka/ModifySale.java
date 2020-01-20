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


public class ModifySale implements ActionListener {
	
	private JButton dodaj, wyczysc, anuluj;

	private JTextField ilosc, koszt, data1, data2;
	
	private JFrame frame;

	private Jack link;
	
	private String ilo, kosz, dat1, dat2, ID;
	
	public ModifySale(String ilo, String kosz, String dat1, String dat2, String ID, Jack link) {
		
		this.link = link;
		
		this.ilo = ilo;
		this.kosz = kosz;
		this.dat1 = dat1;
		this.dat2 = dat2;
		
		this.ID = ID;
		
		frame = new JFrame();
		
		frame.setTitle("Modyfikuj zamówienie");
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
		
		labRef = new JLabel("Ilosc:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		ilosc = new JTextField();
		ilosc.setPreferredSize(new Dimension(200,30));
		panRef.add(ilosc);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
			
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Koszt jednostkowy:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		
		koszt = new JTextField();
		koszt.setPreferredSize(new Dimension(200,30));
		panRef.add(koszt);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Data zamowienia:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		
		data1 = new JTextField();
		data1.setPreferredSize(new Dimension(200,30));
		panRef.add(data1);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Data dostarczenia:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		data2 = new JTextField();
		data2.setPreferredSize(new Dimension(200,30));
		panRef.add(data2);
		
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
		
		ilosc.setText(ilo);
		koszt.setText(kosz);
		data1.setText(dat1);
		data2.setText(dat2);
		
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
			ilosc.setText(ilo);
			koszt.setText(kosz);
			data1.setText(dat1);
			data2.setText(dat2);
		}
		else if(source == dodaj) {
			String ilo = ilosc.getText();
			String kosz = koszt.getText();
			String dat1 = data1.getText();
			String dat2 = data2.getText();
			try {
				link.modyfikujZamowienie(ilo, kosz, dat1, dat2, ID);
				Sale.tab = link.selectZZamowien();	
				for(int i = 0; i < Sale.tab.length; i++) {
					for(int j = 0; j < 6; j++) {
						Sale.table.setValueAt(Sale.tab[i][j], i, j);
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
