package vue;

import controleur.Personne;
import controleur.Produit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.LeafElement;

import modele.Modele;
import modele.ModelePersonne;

public class VuePersonne extends JFrame implements ActionListener {
    //Instancation des panels

    private JPanel panelMenu = new JPanel();
    private JPanel panelAjouter = new JPanel();
    private JPanel panelLister = new JPanel();
    private JPanel panelRechercher = new JPanel();
    private JPanel panelSupprimer = new JPanel();
    private JPanel  paneltitre= new JPanel();
    private JPanel  panelfooter= new JPanel();
    //Construction des objets du Panel Menu
    private JButton btAjouter = new JButton(new ImageIcon("add_user.png" ));
    private JButton btLister = new JButton(new ImageIcon("edituser.png" ));
    private JButton btRechercher = new JButton(new ImageIcon("recherche-icon.png" ));
    private JButton btSupprimer = new JButton(new ImageIcon("delete-user.png" ));
    private JButton btQuitter = new JButton(new ImageIcon("croix.png" ));
    
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
    //contruction du pannel titre
    private JLabel lbtitre1 = new JLabel("Gestion des clients");
  //contruction du pannel footer
    private JLabel lbfooter = new JLabel("Supremcoach tous droits réservés  ©2013-2015");
    private JButton btRetour = new JButton(new ImageIcon("Accueil.png" ));
    private JButton btCoachSu = new JButton(new ImageIcon("coooachsuprem.png" ));
    
    
    
    public VuePersonne() {
        this.setTitle("Gestion des Clients");
        this.setBounds(0, 150, 1200, 750);
        this.setResizable(false);
        this.setLayout(null);
      
        Font fonte = new Font("TimesRoman ",Font.BOLD,30);
      
        this.paneltitre.setBounds(0, 0, 1200, 100);
        this.paneltitre.setBackground(new Color(10,125,255));
        this.paneltitre.setLayout(null);
        this.paneltitre.add(this.lbtitre1);
        this.lbtitre1.setFont(fonte);
        this.lbtitre1.setBounds(475, 20, 800, 50);
        this.lbtitre1.setForeground(Color.WHITE);
     
        this.paneltitre.add(this.btRetour);
        this.paneltitre.add(this.btCoachSu);
        this.btCoachSu.setBounds(35, 15, 135, 80);
        this.btCoachSu.setOpaque(false);
        this.btCoachSu.setContentAreaFilled(false);
        this.btCoachSu.setBorderPainted(false);
        this.btRetour.setBounds(1075, 0, 100, 100);
        this.btRetour.setOpaque(false);
        this.btRetour.setContentAreaFilled(false);
        this.btRetour.setBorderPainted(false);
     
        this.add(this.paneltitre);
        this.panelfooter.add(this.lbfooter);
        this.panelfooter.setFont(fonte);
        this.panelfooter.setForeground(Color.WHITE);
        this.panelfooter.setBounds(0, 700, 1200, 50);
        this.panelfooter.setBackground(new Color(10,125,255));


        this.add(this.panelfooter);
        //Construiction du panel Menu
        this.panelMenu.setBounds(0, 100, 210, 650);
        this.panelMenu.setBackground(new Color(10,125,255));
        this.panelMenu.add(this.btAjouter);
        this.panelMenu.add(this.btRechercher);
        this.panelMenu.add(this.btSupprimer);
        this.panelMenu.add(this.btLister);
        this.panelMenu.add(this.btQuitter);
     
        this.btAjouter.setOpaque(false);
        this.btAjouter.setContentAreaFilled(false);
        this.btAjouter.setBorderPainted(false);
        this.btRechercher.setOpaque(false);
        this.btRechercher.setContentAreaFilled(false);
        this.btRechercher.setBorderPainted(false);
        this.btSupprimer.setOpaque(false);
        this.btSupprimer.setContentAreaFilled(false);
        this.btSupprimer.setBorderPainted(false);
        this.btLister.setOpaque(false);
        this.btLister.setContentAreaFilled(false);
        this.btLister.setBorderPainted(false);
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
        this.btRetour.addActionListener(this);
        //Construction du panel ajouter 
        this.panelAjouter.setBounds(210, 100, 1000, 600);
        this.panelAjouter.setBackground(new Color(88,167,255));
        
        
        this.panelAjouter.setLayout(new GridLayout(10, 2));
        this.panelAjouter.add(new JLabel("Ajouter un client"));
        this.panelAjouter.add(new JLabel(""));
        this.panelAjouter.add(new JLabel(" Prenom : "));
        this.panelAjouter.add(this.tfPrenom);
        this.panelAjouter.add(new JLabel(" Pseudo : "));
        this.panelAjouter.add(this.tfPseudo);
        this.panelAjouter.add(new JLabel(" Mdp : "));
        this.panelAjouter.add(this.tfMdp);
        this.panelAjouter.add(new JLabel(" Nom : "));
        this.panelAjouter.add(this.tfNom);
        this.panelAjouter.add(new JLabel(" Cp : "));
        this.panelAjouter.add(this.tfCp);
        this.panelAjouter.add(new JLabel(" Adresse : "));
        this.panelAjouter.add(this.tfAdresse);
        this.panelAjouter.add(new JLabel(" Email : "));
        this.panelAjouter.add(this.tfEmail);
       
        this.panelAjouter.add(new JLabel(" Telephone : "));
        this.panelAjouter.add(this.tfTel);
        this.panelAjouter.add(this.btAnnuler); 

        this.panelAjouter.add(this.btEnregistrer);
      
       
        this.panelAjouter.setVisible(false);
        this.add(this.panelAjouter);

        //Construction du panel lister
        this.panelLister.setBounds(210, 100, 1000, 600);
        this.panelLister.setBackground(new Color(88,167,255));
        this.panelLister.setLayout(null);
        this.lbLister.setBounds(100, 20, 600, 50);
        this.panelLister.add(this.lbLister);
        this.lbLister.setFont(fonte);
        this.btFermer.setBounds(200, 300, 200, 20);
        this.panelLister.add(this.btFermer);
        this.panelLister.setVisible(false);
        this.add(this.panelLister);

        //Construction du panel rechercher
        this.panelRechercher.setBounds(210, 100, 1000, 600);
        this.panelRechercher.setBackground(new Color(88,167,255));
        this.panelRechercher.setLayout(null);
        this.lbRechercher.setBounds(250, 40, 600, 40);
        this.lbRechercher.setFont(fonte);
        this.panelRechercher.add(this.lbRechercher);
        this.cbxPersonne.setBounds(165, 150, 600, 20);
        this.panelRechercher.add(this.cbxPersonne);
        this.btOk.setBounds(765, 150, 80, 20);
        this.panelRechercher.add(this.btOk);
        this.taResultat.setBounds(165, 190, 680, 300);
        this.panelRechercher.add(this.taResultat);
        this.taResultat.setEditable(false);
 
        this.panelRechercher.setVisible(false);
        this.add(this.panelRechercher);

        //Construction du panel supprimer 
        this.panelSupprimer.setBounds(210, 100, 1000, 600);
        this.panelSupprimer.setBackground(new Color(88,167,255));
        this.panelSupprimer.setLayout(null);
        this.lbSuppr.setBounds(300, 40, 600, 40);
        this.lbSuppr.setFont(fonte);
        this.panelSupprimer.add(this.lbSuppr);
        this.tfSupprimer.setBounds(140, 150, 600, 20);
        this.panelSupprimer.add(this.tfSupprimer);
        this.btSuppr.setBounds(740, 150, 120, 20);
        this.panelSupprimer.add(this.btSuppr);
        this.lbSupprimer.setBounds(140, 190, 500, 50);
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
        	boolean ok = true;
            String pseudo = this.tfPseudo.getText();
            String prenom = this.tfPrenom.getText();
            String nom = this.tfNom.getText();
            String email = this.tfEmail.getText();
            String adresse = this.tfAdresse.getText();
            String mdp = this.tfMdp.getText();
            int tel=0;
            int cp=0;
            try{
            	 tel=Integer.parseInt(this.tfTel.getText());
            	
            }
            catch(NumberFormatException exp)
            {
            	   ok = false;
                   JOptionPane.showMessageDialog(this, "Erreur de saisie du Téléphone");
                   this.tfTel.setBackground(Color.red);
            }
          
            try{
           	 cp=Integer.parseInt(this.tfCp.getText());
           }
           catch(NumberFormatException exp)
           {
           	   ok = false;
                  JOptionPane.showMessageDialog(this, "Erreur de saisie du Code-Postal");
                  this.tfCp.setBackground(Color.red);
           }
           
       String tel2=Integer.toString(tel);
       
       if(tel2.length()!=9)
       {
    	   ok = false;
           JOptionPane.showMessageDialog(this, "Erreur du nombre de chiffre du telephone");
           this.tfTel.setBackground(Color.red);
       }
       String cp2=Integer.toString(cp);
       if(cp2.length()>5)
       {
    	   ok = false;
           JOptionPane.showMessageDialog(this, "Erreur du nombre de chiffre du Cp"+cp2.length());
           this.tfCp.setBackground(Color.red);
       }
            int id = 0;
         String avatar="pas d'avatar";
          String mdp2=Personne.getMD5(mdp);
          
          
            if (ok == true) {
              
                Personne unePersonne = new Personne(id, prenom, nom, cp2, tel2, pseudo, mdp2, avatar, adresse, email);
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
        else if (e.getSource() == this.btRetour)
        {
        	new VuePersonne();
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
