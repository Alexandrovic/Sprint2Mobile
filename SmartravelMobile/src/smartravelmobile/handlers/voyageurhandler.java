/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartravelmobile.handlers;

import smartravelmobile.entities.voyageur;
import gov.nist.core.ParseException;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author wassou
 */
public class voyageurhandler extends DefaultHandler{
      private Vector voyageurs;
    String idTag = "close";
    String nomTag="close";
    String prenomTag="close";
    String emailTag = "close";
    String passwordTag = "close";
    String date_inscriptionTag="close";

    public voyageurhandler() {
        voyageurs = new Vector();
    }

    public voyageur[] getvoyageur() {
        voyageur[] voyageurss = new voyageur[voyageurs.size()];
        voyageurs.copyInto(voyageurss);
        return voyageurss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private voyageur currentVoyageur;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voyageur")) {

            if (currentVoyageur != null) {
                throw new IllegalStateException("already processing a voyageur");
            }
            currentVoyageur = new voyageur();
        } else if (qName.equals("id_voyageur")) {
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenomTag = "open";
        }else if (qName.equals("e_mail")) {
            emailTag = "open";
        }
        else if (qName.equals("password")) {
            passwordTag = "open";
        }
        else if (qName.equals("date_inscription")) {
            date_inscriptionTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("voyageur")) {
            // we are no longer processing a <reg.../> tag
            voyageurs.addElement(currentVoyageur);
            currentVoyageur = null;
        } else if (qName.equals("id_voyageur")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")) {
            prenomTag = "close";
        }else if (qName.equals("e_mail")) {
            emailTag = "close";
        }
        else if (qName.equals("password")) {
            passwordTag = "close";
        }
        else if (qName.equals("date_inscription")) {
            date_inscriptionTag = "close";
        }
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentVoyageur != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentVoyageur.setId(id);
            } else
                if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentVoyageur.setNom(nom);
            } else
                    if (prenomTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentVoyageur.setPrenom(desc);
            } else
                    if (emailTag.equals("open")) {
                String email = new String(ch, start, length).trim();
                currentVoyageur.setEmail(email);
            }
            else
                    if (passwordTag.equals("open")) {
                String password = new String(ch, start, length).trim();
                currentVoyageur.setPassword(Integer.parseInt(password));
            }
            else
                    if (date_inscriptionTag.equals("open")) {
                String date_inscription = new String(ch, start, length).trim();
                currentVoyageur.setEmail(date_inscription);
            }
        }
    }
}
