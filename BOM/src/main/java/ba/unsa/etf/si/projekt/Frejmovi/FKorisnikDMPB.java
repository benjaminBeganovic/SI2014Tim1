package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.Validacija.Validator;
import javax.swing.JPasswordField;

public class FKorisnikDMPB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JPanel panel;
	private JButton btnKreiraj;
	private JFrame parentFrame;
	private String akcija;
	private JFormattedTextField formattedTextField;
	private JButton btnNewButton;
	private JPasswordField passwordField;

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
					FKorisnikDMPB window = new FKorisnikDMPB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//String klasa je sada stavljen samo beze
	//umjesto ovoga treba biti odg. klasa
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
			textField.setEditable(false);
			textField_1.setEditable(false);
			textField_2.setEditable(false);
			textField_4.setEditable(false);
			textField_5.setEditable(false);
			passwordField.setEditable(false);
			comboBox.setEditable(false);
		}
		//tekst button-a
		if(akcija.equals("Kreiranje"))
		{
			btnKreiraj.setText("Kreiraj");
		}
		else if(akcija.equals("Modifikovanje"))
		{
			btnKreiraj.setText("Modifikuj");
		}
		else if(akcija.equals("Brisanje"))
		{
			btnKreiraj.setText("Obriši");
		}
		else if(akcija.equals("Pregled"))
		{
			btnKreiraj.setText("Nazad");
		}
			
			
		panel.setBorder(BorderFactory.createTitledBorder(akcija + " korisnika"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	
	public FKorisnikDMPB() {
		initialize();
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	parentFrame.setEnabled(true);
		    	parentFrame.setVisible(true);
		    	
		    }
		});
		textField.setInputVerifier(new Validator(frame,textField,"Molimo unesite ispravno ime",""));
		textField_1.setInputVerifier(new Validator(frame,textField_1,"Molimo unesite ispravno prezime",""));
		textField_2.setInputVerifier(new Validator(frame,textField_2,"Molimo unesite ispravan JMBG","JMBG"));
		textField_4.setInputVerifier(new Validator(frame,textField_4,"Adresa koju ste unijeli nije ispravna","adresa"));
		textField_5.setInputVerifier(new Validator(frame,textField_5,"Molimo unesite ispravno korisničko ime","korIme"));
		//formattedTextField.setInputVerifier(new Validator(frame,formattedTextField,"Molimo unesite telefon","telefon"));
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 210, 201, 20);
		panel.add(passwordField);
		
		passwordField.setInputVerifier(new Validator(frame,passwordField,"Molimo unesite ispravnu šifu","pass"));
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 455, 401);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 413, 343);
		//panel.setBorder(BorderFactory.createTitledBorder("Pregled korisnika"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(12, 38, 145, 16);
		panel.add(lblIme);
		
		textField = new JTextField();
		textField.setBounds(169, 35, 201, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(12, 67, 145, 16);
		panel.add(lblPrezime);
		
		JLabel lblJmb = new JLabel("JMBG:");
		lblJmb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmb.setBounds(12, 96, 145, 16);
		panel.add(lblJmb);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(12, 125, 145, 16);
		panel.add(lblTelefon);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(12, 183, 145, 16);
		panel.add(lblKorisnikoIme);
		
		JLabel lblifra = new JLabel("\u0160ifra:");
		lblifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifra.setBounds(12, 212, 145, 16);
		panel.add(lblifra);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(12, 154, 145, 16);
		panel.add(lblAdresa);
		
		JLabel lblPozicija = new JLabel("Pozicija:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(12, 241, 145, 16);
		panel.add(lblPozicija);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 64, 201, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 93, 201, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(169, 151, 201, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(169, 180, 201, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(169, 238, 201, 22);
		comboBox.addItem("menadžer");
		comboBox.addItem("radnik");
		panel.add(comboBox);
		
		btnKreiraj = new JButton("Nazad");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Component[] components = panel.getComponents();
				 for (Component component : components) {
					 if(component.getName().contains("textField"))
				((JComponent) component).setInputVerifier(new Validator(frame,component,"Morate popuniti ovo polje"));
				 }*/
				
				//akcija za klik na dugme koje moze imati razlicite f-je
				//brisanje, kreiranje, modifikovanje, pregled
				if(akcija.equals("Kreiranje"))
				{
					//(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password)
					
					if(comboBox.getSelectedItem().toString().equals("menadžer"))
					{
						KompanijaFacade kf = new KompanijaFacade();
						if(kf.dodajMenadzera(textField.getText(), textField_1.getText(), formattedTextField.getText(), textField_4.getText(), textField_2.getText(), comboBox.getSelectedItem().toString(), Ovlasti.kreiranjeIzvjestaja, textField_5.getText(), passwordField.getText(), ""));
							MessageBox.infoBox(frame, "Korisnik je uspješno kreiran", "Info");
					}
					else if(comboBox.getSelectedItem().toString().equals("radnik"))
					{
						KompanijaFacade kf1 = new KompanijaFacade();
						if(kf1.dodajRadnika(textField.getText(), textField_1.getText(), formattedTextField.getText(), textField_4.getText(), textField_2.getText(), comboBox.getSelectedItem().toString(), Ovlasti.pretragaMaterijala, textField_5.getText(), passwordField.getText(), ""));
							MessageBox.infoBox(frame, "Korisnik je uspješno kreiran", "Info");
					}
					
				}
				if(akcija.equals("Modifikovanje"))
				{
					
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
		btnKreiraj.setBounds(291, 282, 79, 22);
		panel.add(btnKreiraj);
		
		MaskFormatter mf1 = new MaskFormatter();
		try{
			mf1 = new MaskFormatter("###-###-###");
		}
		catch( Exception e)
		{
			
		}
		mf1.setPlaceholderCharacter('_');
		formattedTextField = new JFormattedTextField(mf1);
		formattedTextField.setBounds(169, 123, 201, 20);
		panel.add(formattedTextField);
		
		btnNewButton = new JButton("Poništi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				textField_5.setText("");
				passwordField.setText("");
				comboBox.setSelectedItem("");
				formattedTextField.setText("");
				
			}
		});
		btnNewButton.setBounds(192, 282, 79, 22);
		panel.add(btnNewButton);
	}
}
