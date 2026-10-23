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
//import com.ebay.sdk.util.XmlUtil;

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














public class amazon_update_price extends JFrame{//************************************************************************

byte[] b;

final String accessKeyId = nm.carbon[5][2][nm.current_submit_item_a]; //"AKIAJJ
final String secretAccessKey = nm.carbon[5][3][nm.current_submit_item_a]; //"ueTGIbbA

final String merchantId = nm.carbon[5][6][nm.current_submit_item_a]; //"A2ISA


final String appName = "Alchemist";
final String appVersion = "1.4.3";



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
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
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


File st1;


String[][] carbonfiber;
String submit_x = new String("");
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;



static String ddx;



String CONFIG_XML_NAME = "amazon_template.xml";
String SUBMIT_XML_NAME = "amazon_template.xml";
String SUBMIT_FEEDTYPE = "";
int SUBMIT_NUMBER = 0;









amazon_update_price(){//****************************

	super("Amazon Upload");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	Image ximagex2 = new ImageIcon(this.getClass().getResource("images/amazon.png")).getImage();

	Icon aicon = new ImageIcon(ximagex2);

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





	ix0 = 0;
	ix3 = 0;
	for(int xloop = 0; xloop < nm.carbon[0][0].length; xloop++){

	if(nm.selected_int[xloop] == 1){ix0++; ix3++;}

	}//



	amazon_items = 0;



	infox1.setText("Submit item (" + (amazon_items +1) + " of " + ix3 + ")");
	requestFocus();

	try{

		InputStream in = nm.class.getResourceAsStream("ext/amazon_xml_price.xml");
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("amazon_template.xml"));
		byte xdatax[] = new byte[10240];
		while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}
		bout.close();
		in.close();

	}catch (IOException e){System.out.println("ext/amazon_xml_item_add.xml"); e.printStackTrace();}

	infox2.setText("Reset Price...");
	CONFIG_XML_NAME = "amazon_template.xml";
	SUBMIT_XML_NAME = "amazon_template.xml";
	SUBMIT_FEEDTYPE = "_POST_PRODUCT_PRICING_DATA_";
	build_file_price();
	submit_item();

	requestFocus();

	requestFocus();
	amazon_items++;




	if(error_code == 0){pullThePlug();}


}//csv_loader_x1********************************************************















	public void build_file_price(){


	//convert xml item for upload*

		try{


	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

	        Document doc = docBuilder.parse (new File(CONFIG_XML_NAME));

	        // normalize text representation
	        doc.getDocumentElement ().normalize ();
	        System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


		    NodeList list2 = doc.getElementsByTagName("SKU");
		    Node child2 = list2.item(0);
		    child2.setTextContent(nm.carbon[0][nm.part_number_xx][nm.what_item_amazon_update]);
	        System.out.println("data in child number 0: "+ child2.getTextContent());

		    Node child22 = list2.item(0);
		    child22.setTextContent(nm.carbon[0][nm.part_number_xx][nm.what_item_amazon_update]);
	        System.out.println("data in child number 0: "+ child22.getTextContent());



		    NodeList list3 = doc.getElementsByTagName("StandardPrice");
		    Node child3 = list3.item(0);
		    child3.setTextContent(nm.carbon[0][nm.item_price_xx][nm.what_item_amazon_update]);
	        System.out.println("data in child number 0: "+ child3.getTextContent().length());

		    Node child33 = list3.item(0);
		    child33.setTextContent(nm.carbon[0][nm.item_price_xx][nm.what_item_amazon_update]);
	        System.out.println("data in child number 0: "+ child33.getTextContent().length());




		    //NodeList list4 = doc.getElementsByTagName("Price");
		    //Node child4 = list4.item(0);
		    //child4.setTextContent(nm.carbon[0][nm.item_price_xx][nm.what_item_amazon_update]);
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


		}catch(Exception ex){

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


		try{

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
			infox2.setText("Submit Complete. Errors: " + error_code);



			xxxx.close();

		}catch(Exception e){System.out.println("Submit Failed upload XML file."); error_code++;}




	}//submit_to_aa()******************************************************************************************










	private static String removeNonUtf8CompliantCharacters( final String inString ) {

		if (null == inString ) return null;
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
                    System.out.println("Caught Exception: " + exception.getMessage());
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

		amazon_update_price xr = new amazon_update_price();

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