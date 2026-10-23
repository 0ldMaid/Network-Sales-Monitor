import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;


import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 


import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import com.ebay.soap.eBLBaseComponents.CategoryType;




import com.ebay.sdk.ApiContext; 
import com.ebay.sdk.ApiCredential; 
import com.ebay.sdk.ApiException; 
import com.ebay.sdk.SdkException; 
import com.ebay.sdk.call.ReviseInventoryStatusCall; 
import com.ebay.soap.eBLBaseComponents.AmountType; 
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType; 
import com.ebay.soap.eBLBaseComponents.InventoryStatusType; 
import com.ebay.soap.eBLBaseComponents.SiteCodeType; 







public class ebay_update_quantity extends JFrame{//************************************************************************



Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

static int error_code = 0;
int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int amazon_items = 0;//number of new items to submit. 


Float fx0x = (float) 0.0;
Float fx1x = (float) 0.0;


int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;
int ix0x = 0;
int ix1x = 0;
int ix2x = 0;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
static String cx2 = new String("");
String cx3 = new String("");







String ssxs;
String ssxu;
String ssxp;






//C:\Program Files (x86)\glassfishv3\glassfish\domains\domain1\docroot\

String printerx[] = new String[0];
String CSVTEMP[] = new String[500];

File delete_file;

File f0 = new File("alchemist_dazzle_us.lyt");
File f1 = new File("alchemist_dazzle_international.lyt");
File f2 = new File("dazzle_ship.lyt");
String xlinex = new String("");
String blank = new String("");

int working = 0;
int csv_int = 0;

String international = new String("XX");
String postback = new String(nm.carbon[4][0][49]);
String mail_type = new String("XX");

String new_name = new String();

String dazzle_exe_location = new String(nm.carbon[4][0][45]);
String dazzle_xml_location = new String(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
String dazzle_export_location = new String(nm.carbon[4][0][50]);


Toolkit toolkit;

Timer xtimerx;


int what_ii = 0;







ebay_update_quantity(int what_i){//****************************


	super("Dazzle Shipping System");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	what_ii = what_i;

	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(black);
	infox0.setForeground(whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("item number: ");
	infox1.setForeground(whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("item number: ");
	infox2.setForeground(whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(blackx);
	bkp.setForeground(whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(blackx);
	cp.setForeground(whitex);
	cp.add(bkp);

	error_code = 0;

	//setVisible(true);





	complete();

	requestFocus();

	pullThePlug();


}//csv_loader_x1********************************************************













	public void complete(){

		System.out.println("eBay UPDATE");


        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
        apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
        apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses


	  	if(nm.carbon[5][nm.ebay_site_xx][nm.current_submit_item_a].equals("0")){apiContext.setSite(SiteCodeType.US);}
        else if(nm.carbon[5][nm.ebay_site_xx][nm.current_submit_item_a].equals("1")){apiContext.setSite(SiteCodeType.UK);}
	  	else{apiContext.setSite(SiteCodeType.US);}          


        ReviseInventoryStatusCall risCall = new ReviseInventoryStatusCall(apiContext); 


        InventoryStatusType invStatus1 = new InventoryStatusType();  
        //invStatus1.setItemID(nm.carbon[0][nm.ebay_item_xx][what_ii]);
        invStatus1.setItemID(nm.carbon[0][ Integer.parseInt(nm.carbon[5][nm.ebay_listing_id2_xx][nm.current_submit_item_a]) ][what_ii]);
        //invStatus1.setStartPrice(Double.parseDouble(nm.carbon[0][nm.item_price_xx][what_ii])); 




		//inventory control
		if(nm.carbon[4][0][72].equals("1")){

		System.out.println("TEST1");

		try{

		    ix0x = Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_ii]);
		    ix1x = Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_ii]);
		    ix2x = (nm.carbon[1][0].length -1);

			System.out.println("TEST2 " + ix0x + " " + ix1x + " " + ix2x);

		    if(ix1x > ix2x){

				fx0x = (float) ix1x / ix2x;
				cx3 = Float.toString(fx0x);
				ix3 = cx3.indexOf(".");
				if(ix3 > -1){cx3 = cx3.substring(0, ix3);}
				ix0x = Integer.parseInt(cx3);
				System.out.println(ix0x);
				//System.exit(0);

		    }//*************
		    else if(ix1x <= ix2x && ix1x != 0){

			System.out.println("TEST4");

			if( (ix1x - (nm.carbon[1][0].length -1) ) >= 0 ){ix0x = 1;}
			else{ix0x = 0;}

		    }//********************************
		    else{ix0x = 0;}

			System.out.println("TEST5");

		    invStatus1.setQuantity(ix0x);

			System.out.println("TEST6");

		}catch(Exception e){invStatus1.setQuantity(Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_ii])); System.out.println("Inventory Control fail.");}

		}//*********************************
		else{invStatus1.setQuantity(Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_ii])); System.out.println("SET IVENTORY SYSTEM OFF");}
		//inventory control





        //invStatus1.setQuantity(Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_ii])); 



        //CategoryType cat = new CategoryType();
        //try{ix0 = Integer.parseInt(nm.carbon[5][nm.ebay_category_xx][nm.current_submit_item_a]);}
        //catch(Exception e){ix0 = -1;}

        //if(ix0 != -1){cat.setCategoryID(nm.carbon[0][ix0][what_item_here]);}
        //else{cat.setCategoryID("113484");}

        //invStatus1.setPrimaryCategory(cat);



        InventoryStatusType[] invStatuses = new InventoryStatusType[] {invStatus1}; 


        try {

          	risCall.setInventoryStatus(invStatuses);// add the array to the main call 
          	risCall.reviseInventoryStatus(); 

          
        }//try
	  	catch (ApiException e) { e.printStackTrace(); nm.carbon[0][nm.ebay_item_xx][what_ii] = "ebay_item";}
	  	catch (SdkException e) { e.printStackTrace();}
	  	catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK eBay update Inventory.");
     
	}//***************************************









    public void pullThePlug() {


	    nm.firex = 1;

	    System.out.println("PULL THE PLUG");

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull






	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundblack.jpg"), "backgroundblack.jpg"));

    		}catch (Exception e) { System.out.println("Failed001"); }

  		}//backgroundpanel

  		protected void paintComponent(Graphics g){

    		super.paintComponent(g); 
    
    		if (image != null){
      
      			g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

      		}//****************
  
  		}//paint

	}//jpanel


}//last****************************************