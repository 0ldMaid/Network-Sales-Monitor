import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_export_settings extends JFrame{//************************************************************************

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


//settings for alchemist
static int ftp_set_url_xxal = 10;
static int ftp_set_folder_xxal = 11;
static int ftp_set_user_xxal = 12;
static int ftp_set_pass_xxal = 13;
//xx = 16;
//xx = 17;
//xx = 18;
//xx = 19;
//xx = 20; 
static int alchemist_shipping_type_xx = 42;









alchemy_export_settings(){//*********************************************************************************

	super("Export settings");
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
    //repaint();
    connectx();



}//csv_loader_x1********************************************************











    public void connectx(){
    ix0 = 0;


        // Construct data
        try {

            requestFocus();

                   data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][nm.current_submit_item_a], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");



        	for(int xloop = 0; xloop < 400; xloop++){//******

                data += "&" + URLEncoder.encode("valuex1_" + Integer.toString(xloop), "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][0][xloop].replace("<<,>>",""), "UTF-8");
                data += "&" + URLEncoder.encode("valuex2_" + Integer.toString(xloop), "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][1][xloop].replace("<<,>>",""), "UTF-8");
                data += "&" + URLEncoder.encode("valuex3_" + Integer.toString(xloop), "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][2][xloop].replace("<<,>>",""), "UTF-8");
                data += "&" + URLEncoder.encode("valuex4_" + Integer.toString(xloop), "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][3][xloop].replace("<<,>>",""), "UTF-8");

        	}//for*******************************************



            // Send data
            url = new URL(nm.carbon[5][1][nm.current_submit_item_a] + "/dbx_import_settings.php");
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

        } catch (Exception e){System.out.println("URL falure. Alchemy."); ix0++;}

        if(ix0 == 0){pullThePlug();}


    }//connectx()*********************************************************************************************






    public void pullThePlug() {

        System.out.println("PULL THE PLUG");

        nm.firex = 1;

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(){

	   alchemy_export_settings xr = new alchemy_export_settings();

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