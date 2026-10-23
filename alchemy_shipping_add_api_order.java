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







public class alchemy_shipping_add_api_order extends JFrame{//************************************************************************

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

static int runs2 = 400;
static int runs = 50000;
static int error_code = 0;
int bytesRead = 0;
int csv_passes_x = 17;
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
String CONFIG_XML_NAME = new String("dazzle_xml_postback.xml");
String strUser = new String(nm.carbon[4][0][51]);		//
String strPassword = new String(nm.carbon[4][0][52]);	        //
String strServer = new String(nm.carbon[4][0][53]);		//10.20.30.40
String strLocalName = new String(nm.carbon[4][0][54]);	        //c:\\temp\\fred.txt
String strRemoteName = new String(nm.carbon[4][0][55]);	        // /MPC_FILES/AUDIT_RESULTS/fred.txt
String cx0 = new String("");
String cx1 = new String("");
String ssxs;
String ssxu;
String ssxp;
String printerx[] = new String[0];
//String CSVTEMP[] = new String[500];
String xlinex = new String("");
String blank = new String("");
String international = new String("XX");
String postback = new String(nm.carbon[4][0][49]);
String mail_type = new String("XX");
String new_name = new String();
String dazzle_exe_location = new String(nm.carbon[4][0][45]);
String dazzle_xml_location = new String(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
String dazzle_export_location = new String(nm.carbon[4][0][50]);

File delete_file;
File f0 = new File("alchemist_dazzle_us.lyt");
File f1 = new File("alchemist_dazzle_international.lyt");
File f2 = new File("dazzle_ship.lyt");

Toolkit toolkit;
Timer xtimerx;









alchemy_shipping_add_api_order(){//****************************


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

	setVisible(true);


	new_name = "1X_Unit(s)_[Behringer]_HPX2000_923467172012";
	export_to_shipping_system();



}//csv_loader_x1********************************************************













	public void export_to_shipping_system(){


		try {//*******************************************************

			requestFocus();

                   data = URLEncoder.encode("quantity", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.quantity_sold_xx][nm.what_item], "UTF-8");
    		data += "&" + URLEncoder.encode("buyer_name", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.buyers_first_name_xx][nm.what_item], "UTF-8");
    		data += "&" + URLEncoder.encode("item_part", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.part_number_xx][nm.what_item], "UTF-8");
    		data += "&" + URLEncoder.encode("pdf_link", "UTF-8")     + "=" + URLEncoder.encode("/shipping_system/labels/" + new_name + ".pdf", "UTF-8");
    		data += "&" + URLEncoder.encode("pass_id", "UTF-8")      + "=" + URLEncoder.encode(nm.carbon[4][0][57], "UTF-8");
   			data += "&" + URLEncoder.encode("tracking_id", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.tracking_number_xx][nm.what_item], "UTF-8");


   			// Send data
    		System.out.println("post order too: " + nm.carbon[4][0][56]);
    		url = new URL(nm.carbon[4][0][56]);
    		conn = url.openConnection();
    		conn.setDoOutput(true);
    		wr = new OutputStreamWriter(conn.getOutputStream());
   			wr.write(data);
    		wr.flush();

    		// Get the response
    		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null) {
        
        		infox2.setText(line);
				System.out.println(line);

    		}//*************************************

    		wr.close();
    		rd.close();

		} catch (Exception e){System.out.println("URL falure. EXPORT LABEL.");}


		pullThePlug();

	}//**************************************









    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.firex = 1;

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