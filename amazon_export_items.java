import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.io.*;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.ArrayList;
import com.amazonaws.mws.*;
import com.amazonaws.mws.model.*;
import java.util.concurrent.Future;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import com.ebay.sdk.util.XmlUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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








public class amazon_export_items extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


final String accessKeyId = nm.carbon[5][2][nm.current_submit_item_a]; 
final String secretAccessKey = nm.carbon[5][3][nm.current_submit_item_a];
final String merchantId = nm.carbon[5][6][nm.current_submit_item_a]; 
final String appName = "Alchemist";
final String appVersion = "1.4.3";

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

static int error_code = 0;
int bytesRead = 0;
int csv_passes_x = 17;
int amazon_items = 0;//number of new items to submit. 
int csv_int = 0;
int working = 1; 
int thisc2 = 0; 
int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int ix4 = 0;
int ix0x = 0;
int ix1x = 0; 
int ix2x = 0;
int stop = 0;
int post_number = 1;
int what_item_here = 0;
int SUBMIT_NUMBER = 0;

static String ddx;
static String error_code_message = new String("");
static String cx2 = new String("");
String[][] carbonfiber;
String submit_x = new String("");
String xlinex = new String("");
String blank = new String("");
String cx0 = new String("");
String cx1 = new String("");
String cx3 = new String("");
String CONFIG_XML_NAME = "amazon_template.xml";
String SUBMIT_XML_NAME = "amazon_template.xml";
String SUBMIT_FEEDTYPE = "";










amazon_export_items(){//****************************

	super("Amazon Upload");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setDefaultLookAndFeelDecorated(false);
	setUndecorated(true);


    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1;}});

	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	Image ximagex2 = new ImageIcon(this.getClass().getResource("images/amazon.png")).getImage();

	Icon aicon = new ImageIcon(ximagex2);

	infox0.setPreferredSize(new Dimension(320, 80));
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



	setVisible(true);





	ix0 = 0;
	ix3 = 0;
	for (int xloop = 0; xloop < nm.carbon[0][0].length; xloop++) {

		if (nm.selected_int[xloop] == 1) {ix0++; ix3++;}

	}//***********************************************************


	error_code = 0;
	amazon_items = 0;

	for (int xloop = 0; xloop < nm.carbon[0][0].length; xloop++) {//*****************************************

		if (nm.selected_int[xloop] == 1) {

			SUBMIT_NUMBER = xloop;

			infox1.setText("Submit item (" + (amazon_items +1) + " of " + ix3 + ")");
			requestFocus();

			try {

				InputStream in = nm.class.getResourceAsStream("ext/amazon_xml_item_add.xml");
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("amazon_template.xml"));
				byte xdatax[] = new byte[10240];
				while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}
				bout.close();
				in.close();

			} catch (IOException e) {System.out.println("ext/amazon_xml_item_add.xml"); e.printStackTrace();}

			infox2.setText("Build Upload files...");
			CONFIG_XML_NAME = "amazon_template.xml";
			SUBMIT_XML_NAME = "amazon_template.xml";
			SUBMIT_FEEDTYPE = "_POST_PRODUCT_DATA_";
			build_file_item();
			submit_item();

			nm.carbon[0][nm.listing_id_xx][xloop] = cx2;
			requestFocus();

			try {Thread.sleep(500);} catch(InterruptedException e){System.out.println("import black failed 000331");}


			try {

				System.out.println(nm.carbon[5][1][nm.current_submit_item_a]);
				InputStream in;
				if(nm.carbon[5][1][nm.current_submit_item_a].equals("https://mws.amazonservices.co.uk")){in = nm.class.getResourceAsStream("ext/amazon_xml_price_UK.xml");}
				else{in = nm.class.getResourceAsStream("ext/amazon_xml_price_US.xml");}
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("amazon_template.xml"));
				byte xdatax[] = new byte[10240];
				while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}
				bout.close();
				in.close();

			} catch (IOException e) {System.out.println("ext/amazon_xml_item_add.xml"); e.printStackTrace();}

			infox2.setText("Reset Price...");
			CONFIG_XML_NAME = "amazon_template.xml";
			SUBMIT_XML_NAME = "amazon_template.xml";
			SUBMIT_FEEDTYPE = "_POST_PRODUCT_PRICING_DATA_";
			build_file_price();
			submit_item();

			requestFocus();


			try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println("import black failed 000331");}


			try {

				InputStream in = nm.class.getResourceAsStream("ext/amazon_xml_quantity.xml");
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("amazon_template.xml"));
				byte xdatax[] = new byte[10240];
				while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}
				bout.close();
				in.close();

			} catch (IOException e) {System.out.println("ext/amazon_xml_item_add.xml"); e.printStackTrace();}

			infox2.setText("Reset Quantity...");
			CONFIG_XML_NAME = "amazon_template.xml";
			SUBMIT_XML_NAME = "amazon_template.xml";
			SUBMIT_FEEDTYPE = "_POST_INVENTORY_AVAILABILITY_DATA_";
			build_file_quantity();
			submit_item();

			requestFocus();


			try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println("import black failed 000331");}


			//try{
			//InputStream in = nm.class.getResourceAsStream("ext/amazon_xml_image.xml");
			//BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("amazon_template.xml"));
			//byte xdatax[] = new byte[10240];
			//while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}
			//bout.close();
			//in.close();
			//}catch (IOException e){System.out.println("ext/amazon_xml_item_add.xml"); e.printStackTrace();}

			//infox2.setText("Build Image File...");
			//CONFIG_XML_NAME = "amazon_template.xml";
			//SUBMIT_XML_NAME = "amazon_template.xml";
			//SUBMIT_FEEDTYPE = "_POST_PRODUCT_IMAGE_DATA_";
			//build_file_image();
			//submit_item();

			requestFocus();
			amazon_items++;



			if (nm.total_items_selected > 5) {
				
				infox2.setText("Wait 5 Mins for AMAZON throttle...");
				try{Thread.sleep(320000);}
				catch(InterruptedException e){System.out.println("import black failed 000331");}

			}//****************************
			else if (nm.total_items_selected > 1) {

				infox2.setText("Wait 60sec for AMAZON throttle...");
				try{Thread.sleep(60000);}
				catch(InterruptedException e){System.out.println("import black failed 000331");}

			}//if**************************
			else{}


		}//**************************

	}//*******************************************************




	if(error_code == 0){pullThePlug();}


}//csv_loader_x1********************************************************













	public void build_file_item() {


	//convert xml item for upload*

		try {


	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

	        Document doc = docBuilder.parse (new File(CONFIG_XML_NAME));

	        // normalize text representation
	        doc.getDocumentElement ().normalize ();
	        System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


		    NodeList list1 = doc.getElementsByTagName("Title");
		    Node child1 = list1.item(0);
		    child1.setTextContent(nm.carbon[0][nm.title_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child1.getTextContent());


		    NodeList list2 = doc.getElementsByTagName("SKU");
		    Node child2 = list2.item(0);
		    child2.setTextContent(nm.carbon[0][nm.part_number_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child2.getTextContent());


		    ix0 = Integer.parseInt(nm.carbon[5][amazon_settings.match_type_xx][nm.current_submit_item_a]);
		    System.out.println(ix0 + " " + amazon_settings.amazon_match_type[ix0]);
		    NodeList list3 = doc.getElementsByTagName("Type");
		    Node child3 = list3.item(0);
		    child3.setTextContent(amazon_settings.amazon_match_type[ix0]);
	        System.out.println("data in child number d0: "+ child3.getTextContent());


		    ix1 = Integer.parseInt(nm.carbon[5][amazon_settings.match_column_xx][nm.current_submit_item_a]);
		    System.out.println(ix1);
		    NodeList list4 = doc.getElementsByTagName("Value");
		    Node child4 = list4.item(0);
		    child4.setTextContent(nm.carbon[0][ix1][SUBMIT_NUMBER]);
	        System.out.println("data in child number x0: "+ child4.getTextContent());

		    if(nm.carbon[0][ix1][SUBMIT_NUMBER].length() < 9 || nm.carbon[0][ix1][SUBMIT_NUMBER].length() > 11){JOptionPane.showMessageDialog(null,"This may not be and ASIN: " + nm.carbon[0][ix1][SUBMIT_NUMBER]);}

		    //NodeList list5 = doc.getElementsByTagName("Length");
		    //Node child5 = list5.item(0);
		    //child5.setTextContent(nm.carbon[0][nm.package_d_xx][SUBMIT_NUMBER]);
	        //System.out.println("data in child number 0: "+ child5.getTextContent());


		    //NodeList list6 = doc.getElementsByTagName("Width");
		    //Node child6 = list6.item(0);
		    //child6.setTextContent(nm.carbon[0][nm.package_l_xx][SUBMIT_NUMBER]);
	        //System.out.println("data in child number 0: "+ child6.getTextContent());


		    //NodeList list7 = doc.getElementsByTagName("Height");
		    //Node child7 = list7.item(0);
		    //child7.setTextContent(nm.carbon[0][nm.package_w_xx][SUBMIT_NUMBER]);
	        //System.out.println("data in child number 0: "+ child5.getTextContent());


		    //NodeList list8 = doc.getElementsByTagName("BulletPoint");
		    //Node child8 = list8.item(0);
		    //child8.setTextContent(nm.carbon[0][nm.title_xx][SUBMIT_NUMBER]);
	        //System.out.println("data in child number 0: "+ child8.getTextContent());




		    DOMSource source = new DOMSource(doc);

	        PrintStream ps = new PrintStream(SUBMIT_XML_NAME);
	        StreamResult result = new StreamResult(ps);

	        // Once again we are using a factory of some sort,
	        // this time for getting a Transformer instance,
	        // which we use to output the XML
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();

	        // The actual output to a file goes here
	        transformer.transform(source, result);

		    ps.close();


		} catch (Exception ex) {

		System.out.println("xml failed."); infox2.setText("xml failed.");

	        System.err.println("+============================+");
	        System.err.println("|        XML Error           |");
	        System.err.println("+============================+");
	        System.err.println(ex.getClass());
	        System.err.println(ex.getMessage());
	        System.err.println("+============================+");

		}//catch



        System.out.println("Done");


	}//*************************build_file













	public void build_file_price() {


	//convert xml item for upload*

		try {


	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

	        Document doc = docBuilder.parse (new File(CONFIG_XML_NAME));

	        // normalize text representation
	        doc.getDocumentElement ().normalize ();
	        System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


		    NodeList list2 = doc.getElementsByTagName("SKU");
		    Node child2 = list2.item(0);
		    child2.setTextContent(nm.carbon[0][nm.part_number_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child2.getTextContent());

		    Node child22 = list2.item(0);
		    child22.setTextContent(nm.carbon[0][nm.part_number_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child22.getTextContent());



		    NodeList list3 = doc.getElementsByTagName("StandardPrice");
		    Node child3 = list3.item(0);
		    child3.setTextContent(nm.carbon[0][nm.item_price_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child3.getTextContent().length());

		    Node child33 = list3.item(0);
		    child33.setTextContent(nm.carbon[0][nm.item_price_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child33.getTextContent().length());




		    //NodeList list4 = doc.getElementsByTagName("Price");
		    //Node child4 = list4.item(0);
		    //child4.setTextContent(nm.carbon[0][nm.item_price_xx][SUBMIT_NUMBER]);
	        //System.out.println("data in child number 0: "+ child4.getTextContent());




		    DOMSource source = new DOMSource(doc);

	        PrintStream ps = new PrintStream(SUBMIT_XML_NAME);
	        StreamResult result = new StreamResult(ps);

	        // Once again we are using a factory of some sort,
	        // this time for getting a Transformer instance,
	        // which we use to output the XML
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();

	        // The actual output to a file goes here
	        transformer.transform(source, result);

		    ps.close();


		} catch(Exception ex) {

		System.out.println("xml failed."); infox2.setText("xml failed.");

	        System.err.println("+============================+");
	        System.err.println("|        XML Error           |");
	        System.err.println("+============================+");
	        System.err.println(ex.getClass());
	        System.err.println(ex.getMessage());
	        System.err.println("+============================+");

		}//catch



        System.out.println("Done");


	}//*************************build_file












	public void build_file_quantity() {


		//convert xml item for upload*

		try {


	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

	        Document doc = docBuilder.parse (new File(CONFIG_XML_NAME));

	        // normalize text representation
	        doc.getDocumentElement ().normalize ();
	        System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());



		    NodeList list2 = doc.getElementsByTagName("SKU");
		    Node child2 = list2.item(0);
		    child2.setTextContent(nm.carbon[0][nm.part_number_xx][SUBMIT_NUMBER]);
	        System.out.println("data in child number 0: "+ child2.getTextContent());


		    NodeList list3 = doc.getElementsByTagName("Quantity");
		    Node child3 = list3.item(0);




			//inventory control
	
			if (nm.carbon[4][0][72].equals("1")) {

				System.out.println("TEST1");

				try {

				    ix0x = Integer.parseInt(carbonfiber[95][SUBMIT_NUMBER]);
				    ix1x = Integer.parseInt(carbonfiber[nm.total_on_hand_xx][SUBMIT_NUMBER]);
				    ix2x = nm.current_submit_item_a;

					System.out.println("TEST2 " + ix0x + " " + ix1x + " " + ix2x);

				    if (ix1x > ix2x) {

						Float fx0x = (float) ix1x / ix2x;
						cx3 = Float.toString(fx0x);
						ix4 = cx3.indexOf(".");

						if (ix4 > -1) {cx3 = cx3.substring(0, ix4);}

						ix0x = Integer.parseInt(cx3);
						System.out.println(ix0x);
						//System.exit(0);

				    }//*************
				    else if (ix1x <= ix2x && ix1x != 0) {

						System.out.println("TEST4");

						if ( (ix1x - nm.current_submit_item_x) >= 0 ) {ix0x = 1;}
						else {ix0x = 0;}

				    }//********************************
				    else {ix0x = 0;}

					System.out.println("TEST5");

				    child3.setTextContent(Integer.toString(ix0x));

					System.out.println("TEST6");

				} catch (Exception e) {child3.setTextContent(nm.carbon[0][nm.total_on_hand_xx][SUBMIT_NUMBER]); System.out.println("Inventory Control fail.");}

			}//*********************************
			else {child3.setTextContent(nm.carbon[0][nm.total_on_hand_xx][SUBMIT_NUMBER]);}
			//inventory control


		    
            System.out.println("data in child number 0: "+ child3.getTextContent().length());


	   		//NodeList list4 = doc.getElementsByTagName("Price");
	    	//Node child4 = list4.item(0);
	    	//child4.setTextContent(nm.carbon[0][nm.item_price_xx][SUBMIT_NUMBER]);
            //System.out.println("data in child number 0: "+ child4.getTextContent());


	    	DOMSource source = new DOMSource(doc);

            PrintStream ps = new PrintStream(SUBMIT_XML_NAME);
            StreamResult result = new StreamResult(ps);

            // Once again we are using a factory of some sort,
            // this time for getting a Transformer instance,
            // which we use to output the XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // The actual output to a file goes here
            transformer.transform(source, result);

		    ps.close();


		} catch (Exception ex) {

		System.out.println("xml failed."); infox2.setText("xml failed.");

	        System.err.println("+============================+");
	        System.err.println("|        XML Error           |");
	        System.err.println("+============================+");
	        System.err.println(ex.getClass());
	        System.err.println(ex.getMessage());
	        System.err.println("+============================+");

		}//catch





	    System.out.println("Done");


	}//*************************build_file













	public void submit_item() {


	    MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

	    //config.setServiceURL("https://mws.amazonservices.com");         // US

	    config.setServiceURL(nm.carbon[5][1][nm.current_submit_item_a]);         // US

	    config.setMaxAsyncThreads(35);

	    MarketplaceWebService service = new MarketplaceWebServiceClient(accessKeyId, secretAccessKey, appName, appVersion, config);



		try {

	        SubmitFeedRequest requestOnex = new SubmitFeedRequest();

	        requestOnex.setMerchant( merchantId );

	        requestOnex.setFeedType(SUBMIT_FEEDTYPE);//"_POST_PRODUCT_DATA_"

			FileInputStream xxxx = new FileInputStream(SUBMIT_XML_NAME);

			ddx = new String(computeContentMD5HeaderValue(xxxx));


	        requestOnex.setFeedContent(xxxx);

			System.out.println("DDX " + ddx);
			System.out.println("DMX " + xxxx);

	        requestOnex.setContentMD5(ddx);


	        List<SubmitFeedRequest> requests2 = new ArrayList<SubmitFeedRequest>();

	        requests2.add(requestOnex);


	        invokeSubmitFeed(service, requests2);

			if(error_code == 0){infox2.setText("Submit Complete.");}
			else{infox2.setText("Errors: " + error_code_message);}

			nm.carbon[0][nm.transaction_id_xx][SUBMIT_NUMBER] = Integer.toString(nm.current_submit_item_a);

			xxxx.close();

		} catch (Exception e) {System.out.println("Submit Failed upload XML file."); infox2.setText("Connection Failed. Please try again."); error_code++;}




	}//submit_to_aa()******************************************************************************************










	private static String removeNonUtf8CompliantCharacters( final String inString ) {

		if (null == inString ){return null;}
		byte[] byteArr = inString.getBytes();

		for ( int i=0; i < byteArr.length; i++ ) {

			byte ch= byteArr[i];
			// remove any characters outside the valid UTF-8 range as well as all control characters, except tabs and new lines

			if ( !( (ch > 31 && ch < 253 ) || ch == '\t' || ch == '\n' || ch == '\r') ) {byteArr[i]=' ';}

		}//for*************************************

		return new String( byteArr );

	}//*******************************************************************************




	public static String computeContentMD5HeaderValue( FileInputStream fis ) throws IOException, NoSuchAlgorithmException {

		DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance( "MD5" ));
		byte[] buffer = new byte[8192];
		while( dis.read( buffer ) > 0 );

		String md5Content = new String(org.apache.commons.codec.binary.Base64.encodeBase64(dis.getMessageDigest().digest()));
		fis.getChannel().position( 0 );
		return md5Content;
	
	}//*********************************************








    public static void invokeSubmitFeed(MarketplaceWebService service, List<SubmitFeedRequest> requests) {

        List<Future<SubmitFeedResponse>> responses = new ArrayList<Future<SubmitFeedResponse>>();
        for (SubmitFeedRequest request : requests) {
            responses.add(service.submitFeedAsync(request));
        }
        
        for (Future<SubmitFeedResponse> future : responses) {

            while (!future.isDone()) {
                Thread.yield();
            }

            try {

                SubmitFeedResponse response = future.get();
				SubmitFeedResult  submitFeedResult = response.getSubmitFeedResult();
	        	FeedSubmissionInfo feedSubmissionInfo = submitFeedResult.getFeedSubmissionInfo();
                // Original request corresponding to this response, if needed:
                SubmitFeedRequest originalRequest = requests.get(responses.indexOf(future));
                System.out.println("Response request id: " + response.getResponseMetadata().getRequestId());
                System.out.println("Response request id: " + feedSubmissionInfo.getFeedSubmissionId()); cx2 = feedSubmissionInfo.getFeedSubmissionId();

            } catch (Exception e) {

                if (e.getCause() instanceof MarketplaceWebServiceException) {
                    MarketplaceWebServiceException exception = MarketplaceWebServiceException.class.cast(e.getCause());
                    System.out.println("Caught Exception: " + exception.getMessage()); error_code_message = exception.getMessage();
                    System.out.println("Response Status Code: " + exception.getStatusCode()); error_code = 1;
                    System.out.println("Error Code: " + exception.getErrorCode());
                    System.out.println("Error Type: " + exception.getErrorType());
                    System.out.println("Request ID: " + exception.getRequestId());
                    System.out.print("XML: " + exception.getXML());
                } else {
                    e.printStackTrace();
                }

            }
        }

    }//***********************************************************************************************












    public void pullThePlug() {

	    System.out.println("PULL THE PLUG");

	    nm.firex = 1;

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull












    public static void main(){

		amazon_export_items xr = new amazon_export_items();

    }//main






	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3w.jpg"), "background3w.jpg"));

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