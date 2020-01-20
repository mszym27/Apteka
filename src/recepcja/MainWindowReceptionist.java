package recepcja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import logowanie.Jack;
import logowanie.Starter;

public class MainWindowReceptionist extends JFrame implements ActionListener
{
	static JTabbedPane tabbedPane;
	static JPanel	panel1;
	static	JPanel	panel2;
	static	JPanel	panel3;
	static	JPanel panel4;

	static Toolkit kit = Toolkit.getDefaultToolkit();
	static  Dimension screenSize = kit.getScreenSize();
	
	static int screenHeight = screenSize.height;
	static int screenWidth = screenSize.width;
	

	public MainWindowReceptionist(String imie, Jack link) throws IOException
	{	

		setTitle("Przychodnia lekarska");
		setSize(screenWidth, screenHeight);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(new Color(210,220,255));
		//topPanel.setBackground(Color.);
		add(topPanel);
		
		
		JPanel panelgora = new JPanel();
		panelgora.setBackground(new Color(210,220,255));
		
		JPanel panelgora2 = new JPanel();
		panelgora2.setBackground(new Color(210,220,255));
		
		JLabel login = new JLabel("Login: ");
		login.setFont(new Font("Console", Font.BOLD, 15));
		panelgora.add(login);
		
	
		JLabel login2 = new JLabel(imie);
		
		login2.setFont(new Font("Console", Font.BOLD, 15));
		panelgora.add(login2);
		
		/*
		JButton zablok = new JButton("Zablokuj");
		zablok.setForeground(Color.white);
		zablok.setBackground(new Color(80,100,255));
		zablok.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelgora2.add(zablok);
		*/
		
		JButton logout = new JButton("Wyloguj");
		logout.setForeground(Color.white);
		logout.setBackground(new Color(80,100,255));
		logout.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelgora2.add(logout);
		
		logout.addActionListener(this);
		
		JPanel head = new JPanel();
		head.setBackground(new Color(210,220,255));
		head.setLayout(new BorderLayout());
		head.add(panelgora, BorderLayout.WEST);
		head.add(panelgora2, BorderLayout.EAST);
		
		topPanel.add(head, BorderLayout.PAGE_START);

		
		new Patients(link);
		new Doctors(link);
		new Schedules(link);
	
		
	
		ImageIcon icon = new ImageIcon(ImageIO.read(this.getClass().getResource("/Images/pacjenci.jpg")));
		ImageIcon icon2 = new ImageIcon(ImageIO.read(this.getClass().getResource("/Images/lekarze.jpg")));
		ImageIcon icon3 = new ImageIcon(ImageIO.read(this.getClass().getResource("/Images/leki.jpg")));

		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		
		tabbedPane.addTab("",icon, panel1);
		tabbedPane.addTab("",icon2, panel2);
		tabbedPane.addTab("",icon3, panel3);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
		

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		new Starter();
		dispose();		
	}


}