package Lekarz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.ibm.icu.text.SimpleDateFormat;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import logowanie.Jack;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
public class Prescription implements ActionListener
{
	JButton anuluj, gotowe;
	JFrame frame;
	
	//leki
	
	private JTextArea recgora7 = new JTextArea();
	
	private JTextArea recgora10 = new JTextArea();
	
	private JTextArea recgora12 = new JTextArea();
	
	private JTextArea recgora14 = new JTextArea();
	
	private JTextArea recgora16 = new JTextArea();
	
	//odp≥atnoúci
	
	private JTextArea recgora8 = new JTextArea();
	
	private JTextArea recgora11 = new JTextArea();
	
	private JTextArea recgora13 = new JTextArea();
	
	private JTextArea recgora15 = new JTextArea();
	
	private JTextArea recgora17 = new JTextArea();
	
	private JTextArea  recgora20 = new JTextArea();
	
	private Jack link;
	private String ID;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
	Prescription(String ID, Jack link)
	{
		this.link = link;
		this.ID = ID;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		frame = new JFrame();
		frame.setTitle("Recepta");
		frame.setResizable(false);
		frame.setSize(650,850);
////////////////		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);///////////////////////////////////////////////
////////////////		
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2); 
		int y = (int) (45 + (dimension.getHeight() - frame.getHeight()) / 2); 
		frame.setLocation(x, y);
		
		JPanel recepta = new JPanel();
		recepta.setPreferredSize(new Dimension(650,850));
		recepta.setLayout(new GridLayout(11,1));
		recepta.setBackground(new Color(160,190,235));

		Border blackline = BorderFactory.createLineBorder(Color.black);
		recepta.setBorder(blackline);

		JPanel g = new JPanel();
		JPanel gora1 = new JPanel();
		gora1.setBackground(new Color(160,190,235));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
		JTextField recgora1 = new JTextField();
		JTextField recgora3 = new JTextField();
		JTextField recgora4 = new JTextField();
		JTextField recgora5 = new JTextField();
		JTextField recgora6 = new JTextField();
	
		JTextField recgora18 = new JTextField();
		JTextField recgora19 = new JTextField();
		JTextField recgora21 = new JTextField();
		
		recgora1.setEditable(false);
		recgora3.setEditable(false);
		recgora4.setEditable(false);
		recgora5.setEditable(false);
		recgora6.setEditable(false);
		
		recgora18.setEditable(false);
		recgora19.setEditable(false);
		recgora21.setEditable(false);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
		
		JPanel goraa = new JPanel();;
		
		recgora1.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "åwiadczeniodawca:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora1.setPreferredSize(new Dimension(600,100));
		goraa.add(recgora1);
		goraa.setBackground(new Color(160,190,235));
		g.setBackground(new Color(160,190,235));
		g.add(goraa);
		recepta.add(g);
		

		JPanel p1 = new JPanel();
	
		recgora3.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Pacjent:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		
		recgora3.setPreferredSize(new Dimension(485,140));
		p1.setBackground(new Color(160,190,235));
		p1.add(recgora3);
		
		//recgora4.setFocusable(false);
		
		recgora4.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Oddzia≥:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora4.setPreferredSize(new Dimension(110,140));
		p1.add(recgora4);
		p1.setBackground(new Color(160,190,235));
		JPanel gora2 = new JPanel();
		gora2.add(p1);
		gora2.setBackground(new Color(160,190,235));
		
		recepta.add(gora2);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(160,190,235));
		//recgora5.setFocusable(false);
		
		recgora5.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Pesel:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora5.setPreferredSize(new Dimension(485,70));
	    p2.add(recgora5);
	    
	    //recgora6.setFocusable(false);
	  
	    recgora6.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Uprawnienia:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora6.setPreferredSize(new Dimension(110,70));
	    p2.add(recgora6);
	    
	    JPanel p22 = new JPanel();
	    p22.setBackground(new Color(160,190,235));
	    p22.add(p2);
	    recepta.add(p22);    

		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(160,190,235));
		
		recgora7.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Lek 1:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora7.setPreferredSize(new Dimension(485,90));
	    p3.add(recgora7);

		recgora8.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Odp≥atnoúÊ:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora8.setPreferredSize(new Dimension(110,90));
		p3.add(recgora8);
		
		JPanel sr = new JPanel();
		sr.setBackground(new Color(160,190,235));
		sr.add(p3);
		
		recepta.add(sr);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color(160,190,235));
		
		
		recgora10.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Lek 2:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora10.setPreferredSize(new Dimension(485,90));
		p4.add(recgora10);
		
		recgora11.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Odp≥atnoúÊ:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora11.setPreferredSize(new Dimension(110,90));
		p4.add(recgora11);
        
		JPanel sr2 = new JPanel();
		sr2.setBackground(new Color(160,190,235));
		sr2.add(p4);
		
		recepta.add(sr2);
		
		
		JPanel p5 = new JPanel();
		p5.setBackground(new Color(160,190,235));
		
		recgora12.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Lek 3:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora12.setPreferredSize(new Dimension(485,90));
		p5.add(recgora12);
		
		recgora13.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Odp≥atnoúÊ:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora13.setPreferredSize(new Dimension(110,90));
		p5.add(recgora13);
        
		JPanel sr3 = new JPanel();
		sr3.setBackground(new Color(160,190,235));
		sr3.add(p5);
		
		recepta.add(sr3);
		
		JPanel p6 = new JPanel();
		p6.setBackground(new Color(160,190,235));
		
		recgora14.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Lek 4:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora14.setPreferredSize(new Dimension(485,90));
				
		p6.add(recgora14);
		
		recgora15.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Odp≥atnoúÊ:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora15.setPreferredSize(new Dimension(110,90));
		p6.add(recgora15);
        
		JPanel sr4 = new JPanel();
		sr4.setBackground(new Color(160,190,235));
		sr4.add(p6);
		
		recepta.add(sr4);
		
		JPanel p7 = new JPanel();
		p7.setBackground(new Color(160,190,235));
		
		recgora16.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Lek 5:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora16.setPreferredSize(new Dimension(485,90));
		p7.add(recgora16);
		
		recgora17.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Odp≥atnoúÊ:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora17.setPreferredSize(new Dimension(110,90));
		p7.add(recgora17);
        
		JPanel sr5 = new JPanel();
		
		sr5.add(p7);
		sr5.setBackground(new Color(160,190,235));
		recepta.add(sr5);
		
		
		
		JPanel pp = new JPanel();
		
		JPanel doll = new JPanel();
		doll.setBackground(new Color(160,190,235));

		recgora18.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Data wystawienia:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora18.setPreferredSize(new Dimension(370,80));
		pp.add(recgora18);

		recgora19.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Dane i podpis lekarza:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora19.setPreferredSize(new Dimension(225,80));
		pp.add(recgora19);
		pp.setBackground(new Color(160,190,235));
		doll.add(pp);
		recepta.add(doll);
		
		JPanel pp2 = new JPanel();
		JPanel ko2 = new JPanel();
		
		recgora20.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Data realizacji \"od dnia\":", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora20.setPreferredSize(new Dimension(370,80));
	    pp2.add(recgora20);

	    recgora21.setBorder(BorderFactory.createTitledBorder(BorderFactory
		        .createLineBorder(Color.WHITE), "Uprawnienia:", 
		        0, 0, new Font("Comic Sans MS",Font.BOLD,15)));
		recgora21.setPreferredSize(new Dimension(225,80));
	    pp2.add(recgora21);
	    pp2.setBackground(new Color(160,190,235));

	    
	    JPanel guziki = new JPanel();
	    ko2.add(pp2);
	    ko2.setBackground(new Color(160,190,235));
	    recepta.add(ko2); 
	    
		gotowe = new JButton("Zapisz i drukuj");
		gotowe.setForeground(Color.white);
		gotowe.setBackground(new Color(80,100,255));
		gotowe.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		guziki.add(gotowe);
		 
		anuluj = new JButton("Anuluj");
		anuluj.setForeground(Color.white);
		anuluj.setBackground(new Color(80,100,255));
		anuluj.setFont(new Font("Comic Sans MS", Font.BOLD, 17));	
	    guziki.add(anuluj);
	    guziki.setBackground(new Color(160,190,235));    
	    recepta.add(guziki);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V  
	    anuluj.addActionListener(this);
	    gotowe.addActionListener(this);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
	    
	    frame.add(recepta);
		frame.setVisible(true);

		
	}
	
	public static void main(String args[])
	{
		try {
			Prescription n = new Prescription("14", new Jack("test", "12345"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source == anuluj) { 
			frame.dispose();
		}
		else if(source == gotowe) { 
			try {
				generuj();
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			frame.dispose();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////V
	private void generuj() throws DocumentException, IOException {
		
		String[] dane = null;
		
		try {
			dane = link.selectWszystkieDaneWybranegoPacjenta(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
		com.itextpdf.text.Font paragraphica;
		
		String source = getClass().getResource("BlankPage.pdf").toString();
		
        PdfReader reader = new PdfReader(source); 

        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dane[0] + "-r-" + dane[13] + ".pdf")); 

        PdfContentByte over = stamper.getOverContent(1);

        over.beginText();
        over.setFontAndSize(helvetica, 18);   
    	
    	//kody kreskowe
        
        source = "kodRecepty.jpg";
        
    	Image kodRecepty = Image.getInstance(source);
    	kodRecepty.setAbsolutePosition(15, 225);
    	kodRecepty.scaleAbsolute(543, 119);
    	over.addImage(kodRecepty);
    	
    	source = "kodPrzychodni.jpg";
    	
    	Image kodPrzychodni = Image.getInstance(source);
    	kodPrzychodni.setAbsolutePosition(230, 1030);
    	kodPrzychodni.scaleAbsolute(330, 40);
    	over.addImage(kodPrzychodni);

    	source = "kodLekarza.jpg";
    	
    	Image kodLekarza = Image.getInstance(source);
    	kodLekarza.setAbsolutePosition(320, 30);
    	kodLekarza.scaleAbsolute(235, 25);
    	over.addImage(kodLekarza);
    	
        ColumnText danePrzychodni = new ColumnText(over);
        danePrzychodni.setSimpleColumn(new Rectangle(10, 1220, 580, 800));
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 15);
        
        Paragraph nazwaPrzychodni = new Paragraph("NIEPUBLICZNY ZAK£AD OPIEKI ZDROWOTNEJ \"TWOJE ZDROWIE\"", paragraphica);
        Paragraph adresPrzychodni = new Paragraph("UL. POTRKOWSKA 12/2 15-100 £”Dè", paragraphica);
        Paragraph telefonPrzychodni = new Paragraph("TEL. " + "(85) 732-11-11", paragraphica);
        Paragraph REGON = new Paragraph("REGON " + "050600002", paragraphica);
        nazwaPrzychodni.setAlignment(Element.ALIGN_CENTER);
        adresPrzychodni.setAlignment(Element.ALIGN_CENTER);
        telefonPrzychodni.setAlignment(Element.ALIGN_CENTER);
        REGON.setAlignment(Element.ALIGN_CENTER);
        danePrzychodni.addElement(nazwaPrzychodni);
        danePrzychodni.addElement(adresPrzychodni);
        danePrzychodni.addElement(telefonPrzychodni);
        danePrzychodni.addElement(REGON);
        danePrzychodni.go();
       
        ColumnText danePacjenta = new ColumnText(over);
        danePacjenta.setSimpleColumn(new Rectangle(10, 1010, 420, 800));
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 25);
        
        String danes =  dane[1] + " " + dane[2];
        String adress = dane[10] + ", " + dane[6] + " " + dane[7] + ", m " + dane[8];
        
        Paragraph nazwaPacjenta = new Paragraph(danes, paragraphica);
        Paragraph adresPacjenta = new Paragraph(adress, paragraphica);
        danePacjenta.addElement(nazwaPacjenta);
        danePacjenta.addElement(adresPacjenta);
        danePacjenta.go();
        
        String pesels = dane[3];
        
        over.setTextMatrix(80, 839); 
        over.showText(pesels); 
        
    	over.setFontAndSize(helvetica, 35); 
        
        //odp≥atnoúÊ
    	
		int[] ygreki = new int[5];
		
    	int y = 723;
    	for(int i = 0; i < 5; i++) {
            ygreki[i] = y;
            y -= 85;
    	}
    	
        over.setTextMatrix(470, ygreki[0]); 
        over.showText(recgora8.getText());  
        
        over.setTextMatrix(470, ygreki[1]); 
        over.showText(recgora11.getText());  
        
        over.setTextMatrix(470, ygreki[2]); 
        over.showText(recgora13.getText());  
        
        over.setTextMatrix(470, ygreki[3]); 
        over.showText(recgora15.getText());  
        
        over.setTextMatrix(470, ygreki[4]); 
        over.showText(recgora17.getText());  
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 27);
        
        ColumnText lek = new ColumnText(over);
        
        lek.setSimpleColumn(new Rectangle(10, ygreki[0] + 60, 430, ygreki[0] - 40));
        lek.addElement(new Paragraph(recgora7.getText(), paragraphica));
        lek.go();
        
        lek.setSimpleColumn(new Rectangle(10, ygreki[1] + 60, 430, ygreki[1] - 40));
        lek.addElement(new Paragraph(recgora10.getText(), paragraphica));
        lek.go();
        
        lek.setSimpleColumn(new Rectangle(10, ygreki[2] + 60, 430, ygreki[2] - 40));
        lek.addElement(new Paragraph(recgora12.getText(), paragraphica));
        lek.go();
        
        lek.setSimpleColumn(new Rectangle(10, ygreki[3] + 60, 430, ygreki[3] - 40));
        lek.addElement(new Paragraph(recgora14.getText(), paragraphica));
        lek.go();
        
        lek.setSimpleColumn(new Rectangle(10, ygreki[4] + 60, 430, ygreki[4] - 40));
        lek.addElement(new Paragraph(recgora16.getText(), paragraphica));
        lek.go();

        paragraphica = new com.itextpdf.text.Font(helvetica, 25);
        
        ColumnText daneLekarza = new ColumnText(over);
        daneLekarza.setSimpleColumn(new Rectangle(380, 120, 580, 200));
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 25);

    	//data wystawienia
    	over.setTextMatrix(64, 140);
    	over.showText(dane[13]);
    	
    	//data realizacji
    	over.setTextMatrix(64, 35);
    	over.showText(recgora20.getText());
    	
    	//Oddzia≥
    	over.setTextMatrix(470, 950); 
    	over.showText("SS");
    	
    	//Uprawnienia pacjenta
    	over.setTextMatrix(470, 840); 
    	over.showText(dane[11]);
        over.endText();

        stamper.close();

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////A
	
}
