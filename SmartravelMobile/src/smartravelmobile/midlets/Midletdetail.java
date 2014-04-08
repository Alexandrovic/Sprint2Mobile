package smartravelmobile.midlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
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
    int selectedAnn = 2;
    

    Image img;
    Form loadingDialog = new Form("Please Wait");

    Command cmOk = new Command("OK", Command.SCREEN, 0);
    Command cmlocal = new Command("Next", Command.SCREEN, 0);
    Command CmBack = new Command("Back", Command.EXIT, 0);
    HttpConnection hc;
    DataInputStream dis;
    Image bg;
    Image source;

    public void run() {

        try {
            voyageHandler voyhandlr = new voyageHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            hc = (HttpConnection) Connector.open("http://localhost:8080/smartPhp/getXmlAnnonce.php?id="+selectedAnn);
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, voyhandlr);
         
            annonces = voyhandlr.getVoyages();

            if (annonces.length > 0) {
                for (int i = 0; i < annonces.length; i++) {
                    annonce = annonces[i];
                }
            }
            source = Image.createImage("/smartravelmobile/media/logo.jpg");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        disp.setCurrent(new Midletdetail.Draw());
    }

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

    public class Draw extends Canvas {

        int w = getWidth();
        int h = getHeight();
        int x = 0;
        int y = 0;

        protected void paint(Graphics g) {
            g.setColor(153, 204, 225);
            g.fillRect(0, 0, w, h);
            g.setColor(0, 0, 0);
           
            g.drawImage(source, 10, 15, 0);
            
            Font f1 = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD , Font.SIZE_MEDIUM);
            Font f2 = Font.getFont (Font.FACE_PROPORTIONAL, Font.STYLE_BOLD , Font.SIZE_MEDIUM);
            
            g.setColor(20, 30, 40);
            g.setFont(f1);
            g.drawString("Destination : ", 25, 100, Graphics.TOP | Graphics.LEFT);
            g.drawString("jour de depart :", 25, 120, Graphics.TOP | Graphics.LEFT);
            g.drawString("jour de retour :", 25, 140, Graphics.TOP | Graphics.LEFT);
            g.drawString("Moyen de transport : ", 25, 160, Graphics.TOP | Graphics.LEFT);
            g.drawString("Budget: ", 25, 180, Graphics.TOP | Graphics.LEFT);
            g.drawString("nombre de place :", 25, 200, Graphics.TOP | Graphics.LEFT);
            g.drawString("programme :", 25, 220, Graphics.TOP | Graphics.LEFT);

            g.setColor(130, 35, 30);
            g.setFont(f2);
            g.drawString(annonce.getDestination(), 100, 100, Graphics.TOP | Graphics.LEFT);
            g.drawString("2014-03-15",110,120, Graphics.TOP | Graphics.LEFT);
            System.out.println(annonce.getDate_depart()+"azertyu");
            g.drawString("2014-03-20", 110, 140, Graphics.TOP | Graphics.LEFT);
            g.drawString(annonce.getMoyen_transport(), 150, 160, Graphics.TOP | Graphics.LEFT);
            float i = annonce.getBudget();
            float j = annonce.getNb_place();
            g.drawString(Float.toString(i)+" DT", 80, 180, Graphics.TOP | Graphics.LEFT);
            g.drawString(Float.toString(j)+" places",130, 200, Graphics.TOP | Graphics.LEFT);
            g.drawString(annonce.getProgramme(), 100, 220, Graphics.TOP | Graphics.LEFT);

        }

    }

}
