package recepcja;

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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logowanie.ErrorMessage;
import logowanie.Jack;

public class Schedules extends DefaultTableCellRenderer implements ActionListener
{	
	static DefaultTableModel mtblCalendar;
	private JScrollPane scrollPane;
	private JButton b1,b2,b3,b4;
	private JTextField field1;
	private JPanel panelbok, paneldol, panelgora;
	
	private Jack link;
	static String[][] tab;
	static JTable tab2;
	
	Schedules(Jack link)
	{	
		this.link = link;
		
		panelgora = new JPanel();
		panelgora.setLayout(new BorderLayout());
		panelbok = new JPanel();
		paneldol = new JPanel();
		
		panelgora.setBackground(new Color(210,220,255));
		panelbok.setBackground(new Color(210,220,255));
		paneldol.setBackground(new Color(210,220,255));
		
		
		panelbok.setLayout(new GridLayout(3,1,0,100));
		
		panelbok.setBorder(new EmptyBorder(50,60,50,60));
		paneldol.setBorder(new EmptyBorder(40,0,40,0));
		
		MainWindowReceptionist.panel3 = new JPanel();
		MainWindowReceptionist.panel3.setLayout(new BorderLayout());
	
		JPanel panelgora1 = new JPanel();
		panelgora1.setBackground(new Color(210,220,255));
		
		JLabel przy = new JLabel("Godziny przyjêæ w przychodni");
		przy.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelgora1.add(przy);
		
		String[] nazwyKolumn = {"Lekarz",
								"Poniedzia³ek",
								"Wtorek", 
								"Œroda",
								"Czwartek",
								"Pi¹tek",
								"Uwagi",
								};

		try {
			tab = link.selectSchedules();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		

		mtblCalendar = new DefaultTableModel(tab, nazwyKolumn) { 
			public boolean isCellEditable(int rowIndex, int mColIndex) { 
				return false; 
			}
		};
		

		tab2 = new JTable(mtblCalendar);
		tab2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tab2.setRowSelectionAllowed(true);

		
		TableColumnModel columnModel = tab2.getColumnModel();
		
		for(int i=0; i<7; i++){
			columnModel.getColumn(i).setPreferredWidth(150);
		}
	

		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		tab2.getColumnModel().getColumn(0).setCellRenderer(center);
		tab2.getColumnModel().getColumn(1).setCellRenderer(center);
		tab2.getColumnModel().getColumn(2).setCellRenderer(center);
		tab2.getColumnModel().getColumn(3).setCellRenderer(center);
		tab2.getColumnModel().getColumn(4).setCellRenderer(center);
		tab2.getColumnModel().getColumn(5).setCellRenderer(center);
		
		tab2.setRowHeight(70);


		tab2.getColumnModel().getColumn(0).setPreferredWidth(80);
		tab2.getColumnModel().getColumn(1).setPreferredWidth(80);
		tab2.getColumnModel().getColumn(2).setPreferredWidth(80);
		tab2.getColumnModel().getColumn(3).setPreferredWidth(80);
		tab2.getColumnModel().getColumn(4).setPreferredWidth(80);
		tab2.getColumnModel().getColumn(5).setPreferredWidth(80);
		
		DefaultTableCellRenderer left = new DefaultTableCellRenderer();
		left.setHorizontalAlignment(SwingConstants.LEFT);
		
		tab2.getColumnModel().getColumn(6).setCellRenderer(left);
		
		scrollPane = new JScrollPane(tab2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelgora.add(scrollPane, BorderLayout.CENTER);

		
		panelgora.add(panelgora1, BorderLayout.NORTH);
		
	
		b1 = new JButton("Dodaj");
		b1.setPreferredSize(new Dimension(160,50));
		b1.setForeground(Color.white);
		b1.setBackground(new Color(80,100,255));
		b1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		b1.addActionListener(this);
		b1.setContentAreaFilled(false);
		b1.setOpaque(true);
		
		panelbok.add(b1);

		b3 = new JButton("Usuñ");
		b3.setForeground(Color.white);
		b3.setBackground(new Color(80,100,255));
		b3.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		b3.setContentAreaFilled(false);
		b3.setOpaque(true);
		b3.addActionListener(this);
		
		panelbok.add(b3);	
		
		MainWindowReceptionist.panel3.add(panelgora,BorderLayout.CENTER);
		MainWindowReceptionist.panel3.add(panelbok,BorderLayout.LINE_END);
		MainWindowReceptionist.panel3.add(paneldol,BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object zrodlo = e.getSource();
		if(zrodlo == b1)
		{

			new AddSchedule(link);
		}
		else if(zrodlo == b3)
		{
			try {
				link.deleteSchedule(tab[tab2.getSelectedRow()][7]);
				mtblCalendar.removeRow(0);
				tab = link.selectSchedules();
				for(int i = 0; i < tab.length; i++) {
					for(int j = 0; j < 7; j++) {
						tab2.setValueAt(tab[i][j], i, j);
					}
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException ex) {
				new ErrorMessage("Brak zaznaczenia.");
			}
		}		

	}

}
