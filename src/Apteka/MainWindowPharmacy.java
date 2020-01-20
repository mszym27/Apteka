package Apteka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import logowanie.Jack;
import logowanie.Starter;

public class MainWindowPharmacy extends JFrame implements ActionListener
{	
	private static final long serialVersionUID = 2981763467192704172L;
	static JTabbedPane tabbedPane;
	static JPanel	panel1;
	static	JPanel	panel2;
	static	JPanel	panel3;
	static	JPanel	panel4;

	static	JPanel	panel5;
	static	JPanel	panel6;
	
	static Toolkit kit = Toolkit.getDefaultToolkit();
	static  Dimension screenSize = kit.getScreenSize();
	
	static int screenHeight = screenSize.height;
	static int screenWidth = screenSize.width;
	

	private Jack link;


	
	public MainWindowPharmacy(String imie, Jack link)
	{	
		this.link = link;

		
		setTitle("Przychodnia lekarska");
		setSize(screenWidth, screenHeight);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(new Color(140,210,165));
		add(topPanel);
		
		
		JPanel panelgora = new JPanel();
		panelgora.setBackground(new Color(140,210,165));
		
		JPanel panelgora2 = new JPanel();
		panelgora2.setBackground(new Color(140,210,165));
		
		JLabel login = new JLabel("Zalogowany: ");
		login.setFont(new Font("Console", Font.BOLD, 15));
		panelgora.add(login);

		JLabel login2 = new JLabel(imie);
		login2.setFont(new Font("Console", Font.BOLD, 15));
		panelgora.add(login2);
		
		JButton logout = new JButton("Wyloguj");
		logout.setForeground(Color.white);
		logout.setBackground(new Color(10,10,115));
		logout.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelgora2.add(logout);
		
		JPanel head = new JPanel();
		head.setBackground(new Color(140,210,165));
		head.setLayout(new BorderLayout());
		head.add(panelgora, BorderLayout.WEST);
		head.add(panelgora2, BorderLayout.EAST);
		
		topPanel.add(head, BorderLayout.PAGE_START);
		
	
		logout.addActionListener(this);
		
		new Warehouse(link);//Apteka_Zaplecze
		new Orders(link);// , Dostawcy
		new Realization(link);//Sprzedaz 
		new Additional(link);//, Zrealizowane_Recepty 
		new Sale(link);//zamowienia


		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/Images_dla_Apteki/zaplecze.jpg"));
		ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/Images_dla_Apteki/dostawcy.jpg"));
		ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/Images_dla_Apteki/statystyki.jpg"));
		ImageIcon icon5 = new ImageIcon(this.getClass().getResource("/Images_dla_Apteki/recepty.jpg"));
		ImageIcon icon6 = new ImageIcon(this.getClass().getResource("/Images_dla_Apteki/magazyn.jpg"));

		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		
		tabbedPane.addTab("",icon, panel1);
		tabbedPane.addTab("",icon3, panel3);
		tabbedPane.addTab("",icon4, panel4);
		tabbedPane.addTab("",icon5, panel5);
		tabbedPane.addTab("",icon6, panel6);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
		

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Starter();
		dispose();
	}

	
}