package Lekarz;

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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logowanie.Jack;

public class InformationCard extends JFrame implements ActionListener
{
	private JPanel pan6;
	
	static Toolkit kit = Toolkit.getDefaultToolkit();
	static  Dimension screenSize = kit.getScreenSize();
	
	static int screenHeight = screenSize.height;
	static int screenWidth = screenSize.width;
	
	
	private JButton save, print, recepta, skierowanie, zaswiadczenie;
	private DefaultTableModel mtblCalendar;
	private String[][] tab;
	private String[] danePacjenta;
	private String ID;
	private Jack link;
	private JTextField imie2, nazwisko2, pesel2, upraw, telefon2, ulica2, numer2,  miejsc2, kod2, data2, wiz2, lekk2;
	JTable table;
	
	
	
	InformationCard(String ID, Jack link)
	{
		this.ID = ID;
		this.link = link;

		
		setTitle("Karta pacjenta");
		setSize(screenWidth, screenHeight-50);
		setLayout(new BorderLayout());
		
		pan6 = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(100,10,10,10));
		panel.setLayout(new GridLayout(1,2));
		
		panel.setBackground(new Color(210,220,255));
	
		JPanel part = new JPanel();
		part.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
				1, 1, Color.white), "Dane",TitledBorder.ABOVE_BOTTOM,
				TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
				Color.white));
		part.setBackground(new Color(210,220,255));
		part.setLayout(new GridLayout(2,1));
		
		
		JPanel allpart = new JPanel();
		allpart.setBackground(new Color(210,220,255));
		allpart.setLayout(new GridLayout(1,2));
	
		
		JPanel part1 = new JPanel();
		part1.setBackground(new Color(210,220,255));
		part1.setPreferredSize(new Dimension(350,500));
		part1.setLayout(new GridLayout(7,1));
		
		JPanel part2 = new JPanel();
		part2.setBackground(new Color(210,220,255));
		part2.setPreferredSize(new Dimension(350,500));
		part2.setLayout(new GridLayout(7,1));
		
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
		
		JLabel data = new JLabel("Data:");
		data.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		p4.add(data);
		
		data2 = new JTextField();
		data2.setPreferredSize(new Dimension(200,30));
		p4.add(data2);
		
		p4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setBackground(new Color(210,220,255));
		
		JLabel plec = new JLabel("Status:");
		plec.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p5.add(plec);
		
		
		upraw = new JTextField();
		upraw.setPreferredSize(new Dimension(200,30));
		part2.add(upraw);
		
		p5.add(upraw);
		
		p5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p5);
		
		
		
		JPanel p5b = new JPanel();
		p5b.setBackground(new Color(210,220,255));

		JLabel wiz = new JLabel("Data wizyty:");
		wiz.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p5b.add(wiz);
		
		
		wiz2 = new JTextField();
		wiz2.setPreferredSize(new Dimension(200,30));
	
		
		p5b.add(wiz2);
		
		p5b.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part1.add(p5b);
		
		
		
		JPanel p6 = new JPanel();
		p6.setBackground(new Color(210,220,255));
		
		JLabel miejsc = new JLabel("Miasto:");
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
		
		JLabel numer = new JLabel("Nr ul/dom:");
		numer.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p8.add(numer);
		
		numer2 = new JTextField();
		numer2.setPreferredSize(new Dimension(200,30));
		p8.add(numer2);
		
		p8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p8);
		
		
		JPanel p9 = new JPanel();
		p9.setBackground(new Color(210,220,255));
		
		JLabel kod = new JLabel("Kod poczt:");
		kod.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p9.add(kod);
		
		kod2 = new JTextField();
		kod2.setPreferredSize(new Dimension(200,30));
		p9.add(kod2);
		
		p9.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p9);
		
		
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
		
		JPanel p10b = new JPanel();
		p10b.setBackground(new Color(210,220,255));
		
		JLabel lekk = new JLabel("Lekarz:");
		lekk.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		p10b.add(lekk);
		
		
		lekk2 = new JTextField();
		lekk2.setPreferredSize(new Dimension(200,30));
		part2.add(lekk2);
		
		p10b.add(lekk2);
		
		p10b.setLayout(new FlowLayout(FlowLayout.RIGHT));
		part2.add(p10b);
		
		JPanel part3 = new JPanel();
		part3.setBackground(new Color(210,220,255));
		
/*-------------------------------------------------------------------------*/		
		
		
		JPanel wew = new JPanel();
		wew.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.white), "Informacje:"));
		wew.setBackground(new Color(210,220,255));
		
		wew.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
		        1, 1, Color.white), "Informacje",TitledBorder.ABOVE_BOTTOM,
		        TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
		        Color.white));
		
		
		
		JPanel wew1 = new JPanel();	

		JTextArea opis2 = new JTextArea();
		opis2.setFont(new Font("Arial", Font.BOLD, 15));
		opis2.setPreferredSize(new Dimension(600,400));
		opis2.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.BLACK), "OPIS:"));
		//wew1.add(opis2);
		

		
		JPanel dolzak= new JPanel();
		dolzak.setBackground(new Color(210,220,255));
		
		
		String[] nazwyKolumn = {"", ""};
		tab = new String[5][2];
		
		mtblCalendar = new DefaultTableModel(tab, nazwyKolumn) { 
			public boolean isCellEditable(int rowIndex, int mColIndex) { 
				if(mColIndex == 0) {
					return false;
				}
				return true; 
			}
		};
		
		table = new JTable(mtblCalendar);
		
		String[] dane = null;
		
		try {
			dane = link.selectWszystkieDaneWybranegoPacjenta(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		imie2.setText(dane[1]);
		nazwisko2.setText(dane[2]);
		pesel2.setText(dane[3]);
		upraw.setText(dane[11]);
		telefon2.setText(dane[5]);
		ulica2.setText(dane[6]);
		miejsc2.setText(dane[10]);
		kod2.setText(dane[9]);
		data2.setText(dane[4]);
		numer2.setText(dane[7]);
		wiz2.setText(dane[13]);
		lekk2.setText(dane[14]);	

		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setPreferredSize(new Dimension(500,450));
		table.setRowHeight(35);
				
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i=0; i<2; i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
			
		try {
			dane = link.selectRzadZKarty(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table.setValueAt("DATA", 0,0);
		table.setValueAt("WYWIAD", 1,0);
		table.setValueAt("NR CHOROBY", 2,0);
		table.setValueAt("PIERWSZE ZACHOROWANIE", 3,0);
		table.setValueAt("ZWOLNIENIE", 4,0);
		
		table.setValueAt(dane[0], 0,1);
		table.setValueAt(dane[1], 1,1);
		table.setValueAt(dane[2], 2,1);
		table.setValueAt(dane[3], 3,1);
		table.setValueAt(dane[4], 4,1);
		
		table.setRowHeight(1, 100);

		
		wew1.add(scrollPane);
		
		wew.add(wew1);
		
		part3.add(dolzak);		
			
		JPanel polowa = new JPanel();
		polowa.setLayout(new BorderLayout());
		polowa.setBackground(new Color(210,220,255));
		
		polowa.add(wew);
		panel.add(polowa);
		
		pan6.setBackground(new Color(210,220,255));
		pan6.setBorder(new EmptyBorder(10,10,40,10));
		
		save = new JButton("Zapisz");
		save.setForeground(Color.white);
		save.setBackground(new Color(80,100,255));
		save.setFont(new Font("Comic Sans MS", Font.BOLD, 17)); 
		pan6.add(save);

		recepta = new JButton("Generuj recepte");
		recepta.setForeground(Color.white);
		recepta.setBackground(new Color(80,100,255));
		recepta.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		pan6.add(recepta);

		
		zaswiadczenie = new JButton("Generuj zaœwiadczenie");
		zaswiadczenie.setForeground(Color.white);
		zaswiadczenie.setBackground(new Color(80,100,255));
		zaswiadczenie.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		pan6.add(zaswiadczenie);
	
		
		skierowanie = new JButton("Generuj skierowanie");
		skierowanie.setForeground(Color.white);
		skierowanie.setBackground(new Color(80,100,255));
		skierowanie.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		pan6.add(skierowanie);
		
		
		allpart.add(part1);
		allpart.add(part2);
		
		part.add(allpart);
		part.add(part3);
		
		panel.add(part);
		panel.add(polowa);
			
		
		add(panel,BorderLayout.CENTER);
		add(pan6, BorderLayout.SOUTH);	
		

		save.addActionListener(this);
		recepta.addActionListener(this);
		skierowanie.addActionListener(this);
		zaswiadczenie.addActionListener(this);


	
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		
		setVisible(true);
	}
	
	public static void main(String args []) throws SQLException
	{
		new InformationCard("14", new Jack("test", "12345"));
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		//if(source == save) {
		//	System.out.println("save");
		//}
	
		if(source == save) {
			String data1, wawiad, nr, teknie, data2;
			data1 = (String) table.getModel().getValueAt(0,1);
			wawiad = (String) table.getModel().getValueAt(1,1);
			nr = (String) table.getModel().getValueAt(2,1);
			teknie = (String) table.getModel().getValueAt(3,1);
			data2 = (String) table.getModel().getValueAt(4,1);
			try {
				link.updateKartaKardiologa(data1, wawiad, nr, teknie, data2, ID);
				dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(source == recepta) {
			new Prescription(ID, link);
		}
		if(source == skierowanie) {
			new Recomendations(ID, link);
		}
		if(source == zaswiadczenie) {
			new Referral(ID, link);
		}
	}

	
}