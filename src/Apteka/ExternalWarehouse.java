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

import logowanie.Jack;


public class ExternalWarehouse extends DefaultTableCellRenderer implements ActionListener
{

	private Jack link;
	String[][] tab;


	private static final long serialVersionUID = 376360537429352351L;
	private static JTable table;
	private static DefaultTableModel mtblCalendar;
	private JScrollPane scrollPane;
	private JButton b1,b2,b3,b4;
	private JTextField field1;
	private JPanel panelbok, paneldol;
	private JComboBox<String> pq;
	

	ExternalWarehouse(Jack link)
	{	
		this.link = link;

		panelbok = new JPanel();
		paneldol = new JPanel();
		
		panelbok.setBackground(new Color(140,210,165));
		paneldol.setBackground(new Color(140,210,165));
		
		
		panelbok.setLayout(new GridLayout(3,1,0,100));
		
		panelbok.setBorder(new EmptyBorder(50,60,50,60));
		paneldol.setBorder(new EmptyBorder(40,0,40,0));
		
		MainWindowPharmacy.panel2 = new JPanel();
		MainWindowPharmacy.panel2.setLayout(new BorderLayout());
		
		
		String[] nazwyKolumn = {
				"ID",
				"Nazwa",
				"Producent",
				"Wymaga recepty",
				"Stan"
		};
		
		try {
			tab = link.selectZMagazynu();
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
	    mtblCalendar.setRowCount(50);
	    		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		//table.setDefaultRenderer(String.class, new VisitorRenderer());
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		

        String[] dlaSercza = {
        		"IDLeku",
				"Nazwa_Leku",
				"Producent_Leku",
				"Wymaga_Recepty",
				"Stan"
        	};
		
		pq = new JComboBox<String>(dlaSercza);

		
		paneldol.add(pq);
		
		field1 = new JTextField();
		field1.setPreferredSize(new Dimension(350,50));
		paneldol.add(field1);
		
				
		b1 = new JButton("Wyszukaj");
		b1.setPreferredSize(new Dimension(160,50));
		b1.setForeground(Color.white);
		b1.setBackground(new Color(10,10,115));
		b1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b1);
		
		b4 = new JButton("Odśwież");
		b4.setPreferredSize(new Dimension(120,50));
		b4.setForeground(Color.white);
		b4.setBackground(new Color(10,10,115));
		b4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		paneldol.add(b4);
		

		b1.addActionListener(this);
		b4.addActionListener(this);

		
		MainWindowPharmacy.panel2.add(scrollPane,BorderLayout.CENTER);
		MainWindowPharmacy.panel2.add(panelbok,BorderLayout.LINE_END);
		MainWindowPharmacy.panel2.add(paneldol,BorderLayout.PAGE_END);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object zrodlo = e.getSource();
		if(zrodlo == b1)
		{

			for(int i = 0; i < tab.length; i++) {
				for(int j = 0; j < 5; j++) {
					table.setValueAt("", i, j);
				}
			}
			try {
				tab = link.serczMagazyn((String)pq.getSelectedItem(), field1.getText());
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 5; j++) {//11
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(zrodlo == b4)
		{
			try {
				tab = link.selectZMagazynu();
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 5; j++) {
						table.setValueAt(tab[i][j], i, j);
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}