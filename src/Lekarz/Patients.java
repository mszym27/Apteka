package Lekarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logowanie.ErrorMessage;
import logowanie.Jack;

public class Patients implements ActionListener
{
	private JTable table;
	private JScrollPane scrollPane;
	private JButton b4;
	private JTextField field1;
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
	static String[][] tab; 
	private Jack link;
	static DefaultTableModel mtblCalendar;
	private JComboBox<String> pq;
	private JButton dane, refresh;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V		
	Patients(Jack link)
	{	
		this.link = link;
		
		String[] nazwyKolumn = {
				"ID", 
				"Imie", 
				"Nazwisko", 
				"PESEL", 
				"Data urodzenia",
				"Telefon",
				"Ulica",
				"Nr ul.",
				"Nr m.",
				"Kod pocztowy",
				"Miasto",
				"Uprawnienia"
		};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		JPanel paneldol = new JPanel();
		
		paneldol.setBorder(new EmptyBorder(40,0,40,0));
		paneldol.setBackground(new Color(210,220,255));
		
		MainWindowDoctor.panel1 = new JPanel();
		MainWindowDoctor.panel1.setLayout(new BorderLayout());

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		try {
			tab = link.select(); 
			mtblCalendar = new DefaultTableModel(tab, nazwyKolumn) { 
				public boolean isCellEditable(int rowIndex, int mColIndex) { 
					return false; 
				}
			};
			
			table = new JTable(mtblCalendar); 
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setRowSelectionAllowed(true);
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(10);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(10);
			columnModel.getColumn(8).setPreferredWidth(10);
			columnModel.getColumn(11).setPreferredWidth(50);

		} catch(Exception e) {
			
			e.printStackTrace();
		}
		String[] dlaSercza = {
				"IDPacjenta", 
				"Imie", 
				"Nazwisko", 
				"PESEL", 
				"Data_urodzenia",
				"Telefon",
				"Ulica",
				"Kod_pocztowy",
				"Miasto",
				"Uprawnienia"
		};
		pq = new JComboBox<String>(dlaSercza);
		paneldol.add(pq);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		field1 = new JTextField();
		field1.setPreferredSize(new Dimension(350,50));
		paneldol.add(field1);
		
		b4 = new JButton("Wyszukaj");
		b4.addActionListener(this);
		b4.setPreferredSize(new Dimension(160,50));
		b4.setForeground(Color.white);
		b4.setBackground(new Color(80,100,255));
		b4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b4);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		refresh = new JButton("Odœwie¿");
		refresh.addActionListener(this);
		refresh.setPreferredSize(new Dimension(160,50));
		refresh.setForeground(Color.white);
		refresh.setBackground(new Color(80,100,255));
		refresh.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(refresh);
		
		dane = new JButton("Dane pacjenta");
		dane.addActionListener(this);
		dane.setPreferredSize(new Dimension(160,50));
		dane.setForeground(Color.white);
		dane.setBackground(new Color(80,100,255));
		dane.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(dane);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		MainWindowDoctor.panel1.add(scrollPane,BorderLayout.CENTER);
		
		MainWindowDoctor.panel1.add(paneldol,BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object zrodlo = e.getSource();
		if(zrodlo == b4) {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
			for(int i = 0; i < tab.length; i++) {
				for(int j = 0; j < 12; j++) {
					table.setValueAt("", i, j);
				}
			}
			try {
				tab = link.sercz((String)pq.getSelectedItem(), field1.getText());
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 12; j++) {
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				new ErrorMessage("B³¹d po³¹czenia.");
			}
		} else if(zrodlo == dane) {
			try {
			String ID = tab[table.getSelectedRow()][0];
			new HistoryPatient(ID, link);
			} catch (ArrayIndexOutOfBoundsException e1) {
				new ErrorMessage("Brak zaznaczenia.");
			}		
		} else if(zrodlo == refresh) {
			try {
				tab = link.select();
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 12; j++) {
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
	}
}