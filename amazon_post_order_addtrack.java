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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;





public class amazon_post_order_addtrack {//************************************************************************

String CONFIG_XML_NAME = "ext/amazon_shipped_template.xml";
String SUBMIT_XML_NAME = "amazon_template.xml";


static int ix10 = 0;




amazon_post_order_addtrack(int px10) {//****************************


	ix10 = px10;
	//get new file

	try {

		int bytesRead = 0;
		InputStream in = nm.class.getResourceAsStream(CONFIG_XML_NAME);
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(SUBMIT_XML_NAME));
		byte xdatax[] = new byte[10240];
		while ((bytesRead = in.read(xdatax)) != -1) {bout.write(xdatax, 0, bytesRead);}
		bout.close();
		in.close();

	} catch (IOException e) {System.out.println("ext/amazon_xml_item_add.xml"); e.printStackTrace();}



	//convert xml item for upload*

	try {


        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

        Document doc = docBuilder.parse (new File(SUBMIT_XML_NAME));

        // normalize text representation
        doc.getDocumentElement ().normalize ();
        System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());



	    String cx0_fix = nm.carbon[2][nm.sale_id_xx][ix10];

	    if (cx0_fix.substring(cx0_fix.length() -2, cx0_fix.length() -1).equals("-")) {

	    	cx0_fix = cx0_fix.substring(0, cx0_fix.length() -2);

	    }//***************************************************************************

	    System.out.println("cx0_fix" + cx0_fix);


	    NodeList list1 = doc.getElementsByTagName("AmazonOrderID");
	    Node child1 = list1.item(0);
	    child1.setTextContent(cx0_fix);
        System.out.println("data in child number 0: "+ child1.getTextContent());

	    Node child11 = list1.item(0);
	    child11.setTextContent(cx0_fix);
        System.out.println("data in child number 0: "+ child11.getTextContent());



        Calendar now = Calendar.getInstance();
	    TimeZone timeZone = now.getTimeZone();

	    int ix0 = timeZone.getRawOffset();
	    ix0 = ix0 / 3600000;
        System.out.println("Current TimeZone is : " + ix0);

	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd---HH:MM:ss");
	    String formattedDate = df.format(new Date()); 
	    formattedDate = formattedDate.replace("---","T");

	         if (ix0 < 10 && ix0 > -1) {formattedDate = formattedDate + "+0" + Integer.toString(ix0) + ":00";}
	    else if (ix0 < 13 && ix0 > 9) {formattedDate = formattedDate + "+" + Integer.toString(ix0) + ":00";}
	    else if (ix0 < 0 && ix0 > -10) {formattedDate = formattedDate + "-0" + Integer.toString(ix0).replace("-","") + ":00";}
	    else if (ix0 < -9 && ix0 > -13) {formattedDate = formattedDate + "-" + Integer.toString(ix0).replace("-","") + ":00";}
	    else {formattedDate = formattedDate + "+00:00";}

	    System.out.println("DATE " + formattedDate.toString());
	    //System.exit(0);


	    NodeList list2 = doc.getElementsByTagName("FulfillmentDate");
	    Node child2 = list2.item(0);
	    child2.setTextContent(formattedDate.toString());
        System.out.println("data in child number 0: "+ child2.getTextContent());

	    Node child22 = list2.item(0);
	    child22.setTextContent(formattedDate.toString());
        System.out.println("data in child number 0: "+ child22.getTextContent());



	    NodeList list3 = doc.getElementsByTagName("CarrierCode");
	    Node child3 = list3.item(0);
	    child3.setTextContent(nm.carbon[2][nm.shipping_company_xx][ix10]);
        System.out.println("data in child number 0: "+ child3.getTextContent());

	    Node child33 = list3.item(0);
	    child33.setTextContent(nm.carbon[2][nm.shipping_company_xx][ix10]);
        System.out.println("data in child number 0: "+ child33.getTextContent());



	    String mail_type = new String("Standard");
	    try {

	    	int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][ix10]);

	    	//ix0 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_not_international_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ]);
			ix0 = Integer.parseInt(nm.carbon[5][amazon_settings.amazon_ship_not_international_xx][id_match]);
	   		mail_type = nm.carbon[2][ix0][ix10];

	    } catch (Exception e) {System.out.println("ERROR xxx00000323023xxx"); mail_type = "Standard";}
	    System.out.println("mail_type: " + mail_type);

	    NodeList list4 = doc.getElementsByTagName("ShippingMethod");
	    Node child4 = list4.item(0);
	    child4.setTextContent(mail_type);
        System.out.println("data in child number 0: "+ child4.getTextContent());

	    Node child44 = list4.item(0);
	    child44.setTextContent(mail_type);
        System.out.println("data in child number 0: "+ child44.getTextContent());



	    NodeList list5 = doc.getElementsByTagName("ShipperTrackingNumber");
	    Node child5 = list5.item(0);
	    child5.setTextContent(nm.carbon[2][nm.tracking_number_xx][ix10]);
        System.out.println("data in child number 0: "+ child5.getTextContent());

	    Node child55 = list5.item(0);
	    child55.setTextContent(nm.carbon[2][nm.tracking_number_xx][ix10]);
        System.out.println("data in child number 0: "+ child55.getTextContent());



	    NodeList list6 = doc.getElementsByTagName("AmazonOrderItemCode");
	    Node child6 = list6.item(0);
	    child6.setTextContent(nm.carbon[2][nm.transaction_info_xx][ix10]);
        System.out.println("data in child number 0: "+ child6.getTextContent());

	    Node child66 = list6.item(0);
	    child66.setTextContent(nm.carbon[2][nm.transaction_info_xx][ix10]);
        System.out.println("data in child number 0: "+ child66.getTextContent());



	    NodeList list7 = doc.getElementsByTagName("Quantity");
	    Node child7 = list7.item(0);
	    child7.setTextContent(nm.carbon[2][nm.quantity_sold_xx][ix10]);
        System.out.println("data in child number 0: "+ child7.getTextContent());

	    Node child77 = list7.item(0);
	    child77.setTextContent(nm.carbon[2][nm.quantity_sold_xx][ix10]);
        System.out.println("data in child number 0: "+ child77.getTextContent());



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

		System.out.println("xml failed.");

        System.err.println("+============================+");
        System.err.println("|        XML Error           |");
        System.err.println("+============================+");
        System.err.println(ex.getClass());
        System.err.println(ex.getMessage());
        System.err.println("+============================+");

	}//catch





    System.out.println("Done");


	completeSale();




}//csv_loader_x1********************************************************







	public static int find_site_match(String id) {

		System.out.println("Find Site Match...");

		int id_match = -1;

		for (int loop1 = 0; loop1 < nm.carbon[5][2].length; loop1++){

			if(nm.carbon[5][nm.id_mm][loop1].equals(id)){id_match = loop1;}

		}//************************************************

		System.out.println("id_match " + id_match);

		return id_match;

	}//************************************








	public void completeSale(){

		int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][ix10]);

		//final String accessKeyId = nm.carbon[5][2][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ]; //"AKIAJJ
		//final String secretAccessKey = nm.carbon[5][3][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ]; //"ueTGIbbA1Dgv34
		//final String merchantId = nm.carbon[5][6][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ]; //"A2ISA9

		final String accessKeyId = nm.carbon[5][2][id_match];     //"AKIAJJE
		final String secretAccessKey = nm.carbon[5][3][id_match]; //"ueTGIbbA1
		final String merchantId = nm.carbon[5][6][id_match];      //"A2ISA9

		final String appName = nm.program_name;//"Alchemist";
		final String appVersion = nm.program_version;

        MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

        //config.setServiceURL("https://mws.amazonservices.com");         // US
        //config.setServiceURL(nm.carbon[5][1][nm.current_submit_item_a]);         // US
		//config.setServiceURL(nm.carbon[5][1][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ]);

		config.setServiceURL(nm.carbon[5][1][id_match]);

        config.setMaxAsyncThreads(35);

        MarketplaceWebService service = new MarketplaceWebServiceClient(accessKeyId, secretAccessKey, appName, appVersion, config);



		try {


        	SubmitFeedRequest requestOnex = new SubmitFeedRequest();

       		requestOnex.setMerchant( merchantId );

       		requestOnex.setFeedType("_POST_ORDER_FULFILLMENT_DATA_");//"_POST_PRODUCT_DATA_"

			FileInputStream xxxx = new FileInputStream("amazon_template.xml");

			String ddx = new String(computeContentMD5HeaderValue(xxxx));

        	requestOnex.setFeedContent(xxxx);

			System.out.println("DDX " + ddx);
			System.out.println("DMX " + xxxx);

       		requestOnex.setContentMD5(ddx);

        	List<SubmitFeedRequest> requests2 = new ArrayList<SubmitFeedRequest>();

        	requests2.add(requestOnex);

        	invokeSubmitFeed(service, requests2);

			xxxx.close();

			nm.carbon[2][nm.notes_xx][ix10] = "[TRACKING SENT]";

		} catch (Exception e) {System.out.println("Submit Failed upload XML file.");}



		//System.exit(0);

     
	}//***************************************









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
                System.out.println("Response request id: " + feedSubmissionInfo.getFeedSubmissionId()); 
                nm.carbon[2][nm.listing_id_xx][ix10] = feedSubmissionInfo.getFeedSubmissionId();

            } catch (Exception e) {

                if (e.getCause() instanceof MarketplaceWebServiceException) {
                    MarketplaceWebServiceException exception = MarketplaceWebServiceException.class.cast(e.getCause());
                    System.out.println("Caught Exception: " + exception.getMessage());
                    System.out.println("Response Status Code: " + exception.getStatusCode());
                    System.out.println("Error Code: " + exception.getErrorCode());
                    System.out.println("Error Type: " + exception.getErrorType());
                    System.out.println("Request ID: " + exception.getRequestId()); 
                    System.out.print("XML: " + exception.getXML());                //System.out.println(nm.carbon[2][nm.listing_id_xx][ix10]);

                } else {e.printStackTrace();}

            }//********************
        }

    }//****************************************************************************************









	public static String computeContentMD5HeaderValue( FileInputStream fis ) throws IOException, NoSuchAlgorithmException {
	
		DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance( "MD5" ));
		byte[] buffer = new byte[8192];
			
		while( dis.read( buffer ) > 0 );

		String md5Content = new String(org.apache.commons.codec.binary.Base64.encodeBase64(dis.getMessageDigest().digest()));
		fis.getChannel().position( 0 );
		return md5Content;
	
	}//*********************************************





}//last****************************************