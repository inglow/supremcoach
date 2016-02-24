package controleur;


public class Personne 
{
   private String prenom, nom, pseudo, mdp, avatar, adresse, email;
   private String cp;
   private int id;
   private String telephone;
   
   public Personne ()
   {
       this.pseudo = this.prenom = this.nom= this.mdp = this.avatar = this.adresse = this.email = "";
       this.cp = ""; this.id= 0;
       this.telephone = "";
   }
   
   public Personne (int id, String prenom, String nom, String cp, String telephone, String pseudo, String mdp, String avatar, String adresse, String email)
   {
       this.id = id;
       this.prenom = prenom;
       this.nom = nom;
       this.cp = cp;
       this.telephone = telephone;
       this.pseudo = pseudo;
       this.mdp = mdp;
       this.avatar = avatar;
       this.adresse = adresse;
       this.email = email;
   }
  
   
   public String toString()
   {
       return this.id+" - "+this.prenom+" - "+this.nom+" - "+this.cp+" - "+this.telephone+" - "+this.pseudo+" - "+this.mdp+" - "+this.avatar+" - "+this.adresse+" - "+this.email;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String Mdp) {
        this.mdp = mdp;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
} // fin classe
