package vue;

import controleur.Personne;
import controleur.Produit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modele.Modele;
import modele.ModelePersonne;

public class VuePersonne extends JFrame implements ActionListener {
    //Instancation des panels

    private JPanel panelMenu = new JPanel();
    private JPanel panelAjouter = new JPanel();
    private JPanel panelLister = new JPanel();
    private JPanel panelRechercher = new JPanel();
    private JPanel panelSupprimer = new JPanel();

    //Construction des objets du Panel Menu
    private JButton btAjouter = new JButton(new ImageIcon("add_user.png" ));
    private JButton btLister = new JButton("Lister");
    private JButton btRechercher = new JButton("Rechercher");
    private JButton btSupprimer = new JButton("Supprimer");
    private JButton btQuitter = new JButton("Quitter");
    
    //construction des objets du panel Ajouter
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btEnregistrer = new JButton("Enregistrer");
  
    private JTextField tfPrenom = new JTextField();
    private JTextField tfNom = new JTextField();
    private JTextField tfCp = new JTextField();
    private JTextField tfTel = new JTextField();
    private JTextField tfPseudo = new JTextField();
    private JTextField tfMdp = new JTextField();
    private JTextField tfAdresse = new JTextField();
    private JTextField tfEmail = new JTextField();
    //construction des objets panel Lister
    private JLabel lbLister = new JLabel("Liste des personnes");
    private JButton btFermer = new JButton("Fermer");
    private JTable tabPersonne = null;

    //construction des objets du panel Rechercher
    private JLabel lbRechercher = new JLabel("Recherche d'une Personne");
    private JButton btOk = new JButton("Ok");
    private JComboBox cbxPersonne = new JComboBox();
    private JTextArea taResultat = new JTextArea("Résultat : ");
    
    //construction des objets du panel Supprimer
    private JLabel lbSuppr = new JLabel("Suppression d'un personne");
    private JTextField tfSupprimer = new JTextField("");
    private JButton btSuppr = new JButton("Supprimer");
    private JLabel lbSupprimer = new JLabel("Nombre de personne suppriméees : ");
    
    

    public VuePersonne() {
        this.setTitle("Gestion de Personne");
        this.setBounds(150, 150, 1000, 600);
        this.setResizable(false);
        this.setLayout(null);

        //Construiction du panel Menu
        this.panelMenu.setBounds(10, 10, 130, 340);
        this.panelMenu.setBackground(Color.red);
        this.panelMenu.setLayout(new GridLayout(7, 1));
        this.panelMenu.add(new JLabel("Menu Principal"));
        this.panelMenu.add(this.btAjouter);
        this.panelMenu.add(this.btRechercher);
        this.panelMenu.add(this.btSupprimer);
        this.panelMenu.add(this.btLister);
        this.panelMenu.add(this.btQuitter);
        this.btAjouter.setOpaque(false);
        this.btAjouter.setContentAreaFilled(false);
        this.btAjouter.setBorderPainted(false);
        this.panelMenu.add(new JLabel(""));
        this.panelMenu.setVisible(true);
        this.add(this.panelMenu);

        //rendre les boutons cliquables
        this.btAjouter.addActionListener(this);
        this.btLister.addActionListener(this);
        this.btRechercher.addActionListener(this);
        this.btSupprimer.addActionListener(this);
        this.btQuitter.addActionListener(this);
        this.btAnnuler.addActionListener(this);
        this.btEnregistrer.addActionListener(this);
        this.btFermer.addActionListener(this);
        this.btOk.addActionListener(this);
        this.btSuppr.addActionListener(this);

        //Construction du panel ajouter 
        this.panelAjouter.setBounds(140, 10, 350, 340);
        this.panelAjouter.setBackground(Color.cyan);
        this.panelAjouter.setLayout(new GridLayout(7, 2));
       
        this.panelAjouter.add(new JLabel("Prénom : "));
        this.panelAjouter.add(this.tfPrenom);
        this.panelAjouter.add(new JLabel("Pseudo : "));
        this.panelAjouter.add(this.tfPseudo);
        this.panelAjouter.add(new JLabel("Mdp : "));
        this.panelAjouter.add(this.tfMdp);
        this.panelAjouter.add(new JLabel("Nom : "));
        this.panelAjouter.add(this.tfNom);
        this.panelAjouter.add(new JLabel("Cp : "));
        this.panelAjouter.add(this.tfCp);
        this.panelAjouter.add(new JLabel("Adresse : "));
        this.panelAjouter.add(this.tfAdresse);
        this.panelAjouter.add(new JLabel("Email : "));
        this.panelAjouter.add(this.tfEmail);
       
        this.panelAjouter.add(new JLabel("Telephone : "));
        this.panelAjouter.add(this.tfTel);
        this.panelAjouter.add(this.btAnnuler); 

        this.panelAjouter.add(this.btEnregistrer);
      
        this.panelAjouter.add(new JLabel(""));
        this.panelAjouter.add(new JLabel(""));
        this.panelAjouter.setVisible(false);
        this.add(this.panelAjouter);

        //Construction du panel lister
        this.panelLister.setBounds(140, 10, 500, 400);
        this.panelLister.setBackground(Color.yellow);
        this.panelLister.setLayout(null);
        this.lbLister.setBounds(100, 20, 200, 20);
        this.panelLister.add(this.lbLister);
        this.btFermer.setBounds(200, 300, 200, 20);
        this.panelLister.add(this.btFermer);
        this.panelLister.setVisible(false);
        this.add(this.panelLister);

        //Construction du panel rechercher
        this.panelRechercher.setBounds(140, 10, 500, 340);
        this.panelRechercher.setBackground(Color.green);
        this.panelRechercher.setLayout(null);
        this.lbRechercher.setBounds(100, 20, 200, 20);
        this.panelRechercher.add(this.lbRechercher);
        this.cbxPersonne.setBounds(50, 80, 200, 20);
        this.panelRechercher.add(this.cbxPersonne);
        this.btOk.setBounds(260, 80, 80, 20);
        this.panelRechercher.add(this.btOk);
        this.taResultat.setBounds(100, 120, 200, 150);
        this.panelRechercher.add(this.taResultat);
        this.taResultat.setEditable(false);
        this.taResultat.setBackground(Color.GREEN);
        this.panelRechercher.setVisible(false);
        this.add(this.panelRechercher);

        //Construction du panel supprimer 
        this.panelSupprimer.setBounds(140, 10, 500, 340);
        this.panelSupprimer.setBackground(Color.pink);
        this.panelSupprimer.setLayout(null);
        this.lbSuppr.setBounds(100, 20, 200, 20);
        this.panelSupprimer.add(this.lbSuppr);
        this.tfSupprimer.setBounds(50, 80, 200, 20);
        this.panelSupprimer.add(this.tfSupprimer);
        this.btSuppr.setBounds(300, 80, 100, 20);
        this.panelSupprimer.add(this.btSuppr);
        this.lbSupprimer.setBounds(120, 130, 250, 20);
        this.panelSupprimer.add(this.lbSupprimer);
        
        this.panelSupprimer.setVisible(false);
        this.add(this.panelSupprimer);

        this.setVisible(true);

    }

  



    public static String saisirCle() {
        String cle;
        System.out.println("Donner la cle : ");
        cle = Console.saisirString();
        return cle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAjouter) {
            this.panelAjouter.setVisible(true);
            this.panelLister.setVisible(false);
            this.panelRechercher.setVisible(false);
            this.panelSupprimer.setVisible(false);

        } else if (e.getSource() == this.btLister) {

            this.panelAjouter.setVisible(false);
            this.panelLister.setVisible(true);
            this.panelRechercher.setVisible(false);
            this.panelSupprimer.setVisible(false);
            String titres[] = {"Id", "Prenom", "Nom", "Code Postale", "Téléphone", "Pseudo", "Mot de passe", "adresse", "Email", "Avatar"};
            LinkedList<Personne> uneListe = ModelePersonne.selectAll();
            Object donnees[][] = new Object[uneListe.size()][10];
            int i = 0;
            for (Personne UnePersonne : uneListe) {
                donnees[i][0] = UnePersonne.getId();
                donnees[i][1] = UnePersonne.getPrenom();
                donnees[i][2] = UnePersonne.getNom();
                donnees[i][3] = UnePersonne.getCp();
                donnees[i][4] = UnePersonne.getTelephone();
                donnees[i][5] = UnePersonne.getPseudo();
                donnees[i][6] = UnePersonne.getMdp();
                donnees[i][7] = UnePersonne.getAdresse();
                donnees[i][8] = UnePersonne.getEmail();
                donnees[i][9] = UnePersonne.getAvatar();
                
                i++;
            }
            this.tabPersonne = new JTable(donnees, titres);
     
            //ajouter a la table une action Mouslistener 
            this.tabPersonne.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// ici on recupere les donnŽ de la ligne selecter on crŽe le produit on levoie popup
					int a =tabPersonne.getSelectedRow();
					try 
					{
					int id=Integer.parseInt(tabPersonne.getValueAt(a,0).toString());
					String prenom=tabPersonne.getValueAt(a,1).toString();
					String nom=tabPersonne.getValueAt(a,2).toString();
					String cp=tabPersonne.getValueAt(a,3).toString();
					String telephone=tabPersonne.getValueAt(a,4).toString();
					String pseudo=tabPersonne.getValueAt(a,5).toString();
					String mdp=tabPersonne.getValueAt(a,6).toString();
					String adresse=tabPersonne.getValueAt(a,7).toString();
					String email=tabPersonne.getValueAt(a,8).toString();
					String avatar=tabPersonne.getValueAt(a,9).toString();
					
					Personne unePersonne = new Personne(id, prenom, nom, cp, telephone, pseudo, mdp, avatar, adresse, email);
					new VueEdition(unePersonne);
					}
					catch(NumberFormatException exp)
					{
						
					}
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					
				}
			});
            JScrollPane uneScroll = new JScrollPane(this.tabPersonne);
            uneScroll.setBounds(20, 50, 400, 220);
            uneScroll.setVisible(true);
            this.panelLister.add(uneScroll);

        } else if (e.getSource() == this.btRechercher) {

            this.remplirCBX();
            this.panelAjouter.setVisible(false);
            this.panelLister.setVisible(false);
            this.panelRechercher.setVisible(true);
            this.panelSupprimer.setVisible(false);

        } else if (e.getSource() == this.btSupprimer) {

            this.panelAjouter.setVisible(false);
            this.panelLister.setVisible(false);
            this.panelRechercher.setVisible(false);
            this.panelSupprimer.setVisible(true);

        } else if (e.getSource() == this.btAnnuler) {
           
            this.tfPrenom.setText("");
            this.tfNom.setText("");
            this.tfPseudo.setText("");
            this.tfMdp.setText("");
            this.tfAdresse.setText("");
            this.tfEmail.setText("");
            this.tfTel.setText("");
            this.tfCp.setText("");
            
        } else if (e.getSource() == this.btEnregistrer) {
            
            String pseudo = this.tfPseudo.getText();
            String prenom = this.tfPrenom.getText();
            String nom = this.tfNom.getText();
            String email = this.tfEmail.getText();
            String adresse = this.tfAdresse.getText();
            String mdp = this.tfMdp.getText();
            String cp=this.tfCp.getText();
            String tel=this.tfTel.getText();
            int id = 0;
         String avatar="pas d'avatar";
            boolean ok = true;
          
          
            if (ok == true) {
              
                Personne unePersonne = new Personne(id, prenom, nom, cp, tel, pseudo, mdp, avatar, adresse, email);
                ModelePersonne.insertpersonne(unePersonne);
                JOptionPane.showMessageDialog(this, "Personne inséré avec succes");
                this.panelAjouter.setVisible(false);
            }
        } else if (e.getSource() == this.btQuitter) {
            int r = JOptionPane.showConfirmDialog(this, "V v quitter ?", "Demande", JOptionPane.OK_CANCEL_OPTION);
            if (r == 0) {
                this.dispose();
            }
        } else if (e.getSource() == this.btFermer) {
            this.panelLister.setVisible(false);
        } else if (e.getSource() == this.btOk) {
            String chaine = this.cbxPersonne.getSelectedItem().toString();
            String tab[] = new String[10];
            tab = chaine.split("-");
            chaine = "Les clients recherchés"
                    + "\nID : " + tab[0] + "\n"
                    + "Prenom : " + tab[1] + "\n"
                    + "Nom : " + tab[2] + "\n"
                    + "Cp : " + tab[3] + "\n"
                    + "Telephone : " + tab[4] + "\n"
                    + "Pseudo : " + tab[5] + "\n"
                    + "Mdp : " + tab[6] + "\n"
                	+ "Adresse : " + tab[7] + "\n"
                	+ "Email : " + tab[8] + "\n"
                    + "Avatar : " + tab[9] + "\n";
            this.taResultat.setText(chaine);
        }
        else if (e.getSource() == this.btSuppr)
        {
            String cle = this.tfSupprimer.getText();
            int nb = ModelePersonne.deletepersonnes(cle);
            this.lbSupprimer.setText("Nombre de client supprimé : "+nb);
        }
    }

    private void remplirCBX() {
        this.cbxPersonne.removeAllItems(); // vider cbx
        LinkedList<Personne> uneListe = ModelePersonne.selectAll();
        for (Personne unePersonne : uneListe) {
            //inserer client ds cbx
            this.cbxPersonne.addItem(unePersonne.toString());
        }
    }

} // fin de classe
