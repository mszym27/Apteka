package logowanie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Apteka.MainWindowPharmacy;
import Lekarz.MainWindowDoctor;
import recepcja.MainWindowReceptionist;

public class Starter  extends JFrame implements ActionListener {
	
	private JPanel window;
	private BufferedImage myPicture;
	private JLabel picLabel;
	private JComboBox p;
	private JButton zal, anuluj;
	private JTextField login;
	private JPasswordField haslo;

	public Starter()
	{
		setTitle("Logowanie");
		setSize(680,600);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		setResizable(false);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		JPanel allwindow = new JPanel();
		allwindow.setLayout(new GridLayout(3,1));
		allwindow.setBackground(Color.white);
		
		window = new JPanel();
		//window.setBackground(Color.WHITE);
		window.setLayout(new GridLayout(5,1));
		
		JPanel kaw1 = new JPanel();
	     
		JPanel g = new JPanel();
		
		g.setBackground(Color.white);
		g.setBorder(new EmptyBorder(50,10,10,10));
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V		
		myPicture = null;
		try 
		{
			myPicture = ImageIO.read(this.getClass().getResource("/Images/logo.png"));
		} 
		catch (IOException e) 
		{	
			new ErrorMessage("Znowu coœ z obrazkami. Skontaktuj siê z Marcinem.");
		
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		picLabel = new JLabel(new ImageIcon(myPicture));
		g.add(picLabel);
		

		
		
		window.setBackground(Color.white);
		kaw1.setBackground(Color.white);
		window.add(kaw1);

		String[] person = {"Recepcjonistka", "Lekarz", "Apteka" };
		
		JPanel kaw2 = new JPanel();
		p = new JComboBox(person);
		p.addActionListener(this);
		
		
		JLabel wyb = new JLabel("Wybór:");
		wyb.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		p.setSelectedIndex(0);
		
		p.setFont(new Font("Arial", Font.BOLD, 16));
		p.setPreferredSize(new Dimension(200,30));
		kaw2.setBackground(Color.white);
		kaw2.add(wyb);
		kaw2.add(p);
		window.add(kaw2);
		
		JLabel log = new JLabel("Login:");
		log.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		JPanel kaw3 = new JPanel();
		login = new JTextField();
		login.setPreferredSize(new Dimension(200,30));
		kaw3.setBackground(Color.white);
		kaw3.add(log);
		kaw3.add(login);
		window.add(kaw3);
		
		JPanel kaw4= new JPanel();
		JLabel has = new JLabel("Has³o:");
		has.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		kaw4.setBackground(Color.white);
		kaw4.add(has);
		
		haslo = new JPasswordField();
		haslo.setPreferredSize(new Dimension(200,30));
	    kaw4.add(haslo);
		window.add(kaw4);
	    
	    
	    JPanel kaw5 = new JPanel();
	    zal = new JButton("Zaloguj");
	    zal.setForeground(Color.white);
		zal.setBackground(new Color(80,100,255));
		zal.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
	    zal.setPreferredSize(new Dimension(120,30));
	    zal.addActionListener(this);
	    kaw5.setBackground(Color.white);
	    kaw5.add(zal);
	
	  
	    anuluj = new JButton("Anuluj");
	    anuluj.setPreferredSize(new Dimension(120,30));
	    anuluj.setForeground(Color.white);
		anuluj.setBackground(new Color(80,100,255));
		anuluj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
	    anuluj.addActionListener(this);
	    kaw5.add(anuluj);
		window.add(kaw5);
		
		allwindow.add(g);
		allwindow.add(window);
		
		add(allwindow);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) 
	{
		new Starter();
	}
	

	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		Object zrodlo = ex.getSource();	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		if(zrodlo == zal && 1 == p.getSelectedIndex())
		{		
			try {
				setVisible(false);
				dispose();
				Jack link = new Jack(login.getText(), haslo.getText());
				
				new MainWindowDoctor(login.getText(), link);		
			} catch (Exception e) {
				new StarterError("");
				e.printStackTrace();
			}
		}
		else if(zrodlo == zal && 0 == p.getSelectedIndex())
		{
			try {
				setVisible(false);
				dispose();
				Jack link = new Jack(login.getText(), haslo.getText());
				new MainWindowReceptionist(login.getText(), link);		
			} catch (Exception e) {
				new StarterError("");
			}
		}
		else if(zrodlo == zal && 2 == p.getSelectedIndex())
		{
			try {
				setVisible(false);
				dispose();
				Jack link = new Jack(login.getText(), haslo.getText());
				new MainWindowPharmacy(login.getText(), link);		
			} catch (Exception e) {
				new StarterError("");
				e.printStackTrace();
			}
		}
		else if(zrodlo == anuluj)
		{
			dispose();
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A	
	}

}
