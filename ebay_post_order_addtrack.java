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








public class ebay_post_order_addtrack {//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int bytesRead = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;

String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String ssxs;
String ssxu;
String ssxp;






//C:\Program Files (x86)\glassfishv3\glassfish\domains\domain1\docroot\

String printerx[] = new String[0];

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
String dazzle_xml_location = new String(nm.carbon[2][nm.sale_id_xx][ix10] + ".xml");
String dazzle_export_location = new String(nm.carbon[4][0][50]);


Toolkit toolkit;
Timer xtimerx;


static int ix10 = 0;







ebay_post_order_addtrack(int px10) {//****************************

	ix10 = px10;

	completeSale();

}//csv_loader_x1**************************************************






	public static int find_site_match(String id) {

		System.out.println("Find Site Match...");

		int id_match = -1;

		for (int loop1 = 0; loop1 < nm.carbon[5][2].length; loop1++){

			if(nm.carbon[5][nm.id_mm][loop1].equals(id)){id_match = loop1;}

		}//************************************************

		System.out.println("id_match " + id_match);

		return id_match;

	}//************************************







	public static void completeSale() {

        ApiContext apiContext = new ApiContext();

        // Set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();

		// Get the ID match of the site we are using.
        int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][ix10]);

        // Set Auth Token
        //cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
        cred.seteBayToken(nm.carbon[5][2][id_match]);//Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10])
	  	System.out.println("api " + nm.carbon[5][2][id_match]);//Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10])

        //apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
        apiContext.setApiServerUrl(nm.carbon[5][1][id_match]);//Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10])
	  	System.out.println("server " + nm.carbon[5][1][id_match]);//Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10])

        apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses


	    if (nm.carbon[5][ebay_settings.ebay_site_xx][id_match].equals("1")) {

	    	apiContext.setSite(SiteCodeType.UK);

	    }//******************************************************************
        else {

        	apiContext.setSite(SiteCodeType.US);

        }//***
          

        CompleteSaleCall completeSaleApi = new CompleteSaleCall(apiContext);
          
        completeSaleApi.setItemID(nm.carbon[2][nm.listing_id_xx][ix10]);
        completeSaleApi.setTransactionID(nm.carbon[2][nm.sale_id_xx][ix10]);
        completeSaleApi.setShipped(true);

          
        ShipmentType shipType = new ShipmentType();
          
        ShipmentTrackingDetailsType shpmnt = new ShipmentTrackingDetailsType();
        shpmnt.setShipmentTrackingNumber(nm.carbon[2][nm.tracking_number_xx][ix10]);
        //shpmnt.setShippingCarrierUsed("Standard");
        shpmnt.setShippingCarrierUsed(nm.carbon[2][nm.shipping_company_xx][ix10]);
	    System.out.println(nm.carbon[5][ebay_settings.ebay_shipping_type_xx][id_match]);
        shipType.setShipmentTrackingDetails(new ShipmentTrackingDetailsType[]{shpmnt});
          
        completeSaleApi.setShipment(shipType);
          

	    nm.carbon[2][nm.notes_xx][ix10] = "[TRACKING SENT]";

        try {

        	completeSaleApi.completeSale();

        } catch (ApiException e) {

        	e.printStackTrace(); 
        	nm.carbon[2][nm.notes_xx][ix10] = e.getMessage(); 
        	nm.carbon[2][nm.sale_status_xx][ix10] = "Error";

        } catch (SdkException e){

        	e.printStackTrace(); 
        	nm.carbon[2][nm.notes_xx][ix10] = e.getMessage(); 
        	nm.carbon[2][nm.sale_status_xx][ix10] = "Error";

        } catch (Exception e) {

        	e.printStackTrace(); 
        	nm.carbon[2][nm.notes_xx][ix10] = e.getMessage(); 
        	nm.carbon[2][nm.sale_status_xx][ix10] = "Error";

        }//********************

		System.out.println("POSTBACK TRACKING eBay");

     
	}//***************************************






}//last****************************************