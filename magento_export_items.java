import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.axis2.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.country.CountryRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.model.category.Category;
import com.google.code.magja.model.category.CategoryAttribute;
import com.google.code.magja.model.category.CategoryAttributeOption;
import com.google.code.magja.model.media.Media;
import com.google.code.magja.model.product.ConfigurableAttributeData;
import com.google.code.magja.model.product.ConfigurableData;
import com.google.code.magja.model.product.ConfigurableDataException;
import com.google.code.magja.model.product.ConfigurableProductData;
import com.google.code.magja.model.product.Product;
import com.google.code.magja.model.product.ProductAttributeSet;
import com.google.code.magja.model.product.ProductLink;
import com.google.code.magja.model.product.ProductMedia;
import com.google.code.magja.model.product.ProductType;
import com.google.code.magja.model.product.Visibility;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.GeneralService;
import com.google.code.magja.service.ServiceException;
import com.google.code.magja.utils.MagjaFileUtils;
import com.google.code.magja.utils.MagjaStringUtils;
import com.google.code.magja.model.media.Media;
import com.google.code.magja.service.product.ProductAttributeRemoteService;
import com.google.code.magja.service.product.ProductAttributeRemoteServiceImpl;
import com.google.code.magja.service.product.ProductLinkRemoteService;
import com.google.code.magja.service.product.ProductLinkRemoteServiceImpl;
import com.google.code.magja.service.product.ProductMediaRemoteService;
import com.google.code.magja.service.product.ProductMediaRemoteServiceImpl;
import com.google.code.magja.service.product.ProductRemoteService;
import com.google.code.magja.service.product.ProductRemoteServiceImpl;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.model.product.Product;
import com.google.code.magja.model.product.ProductTypeEnum;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.product.ProductRemoteService;








public class magento_export_items extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int thisc2 = 0; 
int thisc3 = 0;
int csv_int = 0;
int working = 1; 
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;
int ix0x = 0;
int ix1x = 0; 
int ix2x = 0;
int stop = 0;
int post_number = 1;
int csv_passes_x = 17;

Float fx0x = (float) 0.0;

String[][] carbonfiber;
String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String cx3 = new String("");
String cx4 = new String("");
String xlinex = new String("");
String blank = new String("");
String ssxs;
String data;
String ssxu;
String ssxp;







magento_export_items(String[][] s1, String s2, String s3, String s4){//*********************************************************************************

	super("Export Items");
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

	ximagex = new ImageIcon(this.getClass().getResource("images/magento.png")).getImage();


	stop = 0;
	csv_int = 0;
	thisc3 = 0;

	carbonfiber = s1;
	ssxs = s2;
	ssxu = s3;
	ssxp = s4;


	ix0 = carbonfiber.length;
	ix1 = carbonfiber[0].length;


	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 80));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("Loading Export Items...");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("Ready.");
	infox2.setForeground(nm.whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.blackx);
	bkp.setForeground(nm.whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);




	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.blackx);
	cpx.setForeground(nm.whitex);
	cpx.add(bkp);


	setVisible(true);



	String user = nm.carbon[5][2][nm.current_submit_item_a];
	String pass = nm.carbon[5][3][nm.current_submit_item_a];
	String host = nm.carbon[5][1][nm.current_submit_item_a];

 

	requestFocus();
	repaint();
	runx();



}//csv_loader_x1********************************************************















	public void runx(){

		System.out.println(ix1);

		for(int xloop = 0; xloop < ix1; xloop++){//******

			post_number = xloop; 
			infox1.setText("Export: " + (xloop + 1) + " of " + ix1);
			connectx();
			infox1.setText("Export: " + (xloop + 1) + " of " + ix1);
			requestFocus();

		}//**************************************************************

		pullThePlug();


	}//run











	public void connectx(){


		try {


			infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[0]");
			//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[0]");


			Product product = new Product();
			product.setSku(carbonfiber[nm.part_number_xx][post_number]);
			product.setName(carbonfiber[nm.title_xx][post_number]);
			product.setShortDescription(carbonfiber[nm.part_number_xx][post_number]);

			//build path
			cx4 = "";
			cx4 = nm.carbon[5][magento_settings.m_build_path_xx][nm.current_submit_item_a];

			for (int loop3 = 0; loop3 < nm.db_string.length; loop3++){//***************************

				cx4 = cx4.replace("[[" + nm.db_string[loop3] + "]]", carbonfiber[loop3][post_number]);

			}//for**********************************************************************************

			cx4 = cx4.replace("[[url]]", nm.carbon[5][magento_settings.host_set_url_xx][nm.current_submit_item_a]);

			product.setDescription(cx4);
			//product.setDescription(carbonfiber[nm.item_description_xx][post_number].replace("[[url]]",nm.carbon[5][nm.host_set_url_xx][nm.current_submit_item_a]));
			//build path

			product.setPrice(Double.parseDouble(carbonfiber[nm.item_price_xx][post_number]));
			product.setCost(Double.parseDouble(carbonfiber[nm.item_cost_xx][post_number]));
			product.setEnabled(true);
			product.setWeight(Double.parseDouble(carbonfiber[nm.item_weight_xx][post_number]));
			product.setType(ProductTypeEnum.SIMPLE.getProductType());
			product.setAttributeSet(new ProductAttributeSet(4, "Default"));
			product.setMetaDescription(carbonfiber[nm.title_xx][post_number]);
			product.setGoogleCheckout(false);


			System.out.println(carbonfiber[nm.part_number_xx][post_number] + " 1");
			infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[1]");
			infox2.setText(carbonfiber[nm.part_number_xx][post_number]);

			try {

				// category
				List<Category> categorys = new ArrayList<Category>();

				System.out.println();
				System.out.println();

				categorys.add(new Category(Integer.parseInt(carbonfiber[ Integer.parseInt(nm.carbon[5][magento_settings.m_cat1_xx][nm.current_submit_item_a]) ][post_number])));
				categorys.add(new Category(Integer.parseInt(carbonfiber[ Integer.parseInt(nm.carbon[5][magento_settings.m_cat2_xx][nm.current_submit_item_a]) ][post_number])));
				product.setCategories(categorys);

			} catch(Exception e) {

				System.out.println("Category Insert Failed");

				try {

					List<Category> categorys2 = new ArrayList<Category>();
					categorys2.add(new Category(2));
					product.setCategories(categorys2);

				} catch (Exception ex) {System.out.println("Category Insert Failed2");}

			}//*****************


			// websites - set the website for product
			Integer[] websites = { 1 };
			product.setWebsites(websites);







			//inventory control
			if (nm.carbon[4][0][72].equals("1")) {

				System.out.println("TEST1");

				try {

				    ix0x = Integer.parseInt(carbonfiber[95][post_number]);
				    ix1x = Integer.parseInt(carbonfiber[nm.total_on_hand_xx][post_number]);
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

					product.setQty(Double.parseDouble(Integer.toString(ix0x)));

					if (ix0x < 1) {product.setInStock(false);}


					System.out.println("TEST6");

				} catch (Exception e) {product.setQty(Double.parseDouble(carbonfiber[nm.total_on_hand_xx][post_number])); if(ix0x < 1){product.setInStock(false);} System.out.println("Inventory Control fail.");}

			}//*********************************
			else {product.setQty(Double.parseDouble(carbonfiber[nm.total_on_hand_xx][post_number])); if(ix0x < 1) {product.setInStock(false);} System.out.println("SET IVENTORY SYSTEM OFF");}
			//inventory control






			// inventory - set the inventory for product
			//product.setQty(Double.parseDouble(carbonfiber[nm.total_on_hand_xx][post_number]));

			product.setInStock(true);



			System.out.println(carbonfiber[nm.part_number_xx][post_number] + " 2");
			infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[2]");
			//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[2]");



			try {

				// you can add images for the product too

				MagjaFileUtils mfu = new MagjaFileUtils();

				byte[] data = mfu.getBytesFromFileURL(carbonfiber[nm.picture_1_xx][post_number].replace("[[url]]",nm.carbon[5][magento_settings.host_set_url_xx][nm.current_submit_item_a]));
				//byte[] data = MagjaFileUtils.getBytesFromFileURL("http://www.sonicsoundking.com/pictures/framed_images/AKG_K271_MKII_Headphones_0.jpg");
				Media image = new Media();
				image.setName(carbonfiber[nm.title_xx][post_number]);
				image.setMime("image/jpeg");
				image.setData(data);

				System.out.println(carbonfiber[nm.part_number_xx][post_number] + " 3");
				infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[3]");
				//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[3]");

				Set<ProductMedia.Type> types = new HashSet<ProductMedia.Type>();
				types.add(ProductMedia.Type.IMAGE);
				types.add(ProductMedia.Type.SMALL_IMAGE);
				types.add(ProductMedia.Type.THUMBNAIL);

				System.out.println(carbonfiber[nm.part_number_xx][post_number] + " 4");
				infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[4]");
				//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[4]");

				ProductMedia media = new ProductMedia();
				media.setExclude(false);
				media.setImage(image);
				media.setLabel(carbonfiber[nm.title_xx][post_number]);
				media.setPosition(1);
				media.setTypes(types);
				product.addMedia(media);

				System.out.println(carbonfiber[nm.part_number_xx][post_number] + " 5");
				infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[5]");
				//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[5]");


			} catch (Exception e) {System.out.println("Image Failure.");}



			// then, we just instantate the service to persist the product

			System.out.println(carbonfiber[nm.part_number_xx][post_number] + " 6");
			infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[6]");
			//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[6]");

			// get service

			try {


			    String user = nm.carbon[5][2][nm.current_submit_item_a];
			    String pass = nm.carbon[5][3][nm.current_submit_item_a];
			    String host = nm.carbon[5][1][nm.current_submit_item_a];


			    System.out.println("user " + user);
			    System.out.println("pass " + pass);
			    System.out.println("host " + host);

		 	    // configure connection
			    SoapConfig soapConfig = new SoapConfig(user, pass, host);

			    MagentoSoapClient magentoSoapClient = MagentoSoapClient.getInstance(soapConfig);
			    magentoSoapClient.setConfig(soapConfig);


			    ProductRemoteService servicex2 = new RemoteServiceFactory(magentoSoapClient).getProductRemoteService();
		            servicex2.setSoapClient(magentoSoapClient);


			    servicex2.save(product);



			} catch (Exception e) {e.printStackTrace(); JOptionPane.showMessageDialog(null, e.getMessage());}




			System.out.println("7");
			infox1.setText("Export: " + (post_number + 1) + " of " + ix1 + " Send[7]");
			//infox2.setText(carbonfiber[nm.part_number_xx][post_number] + " Send[7]");

			infox2.setText("Exported");

			//nm.carbon[][][] = "Listed";

		} catch(Exception e) {System.out.println("URL FAIL"); JOptionPane.showMessageDialog(null, "URL Falure.");}




	}//connectx()*********************************************************************************************







    public void fix_stock(){




    }//********************









    public void pullThePlug() {

	    System.out.println("PULL THE PLUG");

	    nm.firex = 1;

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    //public static void main(String[][] sxx, String ssxs, String ssxu, String ssxp){

	//magento_export_items xr = new magento_export_items(sxx, ssxs, ssxu, ssxp);

    //}//main





	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3b.jpg"), "background3b.jpg"));

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