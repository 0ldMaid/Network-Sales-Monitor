import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
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
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.CompleteSaleCall;
import com.ebay.soap.eBLBaseComponents.ShipmentTrackingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShipmentType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;








public class alchemy_shipping_system_order extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

URL url;

OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

static int error_code = 0;
static int runs2 = 400;
static int runs = 50000;
int amazon_items = 0;//number of new items to submit. 
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;
int bytesRead = 0;
int csv_passes_x = 17;
int working = 0;
int csv_int = 0;

static String cx2 = new String("");
String cx0 = new String("");
String cx1 = new String("");
String ssxs;
String ssxu;
String ssxp;
String data;
String xlinex = new String("");
String blank = new String("");
String dazzle_exe_location = new String(nm.carbon[4][0][45]);
String dazzle_xml_location = new String(nm.carbon[2][nm.sale_id_xx][nm.what_item] + ".xml");
String dazzle_export_location = new String(nm.carbon[4][0][50]);
String international = new String("XX");
String postback = new String(nm.carbon[4][0][49]);
String mail_type = new String("XX");
String new_name = new String();
//String printerx[] = new String[0];
//String CSVTEMP[] = new String[500];

File delete_file;

File f0 = new File("alchemist_dazzle_us.lyt");
File f1 = new File("alchemist_dazzle_international.lyt");
File f2 = new File("dazzle_ship.lyt");

Toolkit toolkit;
Timer xtimerx;





alchemy_shipping_system_order(){//****************************


	super("Dazzle Shipping System");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(nm.blackx);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);



	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("item number: ");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("item number: ");
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



	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(nm.blackx);
	cp.setForeground(nm.whitex);
	cp.add(bkp);

    //setVisible(true);


	error_code = 0;

    export_to_shipping_system();

    //requestFocus();

    pullThePlug();


}//csv_loader_x1********************************************************












	public void export_to_shipping_system(){


        try {//*******************************************************

	       requestFocus();

	       new_name = nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + "X_Unit(s)_" + nm.carbon[2][nm.part_number_xx][nm.what_item].replace(" ","_").replace("'","").replace("/","") + "_" + nm.carbon[2][nm.sale_id_xx][nm.what_item];



                   data = URLEncoder.encode("quantity", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.quantity_sold_xx][nm.what_item], "UTF-8");
            data += "&" + URLEncoder.encode("buyer_name", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.buyers_first_name_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_part", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.part_number_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("pdf_link", "UTF-8")     + "=" + URLEncoder.encode(new_name + ".pdf", "UTF-8");
            data += "&" + URLEncoder.encode("user", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[4][0][58], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[4][0][57], "UTF-8");
            data += "&" + URLEncoder.encode("key", "UTF-8")          + "=" + URLEncoder.encode(nm.carbon[4][0][59], "UTF-8");
            data += "&" + URLEncoder.encode("tracking_id", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.tracking_number_xx][nm.what_item].replace(" ",""), "UTF-8");

            data += "&" + URLEncoder.encode("shipping_id_a1", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][nm.address_1_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_id_city", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][nm.address_2_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_id_state", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][nm.address_3_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_id_zip", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[2][nm.address_4_xx][nm.what_item].replace("'",""), "UTF-8");

            System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][62][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][63][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][64][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][65][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[2][ Integer.parseInt(nm.carbon[4][66][0]) ][nm.what_item].replace("'",""));

            data += "&" + URLEncoder.encode("status", "UTF-8")            + "=" + URLEncoder.encode(nm.carbon[2][ nm.sale_status_xx ][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("store_idx", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[5][0][ Integer.parseInt(nm.carbon[2][ nm.transaction_id_xx ][nm.what_item]) ].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_company", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[2][ nm.shipping_company_xx ][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("sale_id", "UTF-8")           + "=" + URLEncoder.encode(nm.carbon[2][ nm.sale_id_xx ][nm.what_item], "UTF-8");

            data += "&" + URLEncoder.encode("item_fees_paypal", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[2][ nm.final_value_fee_xx ][nm.what_item], "UTF-8");
            data += "&" + URLEncoder.encode("item_fees_ebay", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[2][ nm.paypal_fees_xx ][nm.what_item], "UTF-8");
            data += "&" + URLEncoder.encode("item_fees_shipping", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[2][ nm.shipping_out_xx ][nm.what_item], "UTF-8");

            System.out.println(nm.carbon[2][ nm.transaction_id_xx ][nm.what_item]);
            System.out.println("idx " + nm.carbon[5][0][ Integer.parseInt(nm.carbon[2][ nm.transaction_id_xx ][nm.what_item]) ].replace("'",""));




            // Send data
            System.out.println("post order too: " + nm.carbon[4][0][56]);
            url = new URL(nm.carbon[4][0][56]);
            conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
        
                infox2.setText(line);
	            System.out.println(line);

            }
            wr.close();
            rd.close();

        } catch (Exception e){System.out.println("URL falure. EXPORT LABEL.");}




	}//**************************************









    public void pullThePlug() {


        nm.firex = 1;

        System.out.println("PULL THE PLUG");

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull





    class BackgroundPanel extends JPanel{
  
        Image image;
  
        public BackgroundPanel(){
    
            try{

                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundblack.jpg"), "backgroundblack.jpg"));

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