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




import com.ebay.soap.eBLBaseComponents.FeedbackDetailType;
import com.ebay.soap.eBLBaseComponents.FeedbackInfoType;

import com.ebay.soap.eBLBaseComponents.CommentTypeCodeType;




public class dazzle_export_return_label extends JFrame{//************************************************************************

String CONFIG_XML_NAME = new String("dazzle_xml_postback.xml");


String strUser = new String(nm.carbon[4][0][51]);		//
String strPassword = new String(nm.carbon[4][0][52]);	        //
String strServer = new String(nm.carbon[4][0][53]);		//10.20.30.40
String strLocalName = new String(nm.carbon[4][0][54]);	        //c:\\temp\\fred.txt
String strRemoteName = new String(nm.carbon[4][0][55]);	        // /MPC_FILES/AUDIT_RESULTS/fred.txt







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

int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
static String cx2 = new String("");






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

String dazzle_name1 = new String("DAZzle Professional - ");
String dazzle_name2 = new String("DAZzle Designer - ");
String dazzle_name3 = new String("DAZzle Designer - ");






dazzle_export_return_label(){//****************************


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

	setVisible(true);



//reset

	delete_file = new File(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
	delete_file.delete();
	System.out.println(delete_file);

	delete_file = new File(dazzle_export_location + nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");
	delete_file.delete();
	System.out.println(delete_file);

	delete_file = new File(dazzle_export_location + dazzle_name1 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");
	delete_file.delete();
	System.out.println(delete_file);

	delete_file = new File(dazzle_export_location + dazzle_name2 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");
	delete_file.delete();
	System.out.println(delete_file);

	delete_file = new File(dazzle_export_location + dazzle_name3 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");
	delete_file.delete();
	System.out.println(delete_file);



	//start over





	System.out.println("");
	System.out.println("START D");


	//dazzle_xml_location = dazzle_export_location + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml";

	infox1.setText("Build Label");
	infox2.setText("Load");
	loadx();

	infox2.setText("Replace");
	replacex();

	infox2.setText("Save");
	savex();


	requestFocus();

	infox1.setText("Pass to Dazzle");

	try{
	Runtime rt = Runtime.getRuntime();
	Process p = rt.exec(new String[]{ dazzle_exe_location, dazzle_xml_location });
	}catch(Exception e){error_code++; System.out.println("Start Dazzle failed."); infox2.setText("Start Dazzle failed."); nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; System.out.println("SS error_code " + error_code); pullThePlug();}

	if(nm.what_item > 0 && error_code == 0){nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Ready to ship";}


	requestFocus();

	infox1.setText("Upload to FTP Server");

	if(error_code == 0){
	toolkit = Toolkit.getDefaultToolkit();
	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_loopx(), 0);
	}
	else{System.out.println("ERROR SHIPPING SYSTEM 2 NOT ACTIVE.");}


	requestFocus();

}//csv_loader_x1********************************************************













	class RemindTask_loopx extends TimerTask{
	Runtime loop_runtime = Runtime.getRuntime();


	public void run(){//************************************************************************************


		ix0 = 0;
		//delete_file = new File(dazzle_export_location + "DAZzle Professional - " + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");


		delete_file = new File(dazzle_export_location + dazzle_name1 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");

		if(delete_file.exists()){}
		else{delete_file = new File(dazzle_export_location + dazzle_name2 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");}

		if(delete_file.exists()){}
		else{delete_file = new File(dazzle_export_location + dazzle_name3 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");}






		requestFocus();


		while(ix0 < 100){

			System.out.println("Waiting " + Integer.toString(ix0));

			if(ix0 > 99){if(nm.what_item != 0){nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error";} error_code++;}

			if(delete_file.exists() && ix0 < 2){if(nm.what_item != 0){nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error";} error_code++; System.out.println("Possible double label print.");}
			else if(delete_file.exists()){ix0 = 101;}

			infox2.setText("Rename PDF Label. " + Integer.toString(ix0));

			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println("import black 000332");}

		ix0++;
		}//*************



		requestFocus();


		infox2.setText("Delete XML File.");

		delete_file = new File(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
		delete_file.delete();


		requestFocus();


		infox2.setText("Rename PDF Label.");

		new_name = nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item];
		System.out.println(new_name);

		//delete_file = new File(dazzle_export_location + "DAZzle Professional - " + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");

		delete_file = new File(dazzle_export_location + dazzle_name1 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");

		if(delete_file.exists()){delete_file.renameTo(new File(dazzle_export_location + new_name + ".pdf"));}
		else{delete_file = new File(dazzle_export_location + dazzle_name2 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");}

		if(delete_file.exists()){delete_file.renameTo(new File(dazzle_export_location + new_name + ".pdf"));}
		else{delete_file = new File(dazzle_export_location + dazzle_name3 + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");}

		if(delete_file.exists()){delete_file.renameTo(new File(dazzle_export_location + new_name + ".pdf"));}
		else{System.out.println("Can't find label...");}


		if(delete_file.exists()){System.out.println("RENAMED");}
		else{delete_file.renameTo(new File(dazzle_export_location + new_name + ".pdf"));}


		strLocalName = strLocalName + new_name + ".pdf";
		strRemoteName = strRemoteName + new_name + ".pdf";


		requestFocus();

		try{

			ftp_upload();

		}catch(Exception e){System.out.println("FAILED>>X");}

		requestFocus();



		if(error_code == 0){build_file_item(); completesale_info(); export_to_shipping_system(); pullThePlug();}
		else if(nm.what_item != 0){nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; System.out.println("SS error_code " + error_code); pullThePlug();}
		else{System.out.println("SS error_code " + error_code); pullThePlug();}

	}//runx***************************************************************************************************
    }//remindtask












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















	public void completesale_info(){
	System.out.println(nm.carbon[5][4][nm.current_submit_item_a]);

		if(nm.carbon[4][0][43].equals("1")){



			if(nm.carbon[2][nm.tracking_number_xx][nm.what_item].length() > 3){

				if(nm.carbon[5][4][nm.current_submit_item_a].equals("eBay")){completeSale(); completeSale_feedback();}
				else if(nm.carbon[5][4][nm.current_submit_item_a].equals("Amazon")){amazon_of();}
				else if(nm.carbon[5][4][nm.current_submit_item_a].equals("Alchemist")){}
				else{System.out.println("POSTBACK X FALIED");}

			}//****************************************************************
			else{nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; error_code++;}



		}//if********************************

	}//*****************************






public void amazon_of(){

	ship_post_order_fulfillment spof = new ship_post_order_fulfillment();

	ship_post_order_fulfillment spof2 = new ship_post_order_fulfillment();


}//*********************








	public static void completeSale(){


        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
        apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
        apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses

        apiContext.setSite(SiteCodeType.US); // Set site to UK
          
        CompleteSaleCall completeSaleApi = new CompleteSaleCall(apiContext);
          
        completeSaleApi.setItemID(nm.carbon[2][nm.listing_id_xx][nm.what_item]);
        completeSaleApi.setTransactionID(nm.carbon[2][nm.sale_id_xx][nm.what_item]);
        completeSaleApi.setShipped(true);
          
        ShipmentType shipType = new ShipmentType();
          
        ShipmentTrackingDetailsType shpmnt = new ShipmentTrackingDetailsType();
        shpmnt.setShipmentTrackingNumber(nm.carbon[2][nm.tracking_number_xx][nm.what_item]);
        shpmnt.setShippingCarrierUsed("USPS");
          
        shipType.setShipmentTrackingDetails(new ShipmentTrackingDetailsType[]{shpmnt});
          
        completeSaleApi.setShipment(shipType);
          
        try {completeSaleApi.completeSale();} 
	    catch (ApiException e) { e.printStackTrace();}
	    catch (SdkException e) { e.printStackTrace();}
	    catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK TRACKING eBay");
     
		completeSale2();

	}//***************************************







	//post tracking again for better luck.
	public static void completeSale2(){


        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
        apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
        apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses

        apiContext.setSite(SiteCodeType.US); // Set site to UK
          
        CompleteSaleCall completeSaleApi = new CompleteSaleCall(apiContext);
          
        completeSaleApi.setItemID(nm.carbon[2][nm.listing_id_xx][nm.what_item]);
        completeSaleApi.setTransactionID(nm.carbon[2][nm.sale_id_xx][nm.what_item]);
        completeSaleApi.setShipped(true);
          
        ShipmentType shipType = new ShipmentType();
          
        ShipmentTrackingDetailsType shpmnt = new ShipmentTrackingDetailsType();
        shpmnt.setShipmentTrackingNumber(nm.carbon[2][nm.tracking_number_xx][nm.what_item]);
        shpmnt.setShippingCarrierUsed("USPS");
          
        shipType.setShipmentTrackingDetails(new ShipmentTrackingDetailsType[]{shpmnt});
          
        completeSaleApi.setShipment(shipType);
          
        try {completeSaleApi.completeSale();} 
	    catch (ApiException e) { e.printStackTrace();}
	    catch (SdkException e) { e.printStackTrace();}
	    catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK TRACKING eBay2");
     
	}//***************************************

















	public static void completeSale_feedback(){

          ApiContext apiContext = new ApiContext();
          // set API Token to access eBay API Server
          ApiCredential cred = apiContext.getApiCredential();
          //Set Auth Token
          cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
          apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
          apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses

          apiContext.setSite(SiteCodeType.US); // Set site to UK
          
          CompleteSaleCall completeSaleApi = new CompleteSaleCall(apiContext);
          
          completeSaleApi.setItemID(nm.carbon[2][nm.listing_id_xx][nm.what_item]);
          completeSaleApi.setTransactionID(nm.carbon[2][nm.sale_id_xx][nm.what_item]);


          
          FeedbackInfoType feedtype = new FeedbackInfoType();
          
	  //feedtype.setCommentText("Top of the Line!");
	  feedtype.setCommentText(nm.carbon[5][nm.feedback_message_xx][nm.current_submit_item_a]);
	  feedtype.setCommentType(CommentTypeCodeType.POSITIVE);
	  feedtype.setTargetUser(nm.carbon[2][nm.buyer_id_xx][nm.what_item]);
          
          completeSaleApi.setFeedbackInfo(feedtype);
          



          try {completeSaleApi.completeSale();} 
	  catch (ApiException e) { e.printStackTrace();}
	  catch (SdkException e) { e.printStackTrace();}
	  catch (Exception e)    { e.printStackTrace();}

	System.out.println("POSTBACK FEEDBACK eBay");
     
	}//***************************************


















	public void ftp_upload(){
 

		System.out.println("UPLOAD FTP");

		try{

			System.out.println("LOG IN");

			String strUrl = "ftp://"+strUser+":"+strPassword+"@"+strServer+strRemoteName;
	
			infox2.setText(strUrl);

			URL url = new URL(strUrl);
			URLConnection con = url.openConnection();
			BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
 
			infox2.setText("GET FILE");


			FileInputStream in = new FileInputStream(strLocalName);
 
			infox2.setText("UPLOAD FILE");

			int i = 0;
			byte[] bytesIn = new byte[1024];
			while ((i = in.read(bytesIn)) >= 0){

				out.write(bytesIn, 0, i);

			}//*********************************
			out.close();
			in.close();

			infox2.setText("DONE");

		}catch (Exception exc){System.out.println(exc.getMessage()); error_code++;}
 

	}//***************



























	public void export_to_shipping_system(){


		try {//*******************************************************

		requestFocus();

		           data = URLEncoder.encode("quantity", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.quantity_sold_xx][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("buyer_name", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.buyers_first_name_xx][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("item_part", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.part_number_xx][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("pdf_link", "UTF-8")     + "=" + URLEncoder.encode("/shipping_system/labels/" + new_name + ".pdf", "UTF-8");
		    data += "&" + URLEncoder.encode("pass_id", "UTF-8")      + "=" + URLEncoder.encode(nm.carbon[4][0][57], "UTF-8");
		    data += "&" + URLEncoder.encode("tracking_id", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.tracking_number_xx][nm.what_item], "UTF-8");


		    data += "&" + URLEncoder.encode("shipping_id_a1", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.address_1_xx][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("shipping_id_city", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.address_2_xx][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("shipping_id_state", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.address_3_xx][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("shipping_id_zip", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.address_4_xx][nm.what_item], "UTF-8");


		    data += "&" + URLEncoder.encode("custom_post_00", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][62]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_01", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][63]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_02", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][64]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_03", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][65]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_04", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][66]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_05", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][67]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_06", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][68]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_07", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][69]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_08", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][70]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_09", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][71]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_10", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][72]) ][nm.what_item], "UTF-8");
		    data += "&" + URLEncoder.encode("custom_post_11", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ Integer.parseInt(nm.carbon[4][0][73]) ][nm.what_item], "UTF-8");


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
		    }
		    wr.close();
		    rd.close();
		} catch (Exception e){System.out.println("URL falure. EXPORT LABEL.");}




	}//**************************************














	public void replacex(){

		System.out.println("REPLACE");

		if(nm.carbon[2][nm.address_5_xx][nm.what_item].equals("United States")){

			international = nm.carbon[4][0][46];
			mail_type = "PRIORITY";


			try{

				ix0 = Integer.parseInt(nm.carbon[5][nm.ship_not_international_xx][nm.current_submit_item_a]);
				mail_type = nm.carbon[2][ix0][nm.what_item];
			
			}catch(Exception e){System.out.println("00000323023"); mail_type = "PRIORITY";}
			//JOptionPane.showMessageDialog(null, mail_type);


			if(nm.carbon[2][nm.address_4_xx][nm.what_item].length() > 5 && nm.what_item > 0){nm.carbon[2][nm.address_4_xx][nm.what_item] = nm.carbon[2][nm.address_4_xx][nm.what_item].substring(0, 5);}

		}//if*******************************************************************
		else{international = nm.carbon[4][0][47]; mail_type = "INTLPRIORITY";}





		System.out.println(international);

		//rebuild the weight                                                    x16 = 1lb
		ix0 = (Integer.parseInt(nm.carbon[2][nm.item_weight_xx][nm.what_item]) * 1) * Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][nm.what_item]);


		for (int loop2 = 0; loop2 < printerx.length; loop2++){//*************************

			for (int loop3 = 0; loop3 < nm.db_string.length; loop3++){//*************************


				printerx[loop2] = printerx[loop2].replace("[[" + nm.db_string[loop3] + "]]", nm.carbon[2][loop3][nm.what_item]);
				printerx[loop2] = printerx[loop2].replace("[[layout_template]]", international);
				printerx[loop2] = printerx[loop2].replace("[[postback_template]]", postback);
				printerx[loop2] = printerx[loop2].replace("[[mail_type]]", mail_type);
				printerx[loop2] = printerx[loop2].replace("[[item_weight]]", Integer.toString(ix0));


				//System.out.println(printerx[loop2]);

			}//for**********************************************************************************
		//System.out.println("WORKING");
		}//for***************************************************************************


	}//replacex************













	public void savex(){

		System.out.println("SAVE");

		//f2 = new File(dazzle_lyt_location);



		try{

	        BufferedWriter out = new BufferedWriter(new FileWriter(dazzle_xml_location));

			for (int loop2 = 0; loop2 < printerx.length; loop2++){//*************************

				//System.out.println(printerx[loop2]);
				out.write(printerx[loop2]);
				out.newLine();

			}//for*******************************************************************************
			
	        out.close();

	    }catch(IOException e) {System.out.println("print fail.");}


	}//savex*************









	public void loadx(){

		System.out.println("LOAD");

		csv_int = 0;

		File fx;

		System.out.println(nm.carbon[2][nm.address_5_xx][nm.what_item] + "X");

		if(nm.carbon[2][nm.address_5_xx][nm.what_item].equals("United States")){fx = new File(nm.carbon[4][0][48]); System.out.println("    USA");}
		else{fx = new File(nm.carbon[4][0][48]);  System.out.println("    INT");}


		try {

			BufferedReader in = new BufferedReader(new FileReader(fx.toString()));
			System.out.println("LOADx");
			xlinex = blank;
			while ((xlinex = in.readLine()) != null){CSVTEMP[csv_int] = xlinex; csv_int++;}
			in.close();

		}catch(IOException e){working = 0; System.out.println("no file " + f1.toString());}

		System.out.println("CSV INT " + csv_int);

		printerx = new String[csv_int];

		if(csv_int < 10){if(nm.what_item != 0){nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error";} error_code++; System.out.println("NO SHIPPING .LYT");}

		for (int loop2 = 0; loop2 < csv_int; loop2++){//*************************

			printerx[loop2] = new String(CSVTEMP[loop2]);
			//System.out.println(printerx[loop2]);

		}//for*******************************************************************




	}//savex*************







    public void pullThePlug() {

	    System.out.println("PULL THE PLUG");

	    nm.firex = 1;

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull









    public static void main(String[] args){

		dazzle_export_return_label xr = new dazzle_export_return_label();

    }//main







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