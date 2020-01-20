package Lekarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logowanie.Jack;

public class HistoryPatient extends JFrame implements ActionListener
{
	private JButton dod, anuluj;
	
	
	private Jack link;
	private String ID;
	static String[][] tab;
	private DefaultTableModel mtblCalendar;
	
	
	
	HistoryPatient(String ID, Jack link)
	{
		this.link = link;
		this.ID =ID;

		
		setLayout(new BorderLayout());
		setTitle("Historia wizyt");
		setSize(650,600);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		

		String[] columnNames = {"Data","Godzina"};
		
		try {
			tab = link.selecDoKartyWizyt(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mtblCalendar = new DefaultTableModel(tab, columnNames) { 
			public boolean isCellEditable(int rowIndex, int mColIndex) { 
				return false; 
			}
		};

		JTable table = new JTable(mtblCalendar);


		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane,  BorderLayout.NORTH);

		JPanel doll = new JPanel();
		doll.setBackground(Color.white);
		
		dod = new JButton("Karta pacjenta");
		dod.setPreferredSize(new Dimension(150,50));
		dod.setForeground(Color.white);
		dod.setFont(new Font("Arial", Font.BOLD, 16));
		dod.setBackground(new Color(80,100,255)); 
		dod.addActionListener(this);
		
		doll.add(dod);
		
		anuluj = new JButton("Anuluj");
		anuluj.setPreferredSize(new Dimension(100,50));
		anuluj.setForeground(Color.white);
		anuluj.setFont(new Font("Arial", Font.BOLD, 16));
		anuluj.setBackground(new Color(80,100,255)); 
		anuluj.addActionListener(this);
		doll.add(anuluj);
		
		
		add(doll);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent x) 
	{
		Object zrodlo = x.getSource();
		if(zrodlo == dod)
		{
			new InformationCard(ID, link);
		}
	
		else if(zrodlo == anuluj)
		{
			dispose();
		}
	
	}

}
