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
import com.ebay.sdk.call.GetMyeBaySellingCall;


public class ebay_import_stats{


private ApiContext apiContext = new ApiContext();

int what_item = 0;


public ebay_import_stats(int what_item_x) {

    System.out.println("eBay Import Stats:");

    what_item = what_item_x;

    nm.stats_hits = "n/a";
    nm.stats_running = "n/a";
    nm.stats_sales = "n/a";

    try {

        loadConfiguration();

    } catch (Exception ex) {}


    get_ebay_info();


}//*************************






    public void get_ebay_info() {


        try {


            GetMyeBaySellingCall api = new GetMyeBaySellingCall(this.apiContext);

            ItemListCustomizationType itemListType =  new ItemListCustomizationType();
            itemListType.setInclude(Boolean.TRUE);
            itemListType.setSort(ItemSortTypeCodeType.ITEM_ID_DESCENDING);

            PaginationType page = new PaginationType();
            page.setEntriesPerPage(1);
            itemListType.setPagination(page);

            //ControlTagItem ct = (ControlTagItem)this.cbxActiveSort.getSelectedItem();
            api.setActiveList(itemListType);
            api.setScheduledList(itemListType);
            api.setSoldList(itemListType);
            api.setUnsoldList(itemListType);

            api.getMyeBaySelling();

            ItemType[] tempActiveItems = null;
            if (api.getReturnedActiveList() != null) {tempActiveItems = (api.getReturnedActiveList().getItemArray()).getItem();}

            System.out.println(api.getReturnedActiveList().getPaginationResult().getTotalNumberOfEntries());

            final ItemType[] activeItems = tempActiveItems;

            nm.stats_running = Integer.toString(api.getReturnedActiveList().getPaginationResult().getTotalNumberOfEntries());

            System.out.println("nm.stats_running " + nm.stats_running);

            System.out.println("here");

            OrderTransactionType[] tempSoldItems = null;

            if (api.getReturnedSoldList() == null) {nm.stats_sales = "0";}
            else{}

            tempSoldItems = (api.getReturnedSoldList().getOrderTransactionArray()).getOrderTransaction();

            System.out.println("here2");
            final OrderTransactionType[] soldItems = tempSoldItems;
            System.out.println("here3");

            System.out.println(api.getReturnedSoldList().getPaginationResult().getTotalNumberOfEntries());

            nm.stats_sales = Integer.toString(api.getReturnedSoldList().getPaginationResult().getTotalNumberOfEntries());

            System.out.println("nm.stats_sales " + nm.stats_sales);

        } catch(Exception ex) {System.out.println("xxx");}


    }//****************************************************************************************************






    public void loadConfiguration() throws Exception{

        int ix0 = Integer.parseInt(nm.carbon[1][6][what_item]);
        this.apiContext.setApiServerUrl(nm.carbon[5][1][ix0]);

        //this.apiContext.setEpsServerUrl("https://api.sandbox.ebay.com/ws/api.dll");
        //this.apiContext.setSignInUrl("https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn");

        ApiCredential apiCred = new ApiCredential();
        this.apiContext.setApiCredential(apiCred);

        ApiAccount ac = new ApiAccount();
        apiCred.setApiAccount(ac);

        ac.setDeveloper(ebay_settings.ebay_api_developer);
        ac.setApplication(ebay_settings.ebay_api_application);
        ac.setCertificate(ebay_settings.ebay_api_certificate);

        //ac.setDeveloper("a2e5bb52-b43d-4fad-8db9-2ea2c8c65c06");
        //ac.setApplication("Alchemis-5458-4dac-ab21-a6ab7bfc1422");
        //ac.setCertificate("785bafce-f33e-4381-8ef3-e26c2a9d2f72");

        int ix1 = Integer.parseInt(nm.carbon[1][6][what_item]);
        apiCred.seteBayToken(nm.carbon[5][2][ix1]);  
        
        this.apiContext.setRuName("Alchemist_Devel-Alchemis-5458-4-opowmx");

	    String host = "";//XmlUtil.getChildString(proxy, "Host");
	    String port = "";//XmlUtil.getChildString(proxy, "Port");

	    if (host.length() > 0 && port.length() > 0) {

	    	SdkProxySelector ps = null;
	    	String username = "";//XmlUtil.getChildString(proxy, "Username");
	    	String password = "";//XmlUtil.getChildString(proxy, "Password");

	    	if (username.length() > 0 && password.length() > 0) {

                ps = new SdkProxySelector(host, Integer.parseInt(port), username, password);

            }//**************************************************
		    else {ps = new SdkProxySelector(host, Integer.parseInt(port));}

	    	ps.register();
            
	    }//******************************************
    
    
    }//************************************************************






}//last

