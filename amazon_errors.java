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


public class amazon_errors{

    static int error_code = 0;

    static String cx2 = new String();


    amazon_errors(){//****************************

        submit_item();

    }//csv_loader_x1******************************




    public static int find_site_match(String id) {

        System.out.println("Find Site Match...");

        int id_match = -1;

        for (int loop1 = 0; loop1 < nm.carbon[5][2].length; loop1++){

            if (nm.carbon[5][nm.id_mm][loop1].equals(id)) {

                id_match = loop1;

            }

        }//************************************************

        System.out.println("id_match " + id_match);

        return id_match;

    }//************************************




    public void submit_item() {

        //int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][nm.ix10]);
        int id_match = -1;

    	final String accessKeyId = nm.carbon[5][2][id_match]; //
    	final String secretAccessKey = nm.carbon[5][3][id_match]; //
    	final String merchantId = nm.carbon[5][6][id_match]; //

    	final String appName = "Alchemist";
    	final String appVersion = "1.4.3";

        MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

        config.setServiceURL(nm.carbon[5][1][id_match]);         // US

        config.setMaxAsyncThreads(35);

        MarketplaceWebService service = new MarketplaceWebServiceClient(accessKeyId, secretAccessKey, appName, appVersion, config);

    	try {


            GetFeedSubmissionResultRequest requestb = new GetFeedSubmissionResultRequest();
            requestb.setMerchant( merchantId );

            requestb.setFeedSubmissionId(nm.carbon[nm.db_number][nm.listing_id_xx][nm.what_item]);
            //requestb.setFeedSubmissionId("4607714052");

    	    System.out.println(nm.carbon[nm.db_number][nm.listing_id_xx][nm.what_item]);

            OutputStream processingResult = new FileOutputStream("feedSubmissionResult.xml");
            requestb.setFeedSubmissionResultOutputStream(processingResult);

    	    cx2 = processingResult.toString();

            invokeGetFeedSubmissionResult(service, requestb);


    	    processingResult.close();


    	} catch (Exception e) {System.out.println("Submit Failed upload XML file."); error_code++;}


    	System.out.println(cx2);
    	JOptionPane.showMessageDialog(null, "Export to: feedSubmissionResult.xml");

    }//submit_to_aa()******************************************************************************************




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

    }//**************************************************************************************************




    public static void invokeGetFeedSubmissionResult(MarketplaceWebService service, GetFeedSubmissionResultRequest request) {

        try {

            GetFeedSubmissionResultResponse response = service.getFeedSubmissionResult(request);


            System.out.println ("GetFeedSubmissionResult Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    GetFeedSubmissionResultResponse");
            System.out.println();
            System.out.print("    GetFeedSubmissionResultResult");
            System.out.println();
            System.out.print("            MD5Checksum");
            System.out.println();
            System.out.print("                " + response.getGetFeedSubmissionResultResult().getMD5Checksum());
            System.out.println();
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

            System.out.println("Feed Processing Result");
            System.out.println ("=============================================================================");
            System.out.println();
            System.out.println( request.getFeedSubmissionResultOutputStream().toString() );
            System.out.println();

        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML()); JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//*****************************************************************************************************




    public static void main(){

	   amazon_errors xr = new amazon_errors();

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