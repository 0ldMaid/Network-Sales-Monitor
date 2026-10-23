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




public class dazzle_export_label extends JFrame{//************************************************************************


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 250;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

String CONFIG_XML_NAME = new String("dazzle_xml_postback.xml");


String strUser = new String(nm.carbon[4][0][51]);		//
String strPassword = new String(nm.carbon[4][0][52]);	        //
String strServer = new String(nm.carbon[4][0][53]);		//10.20.30.40
String strLocalName = new String(nm.carbon[4][0][54]);	        //c:\\temp\\fred.txt
String strRemoteName = new String(nm.carbon[4][0][55]);	        // /MPC_FILES/AUDIT_RESULTS/fred.txt


static int error_code = 0;
int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;



JLabel sinfox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel sinfox2 = new JLabel("Loading...", JLabel.LEFT);
JLabel sinfox3 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel sinfox4 = new JLabel("Loading...", JLabel.LEFT);

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






dazzle_export_label(){//****************************


	super("Dazzle Shipping System");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setDefaultLookAndFeelDecorated(false);
	setUndecorated(true);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	ximagex = new ImageIcon(this.getClass().getResource("images/dazzle.png")).getImage();
	Icon aicon = new ImageIcon(ximagex);



	sinfox1.setPreferredSize(new Dimension(320, 25));
	sinfox1.setText("loading...");
	sinfox1.setForeground(whitex);
	sinfox1.setOpaque(true); 
	sinfox1.setBackground(blackx);

	sinfox2.setPreferredSize(new Dimension(320, 25));
	sinfox2.setText("loading...");
	sinfox2.setForeground(whitex);
	sinfox2.setOpaque(true); 
	sinfox2.setBackground(blackx);

	sinfox3.setPreferredSize(new Dimension(320, 25));
	sinfox3.setText("loading...");
	sinfox3.setForeground(whitex);
	sinfox3.setOpaque(true); 
	sinfox3.setBackground(blackx);

	sinfox4.setPreferredSize(new Dimension(320, 5));
	sinfox4.setText("");
	sinfox4.setForeground(whitex);
	//sinfox4.setOpaque(true); 
	sinfox4.setBackground(blackx);




	infox0.setPreferredSize(new Dimension(320, 80));
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
	bkp.setPreferredSize(new Dimension(340, 240));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(blackx);
	bkp.setForeground(whitex);

	bkp.add(infox0);

	bkp.add(sinfox1);
	bkp.add(sinfox2);
	bkp.add(sinfox3);
	bkp.add(sinfox4);

	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(blackx);
	cp.setForeground(whitex);
	cp.add(bkp);

	error_code = 0;

	setVisible(true);






	sinfox1.setText("Part ID: " + nm.carbon[2][nm.part_number_xx][nm.what_item]);
	sinfox2.setText("Sale ID: " + nm.carbon[2][nm.sale_id_xx][nm.what_item]);
	sinfox3.setText("Site ID: " + nm.carbon[2][nm.site_id_xx][nm.what_item]);


	dazzle_name1 = new String(nm.carbon[4][0][44]).replace("[[id]]", nm.carbon[2][nm.sale_id_xx][nm.what_item]);

	System.out.println(dazzle_name1);



//reset

	delete_file = new File(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
	delete_file.delete();
	System.out.println(delete_file);

	delete_file = new File(dazzle_export_location + nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_").replace("/","") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".pdf");
	delete_file.delete();
	System.out.println(delete_file);

	delete_file = new File(dazzle_export_location + dazzle_name1);
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

	} catch (Exception e) {

		error_code++; 
		System.out.println("Start Dazzle failed."); 
		infox2.setText("Start Dazzle failed."); 
		nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; 
		nm.carbon[2][nm.notes_xx][nm.what_item] = "Dazzle was not found or could not be started. Program needs admin access."; 
		System.out.println("SS error_code " + error_code); 
		pullThePlug();

	}//*********************

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


		delete_file = new File(dazzle_export_location + dazzle_name1);


		System.out.println(delete_file);


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

		System.out.println("RENAME 1");

		new_name = nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_").replace("'","").replace("&","").replace("/","") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item];
		System.out.println(new_name);

		delete_file = new File(dazzle_export_location + dazzle_name1);

		if(delete_file.exists()){delete_file.renameTo(new File(dazzle_export_location + new_name + ".pdf")); System.out.println("FOUND!");}
		else{System.out.println("Can't find label... " + delete_file);}

		System.out.println("RENAME 2 " + delete_file);

		if(delete_file.exists()){System.out.println("RENAMED");}
		else{delete_file.renameTo(new File(dazzle_export_location + new_name + ".pdf"));}


		strLocalName = strLocalName + new_name + ".pdf";
		strRemoteName = strRemoteName + new_name + ".pdf";



		requestFocus();

		try{ftp_upload();}catch(Exception e){System.out.println("FAILED>>X");}

		requestFocus();

	        

		if(error_code == 0){build_file_item(); completesale_info(); export_to_shipping_system(); nm.carbon[2][nm.notes_xx][nm.what_item] = "[PASS]"; pullThePlug();}
		else if(nm.what_item != 0){nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; System.out.println("SS error_code " + error_code); pullThePlug();}
		else{System.out.println("SS error_code " + error_code); pullThePlug();}

	}//runx***************************************************************************************************
    }//remindtask












	public void build_file_item(){

		if(nm.carbon[4][0][20].equals("1")){//************************************************************************************************************



		//convert xml item for upload*

			try{

			    System.out.println("START");

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
			nm.carbon[2][nm.notes_xx][nm.what_item] = "Build Label";


		}//if*********************************************************************************************************************************************
		else{System.out.println("DON'T GET XML INFO");}


	}//*************************build_file










	public void completesale_info(){

		nm.ix10 = nm.what_item;
		System.out.println(nm.carbon[5][4][nm.current_submit_item_a]);


		if(nm.carbon[4][0][43].equals("1")){//****************************

			infox2.setText("Complete Sale (MARK SHIPPED)");

			if(nm.carbon[2][nm.tracking_number_xx][nm.what_item].length() > 3){

			if(nm.carbon[5][4][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("eBay")){completeSale();}
			else if(nm.carbon[5][4][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("Amazon")){amazon_of();}
			else if(nm.carbon[5][4][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("Alchemist")){}
			else{System.out.println("POSTBACK X FALIED");}

			}//****************************************************************
			else{nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; error_code++;}

		}//if**************************************************************




		if(nm.carbon[4][0][42].equals("1")){

			infox2.setText("Complete Sale (FEEDBACK)");

			if(nm.carbon[2][nm.tracking_number_xx][nm.what_item].length() > 3){

			if(nm.carbon[5][4][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("eBay")){completeSale_feedback();}
			else if(nm.carbon[5][4][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("Amazon")){}
			else if(nm.carbon[5][4][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("Alchemist")){}
			else{System.out.println("POSTBACK X FALIED");}

			}//****************************************************************
			else{}//nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; error_code++;

		}//if********************************





	}//*****************************









	public void amazon_of(){

		//ship_post_order_fulfillment spof = new ship_post_order_fulfillment();
		//ship_post_order_fulfillment spof2 = new ship_post_order_fulfillment();

		//run 2 times to make sure it's completed.
		amazon_post_order_addtrack spof1 = new amazon_post_order_addtrack();
		amazon_post_order_addtrack spof2 = new amazon_post_order_addtrack();

	}//*********************








	public static void completeSale(){


        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);
        //cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
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
        //shpmnt.setShippingCarrierUsed("USPS");
        shpmnt.setShippingCarrierUsed(nm.carbon[2][nm.shipping_company_xx][nm.what_item]);   
          
        shipType.setShipmentTrackingDetails(new ShipmentTrackingDetailsType[]{shpmnt});
          
        completeSaleApi.setShipment(shipType);
          
	    try {completeSaleApi.completeSale();} 
		catch (ApiException e) { e.printStackTrace();}
		catch (SdkException e) { e.printStackTrace();}
		catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK TRACKING eBay");
	     
		nm.carbon[2][nm.notes_xx][nm.what_item] = "Tracking Number Sent";

		completeSale2();

	}//***************************************







	//post tracking again for better luck.
	public static void completeSale2(){


        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);
        //cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
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
        //shpmnt.setShippingCarrierUsed("USPS");
        shpmnt.setShippingCarrierUsed(nm.carbon[5][nm.ebay_shipping_type_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);   


        shipType.setShipmentTrackingDetails(new ShipmentTrackingDetailsType[]{shpmnt});
          
        completeSaleApi.setShipment(shipType);
          
        try {completeSaleApi.completeSale();} 
	 	catch (ApiException e) { e.printStackTrace();}
	  	catch (SdkException e) { e.printStackTrace();}
	  	catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK TRACKING eBay2");

		nm.carbon[2][nm.notes_xx][nm.what_item] = "Tracking Number Sent";
     
	}//***************************************

















	public static void completeSale_feedback(){


        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);
        //cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
        apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
        apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses

	    System.out.println("Post feedback to ebay.");
	    System.out.println(nm.carbon[5][nm.ebay_site_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);
	    if(nm.carbon[5][nm.ebay_site_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ].equals("0")){apiContext.setSite(SiteCodeType.US);}
	    else{apiContext.setSite(SiteCodeType.UK); System.out.println("EBAY UK");}
          
        CompleteSaleCall completeSaleApi = new CompleteSaleCall(apiContext);
          
        completeSaleApi.setItemID(nm.carbon[2][nm.listing_id_xx][nm.what_item]);
        completeSaleApi.setTransactionID(nm.carbon[2][nm.sale_id_xx][nm.what_item]);

        FeedbackInfoType feedtype = new FeedbackInfoType();
          
	  	//feedtype.setCommentText("Top of the Line!");
	 	feedtype.setCommentText(nm.carbon[5][nm.feedback_message_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);
	  	feedtype.setCommentType(CommentTypeCodeType.POSITIVE);
	  	feedtype.setTargetUser(nm.carbon[2][nm.buyer_id_xx][nm.what_item]);
          
        completeSaleApi.setFeedbackInfo(feedtype);
          
        try {completeSaleApi.completeSale();} 
	  	catch (ApiException e) { e.printStackTrace();}
	 	catch (SdkException e) { e.printStackTrace();}
	  	catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK FEEDBACK eBay");
	     
		nm.carbon[2][nm.notes_xx][nm.what_item] = "Feedback Sent";


	}//***************************************










	public void ftp_upload(){
		 
		if(nm.carbon[4][0][22].equals("1")){//************************************************************************************************************


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
		 
			nm.carbon[2][nm.notes_xx][nm.what_item] = "Label Uploaded";


		}//if*********************************************************************************************************************************************
		else{System.out.println("DON'T UPLOAD PDF");}


	}//***************








	public void export_to_shipping_system(){

		if(nm.carbon[4][0][23].equals("1")){//************************************************************************************************************


			try{//*******************************************************

				requestFocus();



			           data = URLEncoder.encode("quantity", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.quantity_sold_xx][nm.what_item], "UTF-8");
			    data += "&" + URLEncoder.encode("buyer_name", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.buyers_first_name_xx][nm.what_item].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("item_part", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.part_number_xx][nm.what_item].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("pdf_link", "UTF-8")     + "=" + URLEncoder.encode(new_name + ".pdf", "UTF-8");
			    data += "&" + URLEncoder.encode("user", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[4][0][58], "UTF-8");
			    data += "&" + URLEncoder.encode("password", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[4][0][57], "UTF-8");
			    data += "&" + URLEncoder.encode("key", "UTF-8")          + "=" + URLEncoder.encode(nm.carbon[4][0][59], "UTF-8");
			    data += "&" + URLEncoder.encode("tracking_id", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.tracking_number_xx][nm.what_item].replace(" ",""), "UTF-8");

			    data += "&" + URLEncoder.encode("shipping_id_a1", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.address_1_xx][nm.what_item].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("shipping_id_city", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.address_2_xx][nm.what_item].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("shipping_id_state", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.address_3_xx][nm.what_item].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("shipping_id_zip", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.address_4_xx][nm.what_item].replace("'",""), "UTF-8");

			    System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][62][0]) ][nm.what_item].replace("'",""));
			    System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][63][0]) ][nm.what_item].replace("'",""));
			    System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][64][0]) ][nm.what_item].replace("'",""));
			    System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][65][0]) ][nm.what_item].replace("'",""));
			    System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][66][0]) ][nm.what_item].replace("'",""));

			    data += "&" + URLEncoder.encode("store_idx", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[5][0][ Integer.parseInt(nm.carbon[2][ nm.transaction_id_xx ][nm.what_item]) ].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("shipping_company", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ nm.shipping_company_xx ][nm.what_item].replace("'",""), "UTF-8");
			    data += "&" + URLEncoder.encode("sale_id", "UTF-8")           + "=" + URLEncoder.encode(nm.carbon[2][ nm.sale_id_xx ][nm.what_item], "UTF-8");

			    data += "&" + URLEncoder.encode("item_fees_paypal", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][ nm.paypal_fees_xx ][nm.what_item], "UTF-8");
			    data += "&" + URLEncoder.encode("item_fees_ebay", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[2][ nm.final_value_fee_xx ][nm.what_item], "UTF-8");
			    data += "&" + URLEncoder.encode("item_fees_shipping", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][ nm.shipping_out_xx ][nm.what_item], "UTF-8");

			    System.out.println(nm.carbon[2][ nm.transaction_id_xx ][nm.what_item]);
			    System.out.println("idx " + nm.carbon[5][0][ Integer.parseInt(nm.carbon[2][ nm.transaction_id_xx ][nm.what_item]) ].replace("'",""));



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
					System.out.println("*" + line + "*");
					cx0 = cx0 + line;

			    }//while********************************


				if(cx0.contains("PASS") && cx0.length() < 55){System.out.println("PASS TEST 1");}
				else if(cx0.contains("NI-FAIL") && cx0.length() < 55){System.out.println("FAIL TEST 1x"); nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; error_code++; nm.carbon[2][nm.notes_xx][nm.what_item] = "Market Inventory Error!";}
				else{System.out.println("FAIL TEST 1y"); nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; error_code++; nm.carbon[2][nm.notes_xx][nm.what_item] = "Postback != PASS.";}


			    wr.close();
			    rd.close();

			}catch(Exception e){System.out.println("URL falure. EXPORT LABEL."); nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Error"; error_code++; nm.carbon[2][nm.notes_xx][nm.what_item] = "Postback != PASS.";}



		    infox2.setText(cx0);
			try{Thread.sleep(500);} catch (InterruptedException e){System.out.println("29873450928374");}


		}//if*********************************************************************************************************************************************
		else{System.out.println("DON'T SEND ORDER");}

	}//**************************************










	public void replacex(){

		System.out.println("REPLACE");

		if(nm.carbon[2][nm.address_5_xx][nm.what_item].equals("United States")){

			international = nm.carbon[4][0][46];
			mail_type = "PRIORITY";


			try{

				ix0 = Integer.parseInt(nm.carbon[5][nm.ship_not_international_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][nm.what_item]) ]);
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


		try {
	        
	        BufferedWriter out = new BufferedWriter(new FileWriter(dazzle_xml_location));

			for (int loop2 = 0; loop2 < printerx.length; loop2++){//*************************

				//System.out.println(printerx[loop2]);
				out.write(printerx[loop2]);
				out.newLine();

			}//for*******************************************************************************
			
	    out.close();

	    } catch (IOException e) {System.out.println("print fail.");}


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

		dazzle_export_label xr = new dazzle_export_label();

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