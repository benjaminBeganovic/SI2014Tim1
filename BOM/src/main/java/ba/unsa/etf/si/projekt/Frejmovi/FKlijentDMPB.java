package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

public class FKlijentDMPB {

	private JFrame frame;
	private JTextField txtFdsfd;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFormattedTextField formattedTextField;
	private String akcija;
	private JButton btnKreiraj;
	private JPanel panel;
	private JFrame parentFrame;
 
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
					FKlijentDMPB window = new FKlijentDMPB();
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
				txtFdsfd.setEditable(false);
				textField_1.setEditable(false);
				textField_3.setEditable(false);
				textField_4.setEditable(false);
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
				
				
			panel.setBorder(BorderFactory.createTitledBorder(akcija + " klijenta"));
			parentFrame = parentF;
			parentFrame.setEnabled(false);
			frame.setVisible(true);
		}

	/**
	 * Create the application.
	 */
	public FKlijentDMPB() {
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
		frame.setBounds(100, 100, 402, 311);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 372, 253);
		panel.setBorder(BorderFactory.createTitledBorder("Brisanje klijenta"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(12, 50, 109, 16);
		panel.add(lblIme);
		
		txtFdsfd = new JTextField();
		txtFdsfd.setBounds(133, 47, 187, 22);
		panel.add(txtFdsfd);
		txtFdsfd.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(12, 79, 109, 16);
		panel.add(lblPrezime);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 76, 187, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(12, 108, 109, 16);
		panel.add(lblTelefon);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(12, 137, 109, 16);
		panel.add(lblAdresa);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(12, 166, 109, 16);
		panel.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(133, 134, 187, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 163, 187, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		btnKreiraj = new JButton("Obriši");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnKreiraj.setBounds(244, 204, 76, 22);
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
		formattedTextField.setBounds(133, 106, 187, 20);
		panel.add(formattedTextField);
		
		JButton btnNewButton = new JButton("Poništi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFdsfd.setText("");
				textField_1.setText("");
				textField_3.setText("");
				formattedTextField.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton.setBounds(155, 204, 80, 22);
		panel.add(btnNewButton);
		
		
	}
}