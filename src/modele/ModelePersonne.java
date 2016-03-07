package modele;

import java.util.LinkedList;
import controleur.Personne;
import controleur.Produit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelePersonne {
    
    public static LinkedList<Personne> selectAll ()
    {
        LinkedList<Personne> uneListe = new LinkedList<Personne>();
        BDD uneBDD = new BDD("localhost", "supremcoach", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="Select *from client;";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                int id = unRes.getInt("idpcl");
                String prenom = unRes.getString("prenomp");
                String nom = unRes.getString("nomp");
                String cp = unRes.getString("cp");
                String telephone = unRes.getString("telephone");
                String mdp = unRes.getString("mdp");
                String pseudo = unRes.getString("pseudo");
                String avatar = unRes.getString("avatar");
                String adresse = unRes.getString("adresse");
                String email = unRes.getString("email");
                Personne unePersonne = new Personne(id, prenom, nom, cp, telephone, pseudo, mdp, avatar, adresse, email);
                uneListe.add(unePersonne);
                
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    
    public static void insertpersonne(Personne unePersonne)
    {
        //inserer un personne dans la table personne
        String requete ="insert into client (prenomp, cp, telephone, nomp, mdp, pseudo, email, adresse, etat) values ('"+unePersonne.getPrenom()+"',"+unePersonne.getCp()+","+unePersonne.getTelephone()+",'"+unePersonne.getNom()+"','"+unePersonne.getMdp()+"','"+unePersonne.getPseudo()+"','"+unePersonne.getEmail()+"','"+unePersonne.getAdresse()+"','actif');";
        BDD uneBDD = new BDD("localhost", "supremcoach", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        uneBDD.seDeconnecter();
    }
    
    public static LinkedList<Personne> selectWhere (String cle)
    {
        //select where prenom etc.
        LinkedList<Personne> uneListe = new LinkedList<Personne>();
        BDD uneBDD = new BDD("127.0.0.1", "supremcoach", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="select * from client where id like '%"+cle+"%'"+" or prenom like '%"+cle+"%'"+" or nom like '%"+cle+"%'";  
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                int id = unRes.getInt("id");
                String prenom = unRes.getString("prenom");
                String nom = unRes.getString("nom");
                String cp = unRes.getString("cp");
                String telephone = unRes.getString("telephone");
                String mdp = unRes.getString("mdp");
                String pseudo = unRes.getString("pseudo");
                String avatar = unRes.getString("avatar");
                String adresse = unRes.getString("adresse");
                String email = unRes.getString("email");
                Personne unePersonne = new Personne(id, prenom, nom, cp, telephone, pseudo, mdp, avatar, adresse, email);
                uneListe.add(unePersonne);
                
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    public static int deletepersonnes(String cle)
    {
        int nb = 0;
        if (! cle.equals(""))
        {
        String requete1 = "select count(*) as nb from client where idpcl like '"+cle+"';";
        String requete2 = "delete from client where idpcl like '"+cle+"' ;";
    
        BDD uneBDD = new BDD ("127.0.0.1", "supremcoach", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete1);
            unRes.next();
            nb = unRes.getInt("nb");
            if (nb>0)
            {
            unStat.execute(requete2);  //delete from personne
            }
            unRes.close();
            unStat.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete1 + "\n" +requete2);
        }
        uneBDD.seDeconnecter();
        }
        return nb;
    }
    public static  void updatePersonne(Personne unePersonne)
    {
    	   String requete ="Update client set nomp ='"+unePersonne.getNom()+"',"
    	   		+ "prenomp='"+unePersonne.getPrenom()+"',"
    	   		+ "pseudo='"+unePersonne.getPseudo()+"',"
    	   		+ "adresse='"+unePersonne.getAdresse()+"',"
    	   		+ "email='"+unePersonne.getEmail()+"',"
    	   		+ "avatar='"+unePersonne.getAvatar()+"',"
    	   		+ "telephone='"+unePersonne.getTelephone()+"',"
    	   		+ "cp='"+unePersonne.getCp()+"',"
    	   		+ "mdp='"+unePersonne.getMdp()+"'"
    	   		
    	   		+ " WHERE idpcl='"+unePersonne.getId()+"';";
           BDD uneBDD = new BDD("127.0.0.1", "supremcoach", "root", "");
           uneBDD.chargerPilote();
           uneBDD.seConnecter();
           try {
               Statement unStat = uneBDD.getMaconnexion().createStatement();
               unStat.execute(requete);
               unStat.close();
           }
           catch (SQLException exp)
           {
               System.out.println("Erreur de la requete : "+ requete);
           }
           uneBDD.seDeconnecter();
    }
    
}
