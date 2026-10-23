import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.ebay.sdk.*;
import com.ebay.sdk.pictureservice.*;
import com.ebay.soap.eBLBaseComponents.*;
import java.text.*;  
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.SdkProxySelector;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.call.GetSellerTransactionsCall;
import com.ebay.sdk.call.CompleteSaleCall;
import com.ebay.soap.eBLBaseComponents.FeedbackDetailType;
import com.ebay.soap.eBLBaseComponents.FeedbackInfoType;
import com.ebay.soap.eBLBaseComponents.CommentTypeCodeType;





public class ebay_leave_feedback extends JFrame{//************************************************************************




int what_item = 0;


ebay_leave_feedback(int what_item_x) {//****************************


	what_item = what_item_x;

	completeSale_feedback();


}//csv_loader_x1********************************************************





	public void completeSale_feedback() {

        ApiContext apiContext = new ApiContext();
        // set API Token to access eBay API Server
        ApiCredential cred = apiContext.getApiCredential();
        //Set Auth Token
        cred.seteBayToken(nm.carbon[5][2][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ]);
        //cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
        apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
        apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses

	  	System.out.println("Post feedback to ebay.");
	  	System.out.println(nm.carbon[5][ebay_settings.ebay_site_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ]);
	  	if (nm.carbon[5][ebay_settings.ebay_site_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("0")) {apiContext.setSite(SiteCodeType.US);}
	  	else {apiContext.setSite(SiteCodeType.UK); System.out.println("EBAY UK");}
          
        CompleteSaleCall completeSaleApi = new CompleteSaleCall(apiContext);
          
        completeSaleApi.setItemID(nm.carbon[2][nm.listing_id_xx][what_item]);
        completeSaleApi.setTransactionID(nm.carbon[2][nm.sale_id_xx][what_item]);
  
        FeedbackInfoType feedtype = new FeedbackInfoType();
          
	  	//feedtype.setCommentText("Top of the Line!");
	  	feedtype.setCommentText(nm.carbon[5][ebay_settings.feedback_message_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ]);
	  	feedtype.setCommentType(CommentTypeCodeType.POSITIVE);
	  	feedtype.setTargetUser(nm.carbon[2][nm.buyer_id_xx][what_item]);
          
        completeSaleApi.setFeedbackInfo(feedtype);
          

        try {completeSaleApi.completeSale();} 
	 	catch (ApiException e) { e.printStackTrace();}
	 	catch (SdkException e) { e.printStackTrace();}
	 	catch (Exception e)    { e.printStackTrace();}

		System.out.println("POSTBACK FEEDBACK eBay");
     
	}//***************************************





}//last****************************************