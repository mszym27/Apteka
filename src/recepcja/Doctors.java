package recepcja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logowanie.ErrorMessage;
import logowanie.Jack;

public class Doctors 

implements ActionListener

{

	static int i = 1;
	private JButton usunw, modyw;
	static JTable tab2;
	private static Jack link;
	static String[][] tab;
	private JScrollPane scrollPane;
	private JLabel label2,label3,label4;


	private JPanel doctor1;
	static JPanel bok2;
	
	
	/*---------------------------------------*/
	
	static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    

	Doctors(Jack link)
	{
		this.link = link;

		
		//tabbedPane2 = new JTabbedPane();
		MainWindowReceptionist.panel2 = new JPanel();
		MainWindowReceptionist.panel2.setLayout(new BorderLayout());

		doctor1 = new JPanel();
		doctor1.setLayout(new BorderLayout());
		new JPanel();
	
		
		JPanel calosc = new JPanel();
		calosc.setLayout(new BorderLayout());
		
		JPanel gora = new JPanel();
		JPanel gora1 = new JPanel();
		JPanel srodek = new JPanel();
		srodek.setLayout(new GridLayout(1,2));
		srodek.setBackground(new Color(210,220,255));
		
		
		JPanel sr1 = new JPanel();
		sr1.setBackground(new Color(210,220,255));
		sr1.setLayout(new BorderLayout());
		
		JPanel sr2 = new JPanel();
		sr2.setBackground(new Color(210,220,255));
		sr2.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
				1, 1, Color.white), "Kalendarz",TitledBorder.ABOVE_BOTTOM,
				TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
				Color.white));
	
		JPanel dolek = new JPanel();
		dolek.setBackground(new Color(210,220,255));
		
		usunw = new JButton("Usun wizytê");
		usunw.setPreferredSize(new Dimension(160,50));
		usunw.setForeground(Color.white);
		usunw.setBackground(new Color(80,100,255));
		usunw.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		
		modyw = new JButton("Dodaj wizytê");
		modyw.setPreferredSize(new Dimension(200,50));
		modyw.setForeground(Color.white);
		modyw.setBackground(new Color(80,100,255));
		modyw.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		//dolek.add(modyw);
		dolek.add(usunw);
		

		usunw.addActionListener(this);
		modyw.addActionListener(this);

		String[] nazwyKolumn = {"Lekarz", "Godzina", "Pacjent", "Telefon"};
		tab = new String[30][4];
		
		mtblCalendar = new DefaultTableModel(tab, nazwyKolumn) { 
			public boolean isCellEditable(int rowIndex, int mColIndex) { 
				return false; 
			}
		};
			
		tab2 = new JTable(mtblCalendar);
		tab2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1)); // HERE
		tab2.setFont(new Font("Arial", Font.BOLD, 13));
		tab2.setRowHeight(25);
		
		scrollPane = new JScrollPane(tab2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		TableColumnModel columnModel = tab2.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(225);
		columnModel.getColumn(2).setPreferredWidth(225);
		columnModel.getColumn(3).setPreferredWidth(150);
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		tab2.getColumnModel().getColumn(0).setCellRenderer(center);
		tab2.getColumnModel().getColumn(1).setCellRenderer(center);
		tab2.getColumnModel().getColumn(2).setCellRenderer(center);
		tab2.getColumnModel().getColumn(3).setCellRenderer(center);
	

		sr1.setBorder(BorderFactory.createTitledBorder(BorderFactory.
					createMatteBorder(1, 1,
					1, 1, Color.white), "Grafik",TitledBorder.ABOVE_BOTTOM,
					TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
					Color.white));
	
		Date d = new Date(); 
		String newstring = new SimpleDateFormat("dd-MM-YYYY").format(d); 
		JPanel datee = new JPanel(); 
		datee.setBackground(new Color(210,220,255)); 
		JLabel todayy = new JLabel(newstring); 
		todayy.setFont(new Font("Comic Sans MS", Font.BOLD, 17)); 
		datee.add(todayy);
		sr1.add(datee, BorderLayout.NORTH);
		
		JPanel tabik = new JPanel();
		tabik.setBackground(new Color(210,220,255));
		tabik.add(scrollPane);
		
		sr1.add(tabik, BorderLayout.CENTER);
		
		srodek.add(sr1);
	/*----------------------CALENDAR--------------------------------*/
		JPanel calendar = new JPanel();
		calendar.setSize(500,500);
		
		
		/*----------------------------------------------------------*/
		
		 //Look and feel
       try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
       catch (ClassNotFoundException e) {}
       catch (InstantiationException e) {}
       catch (IllegalAccessException e) {}
       catch (UnsupportedLookAndFeelException e) {}
		
		//Create controls
       lblMonth = new JLabel ("Styczeñ");
       lblYear = new JLabel ("Wybierz rok:");
       cmbYear = new JComboBox();
       btnPrev = new JButton ("<<<");//&lt;&lt; 
       btnPrev.setPreferredSize(new Dimension(60,30));
 
       btnNext = new JButton (">>>"); //&gt;&gt;
       btnNext.setPreferredSize(new Dimension(60,30));
       
       
       mtblCalendar = new DefaultTableModel()
       {
       public boolean isCellEditable(int rowIndex, int mColIndex)
       {
       	return false;
       }
       };
       tblCalendar = new JTable(mtblCalendar);
      // tblCalendar.setBackground(new Color(210,220,255));
       stblCalendar = new JScrollPane(tblCalendar);
       stblCalendar.setPreferredSize(new Dimension(450,400));
      
       
       pnlCalendar = new JPanel();
       pnlCalendar.setLayout(new BorderLayout());
       pnlCalendar.setBackground(new Color(210,220,255));
       
       pnlCalendar.setPreferredSize(new Dimension(500,500));

       btnPrev.addActionListener(new btnPrev_Action());
       btnNext.addActionListener(new btnNext_Action());
       cmbYear.addActionListener(new cmbYear_Action());
       
       
       JPanel kgora = new JPanel();
       JPanel kdol = new JPanel();
       
     //  kgora.add(lblMonth);
       kgora.add(btnPrev);
       kgora.add(lblMonth);
       kgora.add(btnNext);
       kgora.setBackground(new Color(210,220,255));
       pnlCalendar.add(kgora, BorderLayout.NORTH);
       
       
       
       JPanel ksrodek = new JPanel();
       ksrodek.add(stblCalendar);
       
       pnlCalendar.add(ksrodek, BorderLayout.CENTER);
       ksrodek.setBackground(new Color(210,220,255));
       kdol.setBackground(new Color(210,220,255));
     //  kdol.add(lblYear);   
            
       pnlCalendar.add(kdol,  BorderLayout.SOUTH);
       
       GregorianCalendar cal = new GregorianCalendar(); //Create calendar
       realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
       realMonth = cal.get(GregorianCalendar.MONTH); //Get month
       realYear = cal.get(GregorianCalendar.YEAR); //Get year
       currentMonth = realMonth; //Match month and year
       currentYear = realYear;
       
      
       String[] headers = {"Nie", "Pon", "Wt", "Åšr",
    		   "Czw", "Pi", "Sob"}; 
       for (int i=0; i<7; i++){
           mtblCalendar.addColumn(headers[i]);
       }
       
       tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
       
       tblCalendar.getTableHeader().setResizingAllowed(false);
       tblCalendar.getTableHeader().setReorderingAllowed(false);
       
       tblCalendar.setColumnSelectionAllowed(true);
       tblCalendar.setRowSelectionAllowed(true);
       tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
     
       tblCalendar.setRowHeight(50);
       mtblCalendar.setColumnCount(7);
       mtblCalendar.setRowCount(6);
       
       for (int i=realYear-100; i<=realYear+100; i++)
       {
           cmbYear.addItem(String.valueOf(i));
       }
       
       refreshCalendar (realMonth, realYear); //Refresh calendar
   

		/**-------------------------------------------------------------*/

		
		
       
		
		//calendar.add(pnlCalendar);
		JButton b = new JButton("xddddd");
       sr2.add(pnlCalendar);
		
	/*----------------------CALENDAR--------------------------------*/
      
       
		srodek.add(sr2);
		
		
		
		doctor1.add(gora,BorderLayout.PAGE_START);
		doctor1.add(srodek, BorderLayout.CENTER);
		doctor1.add(dolek, BorderLayout.PAGE_END);
		
			
		
/*----------------------------------------------------------------------*/
		
		
		
		JPanel bokgora22 = new JPanel();
		//bokgora.setBorder(BorderFactory.createLineBorder(Color.white));
		bokgora22.setBackground(new Color(210,220,255));
		
		JPanel bok22 = new JPanel();
		bok22.setLayout(new GridLayout(3,1));
		bok22.setBackground(new Color(210,220,255));
		
		bok2 = new JPanel();
		bok2.setLayout(new FlowLayout());
		bok2.setBackground(new Color(210,220,255));
		
		label2 = new JLabel("dr. Andrej Nowak");
		label2.setFont(new Font("Arial", Font.BOLD, 16));
		bokgora22.add(label2);
		
		label3 = new JLabel("Specjalizacja: Chirurg");
		label3.setFont(new Font("Arial", Font.BOLD, 16));
		bokgora22.add(label3);
		
		label4 = new JLabel("Telefon: 500-000-000");
		label4.setFont(new Font("Arial", Font.BOLD, 16));
		bokgora22.add(label4);
		bok22.add(bokgora22);
		
		
		JPanel dolek22 = new JPanel();
		dolek22.setBackground(new Color(210,220,255));
		JButton usunw22 = new JButton("Usun wizyte");
		usunw22.setPreferredSize(new Dimension(160,50));
		usunw22.setForeground(Color.white);
		usunw22.setBackground(new Color(80,100,255));
		usunw22.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		JButton modyw22 = new JButton("Dodaj wizytê");
		modyw22.setPreferredSize(new Dimension(200,50));
		modyw22.setForeground(Color.white);
		modyw22.setBackground(new Color(80,100,255));
		modyw22.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		dolek22.add(modyw22);
		dolek22.add(usunw22);
		
		String[] columnNames22 = {"Numer","Godzina",
                "Nazwisko","Imie","PESEL","Adres","Telefon"};
		
		String hours22 [] = {"8.00","8.30","9.00","9.30","10.00","10.30",
				"11.00","11.30","12.00","12.30","13.00","13.30","14.00",
				"14.30","15.00","15.30"}; 
			
		JTable tab22 = new JTable(17, 7);
		tab22.setBorder(BorderFactory.createLineBorder(Color.BLACK,1)); // HERE
		tab22.setFont(new Font("Arial", Font.BOLD, 18));
		tab22.setRowHeight(25);
		

		for(int i=0; i<7; i++)
		{
			tab22.setValueAt(columnNames22[i], 0, i);
		}
		
		for(int i=1; i<=16; i++)
		{
			tab22.setValueAt(i, i, 0);
		}
		
		for(int i=1; i<=16; i++)
		{
			tab22.setValueAt(hours22[i-1], i, 1);
		}
		
		bok2.add(tab22);
		
		
		JPanel comp = new JPanel();
		comp.setPreferredSize(new Dimension(10,100));
		bok2.add(comp);
		
		MainWindowReceptionist.panel2.add(doctor1, BorderLayout.CENTER);
		
		
	}
	
	   /*-----------------------------------------------------------------*/ 
	    public static void refreshCalendar(int month, int year)
	    {
	        String[] months =  {"Styczeñ", "Luty", "Marzec", "Kwiecieñ", 
	        		"Maj", "Czerwiec", "Lipiec", "Sierpieñ", "Wrzesieñ", 
	        		"PaÅºdziernik", "Listopad", "Grudzieñ"};
	        int nod, som; 
	        
	        btnPrev.setEnabled(true);
	        btnNext.setEnabled(true);
	        if (month == 0 && year <= realYear-10)
	        {
	        	btnPrev.setEnabled(false);
	        } //Too early
	        if (month == 11 && year >= realYear+100)
	        {btnNext.setEnabled(false);} //Too late
	        lblMonth.setText(months[month]); //Refresh the month label (at the top)
	        //lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
	        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
	        
	        for (int i=0; i<6; i++){
	            for (int j=0; j<7; j++){
	                mtblCalendar.setValueAt(null, i, j);
	            }
	        }
	        
	        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
	        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
	        
	        for (int i=1; i<=nod; i++){
	            int row = new Integer((i+som-2)/7);
	            int column  =  (i+som-2)%7;
	            mtblCalendar.setValueAt(i, row, column);
	        }
	        
	        //Apply renderers
	        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	        
	      
	        tblCalendar.addMouseListener(new MouseAdapter() {
	        	String wybranaData;
	        	String[][] wyniki;
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
	        	Object obj;
	            public void mousePressed(MouseEvent me) {
	            	i++;
	                if (((me.getClickCount() % 2) == 0) && ((i % 3) == 0)) {
	    				try {
		    				obj = tblCalendar.getModel().getValueAt(tblCalendar.getSelectedRow(), tblCalendar.getSelectedColumn());
		    				wybranaData = currentYear + "-" + monthNumber[currentMonth] + "-" + obj.toString();//nULL
		    				//System.out.println(wybranaData);
							tab = link.selectWizyty(wybranaData);
							for(int i = 0; i < 17; i++) {//1
								for(int j = 0; j < 4; j++) {
									Doctors.tab2.setValueAt("", i, j);
								}
							}
							for(int i = 0; i < tab.length; i++) {//1
								for(int j = 0; j < 4; j++) {
									Doctors.tab2.setValueAt(tab[i][j], i, j);
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
	    				 catch (NullPointerException e) {
							
						}
	    						
	                }
	            }
	        }
	       );
       
	    }
	    
	    
	   /*-------------------------------------------------------------------*/ 
	    static class tblCalendarRenderer extends DefaultTableCellRenderer
	    {
	        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
	            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	            if (column == 0 || column == 6)
	            { 
	                setBackground(new Color(180, 220, 190));
	            }
	            else
	            { 
	                setBackground(new Color(255, 255, 255));
	            }
	            if (value != null)
	            {
	                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
	                    setBackground(new Color(220, 220, 255));
	                }
	            }
	            //setBorder(null);///
	            setForeground(Color.black);
	            return this;
	        }
	    }
	    
	   /*---------------------------------------------------------*/ 
	    static class btnPrev_Action implements ActionListener
	    {
	        public void actionPerformed (ActionEvent e)
	        {
	            if (currentMonth == 0)
	            { 
	                currentMonth = 11;
	                currentYear -= 1;
	            }
	            else
	            {
	                currentMonth -= 1;
	            }
	            refreshCalendar(currentMonth, currentYear);
	        }
	    }
	    
	    
	   /*-----------------------------------------------------------*/ 
	    static class btnNext_Action implements ActionListener
	    {
	        public void actionPerformed (ActionEvent e)
	        {
	            if (currentMonth == 11)
	            { 
	                currentMonth = 0;
	                currentYear += 1;
	            }
	            else
	            {
	                currentMonth += 1;
	            }
	            refreshCalendar(currentMonth, currentYear);
	        }
	    }
	    
	    
	 /*-----------------------------------------------------------------*/   
	    static class cmbYear_Action implements ActionListener
	    {
	        public void actionPerformed (ActionEvent e){
	            if (cmbYear.getSelectedItem() != null){
	                String b = cmbYear.getSelectedItem().toString();
	                currentYear = Integer.parseInt(b);
	                refreshCalendar(currentMonth, currentYear);
	            }
	        }
	    }
	    
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			Object zrodlo = e.getSource();
			if(zrodlo == usunw)
			{
				//System.out.println(tab[tab2.getSelectedRow()][4]);
				try {
					link.deleteWizyte(tab[tab2.getSelectedRow()][4]);
    				Object obj = tblCalendar.getModel().getValueAt(tblCalendar.getSelectedRow(), tblCalendar.getSelectedColumn());
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
    				String wybranaData = currentYear + "-" + monthNumber[currentMonth] + "-" + obj.toString();//nULL
					tab = link.selectWizyty(wybranaData);
					for(int i = 0; i < 17; i++) {//1
						for(int j = 0; j < 4; j++) {
							Doctors.tab2.setValueAt("", i, j);
						}
					}
					for(int i = 0; i < tab.length; i++) {//1
						for(int j = 0; j < 4; j++) {
							Doctors.tab2.setValueAt(tab[i][j], i, j);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				catch (Exception e1) {
					new ErrorMessage("Brak zaznaczenia.");
				}
			}
		}

}