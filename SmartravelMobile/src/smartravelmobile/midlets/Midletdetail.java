package smartravelmobile.midlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataInputStream;
import java.util.Date;
import java.util.TimeZone;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import smartravelmobile.entities.Voyage;
import smartravelmobile.handlers.voyageHandler;

/**
 * @author Belgacem
 */
public class Midletdetail extends MIDlet implements CommandListener, Runnable {

    Voyage[] annonces;
    Voyage annonce;
    Display disp = Display.getDisplay(this);
    Form f = new Form("detail de notre annonce");
    int selectedAnn = 1;
    DateField df = new DateField("date de sortie :", DateField.TIME, TimeZone.getTimeZone("GMT+1"));
    StringItem stdest = new StringItem("notre Destination sera : ", "");
    StringItem stplaces = new StringItem("nous proposons ","");
    StringItem stmoy = new StringItem("le moyen de transport sera: ","");
    StringItem stprog = new StringItem("le programme sera de: ", "");
    StringItem stagence = new StringItem("l'agence" + " vous invite à reserver une place ou plus", "");

    Image img;
    Form loadingDialog = new Form("Please Wait");
  
    Command cmOk = new Command("OK", Command.SCREEN, 0);
    Command cmlocal = new Command("Next", Command.SCREEN, 0);
    Command CmBack = new Command("Back", Command.EXIT, 0);
    HttpConnection hc;
    DataInputStream dis;
    public void startApp() {
          disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
  
          
    }

    public void pauseApp() {

    }

    public void destroyApp(boolean unconditional) {

    }

    public void commandAction(Command c, Displayable d) {

    }

    public void run() {
        try {
            voyageHandler voyhandlr = new voyageHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

            hc = (HttpConnection) Connector.open("http://localhost:8080/smartPhp/getXmlAnnonce.php?id="+selectedAnn);
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, voyhandlr);
            System.out.println("xxxxxxCCCCXXX");
            annonces = voyhandlr.getVoyages();

            if (annonces.length > 0) {
                for (int i = 0; i < annonces.length; i++) {
                    annonce = annonces[i];
                    System.out.println("xxxxxxx" + annonces.length);
                }
            }
             stdest.setText(annonce.getDestination());
             System.out.println(annonce.getDestination()+"aaabbcc") ;
             stmoy.setText(annonce.getMoyen_transport());
           
             int nb = annonce.getNb_place();
              
          //   stplaces.setText();
            
             stprog.setText(annonce.getProgramme());
             stagence.setText("agence 1 ");
            
            df.setLabel(null);
            Image source ;
            
            source = Image.createImage("/smartravelmobile/media/logo.jpg");

            f.append(source);
//          f.append(df);
            f.append(stdest);
//          f.append(stplaces);
            f.append(stmoy);
            f.append(stprog);
            f.append(stagence);
            f.addCommand(cmOk);
            f.addCommand(cmlocal);
            f.addCommand(CmBack);

            f.setCommandListener(this);
            System.out.println(annonce.getDestination() + "zzzzzzzzzzz");
            
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     disp.setCurrent(f);
    }
}
