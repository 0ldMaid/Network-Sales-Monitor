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
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.CompleteSaleCall;
import com.ebay.soap.eBLBaseComponents.ShipmentTrackingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShipmentType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;








public class dazzle_xml_postback extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

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
static int error_code = 0;
int bytesRead = 0;
int amazon_items = 0;//number of new items to submit. 
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;
int working = 0;
int csv_int = 0;

static String cx2 = new String("");
String data;
String cx0 = new String("");
String cx1 = new String("");
String ssxs;
String ssxu;
String ssxp;
String CONFIG_XML_NAME = new String("dazzle_xml_postback.xml");
String xlinex = new String("");
String blank = new String("");
String international = new String("XX");
String postback = new String(nm.carbon[4][0][49]);
String mail_type = new String("XX");
String new_name = new String();
//String printerx[] = new String[0];
//String CSVTEMP[] = new String[500];

File delete_file;
File f0 = new File("alchemist_dazzle_us.lyt");
File f1 = new File("alchemist_dazzle_international.lyt");
File f2 = new File("dazzle_ship.lyt");

//String dazzle_exe_location = new String(nm.carbon[4][0][45]);
//String dazzle_xml_location = new String(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
//String dazzle_export_location = new String(nm.carbon[4][0][50]);

Toolkit toolkit;
Timer xtimerx;










dazzle_xml_postback(){//****************************


	super("Dazzle Shipping System");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);



	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("item number: ");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("item number: ");
	infox2.setForeground(nm.whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.blackx);
	bkp.setForeground(nm.whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(nm.blackx);
	cp.setForeground(nm.whitex);
	cp.add(bkp);

	error_code = 0;

	//setVisible(true);



	System.out.println("Shipping System Postback.");

	build_file_item();

	requestFocus();

	pullThePlug();


}//csv_loader_x1********************************************************













	public void build_file_item(){


		//convert xml item for upload*

		try{

	    	System.out.println("STARRT");

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

	    	System.out.println("LOAD");

            Document doc = docBuilder.parse(new File(CONFIG_XML_NAME));

	    	System.out.println("LOAD");

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


	    	NodeList list1 = doc.getElementsByTagName("FinalPostage");
	    	Node child1 = list1.item(0);
	    	//child1.getTextContent();
            System.out.println("data in child number 0: "+ child1.getTextContent());


	    	NodeList list2 = doc.getElementsByTagName("PIC");
	    	Node child2 = list2.item(0);
	    	//child2.getTextContent();
            System.out.println("data in child number 0: "+ child2.getTextContent());


			if(nm.what_item != 0){
	
				nm.carbon[2][nm.shipping_out_xx][nm.what_item] = child1.getTextContent();
				nm.carbon[2][nm.tracking_number_xx][nm.what_item] = child2.getTextContent();

			}//if*****************



		}catch(Exception ex){

			System.out.println("xml failed.");

			//error_code++;

        	System.err.println("+============================+");
        	System.err.println("|        XML Error           |");
        	System.err.println("+============================+");
        	System.err.println(ex.getClass());
        	System.err.println(ex.getMessage());
       		System.err.println("+============================+");

		}//catch





        System.out.println("Done");


	}//*************************build_file









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