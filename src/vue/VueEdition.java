package vue;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Modele;
import modele.ModelePersonne;
import controleur.Personne;
import controleur.Produit;
public class VueEdition extends JFrame implements ActionListener {
	
	
	private static Personne unePersonne=null;
	
	private JTextField tfId = new JTextField();
	private JTextField tfPrenom = new JTextField();
	private JTextField tfNom = new JTextField();
	private JTextField tfPseudo = new JTextField();
	private JTextField tfMdp = new JTextField();
	private JTextField tfEmail = new JTextField();
	private JTextField tfAdresse = new JTextField();
	private JTextField tfTelephone = new JTextField();
	private JTextField tfCp = new JTextField();
	private JTextField tfAvatar = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btValider = new JButton("Valider");
	private JPanel unPanel = new JPanel();
	
	public VueEdition(Personne unePersonne)
	{
	// cree votre fenetre et ajouter les tetfiels remplis avec la prod 
		this.setTitle("Edition d'une personne");
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(200,200,300,400);
		this.unPanel.setBounds(0, 0, 300, 400);
		this.unPanel.setBackground(Color.cyan);
		this.unPanel.setLayout(new GridLayout(6,2));
		
		this.unPanel.add(new JLabel("Id"));
		this.unPanel.add(this.tfId);
		this.unPanel.add(new JLabel("Prenom"));
		this.unPanel.add(this.tfPrenom);
		this.unPanel.add(new JLabel("Nom"));
		this.unPanel.add(this.tfNom);
		this.unPanel.add(new JLabel("Pseudo"));
		this.unPanel.add(this.tfPseudo);
		this.unPanel.add(new JLabel("Email"));
		this.unPanel.add(this.tfEmail);
		this.unPanel.add(new JLabel("Adresse"));
		this.unPanel.add(this.tfAdresse);
		this.unPanel.add(new JLabel("TÈlÈphone"));
		this.unPanel.add(this.tfTelephone);
		this.unPanel.add(new JLabel("Code-Postal"));
		this.unPanel.add(this.tfCp);
		this.unPanel.add(new JLabel("Avatar"));
		this.unPanel.add(this.tfAvatar);
		this.unPanel.add(new JLabel("Mot de passe"));
		this.unPanel.add(this.tfMdp);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btValider);
		this.unPanel.setVisible(true);
		
		this.tfId.setText(unePersonne.getId()+"");
		this.tfPrenom.setText(unePersonne.getPrenom());
		this.tfNom.setText(unePersonne.getNom());
		this.tfPseudo.setText(unePersonne.getPseudo());
		this.tfEmail.setText(unePersonne.getEmail());
		this.tfAdresse.setText(unePersonne.getAdresse());
		this.tfTelephone.setText(unePersonne.getTelephone());
		this.tfCp.setText(unePersonne.getCp());
		this.tfAvatar.setText(unePersonne.getAvatar());
		this.tfMdp.setText(unePersonne.getMdp());
	
		
		this.tfId.setEditable(false);
		this.btValider.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.add(this.unPanel);
		VueEdition.unePersonne=unePersonne;
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler)
		{
			this.dispose();
		}
		else if(e.getSource()==this.btValider)
		{
			String prenom =this.tfPrenom.getText();
			String nom =this.tfNom.getText();
			String pseudo =this.tfPseudo.getText();
			String email =this.tfEmail.getText();
			String adresse =this.tfAdresse.getText();
			String telephone =this.tfTelephone.getText();
			String cp =this.tfCp.getText();
			String avatar =this.tfAvatar.getText();
			String mdp =this.tfMdp.getText();
			int id=Integer.parseInt(this.tfId.getText());
			
			
			unePersonne= new Personne(id, prenom, nom, cp, telephone, pseudo, mdp, avatar, adresse, email);
			ModelePersonne.updatePersonne(unePersonne);
			JOptionPane.showMessageDialog(null, "La mise a été effectué");
			this.dispose();
		}
		
	}

}
