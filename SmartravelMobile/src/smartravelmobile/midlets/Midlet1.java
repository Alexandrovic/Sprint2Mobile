/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartravelmobile.midlets;

import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.microedition.midlet.*;
import smartravelmobile.entities.Voyage;
import smartravelmobile.handlers.voyageHandler;


/**
 * @author pc
 */
public class Midlet1 extends MIDlet implements CommandListener, Runnable {
     Display disp = Display.getDisplay(this);
    Command cmdParse = new Command("Liste Annonces", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    Command cmdinfo = new Command("Details", Command.BACK, 0);
    Voyage[] voyages;
    /// lst :
    List listeannonces = new List("Annonces", List.IMPLICIT);
    Form f = new Form("Acceuil");
    Form form = new Form("Liste Annonces");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
   
    public void startApp() {
         f.append("Passer à la liste des annnonces");
        f.addCommand(cmdParse);
        f.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
        disp.setCurrent(f);
        listeannonces.addCommand(cmdinfo);
        listeannonces.setCommandListener(this);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
        public void commandAction(Command c, Displayable d) {
        if (c == cmdParse) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == cmdinfo) {
            form.append("Informations Voyage: \n");
            form.append(showAnnonce(listeannonces.getSelectedIndex()));
            disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            disp.setCurrent(listeannonces);
        }

    }

    public void run() {
        try {
            // this will handle our XML
            voyageHandler voyagesHandler = new voyageHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/smartPhp/getXmlAnnonce.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, voyagesHandler);
            // display the result
            voyages = voyagesHandler.getVoyages(); //get_personne

            if (voyages.length > 0) {
               int j=1;
                for (int i = 0; i < voyages.length; i++) {
                     listeannonces.append("",null);
                    listeannonces.append(" Annonce N°"+j, null);
                   /// listeservices.append(prestataires[i].getDomaine(), null);
                   listeannonces.append(voyages[i].getDestination(), null);
                   listeannonces.append("Nbr de places "+voyages[i].getNb_place(), null);
                 //  listeannonces.append("Date "+voyages[i], null);
                   j++;
                   
                   
                   
///ici tableau lazem /// lst.append(voyages[i].getDestination(), null);  //getNom()

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(listeannonces);
    }

    private String showAnnonce(int i) {
        String res = "";
       //////
        if (voyages.length > 0) {
            sb.append("Destination");
            sb.append(voyages[i].getDestination());
            sb.append("\n");
            
            
            sb.append("Date_depart");
            sb.append(voyages[i].getDate_depart());
            sb.append("\n");
            
            
            sb.append("Date_retour");
            sb.append(voyages[i].getDate_retour());
            sb.append("\n");
            
            
            sb.append("Itineraire");
            sb.append(voyages[i].getItineraire());
            sb.append("\n");
            
            sb.append("Nb_place");
            sb.append(voyages[i].getNb_place());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    
}
