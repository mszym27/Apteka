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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.ibm.icu.text.SimpleDateFormat;
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


public class Recomendations implements ActionListener
{
	JFrame frame = new JFrame();
	
	JButton gotowe, anuluj;
	
	JTextArea p1 = new JTextArea();
	JTextArea p3 = new JTextArea();
	JTextArea p4 = new JTextArea();
	JTextArea p5 = new JTextArea();
	JTextArea p6 = new JTextArea();
	
	private Jack link;
	private String ID;

	

	Recomendations(String ID, Jack link)
	{
		this.link = link;
		this.ID = ID;

		frame.setTitle("Zalecenia");
		frame.setResizable(false);
		frame.setSize(900,650);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2); 
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2); 
		frame.setLocation(x, y);
		
		JPanel zalecenia2 = new JPanel();
		JPanel zalecenia = new JPanel();
		
		zalecenia.setBackground(new Color(160,190,235));
		zalecenia2.setBackground(new Color(160,190,235));
		
		zalecenia.setPreferredSize(new Dimension(860,650));
		zalecenia.setLayout(new GridLayout(7,1));

		
		JTextField p7 = new JTextField();
		JTextField p8 = new JTextField();
		
		p7.setEditable(false);
		p8.setEditable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)//////////////
		
		
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Zalecenia pokonsultacyjne",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zalecenia.add(p1);
		
		
		p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Wyniki przeprowadzonych badañ dodatkowych",
			 TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zalecenia.add(p3);
		
		p4.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Rozpoznanie",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zalecenia.add(p4);
		
		p5.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Proponowane badania i leczenie",
			 TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zalecenia.add(p5);
		
		p6.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Inne zalecenia",TitledBorder.LEFT,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		zalecenia.add(p6);
		
		JPanel pp = new JPanel();
		pp.setLayout(new GridLayout(1,2));
		
		p7.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Data",TitledBorder.CENTER,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		pp.add(p7);
		
		p8.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createMatteBorder(1, 1,
			 1, 1, Color.BLACK), "Podpis lekarza konsultuj¹cego",
			 TitledBorder.CENTER,
			 TitledBorder.TOP,new Font("Comic Sans MS",Font.BOLD,16), 
			 Color.black));
		pp.add(p8);
		
		zalecenia.add(pp);
		
		
		
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
	    guziki.setBackground(new Color(160,190,235));    
	    

		gotowe.addActionListener(this);
		anuluj.addActionListener(this);

	    
	    zalecenia.add(guziki);
		
	    zalecenia2.add(zalecenia);
		
		frame.add(zalecenia);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws SQLException 
	{
		new Recomendations("14", new Jack("test", "12345"));
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source == gotowe) {
			try {
				generuj();
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.dispose();
		}
		if(source == anuluj) {
			
			frame.dispose();
		}
	}

	

	private void generuj() throws DocumentException, IOException {
		
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
        		new FileOutputStream(dane[0] + "-s-" + dane[13] + ".pdf")); 

        PdfContentByte over = stamper.getOverContent(1);
 
        paragraphica = new com.itextpdf.text.Font(helvetica, 28);
        
        Paragraph text;

        String zalecenias = p1.getText();
        
        ColumnText zaleceniaPokonsultacyjne = new ColumnText(over);
        zaleceniaPokonsultacyjne.setSimpleColumn(new Rectangle(50, 550, 900, 500));//(675, 450, 225, 400));
        text =  new Paragraph("Zalecenia pokonsultacyjne: " + zalecenias, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        zaleceniaPokonsultacyjne.addElement(text);
        zaleceniaPokonsultacyjne.go();
        
        String wynikis = p3.getText();
        
        ColumnText dataUrodzenia = new ColumnText(over);
        dataUrodzenia.setSimpleColumn(new Rectangle(50, 500, 900, 350));
        text =  new Paragraph("Wyniki przeprowadzonych badañ dodatkowych: " + wynikis, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        dataUrodzenia.addElement(text);
        dataUrodzenia.go();
        
        String rozpoznanies = p4.getText();
        
        ColumnText rozpoznanie = new ColumnText(over);
        rozpoznanie.setSimpleColumn(new Rectangle(50, 350, 900, 250));
        text =  new Paragraph("Rozpoznanie: " + rozpoznanies, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        rozpoznanie.addElement(text);
        rozpoznanie.go();
        
        String proponowanes = p5.getText();
        
        ColumnText proponowaneBadania = new ColumnText(over);
        proponowaneBadania.setSimpleColumn(new Rectangle(50, 250, 900, 150));
        text =  new Paragraph("Proponowane badania i leczenie: " + proponowanes, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        proponowaneBadania.addElement(text);
        proponowaneBadania.go();
        
        String innes = p6.getText();
        
        ColumnText inne = new ColumnText(over);
        inne.setSimpleColumn(new Rectangle(50, 150, 900, 100));
        text =  new Paragraph("Inne zalecenia: " + innes, paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        inne.addElement(text);
        inne.go();
        
        ColumnText data = new ColumnText(over);
        data.setSimpleColumn(new Rectangle(50, 100, 400, 50));
        text = new Paragraph(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), paragraphica);
        text.setAlignment(Element.ALIGN_LEFT);
        data.addElement(text);
        data.go();
        
        ColumnText podpis = new ColumnText(over);
        podpis.setSimpleColumn(new Rectangle(400, 120, 800, 70));
        text = new Paragraph("Podpis", paragraphica);
        text.setAlignment(Element.ALIGN_RIGHT);
        podpis.addElement(text);
        podpis.go();
        
        stamper.close();
	}

}
