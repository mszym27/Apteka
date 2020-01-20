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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import logowanie.Jack;

//import com.itextpdf.text.Font;


public class Referral extends JFrame implements ActionListener
{
	private JButton gotowe, anuluj;
	private JTextField p1, p3, p4, p5, p7, p10;
	private JTextArea p2, p6, p8, p9;
	
	private Jack link;
	private String ID;
	
	Referral(String ID, Jack link)
	{
		this.link = link;
		this.ID = ID;

		
		setTitle("Zaswiadczenie");
		setResizable(false);
		setSize(900,700);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 
		int x = (int) ((dimension.getWidth() - getWidth()) / 2); 
		int y = (int) ((dimension.getHeight() - getHeight()) / 2); 
		setLocation(x, y);
		
		JPanel zaswiadczenie2 = new JPanel();
		JPanel zaswiadczenie = new JPanel();
		
		zaswiadczenie.setBackground(new Color(160,190,235));
		zaswiadczenie2.setBackground(new Color(160,190,235));
		
		zaswiadczenie.setPreferredSize(new Dimension(880,670));
		zaswiadczenie.setLayout(new GridLayout(11,1));
		
		p2 = new JTextArea();
		p6 = new JTextArea();
		p8 = new JTextArea();
		p9 = new JTextArea();


		p1 = new JTextField();
		p3 = new JTextField();
		p4 = new JTextField();
		p5 = new JTextField();
		
		p7 = new JTextField();
		
		p10 = new JTextField();
		
		p1.setEditable(false);
		p2.setEditable(false);
		p3.setEditable(false);
		p4.setEditable(false);
		p5.setEditable(false);
		
		p7.setEditable(false);
		
		p10.setEditable(false);


		
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Miejscowoœæ i data",TitledBorder.RIGHT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,15), 
			 Color.black));
		zaswiadczenie.add(p1);

		
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.white), "ZAŒWIADCZENIE LEKARSKIE",TitledBorder.CENTER,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,18), 
			 Color.black));
		zaswiadczenie.add(p2);
		
		p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Nazwisko i imiê",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p3);
		
		p4.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Data urodzenia",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p4);
		
		p5.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Pesel",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p5);
		
		p6.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Nazwa i nr dowodu to¿samoœci",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p6);
		
		p7.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Zamieszka³y(a)",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p7);
		
		p8.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Rozpoznanie",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p8);
		
		p9.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Cel wydania zaœwiadczenia",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p9);
		
		p10.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Piecz¹tka i podpis lekarza",TitledBorder.RIGHT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zaswiadczenie.add(p10);
		
		JPanel guziki = new JPanel();
		
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
	    

		gotowe.addActionListener(this);
		anuluj.addActionListener(this);

		
	    guziki.setBackground(new Color(160,190,235));    
	    zaswiadczenie.add(guziki);
		
		zaswiadczenie2.add(zaswiadczenie);
		
		add(zaswiadczenie2);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source == gotowe) {
			try {
				generujZaswiadczenie();
				dispose();
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(source == anuluj) {
			
			dispose();
		}
	}
	



	private void generujZaswiadczenie() throws DocumentException, IOException {
		
		String[] dane = null;
		
		try {
			dane = link.selectWszystkieDaneWybranegoPacjenta(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
		com.itextpdf.text.Font paragraphica;
		
		String source = getClass().getResource("Blankiet.pdf").toString();
		
        PdfReader reader = new PdfReader(source); 
        PdfStamper stamper = new PdfStamper(reader, 
        		new FileOutputStream(dane[0] + "-z-" + dane[13] + ".pdf")); 

        PdfContentByte over = stamper.getOverContent(1);
 
        paragraphica = new com.itextpdf.text.Font(helvetica, 20);
        
        ColumnText dataIMiasto = new ColumnText(over);

        dataIMiasto.setSimpleColumn(new Rectangle(875, 550, 575, 500));
        Paragraph text = new Paragraph("£ódŸ " + dane[13], paragraphica);
        text.setAlignment(Element.ALIGN_RIGHT);
        dataIMiasto.addElement(text);
        dataIMiasto.go();
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 22);
        
        ColumnText title = new ColumnText(over);
        title.setSimpleColumn(new Rectangle(675, 450, 225, 500));
        text =  new Paragraph("ZAŒWIADCZENIE LEKARSKIE", paragraphica);
        text.setAlignment(Element.ALIGN_CENTER);
        title.addElement(text);
        title.go();
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 20);
        
        String danes =  dane[1] + " " + dane[2];
        
        ColumnText imieINazwisko = new ColumnText(over);
        imieINazwisko.setSimpleColumn(new Rectangle(50, 450, 500, 400));//(675, 450, 225, 400));
        text =  new Paragraph("Imiê i nazwisko:  " + danes, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        imieINazwisko.addElement(text);
        imieINazwisko.go();
        
        String datas = dane[4];

        ColumnText dataUrodzenia = new ColumnText(over);
        dataUrodzenia.setSimpleColumn(new Rectangle(50, 350, 400, 400));//(675, 450, 225, 400));
        text =  new Paragraph("Data urodzenia: " + datas, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        dataUrodzenia.addElement(text);
        dataUrodzenia.go();
        
        String pesels = dane[3];

        ColumnText PESEL = new ColumnText(over);
        PESEL.setSimpleColumn(new Rectangle(400, 350, 600, 400));//(675, 450, 225, 400));
        text =  new Paragraph("PESEL: " + pesels, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        PESEL.addElement(text);
        PESEL.go();
        
        String input = p6.getText();

        ColumnText nazwaINumer = new ColumnText(over);
        nazwaINumer.setSimpleColumn(new Rectangle(50, 350, 900, 300));//(675, 450, 225, 400));
        text =  new Paragraph("Nazwa i numer dowodu to¿samoœci: " + input, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        nazwaINumer.addElement(text);
        nazwaINumer.go();

        String adress = dane[10] + ", " + dane[6] + " " + dane[7] + ", m " + dane[8];

        ColumnText adres = new ColumnText(over);
        adres.setSimpleColumn(new Rectangle(50, 250, 900, 300));//(675, 450, 225, 400));
        text =  new Paragraph("Zamieszka³y(a): " + adress, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        adres.addElement(text);
        adres.go();
        
        paragraphica = new com.itextpdf.text.Font(helvetica, 28);
        
        String rozpoznanies = p8.getText();
        
        ColumnText rozpoznanie = new ColumnText(over);
        rozpoznanie.setSimpleColumn(new Rectangle(50, 250, 900, 150));//(675, 450, 225, 400));
        text =  new Paragraph("Rozpoznanie: " + rozpoznanies, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        rozpoznanie.addElement(text);
        rozpoznanie.go();
        
        String cels = p9.getText();
        
        ColumnText celWydania = new ColumnText(over);
        celWydania.setSimpleColumn(new Rectangle(50, 150, 900, 50));//(675, 450, 225, 400));
        text =  new Paragraph("Cel wydania: " + cels, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        celWydania.addElement(text);
        celWydania.go();

        stamper.close();
        
	}


}