package Apteka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logowanie.ErrorMessage;
import logowanie.Jack;

public class Realization extends DefaultTableCellRenderer implements ActionListener
{

	private Jack link;
	static String[][] tab;


	private static final long serialVersionUID = 1L;
	static JTable table;
	static DefaultTableModel mtblCalendar;
	private JScrollPane scrollPane;
	private JButton b1,b2,b3,b4,b5;
	private JTextField field1;
	private JPanel panelbok, paneldol;
	private JComboBox<String> pq;


	Realization(Jack link)
	{	
		this.link = link;

		
		panelbok = new JPanel();
		paneldol = new JPanel();
		
		panelbok.setBackground(new Color(140,210,165));
		paneldol.setBackground(new Color(140,210,165));
		
		
		panelbok.setLayout(new GridLayout(3,1,0,100));
		
		panelbok.setBorder(new EmptyBorder(50,60,50,60));
		paneldol.setBorder(new EmptyBorder(40,0,40,0));
		
		MainWindowPharmacy.panel4 = new JPanel();
		MainWindowPharmacy.panel4.setLayout(new BorderLayout());
		

		String[] nazwyKolumn = {
			"Data sprzedaży",
			"Produkt",
			"Ilosc",
			"Cena (sztuka)",
			"Koszt",
		};
		
		try {
			tab = link.selectZeSprzedazy();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		mtblCalendar = new DefaultTableModel(tab, nazwyKolumn)
	       {
	       public boolean isCellEditable(int rowIndex, int mColIndex)
	       {
	       	return false;
	       }
	              
	       };
		
		table = new JTable(mtblCalendar);
		table.setRowHeight(20);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		b1 = new JButton("Dodaj");
		b1.setPreferredSize(new Dimension(160,50));
		b1.setForeground(Color.white);
		b1.setBackground(new Color(10,10,115));
		b1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelbok.add(b1);
		
		b2 = new JButton("Modyfikuj");
		b2.setForeground(Color.white);
		b2.setBackground(new Color(10,10,115));
		b2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panelbok.add(b2);
		
		b3 = new JButton("Usuń");
		b3.setForeground(Color.white);
		b3.setBackground(new Color(10,10,115));
		b3.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelbok.add(b3);
		

        String[] dlaSercza = {
        		"Data_Sprzedazy",
				"Produkt",
				"Ilosc",
				"Cena_szt",
				"Koszt"
        	};
		
		pq = new JComboBox<String>(dlaSercza);

		
		paneldol.add(pq);
		
		field1 = new JTextField();
		field1.setPreferredSize(new Dimension(350,50));
		paneldol.add(field1);
		
				
		b4 = new JButton("Wyszukaj");
		b4.setPreferredSize(new Dimension(160,50));
		b4.setForeground(Color.white);
		b4.setBackground(new Color(10,10,115));
		b4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b4);
		
		b5 = new JButton("Odśwież");
		b5.setPreferredSize(new Dimension(120,50));
		b5.setForeground(Color.white);
		b5.setBackground(new Color(10,10,115));
		b5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b5);


		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);

		
		MainWindowPharmacy.panel4.add(scrollPane,BorderLayout.CENTER);
		MainWindowPharmacy.panel4.add(panelbok,BorderLayout.LINE_END);
		MainWindowPharmacy.panel4.add(paneldol,BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object zrodlo = e.getSource();
		if(zrodlo == b4)

		{	
			for(int i = 0; i < tab.length; i++) {
				for(int j = 0; j < 5; j++) {//ditto
					table.setValueAt("", i, j);
				}
			}
			try {
				tab = link.serczSprzedaz((String)pq.getSelectedItem(), field1.getText());
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 5; j++) {//11
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				new ErrorMessage("Błąd połączenia.");
			}
		}
		if(zrodlo == b5)
		{
			try {
				tab = link.selectZeSprzedazy();
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 5; j++) {//11
						table.setValueAt(tab[i][j], i, j);
					}
				}
			}  catch (SQLException e1) {
				new ErrorMessage("Błąd połączenia.");
			}
		}
		else if(zrodlo == b1)
		{
			new NewProduct(link);
		}
		else if(zrodlo == b2)
		{
			try {
				String ID, data, prod, ilosc, cena;
				data = tab[table.getSelectedRow()][0];
				prod = tab[table.getSelectedRow()][1];
				ilosc = tab[table.getSelectedRow()][2];
				cena = tab[table.getSelectedRow()][3];
				ID = tab[table.getSelectedRow()][5];
				new ModifyProduct(ID, data, prod, ilosc, cena, link);
			} catch (ArrayIndexOutOfBoundsException e1) {
				new ErrorMessage("Brak zaznaczenia.");
				e1.printStackTrace();
			}
		}
		else if(zrodlo == b3)
		{
			try {
				String ID = tab[table.getSelectedRow()][5];
				link.deleteSprzedaz(ID);
				Realization.tab = link.selectZeSprzedazy();
				Realization.mtblCalendar.removeRow(0);	
				for(int i = 0; i < Realization.tab.length; i++) {
					for(int j = 0; j < 5; j++) {
						Realization.table.setValueAt(Realization.tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				new ErrorMessage("Błąd połączenia.");
			} catch (ArrayIndexOutOfBoundsException e1) {
				new ErrorMessage("Brak zaznaczenia.");
				e1.printStackTrace();
			}
		}

	}

}