import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.magja.model.order.Shipment;
import com.google.code.magja.model.order.ShipmentItem;
import com.google.code.magja.model.order.ShipmentTrack;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.ServiceException;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.service.order.ShipmentRemoteService;
import java.util.Properties;
import java.util.Map;
import com.google.code.magja.model.order.OrderItem;
import com.google.code.magja.model.order.Order;
import com.google.code.magja.model.order.OrderFilter;
import com.google.code.magja.model.order.OrderFilterItem;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.ServiceException;
import com.google.code.magja.service.order.OrderRemoteService;



public class magento_post_order_addtrack {//************************************************************************


int ix10 = 0;


magento_post_order_addtrack(int px10) {//******************************

	ix10 = px10;

	completeSale();

}//csv_loader_x1********************************************************






	public static int find_site_match(String id) {

		System.out.println("Find Site Match...");

		int id_match = -1;

		for (int loop1 = 0; loop1 < nm.carbon[5][2].length; loop1++) {

			if (nm.carbon[5][nm.id_mm][loop1].equals(id)) {

				id_match = loop1;

			}//********************************************

		}//************************************************************

		System.out.println("id_match " + id_match);

		return id_match;

	}//************************************







	public void completeSale() {


		try {


			// Get the ID match of the site we are using.
	        int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][ix10]);

			//nm.carbon[5][0][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ]

	   		//String user = nm.carbon[5][2][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ];
	    	//String pass = nm.carbon[5][3][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ];
	    	//String host = nm.carbon[5][1][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ];

	   		String user = nm.carbon[5][2][id_match];
	    	String pass = nm.carbon[5][3][id_match];
	    	String host = nm.carbon[5][1][id_match];


	    	//System.out.println("user " + user);
	    	//System.out.println("pass " + pass);
	    	//System.out.println("host " + host);



	    	// configure connection
	    	SoapConfig soapConfig = new SoapConfig(user, pass, host);

	    	if (soapConfig == null) {System.out.println("000033x");}


	    	System.out.println(soapConfig.getApiUser());
	    	System.out.println(soapConfig.getApiKey());
	    	System.out.println(soapConfig.getRemoteHost());


	    	//MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
	    	MagentoSoapClient magentoSoapClient = MagentoSoapClient.getInstance(soapConfig);
	    	//magentoSoapClient.setConfig(soapConfig);


			System.out.println("test1");


            OrderRemoteService servicex = new RemoteServiceFactory(magentoSoapClient).getOrderRemoteService();
            servicex.setSoapClient(magentoSoapClient);


			System.out.println(nm.carbon[2][nm.transaction_info_xx][ix10]);


	   		Order order = servicex.getById(Integer.parseInt(nm.carbon[2][nm.transaction_info_xx][ix10]));

	    	servicex.addComment(order, "Complete", "Shipped with " + nm.carbon[2][nm.shipping_company_xx][ix10] + " with ID " + nm.carbon[2][nm.tracking_number_xx][ix10], true);


			nm.carbon[2][nm.notes_xx][ix10] = "[INFO UPLOADED TO STORE]";
		


			//send email with website.


			// Construct data
			try {


    			String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[2][nm.buyers_email_xx][ix10], "UTF-8");
    			data = URLEncoder.encode("message", "UTF-8") + "=" + URLEncoder.encode("Shipped with " + nm.carbon[2][nm.shipping_company_xx][ix10] + " with ID " + nm.carbon[2][nm.tracking_number_xx][ix10], "UTF-8");
    			data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[2][magento_settings.m_shipping_user_xx][ix10], "UTF-8");
    			data = URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[2][magento_settings.m_shipping_password_xx][ix10], "UTF-8");



    			// Send data
    			URL url = new URL(nm.carbon[2][magento_settings.m_shipping_url_xx][ix10] + "/api_email_system/send_email_confirmation.php");
    			URLConnection conn = url.openConnection();
    			conn.setDoOutput(true);
    			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    			wr.write(data);
    			wr.flush();

    			// Get the response
    			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    			String line;
    			while ((line = rd.readLine()) != null){

					System.out.println(line);

   				}//************************************
    
    			wr.close();
    			rd.close();
    			//conn.close();

			} catch (Exception e) {System.out.println(e.getMessage());}


			System.out.println("Shipped Magento");


		} catch (Exception e) {e.printStackTrace(); System.out.println(e.getMessage());}


	}//***************************************








}//last****************************************