import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.border.*;
import com.ebay.sdk.*;
import com.ebay.sdk.pictureservice.*;
import com.ebay.sdk.pictureservice.eps.*;
import com.ebay.soap.eBLBaseComponents.*;

import java.math.BigDecimal;

import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;

import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Calendar;
import java.text.SimpleDateFormat;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.helper.InternationalShippingServiceSelector;
import com.ebay.sdk.helper.ServiceControlManager;
import com.ebay.sdk.helper.ShippingServiceHelper;
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.sdk.helper.ui.ControlBuilder;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BestOfferDetailsType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingEnhancementsCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.soap.eBLBaseComponents.VATDetailsType;
import com.ebay.soap.eBLBaseComponents.ReturnPolicyType;

import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.CallRetry;
import com.ebay.sdk.helper.ui.DialogAccount;
import com.ebay.sdk.helper.ui.DialogFetchToken;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.sdk.util.SdkProxySelector;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import com.ebay.sdk.util.XmlUtil;



import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;








public class ebay_export_items_uk extends JFrame{///**********************************************************************



Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


int response;
int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;

int ix0x = 0;
int ix1x = 0; 
int ix2x = 0;

Float fx0x = (float) 0.0;

int stop = 0;
int post_number = 1;
int what_item_here = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String cx3 = new String("");

File st1;


String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;



public DefaultListModel model;
public PictureService picService;



private ApiContext apiContext = new ApiContext();

ShippingServiceSelector shippingServiceSelector2;

boolean resize;
JComboBox cbxShippingService = new JComboBox();
String cost;



Boolean setModal = true;


String stl[] = new String[2];


static final String CONFIG_XML_NAME = "Config.xml";

Frame parentFrame;
SiteCodeType siteId;

ControlTagItem[] ctrlPaymentServices = new ControlTagItem[] {};


MeasureType mtl;
BigDecimal bigd;






public ebay_export_items_uk() {//**************************************************************************************

	super("eBay Export");
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


    this.siteId = SiteCodeType.US;
	picService = eBayPictureServiceFactory.getPictureService(apiContext);
	model = new DefaultListModel();




    try {

      //customInit();

      // Initialize combo box.
      Object[] list = new Object[] {
          new ControlTagItem("1 day", ListingDurationCodeType.DAYS_1),
          new ControlTagItem("3 days", ListingDurationCodeType.DAYS_3),
          new ControlTagItem("5 days", ListingDurationCodeType.DAYS_5),
          new ControlTagItem("7 days", ListingDurationCodeType.DAYS_7),
          new ControlTagItem("GTC", ListingDurationCodeType.GTC),
      };

      //ComboBoxModel dataModel = new DefaultComboBoxModel(list);
      //this.cbxDuration.setModel(dataModel);
      //this.cbxDuration.setSelectedIndex(4);

    }catch(Exception ex){ex.printStackTrace();}






	stop = 0;
	csv_int = 0;
	thisc3 = 0;


	ximagex = new ImageIcon(this.getClass().getResource("images/ebay.png")).getImage();
	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 80));
	infox0.setBackground(black);
	infox0.setForeground(whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("item number: ");
	infox1.setForeground(whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("item number: ");
	infox2.setForeground(whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(blackx);
	bkp.setForeground(whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.add(bkp);



        //runxxx();//set up the local shipping box

	setVisible(true);






	what_item_here = 0;
	ix0 = 0;
	for(int xloopx = 1; xloopx < nm.items_total; xloopx++){//********************************************************************
	

	    if(nm.selected_int[xloopx] == 1){

	        what_item_here = xloopx;

            setTitle("Export to eBay: (" + (ix0 + 1) + ")");
	        infox1.setText("Export: (" + (ix0 + 1) + ") " + nm.carbon[0][nm.part_number_xx][what_item_here]);
	        btnListToEBay();
	        infox2.setText("Exported: (" + (ix0 + 1) + ") item(s).");

	        ix0++;

	    }//if******************



	}//for*****************************************************************************************************************


	pullThePlug();


}//export**************











    public void pullThePlug() {

	    nm.firex = 1;


        try{Thread.sleep(600);}
        catch(InterruptedException e){System.out.println("import black failed 000332");}


        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull










    public void btnListToEBay(){

        try{


            ServiceControlManager manager = ServiceControlManager.getInstance();
            loadConfiguration();

            System.out.println("working 1");

            ItemType item = new ItemType(); 

            item.setTitle(nm.carbon[0][nm.title_xx][what_item_here]);


            //item.setSubTitle(subTitle);

            item.setPrivateListing(true);



            item.setHitCounter(HitCounterCodeType.BASIC_STYLE);




            try{
      
                StorefrontType st = new StorefrontType();
                ix0 = Integer.parseInt(nm.carbon[5][nm.ebay_store_category1_xx][nm.current_submit_item_a]);
                st.setStoreCategoryID(Long.parseLong(nm.carbon[0][ix0][what_item_here]));
                item.setStorefront(st);
      
            }catch(Exception e){System.out.println("Store set catagory failed.");}




            item.setSKU(nm.carbon[0][nm.part_number_xx][what_item_here]);
            item.setItemID(nm.carbon[0][nm.part_number_xx][what_item_here]);



            // Adding product details (BRAND MPN, UPC)
            //String UPC = nm.carbon[0][nm.part_number_xx][what_item_here]; 
            String Brand = nm.carbon[0][nm.part_number_xx][what_item_here];
            String MPN = nm.carbon[0][nm.part_number_xx][what_item_here];

            ProductListingDetailsType product = new ProductListingDetailsType();

	        product.setUPC(nm.carbon[0][ Integer.parseInt(nm.carbon[5][nm.ebay_upc_xx][nm.current_submit_item_a]) ][what_item_here]);

            BrandMPNType brandMPN = new BrandMPNType();
            brandMPN.setMPN("AKG");
            brandMPN.setBrand("AKG");
            //product.setBrandMPN(brandMPN);


            product.setIncludePrefilledItemInformation(true);

            //Include the eBay stock photo with the listing if available and use it
            //as the gallery picture
            //product.setIncludeStockPhotoURL(true);
            //product.setUseStockPhotoURLAsGallery(true);

            //If multiple product matches found, list the item with the 1st
            //product's information
            //product.setUseFirstProduct(true);
            //product.setListIfNoProduct(true);

	        if(nm.carbon[0][ Integer.parseInt(nm.carbon[5][nm.ebay_upc_xx][nm.current_submit_item_a]) ][what_item_here].length() > 3){
                item.setProductListingDetails(product);
	        }//if*********************************************************************************************************************




            cx0 = nm.carbon[5][nm.template_xx][nm.current_submit_item_a];


		    for (int loop3 = 0; loop3 < nm.db_string.length; loop3++){//*************************

		         cx0 = cx0.replace("[[" + nm.db_string[loop3] + "]]", nm.carbon[0][loop3][what_item_here]);
		        //System.out.println(printerx[loop2]);

		    }//for**********************************************************************************


            cx0 = cx0.replace("<<,>>","<<*>>").replace("[[url]]",nm.carbon[5][3][nm.current_submit_item_a]);
            cx0 = cx0.replace("±","&#177;");
            cx0 = cx0.replace("“","\"");
            cx0 = cx0.replace("”","\"");


            item.setDescription(cx0);


            //item.setDescription(cx0.replace("<<,>>","<<*>>").replace("[[url]]",nm.carbon[5][3][nm.current_submit_item_a]));
            //item.setDescription("testing 123 123412 thetinds");

            AmountType at = new AmountType();
            at.setValue(Double.parseDouble(nm.carbon[0][nm.item_price_xx][what_item_here]));
            item.setStartPrice(at);


            item.setPayPalEmailAddress(nm.carbon[5][nm.paypal_email_xx][nm.current_submit_item_a]);//"sales@audiomusicsales.com"

            item.setRegionID("2");
            item.setLocation(nm.carbon[5][nm.ship_from_state_xx][nm.current_submit_item_a]);//"Las Vegas, NV"
            item.setCurrency(CurrencyCodeType.GBP);
            item.setCountry(CountryCodeType.GB);


 



            //inventory control
            if(nm.carbon[4][0][72].equals("1")){

                System.out.println("TEST1");

                try{

                    ix0x = Integer.parseInt(nm.carbon[0][95][what_item_here]);
                    ix1x = Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_item_here]);
                    ix2x = (nm.carbon[1][0].length -1);

                    System.out.println("TEST2 " + ix0x + " " + ix1x + " " + ix2x);

                    if(ix1x > ix2x){
	
                        fx0x = (float) ix1x / ix2x;
	                    cx3 = Float.toString(fx0x);
	                    ix3 = cx3.indexOf(".");
	                    if(ix3 > -1){cx3 = cx3.substring(0, ix3);}
	                    ix0x = Integer.parseInt(cx3);
	                    System.out.println(ix0x);
	                    //System.exit(0);
    
                    }//*************
                    else if(ix1x <= ix2x && ix1x != 0){

                        System.out.println("TEST4");

	                    if( (ix1x - (nm.carbon[1][0].length -1) ) >= 0 ){ix0x = 1;}
	                    else{ix0x = 0;}

                    }//********************************
                    else{ix0x = 0;}

                    System.out.println("TEST5");

                    item.setQuantity(ix0x);

                    System.out.println("TEST6");

                }catch(Exception e){item.setQuantity(Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_item_here])); System.out.println("Inventory Control fail.");}

            }//*********************************
            else{item.setQuantity(Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][what_item_here]));}
            //inventory control






            System.out.println("working tax 1");



            item.setUseTaxTable(false);




            System.out.println("working 2");

            com.ebay.sdk.call.AddItemCall api = new com.ebay.sdk.call.AddItemCall(this.apiContext);
            // Let the call object to automatically generate UUID for my item.
            api.setAutoSetItemUUID(false);
            api.setSite(SiteCodeType.UK);

            // Set detail level to retrieve item description.
            api.addDetailLevel(DetailLevelCodeType.ITEM_RETURN_DESCRIPTION);

            System.out.println("working 3");


    
            System.out.println("working 3x1");
  



            System.out.println("working 3x2");



            ControlTagItem ct3 = new ControlTagItem("Days_3", ListingDurationCodeType.DAYS_3);
            ControlTagItem ct30 = new ControlTagItem("Days_30", ListingDurationCodeType.DAYS_30);
            ControlTagItem ct = new ControlTagItem("GTC", ListingDurationCodeType.GTC);

            ix3 = Integer.parseInt(nm.carbon[5][nm.ebay_duration_xx][nm.current_submit_item_a]);

            if(ix3 == 0){item.setListingDuration(((ListingDurationCodeType)ct.Tag).value());}
            else if(ix3 == 1){item.setListingDuration(((ListingDurationCodeType)ct3.Tag).value());}
            else if(ix3 == 2){item.setListingDuration(((ListingDurationCodeType)ct30.Tag).value());}
            else{item.setListingDuration(((ListingDurationCodeType)ct.Tag).value());}



            System.out.println("working 3x3");



            System.out.println("working 3x4");

            CategoryType cat = new CategoryType();
            try{ix0 = Integer.parseInt(nm.carbon[5][nm.ebay_category_xx][nm.current_submit_item_a]);}
            catch(Exception e){ix0 = -1;}

            if(ix0 != -1){cat.setCategoryID(nm.carbon[0][ix0][what_item_here]);}
            else{cat.setCategoryID("112529");}
            item.setPrimaryCategory(cat);



            System.out.println("working 3x5");




            System.out.println("working 3 1");


            item.setPaymentMethods(new BuyerPaymentMethodCodeType[] {BuyerPaymentMethodCodeType.PAY_PAL});


            System.out.println("working 3 2");



            item.setShippingDetails(buildShippingDetails());


            item.setListingType(ListingTypeCodeType.FIXED_PRICE_ITEM);
            //item.setListingType((ListingTypeCodeType)((ControlTagItem)this.cbxListingType.getSelectedItem()).Tag);
            item.setConditionID(1000);





            System.out.println("working 3 3");



            //stl[0] = new String("US");
            //stl[1] = new String("Worldwide");


            //item.setShipToLocations(stl);

            item.setAutoPay(true);

            System.out.println("working 3 4");




            System.out.println("working 4");

            //fill in mandatory fields
            //handling time
            int time_time = 1;
            item.setDispatchTimeMax(time_time);


            //return policy
            ReturnPolicyType returnPolicy = new ReturnPolicyType();
            returnPolicy.setDescription("30 Day full refund policy as long as product is in original box and unused.");
            returnPolicy.setReturnsAcceptedOption("ReturnsAccepted");
            returnPolicy.setReturnsWithinOption("Days_30");
            //returnPolicy.setShippingCostPaidByOption("Buyer");
            returnPolicy.setRefundOption("MoneyBack");
            item.setReturnPolicy(returnPolicy);

            item.setCurrency(CurrencyCodeType.GBP);

            System.out.println("working 5");




            System.out.println("Picture ready.");
            infox2.setText("Picture ready.");


            System.out.println(nm.carbon[0][nm.picture_1_xx][what_item_here].replace("[[url]]", nm.carbon[5][3][nm.current_submit_item_a]));

            PictureDetailsType pd = new PictureDetailsType(); 
            //pd.setGalleryURL(""); 
            pd.setPictureURL(new String[]{nm.carbon[0][nm.picture_1_xx][what_item_here].replace("[[url]]", nm.carbon[5][3][nm.current_submit_item_a])});
            item.setPictureDetails(pd);

            infox2.setText("Exporting to eBay UK....");
            System.out.println("Exporting to eBay UK....");




            System.out.println("working 7");

            api.setItem(item);

            System.out.println("working 8");

            FeesType fees = api.addItem();

            System.out.println("working 9");

            // Display results.
            nm.carbon[0][nm.sale_status_xx][what_item_here] = "Listed";
            nm.carbon[0][nm.ebay_item_xx][what_item_here] = item.getItemID();
            nm.carbon[0][ Integer.parseInt(nm.carbon[5][nm.ebay_listing_id2_xx][nm.current_submit_item_a]) ][what_item_here] = item.getItemID();
            FeeType ft = eBayUtil.findFeeByName(fees.getFee(), "ListingFee");
            //this.txtListingFee.setText(new Double(ft.getFee().getValue()).toString());


            System.out.println("working 10");


        }catch(Exception ex){

            System.out.println("pp pp " + ex.getMessage()); //((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
            infox2.setText(ex.getMessage());

            nm.carbon[0][nm.notes_xx][what_item_here] = ex.getMessage();
            if(nm.total_items_selected == 1){JOptionPane.showMessageDialog(null,ex.getMessage());}

            //JOptionPane.showMessageDialog(trace(this._currentframe), ex.getMessage(), JOptionPane.WARNING_MESSAGE);

        }//catch************


    }//export











    public ShippingDetailsType buildShippingDetails(){

        // Shipping details.
        ShippingDetailsType sd = new ShippingDetailsType();



        System.out.println("Sales tax");

	    //SalesTaxType sales_tax = new SalesTaxType();
	    //sales_tax.setSalesTaxPercent(Float.parseFloat(nm.carbon[5][nm.tax_amount_xx][nm.current_submit_item_a]));
	    //sales_tax.setSalesTaxState(nm.carbon[5][nm.tax_state_xx][nm.current_submit_item_a]);

	    //sd.setSalesTax(sales_tax);


        System.out.println("payment");


        sd.setPaymentInstructions("Please pay with PayPal.");

        // Shipping type and shipping service options
        //if(nm.carbon[5][nm.shipping_type_xx][nm.current_submit_item_a].equals("0")){sd.setShippingType(ShippingTypeCodeType.FLAT);}
        //else if(nm.carbon[5][nm.shipping_type_xx][nm.current_submit_item_a].equals("1")){sd.setShippingType(ShippingTypeCodeType.FLAT);}
        //else{sd.setShippingType(ShippingTypeCodeType.CALCULATED);}


        //sd.setShippingType(ShippingTypeCodeType.CALCULATED);

        ShippingServiceOptionsType shippingOptions = new ShippingServiceOptionsType();



        AmountType at2 = new AmountType();
        at2.setValue(Double.parseDouble("0.00"));
        shippingOptions.setShippingServiceCost(at2);


        //shippingOptions.setShippingService(ShippingServiceCodeType.USPSParcel.value());
        shippingOptions.setShippingService(ShippingServiceCodeType.UK_ROYAL_MAIL_FIRST_CLASS_RECORDED.value());


        System.out.println("ship 1");

        CalculatedShippingRateType csrt = new CalculatedShippingRateType();
        csrt.setOriginatingPostalCode(nm.carbon[5][nm.shipping_zip_xx][nm.current_submit_item_a]);//"89118"
        csrt.setShippingPackage(ShippingPackageCodeType.PACKAGE_THICK_ENVELOPE);


        System.out.println("ship 2 package_l " + nm.carbon[0][nm.package_l_xx][what_item_here]);

        mtl = new MeasureType();
        bigd = new BigDecimal(Integer.parseInt(nm.carbon[0][nm.package_l_xx][what_item_here]));
        mtl.setUnit("Inches");
        mtl.setValue(bigd);
        csrt.setPackageLength(mtl);

        System.out.println("ship 3 package_w " + nm.carbon[0][nm.package_w_xx][what_item_here]);

        bigd = new BigDecimal(Integer.parseInt(nm.carbon[0][nm.package_w_xx][what_item_here]));
        mtl.setUnit("Inches");
        mtl.setValue(bigd);
        csrt.setPackageWidth(mtl);

        System.out.println("ship 4 package_d " + nm.carbon[0][nm.package_d_xx][what_item_here]);

        bigd = new BigDecimal(Integer.parseInt(nm.carbon[0][nm.package_d_xx][what_item_here]));
        mtl.setUnit("Inches");
        mtl.setValue(bigd);
        csrt.setPackageDepth(mtl);

        System.out.println("ship 5 weight " + nm.carbon[0][nm.item_weight_xx][what_item_here]);

        bigd = new BigDecimal(Integer.parseInt(nm.carbon[0][nm.item_weight_xx][what_item_here]));
        mtl.setUnit("Ounces");
        mtl.setValue(bigd);
        csrt.setWeightMajor(mtl);


        shippingOptions.setShippingServicePriority(new Integer(1));




        stl = new String[1];
        if(nm.carbon[5][nm.shipping_location_xx][nm.current_submit_item_a].equals("0")){stl[0] = new String("UK");}
        else{stl[0] = new String("Worldwide");}

        InternationalShippingServiceOptionsType internationalshippingOptions = new InternationalShippingServiceOptionsType();
        internationalshippingOptions.setShippingService(ShippingServiceCodeType.UK_ROYAL_MAIL_AIRMAIL_INTERNATIONAL.value());
        internationalshippingOptions.setShipToLocation(stl);




        try{

            AmountType at = new AmountType();
            at.setValue(Double.parseDouble(nm.carbon[5][nm.shipping_flat_rate_xx][nm.current_submit_item_a]));
            internationalshippingOptions.setShippingServiceCost(at);

        }catch(Exception e){AmountType at = new AmountType(); at.setValue(Double.parseDouble("9.99")); internationalshippingOptions.setShippingServiceCost(at);}
     



        //US only or Worldwide?
        if(nm.carbon[5][nm.shipping_location_xx][nm.current_submit_item_a].equals("1")){
            sd.setInternationalShippingServiceOption(new InternationalShippingServiceOptionsType[]{internationalshippingOptions});
        }//*****************************************************************************


        sd.setShippingServiceOptions(new ShippingServiceOptionsType[]{shippingOptions});

        return sd;
    }//********************************************************















    public void loadConfiguration() throws Exception{


        this.apiContext.setApiServerUrl(nm.carbon[5][1][nm.current_submit_item_a]);

        //this.apiContext.setEpsServerUrl(nm.carbon[5][1][nm.current_submit_item_a]);//"https://api.sandbox.ebay.com/ws/api.dll"
        //this.apiContext.setSignInUrl("https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn");

        ApiCredential apiCred = new ApiCredential();
        this.apiContext.setApiCredential(apiCred);

        ApiAccount ac = new ApiAccount();
        apiCred.setApiAccount(ac);

        //
        //Node apiCredential = XmlUtil.getChildByName(config, "ApiCredential");


        ac.setDeveloper("a2e5bb52-b43d-4fad-8db9-2ea2c8c65c06");
        ac.setApplication("Alchemis-5458-4dac-ab21-a6ab7bfc1422");
        ac.setCertificate("785bafce-f33e-4381-8ef3-e26c2a9d2f72");

        //Node eBayCredential = XmlUtil.getChildByName(config, "eBayCredential");

        //s = XmlUtil.getChildString(eBayCredential, "Token");
        apiCred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);  
    

        this.apiContext.setRuName("Alchemist_Devel-Alchemis-5458-4-opowmx");

    

	    String host = "";//XmlUtil.getChildString(proxy, "Host");
	    String port = "";//XmlUtil.getChildString(proxy, "Port");
	    if (host.length() > 0 && port.length() > 0) {

	    	SdkProxySelector ps = null;
	    	String username = "";//XmlUtil.getChildString(proxy, "Username");
	    	String password = "";//XmlUtil.getChildString(proxy, "Password");
	    	if(username.length() > 0 && password.length() > 0) {ps = new SdkProxySelector(host, Integer.parseInt(port), username, password);} 
		    else{ps = new SdkProxySelector(host, Integer.parseInt(port));}

	    	ps.register();

	    }//******************************************
    
    
    }//************************************************************






class BackgroundPanel extends JPanel{
  
    Image image;
    public BackgroundPanel(){
        try{

            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3r.jpg"), "background3r.jpg"));

        }catch (Exception e) { System.out.println("Failed001"); }
    }//backgroundpanel

    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        if (image != null){
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
        }
    }//paint

}//jpanel





}//last********************************************************











