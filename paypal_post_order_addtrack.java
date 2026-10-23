import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.RefundTransactionReq;
import urn.ebay.api.PayPalAPI.RefundTransactionRequestType;
import urn.ebay.api.PayPalAPI.RefundTransactionResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.RefundType;
import java.util.HashMap;
import java.util.Map;



public class paypal_post_order_addtrack{//************************************************************************





paypal_post_order_addtrack(){//*******************************************

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







	public void completeSale() {

		System.out.println("SEND REFUND 0001");


		// Get the ID match of the site we are using.
        int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][nm.ix10]);


		Logger logger = Logger.getLogger(this.getClass().toString());

		// ## RefundTransactionReq
		RefundTransactionReq refundTransactionReq = new RefundTransactionReq();
		RefundTransactionRequestType refundTransactionRequest = new RefundTransactionRequestType();

		// Either the `transaction ID` or the `payer ID` must be specified.
		// PayerID is unique encrypted merchant identification number
		// For setting `payerId`,
		// `refundTransactionRequest.setPayerID("A9BVYX8XCR9ZQ");`

		// Unique identifier of the transaction to be refunded.
		refundTransactionRequest.setTransactionID(nm.carbon[2][nm.transaction_info_xx][nm.what_item]);

		// Type of refund you are making. It is one of the following values:
		// 
		// * `Full` - Full refund (default).
		// * `Partial` - Partial refund.
		// * `ExternalDispute` - External dispute. (Value available since
		// version
		// 82.0)
		// * `Other` - Other type of refund. (Value available since version
		// 82.0)

		refundTransactionRequest.setRefundType(RefundType.FULL);

		// `Refund amount`, which contains
		// 
		// * `Currency Code`
		// * `Amount`
		// The amount is required if RefundType is Partial.
		// `Note:
		// If RefundType is Full, do not set the amount.`



		//BasicAmountType amount = new BasicAmountType(CurrencyCodeType.USD,"1.00");
		//refundTransactionRequest.setAmount(amount);

		refundTransactionReq.setRefundTransactionRequest(refundTransactionRequest);

		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint


		Map<String, String> customConfigurationMap = new HashMap<String, String>();
		customConfigurationMap.put("mode", "live"); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.UserName", nm.carbon[5][6][id_match]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Password", nm.carbon[5][7][id_match]); // Load the map with all mandatory parameters
		customConfigurationMap.put("acct1.Signature", nm.carbon[5][2][id_match]); // Load the map with all mandatory parameters
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


		RefundTransactionResponseType refundTransactionResponse = null;
		try {

			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			refundTransactionResponse = service.refundTransaction(refundTransactionReq);

		} catch (Exception e) {

			logger.severe("Error Message : " + e.getMessage());

		}

		// ## Accessing response parameters
		// You can access the response parameters using getter methods in
		// response object as shown below
		// ### Success values
		if (refundTransactionResponse.getAck().getValue().equalsIgnoreCase("success")) {

			// Unique transaction ID of the refund.
			logger.info("Refund Transaction ID" + refundTransactionResponse.getRefundTransactionID());


			//send_coins_api.vrefund = refundTransactionResponse.getRefundTransactionID();


		}//*****************************************************************************
		// ### Error Values
		// Access error values from error list using getter methods
		else {

			List<ErrorType> errorList = refundTransactionResponse.getErrors();
			logger.severe("API Error Message : " + errorList.get(0).getLongMessage());

		}
		

	}//refund







}//last****************************************