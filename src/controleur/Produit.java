package controleur;

import org.omg.Messaging.SyncScopeHelper;

public class Produit 
{
   private String reference, designation, categorie;
   private float prix;
   private int qte;
   
   public Produit ()
   {
       this.reference = this.designation = this.categorie="";
       this.prix = 0;
       this.qte = 0;
   }
   
   public Produit (String reference, String designation, String categorie, float prix, int qte)
   {
       this.reference = reference;
       this.designation = designation;
       this.categorie = categorie;
       this.prix = prix;
       this.qte = qte;
   }
  
   
   public String toString()
   {
       return this.reference+" - "+this.designation+" - "+this.prix+" - "+this.qte+" - "+this.categorie;
   }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
   

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
   
}
