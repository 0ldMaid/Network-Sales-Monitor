import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import com.paypal.api.payments.*;
import com.paypal.api.payments.Payment;
import com.paypal.core.rest.QueryParameters;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.APIContext;
import java.util.HashMap;
import java.util.Map;
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
import urn.ebay.apis.eBLBaseComponents.PaymentTransactionSearchResultType;




public class paypal_test{//************************************************************************







paypal_test(){//****************************

	System.out.println(nm.carbon[5][2][nm.what_item]);
	//connectx();
	transactionSearch();

}//csv_loader_x1********************************************************









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

		}catch(Exception e) {System.out.println(e.getMessage());}



		System.out.println(datex + "T00:00:00+0530");
		//System.exit(0);

		TransactionSearchRequestType transactionSearchRequest = new TransactionSearchRequestType(datex + "T00:00:00+0530");
		transactionSearchReq.setTransactionSearchRequest(transactionSearchRequest);

		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint



		Map<String, String> customConfigurationMap = new HashMap<String, String>();
		customConfigurationMap.put("mode", "live"); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.UserName", nm.carbon[5][6][nm.what_item]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Password", nm.carbon[5][7][nm.what_item]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Signature", nm.carbon[5][2][nm.what_item]); // Load the map with all mandatory parameters
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
		}//********************


		TransactionSearchResponseType transactionSearchResponse = null;
		try {
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			transactionSearchResponse = service.transactionSearch(transactionSearchReq);
		        //TransactionSearchResponseType txnresponse = service.transactionSearch(txnreq, username);

		} catch (Exception e) {
			logger.severe("Error Message : " + e.getMessage());
		}//********************
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


			}//**************************

		nm.pass_com = "1";

		}//*******************************************************************************
		// ### Error Values
		// Access error values from error list using getter methods
		else {

			List<ErrorType> errorList = transactionSearchResponse.getErrors();
			logger.severe("API Error Message : " + errorList.get(0).getLongMessage());
			JOptionPane.showMessageDialog(null, errorList.get(0).getLongMessage());

		}//***




	}//************************************************






}//last****************************************