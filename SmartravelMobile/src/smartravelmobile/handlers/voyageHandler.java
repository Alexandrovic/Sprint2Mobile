/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.handlers;

import java.util.Date;
import org.xml.sax.helpers.DefaultHandler;
import  org.xml.sax.Attributes;
/**
 *
 * @author Belgacem
 */
public class voyageHandler extends DefaultHandler{
    
    String id_voyageT;
    String moyen_transportT;
    String destinationT;
    String budgetT;
    String nb_placeT;

    String programmeT;
    String itineraireT;
    Date date_departT;
    Date date_retourT;
    String voyage_responsableT;
    String type_voyageT;
    public voyageHandler(){
        
    }
    
    public void startElement(){
    
    }
    
}
