package Lekarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.Date;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.ibm.icu.text.SimpleDateFormat;

import logowanie.Jack;

public class Doctors 
{	

	private JButton usunw, modyw;
	static JTable tab2;
	private static Jack link;
	static String[][] tab;
	private JScrollPane scrollPane;
	static DefaultTableModel mtblCalendar;

	
	private JScrollPane scrollPane44;
	private JLabel label1,label2,label3,label4,label5;
	private JTable table;
	
	private JPanel doctor1;
	static JPanel bok2;
	
	
	Doctors(Jack link)
	{
		this.link = link;

		MainWindowDoctor.panel2 = new JPanel();
		MainWindowDoctor.panel2.setLayout(new BorderLayout());

		doctor1 = new JPanel();
		doctor1.setLayout(new BorderLayout());

		JPanel bok = new JPanel();
		bok.setBackground(new Color(210,220,255));
		bok.setLayout(new GridLayout(3,1));
		
		bok2 = new JPanel();
		bok2.setBackground(new Color(210,220,255));
		bok2.setLayout(new FlowLayout());

		JPanel dolek = new JPanel();
		dolek.setBackground(new Color(210,220,255));
			

		
		String[] nazwyKolumn = {"Godzina", "Pacjent", "Telefon"};
		try {
			Scanner s = new Scanner(MainWindowDoctor.userLogin);
			tab = link.selectWizytyDlaLekarza(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), ("" + s.nextInt()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mtblCalendar = new DefaultTableModel(tab, nazwyKolumn) { 
			public boolean isCellEditable(int rowIndex, int mColIndex) { 
				return false; 
			}
		};
		
		tab2 = new JTable(mtblCalendar);
		tab2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		tab2.setFont(new Font("Arial", Font.BOLD, 13));
		tab2.setRowHeight(25);
		
		scrollPane = new JScrollPane(tab2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		TableColumnModel columnModel = tab2.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(150);
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(150);
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		tab2.getColumnModel().getColumn(0).setCellRenderer(center);
		tab2.getColumnModel().getColumn(1).setCellRenderer(center);
		tab2.getColumnModel().getColumn(2).setCellRenderer(center);
		
		for(int i = 0; i < tab.length; i++) {//1
			for(int j = 0; j < 3; j++) {
				tab2.setValueAt(tab[i][j], i, j);
			}
		}

		
		tab2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		tab2.setFont(new Font("Arial", Font.BOLD, 18));
		tab2.setRowHeight(25);
		
		bok2.add(scrollPane);

		doctor1.add(bok,BorderLayout.PAGE_START);
		doctor1.add(bok2, BorderLayout.CENTER);
		doctor1.add(dolek, BorderLayout.PAGE_END);
		
		
		MainWindowDoctor.panel2.add(doctor1, BorderLayout.CENTER);		
	}
	
}