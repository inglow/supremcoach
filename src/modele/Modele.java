package modele;

import java.util.LinkedList;
import controleur.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {
    
    public static LinkedList<Produit> selectAll ()
    {
        LinkedList<Produit> uneListe = new LinkedList<Produit>();
        BDD uneBDD = new BDD("127.0.0.1", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="Select * from produit;";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                String reference = unRes.getString("reference");
                String designation = unRes.getString("designation");
                String categorie = unRes.getString("categorie");
                float prix = unRes.getFloat("prix");
                int qte = unRes.getInt("qte");
                Produit unProd = new Produit (reference, designation, categorie, prix, qte);
                uneListe.add(unProd);
                
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
    
    public static void insertProduit(Produit unProd)
    {
        //inserer un produit dans la table produit
        String requete ="insert into produit(reference, designation," + "prix, qte, categorie) values ('"+unProd.getReference()+"','"+unProd.getDesignation()+"',"+unProd.getPrix()+","+unProd.getQte()+",'"+unProd.getCategorie()+"');";
        BDD uneBDD = new BDD("127.0.0.1", "stock", "root", "");
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
    
    public static LinkedList<Produit> selectWhere (String cle)
    {
        //select where designation etc.
        LinkedList<Produit> uneListe = new LinkedList<Produit>();
        BDD uneBDD = new BDD("127.0.0.1", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="select * from produit where reference like '%"+cle+"%'"+" or designation like '%"+cle+"%'"+" or categorie like '%"+cle+"%'";  
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                String reference = unRes.getString("reference");
                String designation = unRes.getString("designation");
                String categorie = unRes.getString("categorie");
                float prix = unRes.getFloat("prix");
                int qte = unRes.getInt("qte");
                Produit unProd = new Produit (reference, designation, categorie, prix, qte);
                uneListe.add(unProd);
                
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
    public static int deleteProduits(String cle)
    {
        int nb = 0;
        if (! cle.equals(""))
        {
        String requete1 = "select count(*) as nb from produit where reference like '%"+cle+"%'" +" or designation like '%"+cle+"%'"+" or categorie like '%"+cle+"%' ; ";
        String requete2 = "delete from produit where reference like '%"+cle+"%'"+" or designation like '%"+cle+"%'"+" or categorie like '%"+cle+"%' ;";
    
        BDD uneBDD = new BDD ("127.0.0.1", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete1);
            unRes.next();
            nb = unRes.getInt("nb");
            if (nb>0)
            {
            unStat.execute(requete2);  //delete from produit
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
    public static  void updateProduit(Produit unProd)
    {
    	   String requete ="Update produit set designation ='"+unProd.getDesignation()+"',"
    	   		+ "prix='"+unProd.getPrix()+"',"
    	   		+ "qte='"+unProd.getQte()+"',"
    	   		+ "categorie='"+unProd.getCategorie()+"'"
    	   		
    	   		+ " WHERE reference='"+unProd.getReference()+"';";
           BDD uneBDD = new BDD("127.0.0.1", "stock", "root", "");
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
