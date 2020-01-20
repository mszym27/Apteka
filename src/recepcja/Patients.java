package recepcja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logowanie.ErrorMessage;
import logowanie.Jack;


public class Patients implements ActionListener
{
	static JTable table;
	private JScrollPane scrollPane;
	private JButton b1,b2,b3,b4,b5, wizyta;
	private JTextField field1;
	private JComboBox<String> pq;
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
	static String[][] tab; 
	private Jack link;
	static DefaultTableModel mtblCalendar;
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
		
		JPanel panelbok = new JPanel();
		JPanel paneldol = new JPanel();
		
		panelbok.setBackground(new Color(210,220,255));
		paneldol.setBackground(new Color(210,220,255));
		
		
		panelbok.setLayout(new GridLayout(3,1,0,100));
		
		panelbok.setBorder(new EmptyBorder(50,60,50,60));
		paneldol.setBorder(new EmptyBorder(40,0,40,0));
		
		MainWindowReceptionist.panel1 = new JPanel();
		MainWindowReceptionist.panel1.setLayout(new BorderLayout());

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
			columnModel.getColumn(0).setPreferredWidth(30);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(30);
			columnModel.getColumn(8).setPreferredWidth(30);
			
			for(int i = 0; i < tab.length; i++) {
				for(int j = 0; j < 12; j++) {
					table.setValueAt(tab[i][j], i, j);
				}
			}
		}
		catch(Exception e) {
			//table = new JTable(60,10);
			e.printStackTrace();
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A		
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V	
		panelbok.setLayout(new GridLayout(4, 0, 0, 40));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A		
		
		b1 = new JButton("Dodaj");
		b1.setPreferredSize(new Dimension(160,50));
		b1.setForeground(Color.white);
		b1.setBackground(new Color(80,100,255));
		b1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		b1.addActionListener(this);
		panelbok.add(b1);
		
		b2 = new JButton("Modyfikuj");
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V	
		b2.setPreferredSize(new Dimension(160,50));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		b2.setForeground(Color.white);
		b2.setBackground(new Color(80,100,255));
		b2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panelbok.add(b2);
		
		b3 = new JButton("Usuñ");
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		b3.setPreferredSize(new Dimension(160,50));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A	
		
		b3.setForeground(Color.white);
		b3.setBackground(new Color(80,100,255));
		b3.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelbok.add(b3);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V  
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
		
		field1 = new JTextField();
		field1.setPreferredSize(new Dimension(350,50));
		paneldol.add(field1);
		
				
		b4 = new JButton("Wyszukaj");
		b4.setPreferredSize(new Dimension(160,50));
		b4.setForeground(Color.white);
		b4.setBackground(new Color(80,100,255));
		b4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b4);
		
		b5 = new JButton("Odœwie¿");
		b5.setPreferredSize(new Dimension(120,50));
		b5.setForeground(Color.white);
		b5.setBackground(new Color(80,100,255));
		b5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b5);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		wizyta = new JButton("Utwórz wizytê");
		wizyta.setForeground(Color.white);
		wizyta.setBackground(new Color(80,100,255));
		wizyta.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelbok.add(wizyta);
		
		wizyta.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		MainWindowReceptionist.panel1.add(scrollPane,BorderLayout.CENTER);
		MainWindowReceptionist.panel1.add(panelbok,BorderLayout.LINE_END);
		MainWindowReceptionist.panel1.add(paneldol,BorderLayout.PAGE_END);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object zrodlo = e.getSource();
		if(zrodlo == b1)
		{
			new AddPatient(link);

		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		if(zrodlo == b2)
		{
			try {
			String ID, imie, nazwisko, PESEL, Uprawnienia, Telefon, Ulica, Nr_Mieszkania, Nr_Lokalu, Kod_Pocztowy, Miasto;
			ID = tab[table.getSelectedRow()][0];
			imie = tab[table.getSelectedRow()][1];
			nazwisko = tab[table.getSelectedRow()][2];
			PESEL = tab[table.getSelectedRow()][3];
			Telefon = tab[table.getSelectedRow()][5];
			Ulica = tab[table.getSelectedRow()][6];
			Nr_Mieszkania = tab[table.getSelectedRow()][7];
			Nr_Lokalu = tab[table.getSelectedRow()][8];
			Kod_Pocztowy = tab[table.getSelectedRow()][9];
			Miasto = tab[table.getSelectedRow()][10];
			Uprawnienia = tab[table.getSelectedRow()][11];
			new ModifyPatient(link, ID, imie, nazwisko, PESEL, Uprawnienia, Telefon, Ulica, 
					Nr_Mieszkania, Nr_Lokalu, Kod_Pocztowy, Miasto);
			} catch (ArrayIndexOutOfBoundsException ex) {
				new ErrorMessage("Brak zaznaczenia.");
			}

		}
		if(zrodlo == b4)
		{
			try {
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 12; j++) {
						table.setValueAt("", i, j);
					}
				}
				tab = link.sercz((String)pq.getSelectedItem(), field1.getText());
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 12; j++) {//11
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				new ErrorMessage("B³¹d po³¹czenia.");
			}
		}
		if(zrodlo == b3)
		{
			try {
				String ID = tab[table.getSelectedRow()][0];
				link.delete(ID);
				tab = link.select(); 
				mtblCalendar.removeRow(0);
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 12; j++) {
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				new ErrorMessage("B³¹d po³¹czenia.");
			} catch (ArrayIndexOutOfBoundsException e1) {
				new ErrorMessage("Brak zaznaczenia.");
				e1.printStackTrace();
			}
		}
		if(zrodlo == b5)
		{
			try {
				tab = link.select();
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 12; j++) {
						Patients.table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(zrodlo == wizyta)
		{
			try {
				String ID, imie, nazwisko;
				ID = tab[table.getSelectedRow()][0];
				imie = tab[table.getSelectedRow()][1];
				nazwisko = tab[table.getSelectedRow()][2];
				new AddWizyte(link, ID, imie, nazwisko);
			} catch (ArrayIndexOutOfBoundsException ex) {
				new ErrorMessage("Nale¿y zaznaczyæ datê wizyty oraz pacjenta.");
			}
		} 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A	
				
	}
}