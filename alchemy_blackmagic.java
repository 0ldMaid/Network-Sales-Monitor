import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import com.ebay.sdk.ApiContext; 
import com.ebay.sdk.ApiCredential; 
import com.ebay.sdk.ApiException; 
import com.ebay.sdk.SdkException; 
import com.ebay.sdk.call.ReviseInventoryStatusCall; 
import com.ebay.soap.eBLBaseComponents.AmountType; 
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType; 
import com.ebay.soap.eBLBaseComponents.InventoryStatusType; 
import com.ebay.soap.eBLBaseComponents.SiteCodeType; 
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.helper.ShippingServiceOptionTreeBuilder;
import com.ebay.sdk.helper.Utils;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BestOfferDetailsType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingEnhancementsCodeType;
import com.ebay.soap.eBLBaseComponents.ProductListingDetailsType;
import com.ebay.soap.eBLBaseComponents.ReviseStatusType;
import com.ebay.soap.eBLBaseComponents.SellerGuaranteeLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;







public class alchemy_blackmagic {





alchemy_blackmagic() {

    try {



      ApiContext apiContext = new ApiContext();
      // set API Token to access eBay API Server
      ApiCredential cred = apiContext.getApiCredential();
      //Set Auth Token
      cred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);
     
      apiContext.setApiServerUrl("https://api.ebay.com/wsapi");// Pointing to sandbox for testing.          
          
      apiContext.getApiLogging().setLogSOAPMessages(true);// This will log SOAP requests and responses

      if(nm.carbon[5][nm.ebay_site_xx][nm.current_submit_item_a].equals("0")){apiContext.setSite(SiteCodeType.US);}
      else if(nm.carbon[5][nm.ebay_site_xx][nm.current_submit_item_a].equals("1")){apiContext.setSite(SiteCodeType.UK);}
      else{apiContext.setSite(SiteCodeType.US);}   








      GetItemCall api = new GetItemCall(apiContext);

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };


      api.setDetailLevel(detailLevels);

      String itemID = "110929741671";
      itemID = itemID.trim();
      ItemType item = api.getItem(itemID);

      // Display data in GUI.
      System.out.println(item.getTitle());
      System.out.println(item.getQuantity().toString());
      System.out.println(item.getPrimaryCategory().getCategoryID());
      System.out.println((new Double(item.getSellingStatus().getCurrentPrice().getValue()).toString()));

      //AmountType amt = item.getReservePrice();
      //this.txtReservePrice.setText( amt == null ? "" : (new Double(amt.getValue()).toString()));

      //amt = item.getBuyItNowPrice();
      //txtBINPrice.setText( amt == null ? "" : (new Double(amt.getValue()).toString()));


    } catch (Exception e) {}


}//blackmagic




}//last