package recepcja;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logowanie.ErrorMessage;
import logowanie.Jack;


public class ModifyPatient extends JFrame implements ActionListener {
	
	private JButton anuluj;
	private JButton modyfikuj;
	private JButton cofnij;
	
	private JTextField imie2, nazwisko2, pesel2, data2, telefon2, ulica2, numer2, Nr_Mieszkania2, miejsc2;
	private String ID, 
		imie1, nazwisko1, PESEL, Uprawnienia, Telefon, Ulica, Nr_Mieszkania, Nr_Lokalu, Kod_Pocztowy, Miasto;
	private Jack link;
	
	private JTextField kod2, kod2a, kod2b, kod2c, kod2d;
	
	ModifyPatient(Jack link, String ID, String imie1, String nazwisko1, String PESEL, String Uprawnienia, 
			String Telefon, String Ulica, String Nr_Mieszkania, String Nr_Lokalu, String Kod_Pocztowy, String Miasto)
	{
		this.ID = ID;

		this.imie1 = imie1;
		this.nazwisko1 = nazwisko1;
		this.PESEL = PESEL;
		this.Uprawnienia = Uprawnienia;
		this.Telefon = Telefon;
		this.Ulica = Ulica;
		this.Nr_Mieszkania = Nr_Mieszkania;
		this.Nr_Lokalu = Nr_Lokalu;
		this.Kod_Pocztowy = Kod_Pocztowy;
		this.Miasto = Miasto;
		this.link = link;
		
		setTitle("Modyfikuj pacjenta");
		setSize(800,600);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		setResizable(false);
		
		
		setLayout(new BorderLayout());
		
		JPanel allpart = new JPanel();
		allpart.setBackground(new Color(210,220,255));
		allpart.setBorder(new EmptyBorder(50,10,10,10));
		
		
		
		JPanel part1 = new JPanel();
		part1.setBackground(new Color(210,220,255));
		part1.setPreferredSize(new Dimension(350,500));
		part1.setLayout(new GridLayout(9,1));
		
		JPanel part2 = new JPanel();
		part2.setBackground(new Color(210,220,255));
		part2.setPreferredSize(new Dimension(350,500));
		part2.setLayout(new GridLayout(9,1));
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(210,220,255));
		
		JLabel imie = new JLabel("Imiê:");
		imie.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		p1.add(imie);
 
		imie2 = new JTextField();
		imie2.setPreferredSize(new Dimension(200,30));
		p1.add(imie2);
		
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(210,220,255));
		
		JLabel nazwisko = new JLabel("Nazwisko:");
		nazwisko.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p2.add(nazwisko);
		
		
		nazwisko2 = new JTextField();
		nazwisko2.setPreferredSize(new Dimension(200,30));
		p2.add(nazwisko2);
		
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p2);
		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(210,220,255));
		
		JLabel pesel = new JLabel("PESEL:");
		pesel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p3.add(pesel);
		
		pesel2 = new JTextField();
		pesel2.setPreferredSize(new Dimension(200,30));
		p3.add(pesel2);
		
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color(210,220,255));
		
		JLabel data = new JLabel("Uprawnienia:");
		data.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		p4.add(data);
		
		data2 = new JTextField();
		data2.setPreferredSize(new Dimension(200,30));
		p4.add(data2);
		
		p4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setBackground(new Color(210,220,255));
		
		JLabel plec = new JLabel("Nr mieszkania:");
		plec.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p5.add(plec);
		
		
		Nr_Mieszkania2 = new JTextField();
		Nr_Mieszkania2.setPreferredSize(new Dimension(200,30));
		part2.add(Nr_Mieszkania2);
		
		p5.add(Nr_Mieszkania2);
		
		p5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p5);
		
		
		JPanel p6 = new JPanel();
		p6.setBackground(new Color(210,220,255));
		
		JLabel miejsc = new JLabel("Miejscowoœæ:");
		miejsc.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p6.add(miejsc);
		
		miejsc2 = new JTextField();
		miejsc2.setPreferredSize(new Dimension(200,30));
		p6.add(miejsc2);
		
		p6.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p6);
		
		JPanel p7 = new JPanel();
		p7.setBackground(new Color(210,220,255));
		
		JLabel ulica = new JLabel("Ulica:");
		ulica.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p7.add(ulica);
		
		ulica2 = new JTextField();
		ulica2.setPreferredSize(new Dimension(200,30));
		p7.add(ulica2);
		
		
		p7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p7);
		
		JPanel p8 = new JPanel();
		p8.setBackground(new Color(210,220,255));
		
		JLabel numer = new JLabel("Numer ul/domu:");
		numer.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p8.add(numer);
		
		numer2 = new JTextField();
		numer2.setPreferredSize(new Dimension(200,30));
		p8.add(numer2);
		
		p8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p8);
		
		JPanel p9 = new JPanel();
		p9.setBackground(new Color(210,220,255));

		
		JLabel kod = new JLabel("Kod pocztowy:");
		kod.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p9.add(kod);
		
		kod2 = new JTextField();
		kod2a = new JTextField();
		kod2b = new JTextField();
		kod2c = new JTextField();
		kod2d = new JTextField();
		
		JLabel m = new JLabel("-");
		m.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		kod2.setPreferredSize(new Dimension(25,30));
		kod2a.setPreferredSize(new Dimension(25,30));
		kod2b.setPreferredSize(new Dimension(25,30));
		kod2c.setPreferredSize(new Dimension(25,30));
		kod2d.setPreferredSize(new Dimension(25,30));
		
		JPanel breaak = new JPanel();//dopasowanie kod poczt.
		breaak.setPreferredSize(new Dimension(30,30));//dopasowanie kod poczt.
		breaak.setBackground(new Color(210,220,255));//dopasowanie kod poczt.
		
		p9.add(kod2);
		p9.add(kod2a);
		p9.add(m);
		p9.add(kod2b);
		p9.add(kod2c);
		p9.add(kod2d);
		p9.add(breaak);//dopasowanie kod poczt.
		
		p9.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p9);
		
		allpart.add(part1);


		JPanel p10 = new JPanel();
		p10.setBackground(new Color(210,220,255));
		
		JLabel telefon = new JLabel("Telefon:");
		telefon.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		p10.add(telefon);
		
		telefon2 = new JTextField();
		telefon2.setPreferredSize(new Dimension(200,30));
		p10.add(telefon2);
		
		p10.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p10);
		
		allpart.add(part2);
		
		add(allpart, BorderLayout.CENTER);
		
		JPanel part3 = new JPanel();
		part3.setBackground(new Color(210,220,255));
		part3.setBorder(new EmptyBorder(10,10,60,10));
		
		
		modyfikuj = new JButton("Modyfikuj pacjenta");
		modyfikuj.addActionListener(this);
		modyfikuj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		part3.add(modyfikuj);
		
		cofnij = new JButton("Cofnij");
		cofnij.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		part3.add(cofnij);
		
		anuluj = new JButton("Anuluj");
		anuluj.addActionListener(this);
		anuluj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		part3.add(anuluj);
		
		add(part3, BorderLayout.SOUTH);
	
		setVisible(true);
		
		cofnij.setForeground(Color.white);
		cofnij.setBackground(new Color(80,100,255));
		cofnij.setContentAreaFilled(false);
		cofnij.setOpaque(true);
		
		modyfikuj.setForeground(Color.white);
		modyfikuj.setBackground(new Color(80,100,255));
		modyfikuj.setContentAreaFilled(false);
		modyfikuj.setOpaque(true);
		
		anuluj.setForeground(Color.white);
		anuluj.setBackground(new Color(80,100,255));
		anuluj.setContentAreaFilled(false);
		anuluj.setOpaque(true);
		
		imie2.setText(imie1);
		nazwisko2.setText(nazwisko1);
		pesel2.setText(PESEL);
		data2.setText(Uprawnienia);
		telefon2.setText(Telefon);
		ulica2.setText(Nr_Lokalu);
		numer2.setText(Nr_Mieszkania);
		Nr_Mieszkania2.setText(Nr_Mieszkania);
		kod2.setText(Character.toString(Kod_Pocztowy.charAt(0)));
		kod2a.setText(Character.toString(Kod_Pocztowy.charAt(1)));
		kod2b.setText(Character.toString(Kod_Pocztowy.charAt(3)));
		kod2c.setText(Character.toString(Kod_Pocztowy.charAt(4)));
		kod2d.setText(Character.toString(Kod_Pocztowy.charAt(5)));
		miejsc2.setText(Miasto);
		
		cofnij.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		Object x = ex.getSource();
		String[][] tab;
		if(x == modyfikuj)
		{
			try {
				StringBuilder kod = new StringBuilder("");
				kod.append(kod2.getText()).append(kod2a.getText()).append("-").append(kod2b.getText()).append(kod2c.getText()).append(kod2d.getText());
				link.modyfikuj(	
						ID,	
						imie2.getText(),
						nazwisko2.getText(),
						pesel2.getText(),
						data2.getText(),
						telefon2.getText(),
						ulica2.getText(),
						numer2.getText(),
						Nr_Mieszkania2.getText(),
						kod.toString(),
						miejsc2.getText()
				);
				tab = link.select(); 
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 11; j++) {
						Patients.table.setValueAt(tab[i][j], i, j);
					}
				}
				dispose();
			} catch (SQLException e) {
				new ErrorMessage("Niew³aœciwe dane.");
				e.printStackTrace();
			}  catch (Exception e) {
				new ErrorMessage("Niew³aœciwa d³ugoœæ kodu pocztowego.");
				e.printStackTrace();
			}
		}
		else if(x == cofnij)
		{
			imie2.setText(imie1);
			nazwisko2.setText(nazwisko1);
			pesel2.setText(PESEL);
			data2.setText(Uprawnienia);
			telefon2.setText(Telefon);
			ulica2.setText(Nr_Lokalu);
			numer2.setText(Nr_Mieszkania);
			Nr_Mieszkania2.setText(Nr_Mieszkania);
			kod2.setText(Character.toString(Kod_Pocztowy.charAt(0)));
			kod2a.setText(Character.toString(Kod_Pocztowy.charAt(1)));
			kod2b.setText(Character.toString(Kod_Pocztowy.charAt(3)));
			kod2c.setText(Character.toString(Kod_Pocztowy.charAt(4)));
			kod2d.setText(Character.toString(Kod_Pocztowy.charAt(5)));
			miejsc2.setText(Miasto);
		}
		else if(x == anuluj)
		{
			dispose();
		}	
	}


}
