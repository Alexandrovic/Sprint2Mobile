/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.entities;

import java.util.Date;

/**
 *
 * @author Belgacem
 */
public class Voyageur {
    
    
    public String  nom ;
    public String prenom ;
    public String email;
    public String password;
    public Date  date_inscrip ;
   
    
  
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate_inscrip() {
        return date_inscrip;
    }

  

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate_inscrip(Date date_inscrip) {
        this.date_inscrip = date_inscrip;
    }
  
    
    
    
    
    
}
