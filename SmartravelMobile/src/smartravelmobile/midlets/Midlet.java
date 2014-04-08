/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import smartravelmobile.handlers.voyageurhandler;
import smartravelmobile.entities.voyageur;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.GUIControl;
import javax.microedition.media.control.VideoControl;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Belgacem
 */
public class Midlet extends MIDlet implements CommandListener, Runnable {

    Form f1 = new Form("Voyage à la carte");//pour l'authentification
    Form f2 = new Form("Page d'accueil");//pour la page d'accuiel

    Player player = null;//pour la page d'accueil

    Ticker t1 = new Ticker("Connexion");//pour l'authentification
    Ticker t2 = new Ticker("welcom To Smart travel");//pour la page d'accueil

    StringItem nom_voyageur = new StringItem("welcom Mr", null);

    TextField login = new TextField("email", null, 50, TextField.ANY);//pour l'authentification
    TextField password = new TextField("password", null, 50, TextField.ANY);//pour l'authentification

   

    Command cmdconnect = new Command("Entrer", Command.SCREEN, 0);//pour l'authentification

    private boolean error = false;
    private Alert alert = new Alert("Error");

    Display disp = Display.getDisplay(this);
    voyageur[] voy;
  
        
        
        
    public void startApp() {
        try {
            Image im ;
            im = Image.createImage("/smartravelmobile/media/accueil.jpg");
            
            
            f1.append(im);//pour l'authentification
            f1.setTicker(t1);//pour l'authentification
            f1.append(login);//pour l'authentification
            f1.append(new Spacer(5, 5));//pour l'authentification
            f1.append(password);//pour l'authentification
            f1.addCommand(cmdconnect);//pour l'authentification
            f1.setCommandListener(this);//pour l'authentification
            disp.setCurrent(f1);//pour l'authentification
            
            f2.setTicker(t2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
      

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdconnect) {
            Thread th = new Thread(this);
            th.start();

           

        }

    }

    public void run() {

        try {
            // this will handle our XML
            voyageurhandler voyHandler = new voyageurhandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost:8080/smartPhp/getXmlUser.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, voyHandler);
            // display the result
            voy = voyHandler.getvoyageur();
             try {
                loadPlayer();
                GUIControl guiControl = (GUIControl) player.getControl("javax.microedition.media.control.GUIControl");
               
                if (guiControl == null) {
                    throw new Exception("No GUIControl!!");
                }
                Item videoItem = (Item) guiControl.initDisplayMode(GUIControl.USE_GUI_PRIMITIVE,null);
                videoItem.setPreferredSize(f2.getWidth()-2,f2.getHeight()/2);
               
                f2.insert(0, videoItem);
                

                f1.append(new Spacer(50, 50));
                player.start();

            } catch (Exception e) {
                error(e);
            }
            for (int i = 0; i < voy.length; i++) {
                if (voy[i].getEmail().equals(login.getString()) && voy[i].getPassword() == Integer.parseInt(password.getString())) {
                    nom_voyageur.setText(voy[i].getNom());

                    f2.append(nom_voyageur);
                    disp.setCurrent(f2);
                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }

    }

    private void loadPlayer() throws Exception {
        player = Manager.createPlayer(getClass().getResourceAsStream("/smartravelmobile/media/phantom.mpg"), "video/mpeg");
      
        player.realize();
        
    }

    private void error(Exception e) {
        alert.setString(e.getMessage());
        alert.setTimeout(Alert.FOREVER);
        disp.setCurrent(alert);
        e.printStackTrace();
        error = true;
    }

} //To change body of generated methods, choose Tools | Templates.

