package Lekarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import logowanie.Jack;
import logowanie.Starter;

public class MainWindowDoctor extends JFrame implements ActionListener
{
	private	JTabbedPane tabbedPane;
	static JPanel	panel1;
	static	JPanel	panel2;
	static	JPanel	panel3;

	static Toolkit kit = Toolkit.getDefaultToolkit();
	static  Dimension screenSize = kit.getScreenSize();
	
	static int screenHeight = screenSize.height;
	static int screenWidth = screenSize.width;


	static String userLogin;

	
	
	public MainWindowDoctor(String userLogin, Jack link) throws IOException
	{		
		MainWindowDoctor.userLogin = userLogin;

		
		setTitle("Przychodnia lekarska");
		setSize(screenWidth, screenHeight);
		//setBackground(Color.blue);
		//setResizable(false);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(210,220,255));
		topPanel.setLayout(new BorderLayout());
		//topPanel.setBackground(Color.);
		add(topPanel);
		
		
		JPanel panelgora = new JPanel();
		panelgora.setBackground(new Color(210,220,255));
		JPanel panelgora2 = new JPanel();
		panelgora2.setBackground(new Color(210,220,255));
		
		
		JLabel login = new JLabel("Zalogowany: ");
		login.setFont(new Font("Console", Font.BOLD, 15));
		panelgora.add(login);
		
		
		JLabel login2 = new JLabel(userLogin);

		
		login2.setFont(new Font("Console", Font.BOLD, 15));
		panelgora.add(login2);
		
		JButton logout = new JButton("Wyloguj");
		logout.setForeground(Color.white);
		logout.setBackground(new Color(80,100,255));
		logout.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		panelgora2.add(logout);
		
		JPanel head = new JPanel();
		head.setBackground(new Color(210,220,255));
		head.setLayout(new BorderLayout());
		head.add(panelgora, BorderLayout.WEST);
		head.add(panelgora2, BorderLayout.EAST);
		
		topPanel.add(head, BorderLayout.PAGE_START);
		
	
		new Patients(link);
		new Doctors(link);
		new Medicines();
		
		logout.addActionListener(this);

		
		
		ImageIcon icon = new ImageIcon(ImageIO.read(this.getClass().getResource("/Images/pacjenci.jpg")));
		ImageIcon icon2 = new ImageIcon(ImageIO.read(this.getClass().getResource("/Images/lekarze.jpg")));
		ImageIcon icon3 = new ImageIcon(ImageIO.read(this.getClass().getResource("/Images/leki.jpg")));
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		
		tabbedPane.addTab("",icon, panel1);
		tabbedPane.addTab("",icon2, panel2);
		tabbedPane.addTab("",icon3, panel3);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		
	}
	
	public static void main(String args[]) throws IOException, SQLException
	{
		MainWindowDoctor start = new MainWindowDoctor("1 - tylkotest", new Jack("test", "12345"));
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		new Starter();
		dispose();		
	}

}