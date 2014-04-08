/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartravelmobile.entities;

/**
 *
 * @author wassou
 */
public class voyageur {
    
    private String id;
    private String nom;
    private String prenom;

    private String email;
    private int password;
    private String date_inscription;
    
    public voyageur()
    {}
  
    
    public String getId()
    {return id;}
    
    public String getNom()
    {return nom;}
    
    public String getPrenom()
    {return prenom;}
    
   
    
    public String getEmail()
    {return email;}
    
    public int getPassword()
    {return password;}
    
    public String getDate_inscription()
    {return date_inscription;}
    
    public void setId(String Id)
    {this.id=Id;}
    
    public void setNom(String nom)
    {this.nom=nom;}
    
    public void setPrenom(String prenom)
    {this.prenom=prenom;}
    
     
    public void setEmail(String email)
    {this.email=email;}
    
    public void setPassword(int Password)
    {this.password=password;}
    
    public void setDate_incription(String Date_inscription)
    {this.date_inscription=date_inscription;}
}
