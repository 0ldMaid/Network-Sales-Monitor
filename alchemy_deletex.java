import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_deletex extends JFrame{//************************************************************************

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

JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

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
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;

int[] selected_int;

String settings[][] = new String[1][runs];
String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");

String send_url = new String("");
//String send_url = new String("http://www.superstrategic.com/alchemist_webshop/write_db.php");







alchemy_deletex(String[][] sxx, String[][] ssxs, int[] selected_intx){//************************************************************************

	super("Submit");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("hex.png")).getImage();
	setIconImage(ximagex);


    selected_int = selected_intx;

    //System.out.println("item to post " + post_number);

    stop = 0;
    csv_int = 0;
    thisc3 = 0;

    carbonfiber = sxx;
    //settings = ssxs;


    ix0 = carbonfiber.length;
    ix1 = carbonfiber[0].length;



    for(int xloop = 0; xloop < 100; xloop++){//******
    	settings[0][xloop] = new String("");
    }//for************************************************


    settings[0][20] = new String("super");
    settings[0][21] = new String("1234");



    infoxs.setPreferredSize(new Dimension(320, 25));
    infoxs.setText("Submit items to Database.");
    infoxs.setForeground(whitex);
    infoxs.setOpaque(true); 
    infoxs.setBackground(blackx);


    infox0.setPreferredSize(new Dimension(320, 25));
    infox0.setText("Submitting items to site.");
    infox0.setBackground(blackx);
    infox0.setForeground(whitex);
    infox0.setOpaque(true); 
    infox0.setBackground(blackx);


    infox1.setPreferredSize(new Dimension(320, 25));
    infox1.setText("item number: ");
    infox1.setForeground(whitex);
    infox1.setOpaque(true); 
    infox1.setBackground(blackx);


    BackgroundPanel bkp = new BackgroundPanel();
    bkp.setPreferredSize(new Dimension(340, 140));
    bkp.setLayout(new FlowLayout());
    bkp.setBackground(blackx);
    bkp.setForeground(whitex);
    bkp.add(infoxs);
    bkp.add(infox0);
    bkp.add(infox1);




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

    	for(int xloop = 0; xloop < selected_int.length; xloop++){//******

    	   if(selected_int[xloop] == 1){post_number = xloop; connectx();}
    	   infox1.setText("item number: " + xloop);

    	}//**************************************************************

    	pullThePlug();

	}//run






    public void connectx(){



        // Construct data
        try {

            requestFocus();

                   data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(settings[0][20], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(settings[0][21], "UTF-8");




            data += "&" + URLEncoder.encode("address_1", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[0] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("address_2", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[1] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("address_3", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[2] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("address_4", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[3] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("address_5", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[4] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("buyer_id", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[5] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("buyers_email", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[6] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("buyers_first_name", "UTF-8")     + "=" + URLEncoder.encode(carbonfiber[7] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("buyers_last_name", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[8] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("buyers_notes", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[9] [post_number], "UTF-8");
            data += "&" + URLEncoder.encode("checkout_completed", "UTF-8")    + "=" + URLEncoder.encode(carbonfiber[10][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("currency", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[11][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_1", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[12][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_2", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[13][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_3", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[14][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_4", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[15][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_5", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[16][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_6", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[17][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_7", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[18][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_8", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[19][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_9", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[20][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("custom_template", "UTF-8")       + "=" + URLEncoder.encode(carbonfiber[21][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("date_payment_cleared", "UTF-8")  + "=" + URLEncoder.encode(carbonfiber[22][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("date_payment_received", "UTF-8") + "=" + URLEncoder.encode(carbonfiber[23][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("date_shipped", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[24][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("date_sold", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[25][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("ebay_item", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[26][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("final_value_fee", "UTF-8")       + "=" + URLEncoder.encode(carbonfiber[27][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("handling", "UTF-8")              + "=" + URLEncoder.encode(carbonfiber[28][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("hits", "UTF-8")                  + "=" + URLEncoder.encode(carbonfiber[29][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("item_cost", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[30][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("item_description", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[31][post_number].substring(1, carbonfiber[31][post_number].length() -1), "UTF-8");
            data += "&" + URLEncoder.encode("item_id", "UTF-8")               + "=" + URLEncoder.encode(carbonfiber[32][post_number].substring(1, carbonfiber[32][post_number].length() -1), "UTF-8");
            data += "&" + URLEncoder.encode("item_price", "UTF-8")            + "=" + URLEncoder.encode(carbonfiber[33][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("item_weight", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[34][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("listing_id", "UTF-8")            + "=" + URLEncoder.encode(carbonfiber[35][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("notes", "UTF-8")                 + "=" + URLEncoder.encode(carbonfiber[36][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("package_d", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[37][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("package_l", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[38][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("package_w", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[39][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("part_number", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[40][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("payment_type", "UTF-8")          + "=" + URLEncoder.encode(carbonfiber[41][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("paypal_fees", "UTF-8")           + "=" + URLEncoder.encode(carbonfiber[42][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("picture_1", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[43][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("quantity_sold", "UTF-8")         + "=" + URLEncoder.encode(carbonfiber[44][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("sale_id", "UTF-8")               + "=" + URLEncoder.encode(carbonfiber[45][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("shipping_company", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[46][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("site_id", "UTF-8")               + "=" + URLEncoder.encode(carbonfiber[47][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("source_of_sale", "UTF-8")        + "=" + URLEncoder.encode(carbonfiber[48][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("title", "UTF-8")                 + "=" + URLEncoder.encode(carbonfiber[49][post_number].substring(1, carbonfiber[49][post_number].length() -1), "UTF-8");
            data += "&" + URLEncoder.encode("title_url", "UTF-8")             + "=" + URLEncoder.encode(carbonfiber[50][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("total_on_hand", "UTF-8")         + "=" + URLEncoder.encode(carbonfiber[51][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("tracking_number", "UTF-8")       + "=" + URLEncoder.encode(carbonfiber[52][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("transaction_id", "UTF-8")        + "=" + URLEncoder.encode(carbonfiber[53][post_number], "UTF-8");
            data += "&" + URLEncoder.encode("transaction_info", "UTF-8")      + "=" + URLEncoder.encode(carbonfiber[54][post_number], "UTF-8");





            // Send data
            url = new URL(send_url);
            conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {

                infox0.setText(line);

            }
            wr.close();
            rd.close();

        } catch (Exception e) {}




    }//connectx()*********************************************************************************************






    public void pullThePlug() {

        System.out.println("PULL THE PLUG");

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(String[][] sxx, String[][] ssxs, int[] selected_int){

	   alchemy_deletex xr = new alchemy_deletex(sxx, ssxs, selected_int);

    }//main






    class BackgroundPanel extends JPanel{
  
        Image image;
  
        public BackgroundPanel(){
    
            try{

                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3.jpg"), "background3.jpg"));

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