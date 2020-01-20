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
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logowanie.ErrorMessage;
import logowanie.Jack;


class AddSchedule extends JFrame implements ActionListener {

	private JButton anuluj;
	private JButton dodaj;
	private JButton wyczysc;
	
	private Jack link;
	private JTextField Pon_Godz, Pon_Pok, Wt_Godz, Wt_Pok, Srd_Godz, Srd_Pok, Czw_Godz, Czw_Pok, Ptk_Godz, Ptk_Pok, Opis;
	private JComboBox<String> pq;
	
	private String[] numeryLekarzy;
	
	AddSchedule(Jack link)
	{
		this.link = link;
		
		setTitle("Dodaj rozk³ad");
		setSize(800, 700);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		JPanel allpart = new JPanel();
		allpart.setBackground(new Color(210,220,255));
		allpart.setBorder(new EmptyBorder(50,10,10,10));	
		
		JPanel part1 = new JPanel();
		part1.setBackground(new Color(210,220,255));
		part1.setPreferredSize(new Dimension(350,500));
		part1.setLayout(new GridLayout(7,1));//dni tygodnia + pusty panel + przycisk
		
		JPanel part2 = new JPanel();
		part2.setBackground(new Color(210,220,255));
		part2.setPreferredSize(new Dimension(350,500));
		part2.setLayout(new GridLayout(7,1));
		
		JPanel panRef;
		JLabel labRef;
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Poniedzia³ek godziny:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Pon_Godz = new JTextField();
		Pon_Godz.setPreferredSize(new Dimension(200,30));
		panRef.add(Pon_Godz);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Wtorek godziny:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Wt_Godz = new JTextField();
		Wt_Godz.setPreferredSize(new Dimension(200,30));
		panRef.add(Wt_Godz);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Œroda godziny:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Srd_Godz = new JTextField();
		Srd_Godz.setPreferredSize(new Dimension(200,30));
		panRef.add(Srd_Godz);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-	
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Czwartek godziny:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Czw_Godz = new JTextField();
		Czw_Godz.setPreferredSize(new Dimension(200,30));
		panRef.add(Czw_Godz);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-	
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Pi¹tek godziny:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Ptk_Godz = new JTextField();
		Ptk_Godz.setPreferredSize(new Dimension(200,30));
		panRef.add(Ptk_Godz);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-	
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("IDLekarza");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		try {
			numeryLekarzy = Jack.selectIDLekarzy();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pq = new JComboBox<String>(numeryLekarzy);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		
		panRef.add(labRef);
		panRef.add(pq);
		
		part1.add(panRef);
		
		-
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Poniedzia³ek pokój:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Pon_Pok = new JTextField();
		Pon_Pok.setPreferredSize(new Dimension(200,30));
		panRef.add(Pon_Pok);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part2.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Wtorek pokój:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Wt_Pok = new JTextField();
		Wt_Pok.setPreferredSize(new Dimension(200,30));
		panRef.add(Wt_Pok);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part2.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Œroda pokój:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Srd_Pok = new JTextField();
		Srd_Pok.setPreferredSize(new Dimension(200,30));
		panRef.add(Srd_Pok);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part2.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Czwartek pokój:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Czw_Pok = new JTextField();
		Czw_Pok.setPreferredSize(new Dimension(200,30));
		panRef.add(Czw_Pok);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part2.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Pi¹tek pokój:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Ptk_Pok = new JTextField();
		Ptk_Pok.setPreferredSize(new Dimension(200,30));
		panRef.add(Ptk_Pok);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part2.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Uwagi:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Opis = new JTextField();
		Opis.setPreferredSize(new Dimension(300, 100));
		panRef.add(Opis);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part2.add(panRef);
		
		-
		
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
		
		wyczysc = new JButton("Wyczysc");
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
		
		add(part3, BorderLayout.SOUTH);
		
		allpart.add(part1);
		
		allpart.add(part2);
		
		add(allpart, BorderLayout.NORTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object x = arg0.getSource();
		if(x == dodaj)
		{
			try {
				Scanner s = new Scanner((String)pq.getSelectedItem());
				link.addSchedule(	
						("" + s.nextInt()),
						Pon_Godz.getText(),
						Pon_Pok.getText(),
						Wt_Godz.getText(),
						Wt_Pok.getText(),
						Srd_Godz.getText(),
						Srd_Pok.getText(),
						Czw_Godz.getText(),
						Czw_Pok.getText(),
						Ptk_Godz.getText(),
						Ptk_Pok.getText(),
						Opis.getText()
						);
				Schedules.tab = link.selectSchedules();
				Schedules.mtblCalendar.addRow(Schedules.tab[Schedules.tab.length - 1]);	
				for(int i = 0; i < Schedules.tab.length; i++) {
					for(int j = 0; j < 7; j++) {
						Schedules.tab2.setValueAt(Schedules.tab[i][j], i, j);
					}
				}
				dispose();
			} catch (SQLException e) {
				new ErrorMessage("B³¹d po³¹czenia. Uruchom program ponownie.");
				e.printStackTrace();
			} 
		}
		else if(x == wyczysc)
		{
			Pon_Godz.setText("");
			Pon_Pok.setText("");
			Wt_Godz.setText("");
			Wt_Pok.setText("");
			Srd_Godz.setText("");
			Srd_Pok.setText("");
			Czw_Godz.setText("");
			Czw_Pok.setText("");
			Ptk_Godz.setText("");
			Ptk_Pok.setText("");
			Opis.setText("");
		}
		else if(x == anuluj)
		{
			dispose();
		}
		
	}

}

