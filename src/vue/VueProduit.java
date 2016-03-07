package vue;

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

public class VueProduit extends JFrame implements ActionListener {
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
    private JButton btSupprimer = new JButton(new ImageIcon("delete.png" ));
    private JButton btQuitter = new JButton("Quitter");

    //construction des objets du panel Ajouter
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btEnregistrer = new JButton("Enregistrer");
    private JTextField tfReference = new JTextField();
    private JTextField tfDesignation = new JTextField();
    private JTextField tfPrix = new JTextField();
    private JTextField tfQte = new JTextField();
    private JTextField tfCategorie = new JTextField();

    //construction des objets panel Lister
    private JLabel lbLister = new JLabel("Liste des produits");
    private JButton btFermer = new JButton("Fermer");
    private JTable tabProduit = null;

    //construction des objets du panel Rechercher
    private JLabel lbRechercher = new JLabel("Recherche d'un Produit");
    private JButton btOk = new JButton("Ok");
    private JComboBox cbxProduit = new JComboBox();
    private JTextArea taResultat = new JTextArea("Résultat : ");
    
    //construction des objets du panel Supprimer
    private JLabel lbSuppr = new JLabel("Suppression des produits");
    private JTextField tfSupprimer = new JTextField("");
    private JButton btSuppr = new JButton("Supprimer");
    private JLabel lbSupprimer = new JLabel("Nombre de produits supprimés : ");
    
    

    public VueProduit() {
        this.setTitle("Gestion de stock");
        this.setBounds(200, 200, 600, 400);
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
        this.panelAjouter.add(new JLabel("Référence : "));
        this.panelAjouter.add(this.tfReference);
        this.panelAjouter.add(new JLabel("Désignation : "));
        this.panelAjouter.add(this.tfDesignation);
        this.panelAjouter.add(new JLabel("Prix : "));
        this.panelAjouter.add(this.tfPrix);
        this.panelAjouter.add(new JLabel("Quantité : "));
        this.panelAjouter.add(this.tfQte);
        this.panelAjouter.add(new JLabel("Catégorie : "));
        this.panelAjouter.add(this.tfCategorie);
        this.panelAjouter.add(this.btAnnuler);
        this.panelAjouter.add(this.btEnregistrer);
        this.panelAjouter.add(new JLabel(""));
        this.panelAjouter.add(new JLabel(""));
        this.panelAjouter.setVisible(false);
        this.add(this.panelAjouter);

        //Construction du panel lister
        this.panelLister.setBounds(140, 10, 500, 340);
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
        this.cbxProduit.setBounds(50, 80, 200, 20);
        this.panelRechercher.add(this.cbxProduit);
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

    public static void afficherProduits(String chaine) {
        System.out.println("Les produitsde la bdd");
        System.out.println(chaine);
    }

    public static Produit saisirProduit() {
        Produit unProd = new Produit();
        System.out.println("Donner la reference : ");
        unProd.setReference(Console.saisirString());

        System.out.println("Donner la designation : ");
        unProd.setDesignation(Console.saisirString());

        System.out.println("Donner la categorie : ");
        unProd.setCategorie(Console.saisirString());

        System.out.println("Donner le prix : ");
        unProd.setPrix(Console.saisirFloat());

        System.out.println("Donner la quantité : ");
        unProd.setQte(Console.saisirInt());
        return unProd;
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
            String titres[] = {"Référence", "Désignation", "Categorie", "Prix", "Qte"};
            LinkedList<Produit> uneListe = Modele.selectAll();
            Object donnees[][] = new Object[uneListe.size()][5];
            int i = 0;
            for (Produit unProd : uneListe) {
                donnees[i][0] = unProd.getReference();
                donnees[i][1] = unProd.getDesignation();
                donnees[i][2] = unProd.getCategorie();
                donnees[i][3] = unProd.getPrix();
                donnees[i][4] = unProd.getQte();
                i++;
            }
            this.tabProduit = new JTable(donnees, titres);
            //ajouter a la table une action Mouslistener 
            this.tabProduit.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// ici on recupere les donn� de la ligne selecter on cr�e le produit on levoie popup
					int a =tabProduit.getSelectedRow();
					String reference=tabProduit.getValueAt(a,0).toString();
					String designation=tabProduit.getValueAt(a,1).toString();
					Float prix=Float.parseFloat(tabProduit.getValueAt(a,3).toString());
					int qte=Integer.parseInt(tabProduit.getValueAt(a,4).toString());
					String categorie = tabProduit.getValueAt(a,2).toString();
					Produit unProd= new Produit(reference, designation, categorie, prix, qte);
					//new VueEdition(unProd);
					
					
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
            JScrollPane uneScroll = new JScrollPane(this.tabProduit);
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
            this.tfReference.setText("");
            this.tfDesignation.setText("");
            this.tfPrix.setText("");
            this.tfQte.setText("");
            this.tfCategorie.setText("");

        } else if (e.getSource() == this.btEnregistrer) {
            
            String reference = this.tfReference.getText();
            String designation = this.tfDesignation.getText();
            float prix = 0;
            int qte = 0;
            boolean ok = true;
            try {
                prix = Float.parseFloat(this.tfPrix.getText());
            } catch (NumberFormatException exp) {
                ok = false;
                JOptionPane.showMessageDialog(this, "Erreur de saisie du prix ou de qte");
                this.tfPrix.setBackground(Color.red);
            }
            try {
                qte = Integer.parseInt(this.tfQte.getText());
            } catch (NumberFormatException exp) {
                ok = false;
                JOptionPane.showMessageDialog(this, "Erreur de saisie du prix ou la qte");
                this.tfQte.setBackground(Color.red);
            }
            if (ok == true) {
                String categorie = this.tfCategorie.getText();
                Produit unProd = new Produit(reference, designation, categorie, prix, qte);
                modele.Modele.insertProduit(unProd);
                JOptionPane.showMessageDialog(this, "Produit inséré avec succes");
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
            String chaine = this.cbxProduit.getSelectedItem().toString();
            String tab[] = new String[5];
            tab = chaine.split("-");
            chaine = "Le produit recherché"
                    + "\nRéférence : " + tab[0] + "\n"
                    + "Désignation : " + tab[1] + "\n"
                    + "Prix : " + tab[2] + "\n"
                    + "Quantité : " + tab[3] + "\n"
                    + "Catégorie : " + tab[4] + "\n";
            this.taResultat.setText(chaine);
        }
        else if (e.getSource() == this.btSuppr)
        {
        	   String cle = this.tfSupprimer.getText();
        	if(cle.equals(""))
        	{
        		JOptionPane.showMessageDialog(this, "Remplir le champs suprrim�", "Remplir le champs suprrim�", JOptionPane.OK_CANCEL_OPTION);
        	}
        	else{
         
            int nb = Modele.deleteProduits(cle);
            this.lbSupprimer.setText("Nombre de produits supprimés : "+nb);
        	}
        }
    }

    private void remplirCBX() {
        this.cbxProduit.removeAllItems(); // vider cbx
        LinkedList<Produit> uneListe = Modele.selectAll();
        for (Produit unProd : uneListe) {
            //inserer produit ds cbx
            this.cbxProduit.addItem(unProd.toString());
        }
    }

} // fin de classe
