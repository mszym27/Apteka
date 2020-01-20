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

public class AddPatient extends JFrame implements ActionListener
{
	private JButton anuluj;
	private JButton dodaj;
	private JButton wyczysc;
	
	private Jack link;
	private JTextField imie2, nazwisko2, pesel2, upraw, telefon2, ulica2, numer2, Nr_Mieszkania2, miejsc2;
	
	private JTextField kod2, kod2a, kod2b, kod2c, kod2d;
	
	AddPatient(Jack link)
	{
		this.link = link;
		
		setTitle("Dodaj pacjenta");
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
		
		JLabel data = new JLabel("Uprawnienia:");//
		data.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		p4.add(data);
		
		upraw = new JTextField();
		upraw.setPreferredSize(new Dimension(200,30));
		p4.add(upraw);
		
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
		
		
		dodaj = new JButton("Dodaj pacjenta");
		dodaj.addActionListener(this);
		dodaj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		part3.add(dodaj);
		
		wyczysc = new JButton("Wyczyœæ");
		wyczysc.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		part3.add(wyczysc);
		
		anuluj = new JButton("Anuluj");
		anuluj.addActionListener(this);
		anuluj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		part3.add(anuluj);
		
		wyczysc.setForeground(Color.white);
		wyczysc.setBackground(new Color(80,100,255));
		wyczysc.setContentAreaFilled(false);
		wyczysc.setOpaque(true);
		
		dodaj.setForeground(Color.white);
		dodaj.setBackground(new Color(80,100,255));
		dodaj.setContentAreaFilled(false);
		dodaj.setOpaque(true);
		
		anuluj.setForeground(Color.white);
		anuluj.setBackground(new Color(80,100,255));
		anuluj.setContentAreaFilled(false);
		anuluj.setOpaque(true);
		
		
		
		add(part3, BorderLayout.SOUTH);
		
		wyczysc.addActionListener(this);
	
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		Object x = ex.getSource();
		if(x == dodaj)
		{

			StringBuilder kod = new StringBuilder("");
			kod.append(kod2.getText()).append(kod2a.getText()).append("-").append(kod2b.getText()).append(kod2c.getText()).append(kod2d.getText());
			try {
				link.dodaj(	
						imie2.getText(),
						nazwisko2.getText(),
						pesel2.getText(),
						telefon2.getText(),
						ulica2.getText(),
						numer2.getText(),
						Nr_Mieszkania2.getText(),
						kod.toString(),
						miejsc2.getText(),
						upraw.getText()
						);
				Patients.tab = link.select();
				Patients.mtblCalendar.addRow(Patients.tab[Patients.tab.length - 1]);	
				for(int i = 0; i < Patients.tab.length; i++) {
					for(int j = 0; j < 11; j++) {
						Patients.table.setValueAt(Patients.tab[i][j], i, j);
					}
				}
				dispose();
			} catch (SQLException e) {
				new ErrorMessage("Niew³aœciwe dane.");
				e.printStackTrace();
			} catch (Exception e) {
				new ErrorMessage("Niew³aœciwa d³ugoœæ kodu pocztowego.");
				e.printStackTrace();
			}  

		}
		else if(x == wyczysc)
		{
			imie2.setText("");
			nazwisko2.setText("");
			pesel2.setText("");
			upraw.setText("");
			telefon2.setText("");
			ulica2.setText("");
			numer2.setText("");
			Nr_Mieszkania2.setText("");
			kod2.setText("");
			kod2a.setText("");
			kod2b.setText("");
			kod2c.setText("");
			kod2d.setText("");
			miejsc2.setText("");
		}
		else if(x == anuluj)
		{
			dispose();
		}		
	}

	
}
