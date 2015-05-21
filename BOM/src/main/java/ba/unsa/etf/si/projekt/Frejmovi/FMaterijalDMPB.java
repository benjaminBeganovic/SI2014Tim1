package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Validacija.NotEmptyValidator;

import com.toedter.calendar.JDateChooser;

public class FMaterijalDMPB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JDateChooser dateChooser;
	private String akcija;
	private JFrame parentFrame;
	private JButton btnUnesi;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//ovaj try sluzi za postavljanje izgleda aplikacije slicnijeg platformi
				try { 
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
				try {
					FMaterijalDMPB window = new FMaterijalDMPB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFrame(JFrame parentF, String akcijaA, String klasa)
	{
		//mozda neka provjera da li je akcija validna (moze i enumeracija)
		//ali i ne mora :D
		akcija = akcijaA;
		
		
		//kreiranje, modifikovanje, brisanje, pregled
		//po defaultu je sve editabilno
		
		//za brisanje i pregleda ne trebaju biti editabilini!
		if(akcija.equals("Brisanje") || akcija.equals("Pregled"))
		{
			comboBox.setEditable(false);
			comboBox_1.setEditable(false);
			comboBox_2.setEditable(false);
			comboBox_3.setEditable(false);
			textField.setEditable(false);
			textField_1.setEditable(false);
			textField_2.setEditable(false); 
			textField_4.setEditable(false);
		}
		//tekst button-a
		if(akcija.equals("Kreiranje"))
		{
			btnUnesi.setText("Unesi");
		}
		else if(akcija.equals("Modifikovanje"))
		{
			btnUnesi.setText("Modifikuj");
		}
		else if(akcija.equals("Brisanje"))
		{
			btnUnesi.setText("Obriši");
		}
		else if(akcija.equals("Pregled"))
		{
			btnUnesi.setText("Nazad");
		}
			
		String pom = akcija;
		if(akcija.equals("Kreiranje"))
			pom = "Unos";
		panel.setBorder(BorderFactory.createTitledBorder(pom + " materijala/poluproizvoda"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public FMaterijalDMPB() {
		initialize();
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	parentFrame.setEnabled(true);
		    	parentFrame.setVisible(true);
		    	
		    }
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 512, 407);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 482, 349);
		panel.setBorder(BorderFactory.createTitledBorder("Pregled materijala/poluproizvoda"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSerijskiBroj = new JLabel("Serijski broj:");
		lblSerijskiBroj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerijskiBroj.setBounds(112, 46, 74, 16);
		panel.add(lblSerijskiBroj);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaziv.setBounds(130, 75, 56, 16);
		panel.add(lblNaziv);
		
		JLabel lblKoliina = new JLabel("Koli\u010Dina:");
		lblKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoliina.setBounds(130, 104, 56, 16);
		panel.add(lblKoliina);
		
		JLabel lblTip = new JLabel("Tip:");
		lblTip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTip.setBounds(130, 133, 56, 16);
		panel.add(lblTip);
		
		JLabel lblNabavnaCijena = new JLabel("Nabavna cijena:");
		lblNabavnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNabavnaCijena.setBounds(89, 162, 97, 16);
		panel.add(lblNabavnaCijena);
		
		JLabel lblProdajnaCijena = new JLabel("Prodajna cijena:");
		lblProdajnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProdajnaCijena.setBounds(83, 191, 103, 16);
		panel.add(lblProdajnaCijena);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(198, 43, 216, 22);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(198, 72, 216, 22);
		panel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(198, 101, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(326, 101, 88, 22);
		panel.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(198, 130, 116, 22);
		panel.add(comboBox_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 159, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 188, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblKmjedinica = new JLabel("KM/jedinica");
		lblKmjedinica.setBounds(326, 162, 130, 16);
		panel.add(lblKmjedinica);
		
		JLabel lblKmjedinica_1 = new JLabel("KM/jedinica");
		lblKmjedinica_1.setBounds(326, 191, 130, 16);
		panel.add(lblKmjedinica_1);
		
		JLabel lblDatumNabavke = new JLabel("Datum nabavke:");
		lblDatumNabavke.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumNabavke.setBounds(77, 220, 109, 16);
		panel.add(lblDatumNabavke);
		
		JLabel lblGraninaKoliina = new JLabel("Grani\u010Dna koli\u010Dina:");
		lblGraninaKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGraninaKoliina.setBounds(12, 249, 174, 16);
		panel.add(lblGraninaKoliina);
		
		textField_4 = new JTextField();
		textField_4.setBounds(198, 246, 116, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblJedinica = new JLabel("jedinica");
		lblJedinica.setBounds(326, 249, 130, 16);
		panel.add(lblJedinica);
		
		btnUnesi = new JButton("Nazad");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setInputVerifier(new NotEmptyValidator(frame,textField_4,"Morate popuniti ovo polje"));
				textField_1.setInputVerifier(new NotEmptyValidator(frame,textField_1,"BlaBla"));
				//akcija za klik na dugme koje moze imati razlicite f-je
				//brisanje, kreiranje, modifikovanje, pregled
				if(akcija.equals("Kreiranje") || akcija.equals("Modifikovanje"))
				{
					//ovdje treba procitati formu i
					//uraditi validaciju
					//azurirati bazu npr
					//ispisati messageBox ?
					//vratiti se nazad
				}
				if(akcija.equals("Brisanje"))
				{
					//ispisati dialogBox ? (da zelite brisati)
					//azurirati bazu
					//vratiti se nazad
				}
				if(akcija.equals("Pregled"))
				{
					//vratiti se nazad
				}
				
			}
		});
		btnUnesi.setBounds(326, 311, 88, 27);
		panel.add(btnUnesi);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(198, 216, 116, 20);
		panel.add(dateChooser);
		
		JButton btnNewButton = new JButton("Poništi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				comboBox.setSelectedItem("");
				comboBox_1.setSelectedItem("");
				comboBox_2.setSelectedItem("");
				comboBox_3.setSelectedItem("");
				dateChooser.setCalendar(null);
			}
		});
		btnNewButton.setBounds(217, 311, 89, 27);
		panel.add(btnNewButton);
		
		
	}
}
