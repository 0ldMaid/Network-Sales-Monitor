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








public class alchemy_shipping_ftp_label extends JFrame{//************************************************************************

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
String strUser = new String(nm.carbon[4][0][51]);		//
String strPassword = new String(nm.carbon[4][0][52]);	        //
String strServer = new String(nm.carbon[4][0][53]);		//10.20.30.40
String strLocalName = new String(nm.carbon[4][0][54]);	        //c:\\temp\\fred.txt
String strLocalName2 = new String(nm.carbon[4][0][54]);	        //c:\\temp\\fred.txt
String strRemoteName = new String(nm.carbon[4][0][55]);	        // /MPC_FILES/AUDIT_RESULTS/fred.txt
String ssxs;
String ssxu;
String ssxp;
String xlinex = new String("");
String blank = new String("");
String international = new String("XX");
String postback = new String(nm.carbon[4][0][49]);
String mail_type = new String("XX");
//String printerx[] = new String[0];
String dazzle_exe_location = new String(nm.carbon[4][0][45]);
String dazzle_xml_location = new String(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
String dazzle_export_location = new String(nm.carbon[4][0][50]);
String strRemoteName_title = new String("");
String new_name = new String();
//String CSVTEMP[] = new String[500];

File delete_file;
File test_file;
File test_file2;

File f0 = new File("alchemist_dazzle_us.lyt");
File f1 = new File("alchemist_dazzle_international.lyt");
File f2 = new File("dazzle_ship.lyt");

Toolkit toolkit;
Timer xtimerx;










alchemy_shipping_ftp_label(){//****************************


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





	test();

	requestFocus();

	pullThePlug();


}//csv_loader_x1********************************************************







	public void test(){


		strLocalName = dazzle_export_location + nm.carbon[4][0][44].replace("[[id]]", nm.carbon[2][nm.sale_id_xx][nm.what_item]);
		strLocalName2 = dazzle_export_location + nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_").replace("'","").replace("&","").replace("/","") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf";

		strRemoteName_title = nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_").replace("'","").replace("&","") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item];

		System.out.println(strLocalName);

		test_file = new File(strLocalName);
		test_file2 = new File(strLocalName2);


		if(test_file.exists()){ftp_upload();}
		else if(test_file2.exists()){strLocalName = strLocalName2; ftp_upload();}
		else{System.out.println("Can't find label."); hand_upload();}

	}//**









	public void hand_upload(){

		System.out.println("HAND UPLOAD FTP");

		setVisible(true);

		f1 = new File("");

		JFileChooser fc = new JFileChooser(f1);

		fc.setCurrentDirectory(new File(f1.getAbsolutePath()));

		fc.setSelectedFile(f1);

		int returnVal = fc.showSaveDialog(fc);

		f1 = fc.getSelectedFile(); //This grabs the File you typed
        System.out.println(f1);

		if(returnVal == 0){//*********************************************************************************************

			try{

				System.out.println("LOG IN BY HAND " + f1);


				String strUrl = "ftp://"+strUser+":"+strPassword+"@"+strServer+"/"+strRemoteName+strRemoteName_title;
	
				infox2.setText(strUrl);
				System.out.println(strUrl);

				URL url = new URL(strUrl);
				URLConnection con = url.openConnection();
				BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
 
				infox2.setText("GET FILE");

				FileInputStream in = new FileInputStream(f1);
 
				infox2.setText("UPLOAD FILE");

			int i = 0;
			byte[] bytesIn = new byte[1024];
			while ((i = in.read(bytesIn)) >= 0)
			{
				out.write(bytesIn, 0, i);
			}
			out.close();
			in.close();

			infox2.setText("DONE");

			}catch (Exception exc){System.out.println(exc.getMessage()); error_code++;}



		}//****************************************************************************************************************



	}//***********












	public void ftp_upload(){
 

		System.out.println("UPLOAD FTP");

		try{

			System.out.println("LOG IN");

			String strUrl = "ftp://"+strUser+":"+strPassword+"@"+strServer+"/"+strRemoteName+strRemoteName_title+".pdf";
	
			infox2.setText(strUrl);

			URL url = new URL(strUrl);
			URLConnection con = url.openConnection();
			BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
 
			infox2.setText("GET FILE");


			//strLocalName = nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item];

			FileInputStream in = new FileInputStream(strLocalName);
 
			infox2.setText("UPLOAD FILE");

			int i = 0;
			byte[] bytesIn = new byte[1024];
			while ((i = in.read(bytesIn)) >= 0)
			{
				out.write(bytesIn, 0, i);
			}
			out.close();
			in.close();

			infox2.setText("DONE");

		}catch (Exception exc){System.out.println(exc.getMessage()); error_code++;}
 

	}//***************














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