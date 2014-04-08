package smartravelmobile.midlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.DataInputStream;
import java.util.TimeZone;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import smartravelmobile.handlers.voyageHandler;

/**
 * @author Belgacem
 */

public class Midletdetail1 extends MIDlet implements CommandListener,Runnable{

    Display disp = Display.getDisplay(this);
    Form f = new Form(" detail de notre annonce");
       
    DateField df = new DateField("date de sortie", DateField.TIME, TimeZone.getTimeZone("GMT+1"));
    StringItem stdest = new StringItem("notre Destination", null);
    StringItem stplaces = new StringItem("nous proposons"+"places", null);
    StringItem stmoy = new StringItem("le moyen de transport sera", null);
    StringItem stprog = new StringItem("le programme sera de", null);
    StringItem stagence = new StringItem("l'agence"+" vous invite à reserver une place ou plus", null);
    
       
   
    
    Command cmOk = new Command("OK", Command.SCREEN, 0);
    Command cmlocal = new Command("Next", Command.SCREEN, 0);    
    Command CmBack = new Command("Back", Command.EXIT, 0);     
   
    
    public void startApp() {
        f.append(df);
        f.append(stdest);
        f.append(stplaces);
        f.append(stmoy);
        f.append(stprog);
//        f.append(stagence);
//        f.addCommand(cmOk);
//        f.addCommand(cmlocal);
//        f.addCommand(CmBack);
       
        f.setCommandListener(this);
        disp.setCurrent(f); 
    }
    
    public void pauseApp() {
        
    }
    
    public void destroyApp(boolean unconditional) {
        
        
    }

    public void commandAction(Command c, Displayable d) {
        
    }

    public void run() {
      
    }

   

   
}
