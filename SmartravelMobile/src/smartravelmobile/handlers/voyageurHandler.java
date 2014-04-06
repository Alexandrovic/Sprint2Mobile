/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartravelmobile.handlers;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import smartravelmobile.entities.Voyageur;

/**
 *
 * @author Belgacem
 */
public class voyageurHandler extends DefaultHandler {

    private Vector voys;
    
    String idTag = "close";
    String nomTag = "close";
    String prenTag = "close";
    String mailTag = "close";
    String passwordTag = "close";

    public voyageurHandler() {
       

    }

    public Voyageur[] getVoyageur() {
        Voyageur[] vs = new Voyageur[voys.size()];
        voys.copyInto(vs);
        return vs;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Voyageur currentVoy;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voyageur")) {

            if (currentVoy != null) {
                throw new IllegalStateException("already processing a voys");
            }
            currentVoy = new Voyageur();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenTag = "open";
        } else if (qName.equals("e_mail")) {
            mailTag = "open";
        } else if (qName.equals("password")) {
            passwordTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("voyage")) {
            // we are no longer processing a <reg.../> tag
            voys.addElement(currentVoy);
            currentVoy = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")) {
            prenTag = "close";
        } else if (qName.equals("e_mail")) {
            mailTag = "close";
        } else if (qName.equals("password")) {
            passwordTag = "close";
        }
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentVoy != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String ids = new String(ch, start, length).trim();
                int id = Integer.parseInt(ids);
                currentVoy.setId(id);
            } else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentVoy.setNom(nom);
            } else if (prenTag.equals("open")) {
                String prenom = new String(ch, start, length).trim();
                currentVoy.setPrenom(prenom);
            } else if (mailTag.equals("open")) {
                 String mail = new String(ch, start, length).trim();
                 currentVoy.setEmail(mail);
            }else if(passwordTag.equals("open")){
                String pass = new  String(ch, start, length).trim();
                currentVoy.setPassword(pass);
            }
        }
     
    }

}
