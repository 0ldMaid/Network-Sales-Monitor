import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.Toolkit;
import com.paypal.api.payments.*;
import com.paypal.api.payments.Payment;
import com.paypal.core.rest.QueryParameters;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.APIContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.TransactionSearchReq;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.OptionType;
import urn.ebay.apis.eBLBaseComponents.OptionTypeListType;
import urn.ebay.apis.eBLBaseComponents.PaymentItemType;
import urn.ebay.apis.eBLBaseComponents.PaymentTransactionSearchResultType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsReq;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.GetPalDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetBalanceReq;
import urn.ebay.api.PayPalAPI.GetBalanceRequestType;
import urn.ebay.api.PayPalAPI.GetBalanceResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.api.PayPalAPI.GetPalDetailsReq;
import urn.ebay.api.PayPalAPI.GetPalDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetPalDetailsResponseType;




public class paypal_import_sales extends JFrame{//************************************************************************


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

String temp0 = new String("0.01");
String temp1 = new String("0.00");
String temp2 = new String("1");
String temp3 = new String("10");
String temp4 = new String("5");
String temp5 = new String("5");
String temp6 = new String("0.00");
String temp7 = new String("0.00");
String temp8 = new String("");
String temp9 = new String("");

String custom_temp1 = new String();
String custom_temp2 = new String();
String custom_temp3 = new String();
String custom_temp4 = new String();
String custom_temp5 = new String();
String custom_temp6 = new String();
String custom_temp7 = new String();
String custom_temp8 = new String();
String custom_temp9 = new String();
String custom_temp10 = new String();
String custom_temp11 = new String();
String custom_temp12 = new String();
String custom_temp13 = new String();
String custom_temp14 = new String();
String custom_temp15 = new String();
String custom_temp16 = new String();
String custom_temp17 = new String();
String custom_temp18 = new String();
String custom_temp19 = new String();
String custom_temp20 = new String();
String custom_temp21 = new String();
String custom_temp22 = new String();
String custom_temp23 = new String();
String custom_temp24 = new String();
String custom_temp25 = new String();
String custom_temp26 = new String();
String custom_temp27 = new String();
String custom_temp28 = new String();
String custom_temp29 = new String();
String custom_temp30 = new String();
String custom_temp31 = new String();
String custom_temp32 = new String();
String custom_temp33 = new String();
String custom_temp34 = new String();
String custom_temp35 = new String();
String custom_temp36 = new String();
String custom_temp37 = new String();
String custom_temp38 = new String();
String custom_temp39 = new String();
String custom_temp40 = new String();
String custom_temp41 = new String();
String custom_temp42 = new String();
String custom_temp43 = new String();
String custom_temp44 = new String();
String custom_temp45 = new String();
String custom_temp46 = new String();
String seller_id = new String("");
String buyer_id = new String("");
String buyer_name = new String("");
String buyer_email = new String("");
String buyer_phone = new String("");
String buyer_address0 = new String("");
String buyer_address1 = new String("");
String buyer_address2 = new String("");
String buyer_address3 = new String("");
String buyer_address4 = new String("");
String buyer_address5 = new String("");
String buyer_address6 = new String("");
String sale_date = new String("");
String sale_status = new String("");
String sale_type = new String("");
String item_id = new String("");
String item_price = new String("");
String item_currency = new String("");
String item_tax = new String("");
String item_fee = new String("");
String item_note = new String("");
String item_part = new String("");
String item_title = new String("");
String item_option = new String("");






paypal_import_sales(){//****************************

	super("PayPal Import Sales");
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

	Image ximagex2 = new ImageIcon(this.getClass().getResource("images/paypal.png")).getImage();

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
	infox1.setText("PayPal transactionSearch");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("Loading...");
	infox2.setForeground(nm.whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.blackx);
	bkp.setForeground(nm.whitex);

	//bkp.add(txtModTimeFrom);
	//bkp.add(txtModTimeTo);

	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.add(bkp);


	if(!nm.run_silent){setVisible(true);}
	else{System.out.println("RUN SILENT");}



	seller_id = nm.carbon[5][3][nm.current_submit_item_a];


	//getaccountx();
	transactionSearch();

}//csv_loader_x1********************************************************








	public void getaccountx() {


		infox1.setText("PayPal getAccountDetails");


		Logger logger = Logger.getLogger(this.getClass().toString());

		// ## GetBalanceReq
		GetPalDetailsReq getPalDetailsReq = new GetPalDetailsReq();
		GetPalDetailsRequestType getPalDetailsRequestType = new GetPalDetailsRequestType();



		Map<String, String> customConfigurationMap = new HashMap<String, String>();
		customConfigurationMap.put("mode", "live"); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.UserName", nm.carbon[5][6][nm.current_submit_item_a]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Password", nm.carbon[5][7][nm.current_submit_item_a]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Signature", nm.carbon[5][2][nm.current_submit_item_a]); // Load the map with all mandatory parameters
		customConfigurationMap.put("service.Binding", "SOAP");
		customConfigurationMap.put("service.EndPoint", "https://api-3t.paypal.com/2.0");
		customConfigurationMap.put("service.RedirectURL", "https://www.paypal.com/webscr&cmd=");
		customConfigurationMap.put("service.DevCentralURL", "https://developer.paypal.com");



		PayPalAPIInterfaceServiceService service = null;
		try {

			//service = new PayPalAPIInterfaceServiceService("src/main/resources/sdk_config.properties");
			service = new PayPalAPIInterfaceServiceService(customConfigurationMap);

		} catch (Exception e) {
			logger.severe("Error Message : " + e.getMessage());
		}

		GetPalDetailsResponseType getResponse = null;
		try {
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object

			 getResponse = service.getPalDetails(getPalDetailsReq);

		} catch (Exception e) {
			logger.severe("Error Message : " + e.getMessage());
		}
		// ## Accessing response parameters
		// You can access the response parameters using getter methods in
		// response object as shown below
		// ### Success values
		if (getResponse.getAck().getValue().equalsIgnoreCase("success")) {

		
		System.out.println(getResponse.getPal());

		//System.exit(0);


		}//**********************************************************************
		// ### Error Values
		// Access error values from error list using getter methods
		else {
			List<ErrorType> errorList = getResponse.getErrors();
			logger.severe("API Error Message : " + errorList.get(0).getLongMessage());
		}
		
	}//**********************************************










	public void transactionSearch() {


		Logger logger = Logger.getLogger(this.getClass().toString());

		// ## TransactionSearchReq
		TransactionSearchReq transactionSearchReq = new TransactionSearchReq();

		// `TransactionSearchRequestType` which takes mandatory argument:
		// 
		// * `Start Date` - The earliest transaction date at which to start the
		// search.



		String datex = new String();
		int datexi = 0;

		try {

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -50);

			System.out.println(cal.get(Calendar.DATE));
			System.out.println(cal.get(Calendar.MONTH));
			System.out.println(cal.get(Calendar.YEAR));

			String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
			if(month.length() == 1){month = "0" + month;}

			String day = Integer.toString(datexi);
			if(day.length() == 1){day = "0" + day;}

			System.out.println(cal.get(Calendar.YEAR));
			System.out.println(month);
			System.out.println(cal.get(Calendar.DATE));

			datex = cal.get(Calendar.YEAR) + "-" + month + "-" + day; 

		} catch (Exception e) {System.out.println(e.getMessage());}



		System.out.println(datex + "T00:00:00+0530");
		//System.exit(0);

		TransactionSearchRequestType transactionSearchRequest = new TransactionSearchRequestType(datex + "T00:00:00+0530");
		transactionSearchReq.setTransactionSearchRequest(transactionSearchRequest);

		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint



		Map<String, String> customConfigurationMap = new HashMap<String, String>();
		customConfigurationMap.put("mode", "live"); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.UserName", nm.carbon[5][6][nm.current_submit_item_a]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Password", nm.carbon[5][7][nm.current_submit_item_a]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Signature", nm.carbon[5][2][nm.current_submit_item_a]); // Load the map with all mandatory parameters
		customConfigurationMap.put("service.Binding", "SOAP");
		customConfigurationMap.put("service.EndPoint", "https://api-3t.paypal.com/2.0");
		customConfigurationMap.put("service.RedirectURL", "https://www.paypal.com/webscr&cmd=");
		customConfigurationMap.put("service.DevCentralURL", "https://developer.paypal.com");



		PayPalAPIInterfaceServiceService service = null;
		try {

			//service = new PayPalAPIInterfaceServiceService("sdk_config.properties");
			service = new PayPalAPIInterfaceServiceService(customConfigurationMap);

		} catch (Exception e) {
			logger.severe("Error Message : " + e.getMessage());
		}


		TransactionSearchResponseType transactionSearchResponse = null;
		try {
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			transactionSearchResponse = service.transactionSearch(transactionSearchReq);
		        //TransactionSearchResponseType txnresponse = service.transactionSearch(txnreq, username);

		} catch (Exception e) {
			logger.severe("Error Message : " + e.getMessage());
		}
		// ## Accessing response parameters
		// You can access the response parameters using getter methods in
		// response object as shown below
		// ### Success values
		if (transactionSearchResponse.getAck().getValue().equalsIgnoreCase("success")) {

			// Search Results
			Iterator<PaymentTransactionSearchResultType> iterator = transactionSearchResponse.getPaymentTransactions().iterator();
			while (iterator.hasNext()) {

				PaymentTransactionSearchResultType searchResult = iterator.next();

				// Merchant's transaction ID.
				logger.info("Transaction ID : " + searchResult.getTransactionID());
				infox2.setText(searchResult.getTransactionID());

				String xgetx = "";
				xgetx = searchResult.getTransactionID();
				getTransactionDetails(xgetx);


			}//**************************

		

		}
		// ### Error Values
		// Access error values from error list using getter methods
		else {

			List<ErrorType> errorList = transactionSearchResponse.getErrors();
			logger.severe("API Error Message : " + errorList.get(0).getLongMessage());

			if (!nm.run_silent) {

				JOptionPane.showMessageDialog(null, errorList.get(0).getLongMessage());

			}//*********************

		}//***




		pullThePlug();

	}//************************************************








	public void getTransactionDetails(String xgetx) {

		infox1.setText("PayPal getTransactionDetails");

		int ixtest3 = 0;
		int ixtest4 = 0;

		try {

			//see if item is already imported in the sales db
			for (int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++) {//***************
		
				ixtest3 = 0;

				//System.out.println(xloopx2 + " " + nm.carbon[2][nm.sale_id_xx].length + " " + nm.carbon[2][nm.sale_id_xx][xloopx2]);
				ixtest4 = xgetx.indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);
				if (ixtest4 > -1 || xgetx.length() < 3) {

					ixtest3++; 
					System.out.println(" 77 " + nm.carbon[2][nm.sale_id_xx][xloopx2]); 
					break;

				}//**********************************

			}//for*****************************************************************************************
			//see if item is already imported

		} catch (Exception e) {ixtest3 = 0;}


		try {

			//see if item is already imported in the archived db
			for (int xloopx2 = 0; xloopx2 < nm.jdb_load_sales_ids.length; xloopx2++){//***************
	
				ixtest4 = 0;
				//System.out.println(xloopx2 + " " + nm.jdb_load_sales_ids[xloopx2] + " " + nm.jdb_load_sales_ids[xloopx2]);
				int ix5 = xgetx.indexOf(nm.jdb_load_sales_ids[xloopx2]);
				if (ix5 > -1 || xgetx.length() < 3) {

					ixtest4++; 
					System.out.println(" 88 " + nm.jdb_load_sales_ids[xloopx2]); 
					break;

				}//**********************************
	
			}//for*****************************************************************************************
			//see if item is already imported in the archived

		} catch (Exception e) {ixtest4 = 0;}



		System.out.println("xx working " + ixtest3 + " " + ixtest4);



		if (ixtest3 == 0 && ixtest4 == 0) {//*************************************************************ix3 == 0 && ix4 == 0

			System.out.println("working");


			Logger logger = Logger.getLogger(this.getClass().toString());

			// ## GetTransactionDetailsReq
			GetTransactionDetailsReq getTransactionDetailsReq = new GetTransactionDetailsReq();
			GetTransactionDetailsRequestType getTransactionDetailsRequest = new GetTransactionDetailsRequestType();


			getTransactionDetailsRequest.setTransactionID(xgetx);
			getTransactionDetailsReq.setGetTransactionDetailsRequest(getTransactionDetailsRequest);

			// ## Creating service wrapper object
			// Creating service wrapper object to make API call and loading
			// configuration file for your credentials and endpoint


			Map<String, String> customConfigurationMap = new HashMap<String, String>();
			customConfigurationMap.put("mode", "live"); // Load the map with all mandatory parameters
			customConfigurationMap.put("acct1.UserName", nm.carbon[5][6][nm.current_submit_item_a]); // Load the map with all mandatory parameters
			customConfigurationMap.put("acct1.Password", nm.carbon[5][7][nm.current_submit_item_a]); // Load the map with all mandatory parameters
			customConfigurationMap.put("acct1.Signature", nm.carbon[5][2][nm.current_submit_item_a]); // Load the map with all mandatory parameters
			customConfigurationMap.put("service.Binding", "SOAP");
			customConfigurationMap.put("service.EndPoint", "https://api-3t.paypal.com/2.0");
			customConfigurationMap.put("service.RedirectURL", "https://www.paypal.com/webscr&cmd=");
			customConfigurationMap.put("service.DevCentralURL", "https://developer.paypal.com");


			PayPalAPIInterfaceServiceService service = null;


			try{
		
				//service = new PayPalAPIInterfaceServiceService("sdk_config.properties");
				service = new PayPalAPIInterfaceServiceService(customConfigurationMap);

			} catch (Exception e) {logger.severe("Error Message : " + e.getMessage());}//**********************


			GetTransactionDetailsResponseType getTransactionDetailsResponse = null;


			try {

				// ## Making API call
				// Invoke the appropriate method corresponding to API in service
				// wrapper object
				getTransactionDetailsResponse = service.getTransactionDetails(getTransactionDetailsReq);

			} catch (Exception e) {logger.severe("Error Message : " + e.getMessage());}



			// ## Accessing response parameters
			// You can access the response parameters using getter methods in
			// response object as shown below
			// ### Success values

			if (getTransactionDetailsResponse.getAck().getValue().equalsIgnoreCase("success")){

				// Unique PayPal Customer Account identification number.
				logger.info("Payer ID:" + getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getPayerID());

		
				try { 

					buyer_id = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getPayerID().toString();

				} catch (Exception e) {buyer_id = "";}

				try {

					buyer_email = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getPayer().toString();

				} catch(Exception e) {buyer_email = "";}

				try {

					buyer_name = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getPayerName().getFirstName().toString();

				} catch (Exception e) {}

				try {

					buyer_name = buyer_name + " " + getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getPayerName().getLastName().toString();

				} catch (Exception e) {buyer_name = "";}

				try {

					buyer_phone = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getContactPhone().toString();

				} catch (Exception e) {buyer_phone = "";}

				try {

					buyer_address0 = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getAddress().getStreet1();

				} catch (Exception e) {System.out.println("");}

				try {

					buyer_address1 = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getAddress().getStreet2();

				} catch (Exception e) {System.out.println("");}

				try {

					buyer_address2 = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getAddress().getCityName();

				} catch (Exception e) {System.out.println("");}


				try {

					buyer_address3 = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getAddress().getStateOrProvince();

				} catch (Exception e) {System.out.println("");}

				try {

					buyer_address4 = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getAddress().getPostalCode();

				} catch (Exception e) {System.out.println("");}

				try {

					buyer_address5 = getTransactionDetailsResponse.getPaymentTransactionDetails().getPayerInfo().getPayerCountry().getValue();

				} catch (Exception e) {System.out.println("");}
		

				item_price = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().getGrossAmount().getValue().toString();
				item_currency = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().getGrossAmount().getCurrencyID().toString();


				try {

					item_tax = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().getTaxAmount().getValue().toString();

				} catch (Exception e) {item_tax = "0.00";}

				try {

					item_fee = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().getFeeAmount().getValue().toString();

				} catch (Exception e) {item_fee = "0.00";}

				try {

					sale_date = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().getPaymentDate().toString(); 
					sale_date = sale_date.replace("T","-").replace("Z",".1");

				} catch (Exception e) {sale_date = "XXX";}

				try {

					sale_status = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().getPaymentStatus().getValue();

				} catch (Exception e) {}

				try {

					sale_type = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentInfo().toString();

				} catch (Exception e) {}

				try { 

					item_note = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentItemInfo().getMemo();

				} catch (Exception e) {}

				List<PaymentItemType> paymentItem = new ArrayList<PaymentItemType>();
				try { 

					paymentItem = getTransactionDetailsResponse.getPaymentTransactionDetails().getPaymentItemInfo().getPaymentItem();

				} catch (Exception e) {}

				//try{item_part = Integer.toString(paymentItem.size());}catch(Exception e){}

				try {

					item_part = paymentItem.get(0).getNumber();

				} catch (Exception e) {}

				try {

					item_title = paymentItem.get(0).getName();

				} catch (Exception e) {}

				List<OptionType> options = new ArrayList<OptionType>();
				try {

					options = paymentItem.get(0).getOptions();

				} catch (Exception e) {}

				System.out.println(Integer.toString(options.size()));



				//item_option = options.get(0).getName().length();
				//options.get(0).setName("xxx");
				//System.out.println("XX " + options.get(0).getName());
				//System.out.println("XX " + options.get(0).getValue());


				//System.exit(0);



				System.out.println(seller_id);
				System.out.println(buyer_id);


				if (sale_status.equals("Completed") && !seller_id.equals(buyer_id)) {

					if (item_part != null && !item_price.contains("-")) {

						insert_to_db(xgetx);

					}//************************************************

				}//****************************************************************


			}//if*******************************************************************************
			// ### Error Values
			// Access error values from error list using getter methods
		
			else {

				List<ErrorType> errorList = getTransactionDetailsResponse.getErrors();
				logger.severe("API Error Message : " + errorList.get(0).getLongMessage());

			}//**

		}//*************************************************************************************ix3 == 0 && ix4 == 0

	}//get 






	public void insert_to_db(String xgetx) {//*********************************************************************************************************************



		/**

		String[][] carbonfiber = nm.carbon[2];

		nm.carbon[2] = new String[nm.db_cc_number][(carbonfiber[0].length + 1)];


		int ix6 = 1;

		try {//***********************************************

			for (int xloopx1 = 1; xloopx1 < (nm.carbon[2][0].length); xloopx1++) {//***************

				for (int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++) {//***************

					nm.carbon[2][xloopx2][xloopx1] = carbonfiber[xloopx2][ix6];
					//System.out.println("xx " + xloopx1 + " " + nm.carbon[2][xloopx2][xloopx1]);

				}//*************************************************************************

				ix6++;

			}//**********************************************************************************

		} catch (Exception e) {System.out.println("FFFFFF LOOP");}

		**/


		

		//match db items


		for (int xloopx1 = 0; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************

			if (item_part.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

				//quantity
				try {

					nm.carbon[0][nm.total_on_hand_xx][xloopx1] = Integer.toString( Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx1]) - 1 );

				} catch (Exception e) {System.out.println("Quantity update failed.");}


				temp1 = nm.carbon[0][nm.item_cost_xx][xloopx1];
				temp2 = nm.carbon[0][nm.item_weight_xx][xloopx1];
				temp3 = nm.carbon[0][nm.package_d_xx][xloopx1];
				temp4 = nm.carbon[0][nm.package_l_xx][xloopx1];
				temp5 = nm.carbon[0][nm.package_w_xx][xloopx1];
				temp6 = nm.carbon[0][nm.shipping_out_xx][xloopx1];

				temp9 = nm.carbon[0][nm.shipping_company_xx][xloopx1];

				custom_temp1 = nm.carbon[0][nm.custom_1_xx][xloopx1];
				custom_temp2 = nm.carbon[0][nm.custom_2_xx][xloopx1];
				custom_temp3 = nm.carbon[0][nm.custom_3_xx][xloopx1];
				custom_temp4 = nm.carbon[0][nm.custom_4_xx][xloopx1];
				custom_temp5 = nm.carbon[0][nm.custom_5_xx][xloopx1];
				custom_temp6 = nm.carbon[0][nm.custom_6_xx][xloopx1];
				custom_temp7 = nm.carbon[0][nm.custom_7_xx][xloopx1];
				custom_temp8 = nm.carbon[0][nm.custom_8_xx][xloopx1];
				custom_temp9 = nm.carbon[0][nm.custom_9_xx][xloopx1];
				custom_temp10 = nm.carbon[0][nm.custom_10_xx][xloopx1];
				custom_temp11 = nm.carbon[0][nm.custom_11_xx][xloopx1];
				custom_temp12 = nm.carbon[0][nm.custom_12_xx][xloopx1];
				custom_temp13 = nm.carbon[0][nm.custom_13_xx][xloopx1];
				custom_temp14 = nm.carbon[0][nm.custom_14_xx][xloopx1];
				custom_temp15 = nm.carbon[0][nm.custom_15_xx][xloopx1];
				custom_temp16 = nm.carbon[0][nm.custom_16_xx][xloopx1];
				custom_temp17 = nm.carbon[0][nm.custom_17_xx][xloopx1];
				custom_temp18 = nm.carbon[0][nm.custom_18_xx][xloopx1];
				custom_temp19 = nm.carbon[0][nm.custom_19_xx][xloopx1];
				custom_temp20 = nm.carbon[0][nm.custom_20_xx][xloopx1];
				custom_temp21 = nm.carbon[0][nm.custom_21_xx][xloopx1];
				custom_temp22 = nm.carbon[0][nm.custom_22_xx][xloopx1];
				custom_temp23 = nm.carbon[0][nm.custom_23_xx][xloopx1];
				custom_temp24 = nm.carbon[0][nm.custom_24_xx][xloopx1];
				custom_temp25 = nm.carbon[0][nm.custom_25_xx][xloopx1];
				custom_temp26 = nm.carbon[0][nm.custom_26_xx][xloopx1];
				custom_temp27 = nm.carbon[0][nm.custom_27_xx][xloopx1];
				custom_temp28 = nm.carbon[0][nm.custom_28_xx][xloopx1];
				custom_temp29 = nm.carbon[0][nm.custom_29_xx][xloopx1];
				custom_temp30 = nm.carbon[0][nm.custom_30_xx][xloopx1];
				custom_temp31 = nm.carbon[0][nm.custom_31_xx][xloopx1];
				custom_temp32 = nm.carbon[0][nm.custom_32_xx][xloopx1];
				custom_temp33 = nm.carbon[0][nm.custom_33_xx][xloopx1];
				custom_temp34 = nm.carbon[0][nm.custom_34_xx][xloopx1];
				custom_temp35 = nm.carbon[0][nm.custom_35_xx][xloopx1];
				custom_temp36 = nm.carbon[0][nm.custom_36_xx][xloopx1];
				custom_temp37 = nm.carbon[0][nm.custom_37_xx][xloopx1];
				custom_temp38 = nm.carbon[0][nm.custom_38_xx][xloopx1];
				custom_temp39 = nm.carbon[0][nm.custom_39_xx][xloopx1];
				custom_temp40 = nm.carbon[0][nm.custom_40_xx][xloopx1];
				custom_temp41 = nm.carbon[0][nm.custom_41_xx][xloopx1];
				custom_temp42 = nm.carbon[0][nm.custom_42_xx][xloopx1];
				custom_temp43 = nm.carbon[0][nm.custom_43_xx][xloopx1];
				custom_temp44 = nm.carbon[0][nm.custom_44_xx][xloopx1];
				custom_temp45 = nm.carbon[0][nm.custom_45_xx][xloopx1];
				custom_temp46 = nm.carbon[0][nm.custom_46_xx][xloopx1];


				//passx_listing_id[0] = nm.carbon[0][nm.listing_id_xx][xloopx1];
				break;

			}//*****************************************************************************************************
			else{

				temp0 = "0.01";
				temp1 = "0.00";
				temp2 = "1";
				temp3 = "10";
				temp4 = "5";
				temp5 = "5";
				temp6 = "0.00";

			}//**

		}//**********************************************************************************



		//add the new item
		//quantity more cost more
		try {

			temp0 = item_price;//passx_price
			//temp1 = Float.toString(0.0f);//price * quantity
			temp7 = item_fee;//fees


			int ix0 = temp7.indexOf(".");

			if (ix0 > -1) {

				String cx0 = temp7.substring(0, ix0);
				String cx1 = temp7.substring(ix0, temp7.length());

				if (cx1.length() > 3) {

					temp7 = cx0 + temp7.substring(ix0, ix0 + 3);

				}//********************

			}//**********

		} catch (Exception e) {System.out.println("Q M P M"); temp0 = "0.02"; temp1 = "0.02";}


		try {


			if (buyer_address1 == null) {

				nm.carbon[2][0][0] = new String("" + buyer_address0);

			}//**************************
			else {

				nm.carbon[2][0][0] = new String("" + buyer_address0 + " " + buyer_address1);

			}//***


			//nm.carbon[2][0] [1] = new String("" + buyer_address1);//address1
			nm.carbon[2][1] [0] = new String("" + buyer_address2);//address2
			nm.carbon[2][2] [0] = new String("" + buyer_address3);//address3
			nm.carbon[2][3] [0] = new String("" + buyer_address4);//address4
			nm.carbon[2][4] [0] = new String("" + buyer_address5);//address5
			nm.carbon[2][5] [0] = new String("" + buyer_address6);//address6
			nm.carbon[2][6] [0] = new String("" + buyer_id);//buyer_id
			nm.carbon[2][7] [0] = new String("" + buyer_email);//buyers_email
			nm.carbon[2][8] [0] = new String("" + buyer_name);//buyers_first_name
			nm.carbon[2][9] [0] = new String("");//buyers_last_name
			nm.carbon[2][10][0] = new String("" + item_note);//buyers_notes
			nm.carbon[2][11][0] = new String("" + buyer_phone);//buyers_phone
			nm.carbon[2][12][0] = new String(item_currency);//currency
			nm.carbon[2][13][0] = new String(custom_temp1);
			nm.carbon[2][14][0] = new String(custom_temp2);
			nm.carbon[2][15][0] = new String(custom_temp3);
			nm.carbon[2][16][0] = new String(custom_temp4);
			nm.carbon[2][17][0] = new String(custom_temp5);
			nm.carbon[2][18][0] = new String(custom_temp6);
			nm.carbon[2][19][0] = new String(custom_temp7);
			nm.carbon[2][20][0] = new String(custom_temp8);
			nm.carbon[2][21][0] = new String(custom_temp9);
			nm.carbon[2][22][0] = new String(custom_temp10);
			nm.carbon[2][23][0] = new String(custom_temp11);
			nm.carbon[2][24][0] = new String(custom_temp12);
			nm.carbon[2][25][0] = new String(custom_temp13);
			nm.carbon[2][26][0] = new String(custom_temp14);
			nm.carbon[2][27][0] = new String(custom_temp15);
			nm.carbon[2][28][0] = new String(custom_temp16);
			nm.carbon[2][29][0] = new String(custom_temp17);
			nm.carbon[2][30][0] = new String(custom_temp18);
			nm.carbon[2][31][0] = new String(custom_temp19);
			nm.carbon[2][32][0] = new String(custom_temp20);
			nm.carbon[2][33][0] = new String(custom_temp21);
			nm.carbon[2][34][0] = new String(custom_temp22);
			nm.carbon[2][35][0] = new String(custom_temp23);
			nm.carbon[2][36][0] = new String(custom_temp24);
			nm.carbon[2][37][0] = new String(custom_temp25);
			nm.carbon[2][38][0] = new String(custom_temp26);
			nm.carbon[2][39][0] = new String(custom_temp27);
			nm.carbon[2][40][0] = new String(custom_temp28);
			nm.carbon[2][41][0] = new String(custom_temp29);
			nm.carbon[2][42][0] = new String(custom_temp30);
			nm.carbon[2][43][0] = new String(custom_temp31);
			nm.carbon[2][44][0] = new String(custom_temp32);
			nm.carbon[2][45][0] = new String(custom_temp33);
			nm.carbon[2][46][0] = new String(custom_temp34);
			nm.carbon[2][47][0] = new String(custom_temp35);
			nm.carbon[2][48][0] = new String(custom_temp36);
			nm.carbon[2][49][0] = new String(custom_temp37);
			nm.carbon[2][50][0] = new String(custom_temp38);
			nm.carbon[2][51][0] = new String(custom_temp39);
			nm.carbon[2][52][0] = new String(custom_temp40);
			nm.carbon[2][53][0] = new String(custom_temp41);
			nm.carbon[2][54][0] = new String(custom_temp42);
			nm.carbon[2][55][0] = new String(custom_temp43);
			nm.carbon[2][56][0] = new String(custom_temp44);
			nm.carbon[2][57][0] = new String(custom_temp45);
			nm.carbon[2][58][0] = new String(custom_temp46);
			nm.carbon[2][59][0] = new String("custom_template");
			nm.carbon[2][60][0] = new String("" + "");//date_last_modified
			nm.carbon[2][61][0] = new String("" + sale_date);//date_payment_received
			nm.carbon[2][62][0] = new String("");//date_shipped
			nm.carbon[2][63][0] = new String("" + sale_date);//date_sold
			nm.carbon[2][64][0] = new String("");//ebay_item
			nm.carbon[2][65][0] = new String("0.00");//final_value_fee ebay
			nm.carbon[2][66][0] = new String("0.00");//handling paypal.
			nm.carbon[2][67][0] = new String("0");//hits
			nm.carbon[2][68][0] = new String(temp1);//item_cost
			nm.carbon[2][69][0] = new String("item_description");//item_description
			nm.carbon[2][70][0] = new String("item_id");//item_id
			nm.carbon[2][71][0] = new String(temp0);//item_price trans 16
			nm.carbon[2][72][0] = new String(temp2);//item_weight
			nm.carbon[2][73][0] = new String("0.00");//listing_fees
			nm.carbon[2][74][0] = new String("" + "");//listing_id
			nm.carbon[2][75][0] = new String("" + item_option);//notes
			nm.carbon[2][76][0] = new String(temp3);//package
			nm.carbon[2][77][0] = new String(temp4);//package
			nm.carbon[2][78][0] = new String(temp5);//package
			nm.carbon[2][79][0] = new String("" + item_part);//part_number
			nm.carbon[2][80][0] = new String("PayPal");//payment_type
			nm.carbon[2][81][0] = new String(temp7);//paypal_fees
			nm.carbon[2][82][0] = new String("picture_1");//picture_1
			nm.carbon[2][83][0] = new String("1");//quantity_sold
			nm.carbon[2][84][0] = new String("" + xgetx);//sale id
			nm.carbon[2][85][0] = new String("Errorx");//sale status
			nm.carbon[2][86][0] = new String("" + item_tax);//sales_tax
			nm.carbon[2][87][0] = new String("" + temp9);//shipping_company
			nm.carbon[2][88][0] = new String("0.00");//shipping_in
			nm.carbon[2][89][0] = new String(temp6);//shipping_out
			nm.carbon[2][90][0] = new String("PayPal");//site_id
			nm.carbon[2][91][0] = new String("site_url");//site_url
			nm.carbon[2][92][0] = new String("" + nm.carbon[5][0][nm.current_submit_item_a]);//source of sale
			nm.carbon[2][93][0] = new String("" + item_title);//title
			nm.carbon[2][94][0] = new String("title_url");//title_url
			nm.carbon[2][95][0] = new String("1");//total_on_hand
			nm.carbon[2][96][0] = new String(temp0);//total_sale_amount
			nm.carbon[2][97][0] = new String(" ");//tracking number
			nm.carbon[2][98][0] = new String(nm.carbon[5][nm.id_mm][nm.current_submit_item_a]);//transaction_id Integer.toString(nm.current_submit_item_a)
			nm.carbon[2][99][0] = new String("" + xgetx);//transaction_info

		} catch (Exception e) {System.out.println("FFFFFF");}




		//only import inventoried sales.
		try {

			String xxpart = new String("");

			try {
			
				xxpart = item_part;

				if (xxpart == null) {xxpart = new String("");}

			} catch (Exception e) {xxpart = new String("");}


 			for (int xloopx1 = 0; xloopx1 < nm.carbon[0][0].length; xloopx1++) {//****************

				//System.out.println(nm.carbon[0][nm.part_number_xx][1]);
 				if (xxpart.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

 					nm.carbon[2][nm.sale_status_xx][0] = "Sold"; 
					break;

 				}//************************************************************
				else {

					nm.carbon[2][nm.sale_status_xx][0] = "Error";

				}//***

 			}//**********************************************************************************

		} catch (Exception e) {e.printStackTrace();}




		//add to database
		String[][] sale_xn = new String[ nm.carbon[2].length ][1];

		for (int xloopx = 0; xloopx < nm.carbon[2].length; xloopx++) {//****

			sale_xn[xloopx][0] = nm.carbon[2][xloopx][0];

		}//*****************************************************************

		//add to database
		jdb_new_sale saves = new jdb_new_sale(sale_xn);





	}//insert_to_db()*********************************************************************************************************************************









    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.sales_import_done = true;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull






	class BackgroundPanel extends JPanel {
	
		Image image;

		public BackgroundPanel() {
    
    		try {

     			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3g.jpg"), "background3g.jpg"));

    		} catch (Exception e) {System.out.println("Failed001");}

  		}//backgroundpanel

		protected void paintComponent(Graphics g){
    
    		super.paintComponent(g); 

   			if (image != null) {

   				g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

   			}//*****************

  		}//paint

	}//jpanel







}//last****************************************