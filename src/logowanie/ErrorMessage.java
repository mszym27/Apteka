package logowanie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ErrorMessage  extends JFrame implements ActionListener {
	
	public ErrorMessage(String message) {
		setTitle("B³¹d");
		setSize(400, 200);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2); 
		setLocation(x, y);
		setResizable(false);

		JPanel allpart = new JPanel();
		allpart.setBackground(new Color(210,220,255));
		allpart.setBorder(new EmptyBorder(50,10,10,10));
		allpart.setLayout(new GridLayout(2, 0, 0 ,30));
		
		JPanel panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		JLabel labRef = new JLabel(message);
		labRef.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		panRef.add(labRef);
		allpart.add(panRef);
		
		panRef = new JPanel();
		panRef.setBackground(new Color(210,220,255));
		
		JButton OK = new JButton("OK");
		OK.addActionListener(this);
		OK.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		OK.setForeground(Color.white);
		OK.setBackground(new Color(80,100,255));
		OK.setContentAreaFilled(false);
		OK.setOpaque(true);
		
		panRef.add(OK);
		allpart.add(panRef);
		
		add(allpart);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();
	}

}

