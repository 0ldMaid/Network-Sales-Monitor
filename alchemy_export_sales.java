import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_export_sales extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


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
int stop = 0;
int post_number = 1;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;


String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;








alchemy_export_sales(String[][] s1, String s2, String s3, String s4){//*********************************************************************************

	super("Export sales");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);




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

    infox0.setPreferredSize(new Dimension(320, 50));
    infox0.setBackground(black);
    infox0.setForeground(whitex);
    infox0.setOpaque(false);
    infox0.setIcon(aicon);
    infox0.setText("Version 2.1.1");
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




	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(blackx);
	cpx.setForeground(whitex);
	cpx.add(bkp);


	setVisible(true);







    requestFocus();
    repaint();
    runx();



}//csv_loader_x1********************************************************
















	public void runx(){

    	System.out.println(ix1);

    	for(int xloop = 0; xloop < ix1; xloop++){//******

        	post_number = xloop; 
        	connectx();
        	infox1.setText("Export: " + (xloop + 1) + " of " + ix1);
        	requestFocus();

    	}//**************************************************************

    	pullThePlug();


	}//run






    public void connectx(){



        // Construct data
        try {

            requestFocus();

                   data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(ssxu, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(ssxp, "UTF-8");
            data += "&" + URLEncoder.encode("post_key", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][0][29], "UTF-8");



            data += "&" + URLEncoder.encode("address_1", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[0] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("address_2", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[1] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("address_3", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[2] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("address_4", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[3] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("address_5", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[4] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("address_6", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[5] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("buyer_id", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[6] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("buyers_email", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[7] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("buyers_first_name", "UTF-8")     + "=" + URLEncoder.encode(carbonfiber[8] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("buyers_last_name", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[9] [post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("buyers_notes", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[10][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("buyers_phone", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[11][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("currency", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[12][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_1", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[13][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_2", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[14][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_3", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[15][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_4", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[16][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_5", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[17][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_6", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[18][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_7", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[19][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_8", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[20][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_9", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[21][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_10", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[22][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_11", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[23][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_12", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[24][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_13", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[25][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_14", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[26][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_15", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[27][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_16", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[28][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_17", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[29][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_18", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[30][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_19", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[31][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_20", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[32][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_21", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[33][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_22", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[34][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_23", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[35][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_24", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[36][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_25", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[37][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_26", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[38][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_27", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[39][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_28", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[40][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_29", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[41][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_30", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[42][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_31", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[43][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_32", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[44][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_33", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[45][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_34", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[46][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_35", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[47][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_36", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[48][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_37", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[49][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_38", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[50][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_39", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[51][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_40", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[52][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_41", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[53][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_42", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[54][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_43", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[55][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_44", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[56][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_45", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[57][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_46", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[58][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("custom_template", "UTF-8")       + "=" + URLEncoder.encode(carbonfiber[59][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("date_last_modified", "UTF-8")    + "=" + URLEncoder.encode(carbonfiber[60][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("date_payment_received", "UTF-8") + "=" + URLEncoder.encode(carbonfiber[61][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("date_shipped", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[62][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("date_sold", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[63][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("ebay_item", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[64][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("final_value_fee", "UTF-8")       + "=" + URLEncoder.encode(carbonfiber[65][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("handling", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[66][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("hits", "UTF-8")                  + "=" + URLEncoder.encode(carbonfiber[67][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_cost", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[68][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_description", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[69][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_id", "UTF-8")               + "=" + URLEncoder.encode(carbonfiber[70][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_price", "UTF-8")            + "=" + URLEncoder.encode(carbonfiber[71][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_weight", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[72][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("listing_fees", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[73][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("listing_id", "UTF-8")            + "=" + URLEncoder.encode(carbonfiber[74][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("notes", "UTF-8")                 + "=" + URLEncoder.encode(carbonfiber[75][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("package_d", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[76][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("package_l", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[77][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("package_w", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[78][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("part_number", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[79][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("payment_type", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[80][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("paypal_fees", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[81][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("picture_1", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[82][post_number].replace("[[url]]", nm.carbon[5][1][nm.current_submit_item_a]).replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("quantity_sold", "UTF-8")         + "=" + URLEncoder.encode(carbonfiber[83][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("sale_id", "UTF-8")               + "=" + URLEncoder.encode(carbonfiber[84][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("sale_status", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[85][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("sales_tax", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[86][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_company", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[87][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_in", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[88][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_out", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[89][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("site_id", "UTF-8")               + "=" + URLEncoder.encode(carbonfiber[90][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("site_url", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[91][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("source_of_sale", "UTF-8")        + "=" + URLEncoder.encode(carbonfiber[92][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("title", "UTF-8")                 + "=" + URLEncoder.encode(carbonfiber[93][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("title_url", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[94][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("total_on_hand", "UTF-8")         + "=" + URLEncoder.encode(carbonfiber[95][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("total_sale_amount", "UTF-8")     + "=" + URLEncoder.encode(carbonfiber[96][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("tracking_number", "UTF-8")       + "=" + URLEncoder.encode(carbonfiber[97][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("transaction_id", "UTF-8")        + "=" + URLEncoder.encode(carbonfiber[98][post_number].replace("<<,>>",""), "UTF-8");
            data += "&" + URLEncoder.encode("transaction_info", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[99][post_number].replace("<<,>>",""), "UTF-8");




            // Send data
            url = new URL(ssxs + "/dbx_import_sales.php");
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
        	   //System.out.println(line);
                
            }

            wr.close();
            rd.close();

        }catch(Exception e){System.out.println("URL falure. Alchemy.");}




    }//connectx()*********************************************************************************************






    public void pullThePlug() {

        System.out.println("PULL THE PLUG");

        nm.firex = 1;

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(String[][] sxx, String ssxs, String ssxu, String ssxp){

	   alchemy_export_sales xr = new alchemy_export_sales(sxx, ssxs, ssxu, ssxp);

    }//main








    class BackgroundPanel extends JPanel{
  
        Image image;
  
        public BackgroundPanel(){
    
            try{

                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundgold.jpg"), "backgroundgold.jpg"));

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