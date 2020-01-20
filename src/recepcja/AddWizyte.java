package recepcja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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


class AddWizyte extends JFrame implements ActionListener {

	private Jack link;
	private JButton dodaj, anuluj;
	private JTextField Data, Godz;
	private JComboBox<String> pq;
	private String[] numeryLekarzy;
	private String IDPacjenta;
	
	AddWizyte(Jack link, String IDPacjenta, String imie, String nazwisko) {
		
		this.IDPacjenta = IDPacjenta;
		this.link = link;
		
		setTitle("Utwórz wizytê");
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
		part1.setLayout(new GridLayout(7,1));
		
		JPanel panRef;
		JLabel labRef;

		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Pacjent:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Godz = new JTextField();
		Godz.setPreferredSize(new Dimension(200,30));
		Godz.setText(imie + " " + nazwisko);
		Godz.setEditable(false);
		panRef.add(Godz);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Data:");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Data = new JTextField();
		Data.setPreferredSize(new Dimension(200,30));
		
		Object obj = Doctors.tblCalendar.getModel().getValueAt(Doctors.tblCalendar.getSelectedRow(), Doctors.tblCalendar.getSelectedColumn());
    	String[] monthNumber = {
    			"01",
    			"02",
    			"03",
    			"04",
    			"05",
    			"06",
    			"07",
    			"08",
    			"09",
    			"10",
    			"11",
    			"12",	   	
    	};
		String wybranaData = Doctors.currentYear + "-" + monthNumber[Doctors.currentMonth] + "-" + obj.toString();
		Data.setText(wybranaData);
		Data.setEditable(false);
		
		panRef.add(Data);
		
		panRef.setLayout(new BoxLayout(panRef, BoxLayout.PAGE_AXIS));
		part1.add(panRef);
		
		-	
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		labRef = new JLabel("Godzina (w formacie HH:MM):");
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
 
		Godz = new JTextField();
		Godz.setPreferredSize(new Dimension(200,30));
		panRef.add(Godz);
		
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
		
		allpart.add(part1);
		add(allpart, BorderLayout.CENTER);
		
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
		
		anuluj = new JButton("Anuluj");
		anuluj.addActionListener(this);
		anuluj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		anuluj.setForeground(Color.white);
		anuluj.setBackground(new Color(80,100,255));
		anuluj.setContentAreaFilled(false);
		anuluj.setOpaque(true);
		
		part3.add(anuluj);
		
		add(part3, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source == dodaj) {
			Scanner s = new Scanner((String)pq.getSelectedItem());
			try {
				link.addWizyte(
						IDPacjenta,
						("" + s.nextInt()),
						Data.getText(),
						Godz.getText()
						);
				Object obj = Doctors.tblCalendar.getModel().getValueAt(Doctors.tblCalendar.getSelectedRow(), Doctors.tblCalendar.getSelectedColumn());
	        	String[] monthNumber = {
	        			"01",
	        			"02",
	        			"03",
	        			"04",
	        			"05",
	        			"06",
	        			"07",
	        			"08",
	        			"09",
	        			"10",
	        			"11",
	        			"12",	   	
	        	};
				String wybranaData = Doctors.currentYear + "-" + monthNumber[Doctors.currentMonth] + "-" + obj.toString();//nULL
				Doctors.tab = link.selectWizyty(wybranaData);
				for(int i = 0; i < 17; i++) {//1
					for(int j = 0; j < 4; j++) {
						Doctors.tab2.setValueAt("", i, j);
					}
				}
				for(int i = 0; i < Doctors.tab.length; i++) {//1
					for(int j = 0; j < 4; j++) {
						Doctors.tab2.setValueAt(Doctors.tab[i][j], i, j);
					}
				}
				dispose();
			} catch (SQLException e) {
				new ErrorMessage("B³êdna godzina");
				e.printStackTrace();
			}
		}	
		if(source == anuluj) {
			dispose();
		}		
	}

}

