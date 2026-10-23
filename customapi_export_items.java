import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;





public class customapi_export_items extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;
int post_number = 1;
int ix0x = 0;
int ix1x = 0; 
int ix2x = 0;

Float fx0x = (float) 0.0;

String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");
String ssxs;
String ssxu;
String ssxp;
String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String cx3 = new String("");








customapi_export_items(String[][] s1, String s2, String s3, String s4){//*********************************************************************************

	super("Custom API Export");
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
    infox0.setText("Version 2.1.1");
    infox0.setHorizontalTextPosition(JLabel.LEFT);
    infox0.setIconTextGap(30);

    infox1.setPreferredSize(new Dimension(320, 25));
    infox1.setText("Loading Export Items");
    infox1.setForeground(nm.whitex);
    infox1.setOpaque(true); 
    infox1.setBackground(nm.blackx);

    infox2.setPreferredSize(new Dimension(320, 25));
    infox2.setText("Exporting...");
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




    requestFocus();
    repaint();
    runx();



}//csv_loader_x1********************************************************
















	public void runx(){

	   System.out.println(ix1x);

	   for(int xloop = 0; xloop < ix1; xloop++){//******

	       post_number = xloop; 
	       connectx();
	       infox1.setText("Export: " + (xloop + 1) + " of " + ix1);
	       requestFocus();

	   }//**************************************************************

	   pullThePlug();


	}//run






    public void connectx(){

        String data;
        URL url;
        OutputStreamWriter wr;
        BufferedReader rd;
        URLConnection conn;

        // Construct data
        try {


            requestFocus();


                   data = URLEncoder.encode("user", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[5][2][nm.current_submit_item_a], "UTF-8");
            data += "&" + URLEncoder.encode("pass", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");

            String hold_item_description = new String("");

            hold_item_description = "";


		    for (int loop3 = 0; loop3 < nm.db_string.length; loop3++){//*************************

		        hold_item_description = hold_item_description.replace("[[" + nm.db_string[loop3] + "]]", carbonfiber[loop3][post_number]);

		    }//for**********************************************************************************


            hold_item_description = hold_item_description.replace("<<,>>","<<*>>").replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            hold_item_description = hold_item_description.replace("±","&#177;");
            hold_item_description = hold_item_description.replace("“","\"");
            hold_item_description = hold_item_description.replace("”","\"");




            int x1 = Integer.parseInt(nm.carbon[5][nm.m2_cx1_xx][nm.current_submit_item_a]);
            int x2 = Integer.parseInt(nm.carbon[5][nm.m2_cx2_xx][nm.current_submit_item_a]);
            int x3 = Integer.parseInt(nm.carbon[5][nm.m2_cx3_xx][nm.current_submit_item_a]);
            int x4 = Integer.parseInt(nm.carbon[5][nm.m2_cx4_xx][nm.current_submit_item_a]);
            int x5 = Integer.parseInt(nm.carbon[5][nm.m2_cx5_xx][nm.current_submit_item_a]);
            int x6 = Integer.parseInt(nm.carbon[5][nm.m2_cx6_xx][nm.current_submit_item_a]);
            int x7 = Integer.parseInt(nm.carbon[5][nm.m2_cx7_xx][nm.current_submit_item_a]);
            int x8 = Integer.parseInt(nm.carbon[5][nm.m2_cx8_xx][nm.current_submit_item_a]);
            int x9 = Integer.parseInt(nm.carbon[5][nm.m2_cx9_xx][nm.current_submit_item_a]);
            int x10 = Integer.parseInt(nm.carbon[5][nm.m2_cx10_xx][nm.current_submit_item_a]);
            int x11 = Integer.parseInt(nm.carbon[5][nm.m2_cx11_xx][nm.current_submit_item_a]);
            int x12 = Integer.parseInt(nm.carbon[5][nm.m2_cx12_xx][nm.current_submit_item_a]);
            int x13 = Integer.parseInt(nm.carbon[5][nm.m2_cx13_xx][nm.current_submit_item_a]);
            int x14 = Integer.parseInt(nm.carbon[5][nm.m2_cx14_xx][nm.current_submit_item_a]);
            int x15 = Integer.parseInt(nm.carbon[5][nm.m2_cx15_xx][nm.current_submit_item_a]);
            int x16 = Integer.parseInt(nm.carbon[5][nm.m2_cx16_xx][nm.current_submit_item_a]);
            int x17 = Integer.parseInt(nm.carbon[5][nm.m2_cx17_xx][nm.current_submit_item_a]);
            int x18 = Integer.parseInt(nm.carbon[5][nm.m2_cx18_xx][nm.current_submit_item_a]);
            int x19 = Integer.parseInt(nm.carbon[5][nm.m2_cx19_xx][nm.current_submit_item_a]);
            int x20 = Integer.parseInt(nm.carbon[5][nm.m2_cx20_xx][nm.current_submit_item_a]);
            int x21 = Integer.parseInt(nm.carbon[5][nm.m2_cx21_xx][nm.current_submit_item_a]);
            int x22 = Integer.parseInt(nm.carbon[5][nm.m2_cx22_xx][nm.current_submit_item_a]);
            int x23 = Integer.parseInt(nm.carbon[5][nm.m2_cx23_xx][nm.current_submit_item_a]);
            int x24 = Integer.parseInt(nm.carbon[5][nm.m2_cx24_xx][nm.current_submit_item_a]);
            int x25 = Integer.parseInt(nm.carbon[5][nm.m2_cx25_xx][nm.current_submit_item_a]);
            int x26 = Integer.parseInt(nm.carbon[5][nm.m2_cx26_xx][nm.current_submit_item_a]);
            int x27 = Integer.parseInt(nm.carbon[5][nm.m2_cx27_xx][nm.current_submit_item_a]);
            int x28 = Integer.parseInt(nm.carbon[5][nm.m2_cx28_xx][nm.current_submit_item_a]);
            int x29 = Integer.parseInt(nm.carbon[5][nm.m2_cx29_xx][nm.current_submit_item_a]);
            int x30 = Integer.parseInt(nm.carbon[5][nm.m2_cx30_xx][nm.current_submit_item_a]);


            String s1 = carbonfiber[x1][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s2 = carbonfiber[x2][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s3 = carbonfiber[x3][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s4 = carbonfiber[x4][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s5 = carbonfiber[x5][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s6 = carbonfiber[x6][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s7 = carbonfiber[x7][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s8 = carbonfiber[x8][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s9 = carbonfiber[x9][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s10 = carbonfiber[x10][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s11 = carbonfiber[x11][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s12 = carbonfiber[x12][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s13 = carbonfiber[x13][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s14 = carbonfiber[x14][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s15 = carbonfiber[x15][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s16 = carbonfiber[x16][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s17 = carbonfiber[x17][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s18 = carbonfiber[x18][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s19 = carbonfiber[x19][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s20 = carbonfiber[x20][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s21 = carbonfiber[x21][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s22 = carbonfiber[x22][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s23 = carbonfiber[x23][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s24 = carbonfiber[x24][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s25 = carbonfiber[x25][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s26 = carbonfiber[x26][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s27 = carbonfiber[x27][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s28 = carbonfiber[x28][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s29 = carbonfiber[x29][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);
            String s30 = carbonfiber[x30][post_number].replace("[[url]]", nm.carbon[5][nm.m2_pic_url_xx][nm.current_submit_item_a]);


            data += "&" + URLEncoder.encode("cpost1", "UTF-8")   + "=" + URLEncoder.encode(s1, "UTF-8");
            data += "&" + URLEncoder.encode("cpost2", "UTF-8")   + "=" + URLEncoder.encode(s2, "UTF-8");
            data += "&" + URLEncoder.encode("cpost3", "UTF-8")   + "=" + URLEncoder.encode(s3, "UTF-8");
            data += "&" + URLEncoder.encode("cpost4", "UTF-8")   + "=" + URLEncoder.encode(s4, "UTF-8");
            data += "&" + URLEncoder.encode("cpost5", "UTF-8")   + "=" + URLEncoder.encode(s5, "UTF-8");
            data += "&" + URLEncoder.encode("cpost6", "UTF-8")   + "=" + URLEncoder.encode(s6, "UTF-8");
            data += "&" + URLEncoder.encode("cpost7", "UTF-8")   + "=" + URLEncoder.encode(s7, "UTF-8");
            data += "&" + URLEncoder.encode("cpost8", "UTF-8")   + "=" + URLEncoder.encode(s8, "UTF-8");
            data += "&" + URLEncoder.encode("cpost9", "UTF-8")   + "=" + URLEncoder.encode(s9, "UTF-8");
            data += "&" + URLEncoder.encode("cpost10", "UTF-8")  + "=" + URLEncoder.encode(s10, "UTF-8");
            data += "&" + URLEncoder.encode("cpost11", "UTF-8")  + "=" + URLEncoder.encode(s11, "UTF-8");
            data += "&" + URLEncoder.encode("cpost12", "UTF-8")  + "=" + URLEncoder.encode(s12, "UTF-8");
            data += "&" + URLEncoder.encode("cpost13", "UTF-8")  + "=" + URLEncoder.encode(s13, "UTF-8");
            data += "&" + URLEncoder.encode("cpost14", "UTF-8")  + "=" + URLEncoder.encode(s14, "UTF-8");
            data += "&" + URLEncoder.encode("cpost15", "UTF-8")  + "=" + URLEncoder.encode(s15, "UTF-8");
            data += "&" + URLEncoder.encode("cpost16", "UTF-8")  + "=" + URLEncoder.encode(s16, "UTF-8");
            data += "&" + URLEncoder.encode("cpost17", "UTF-8")  + "=" + URLEncoder.encode(s17, "UTF-8");
            data += "&" + URLEncoder.encode("cpost18", "UTF-8")  + "=" + URLEncoder.encode(s18, "UTF-8");
            data += "&" + URLEncoder.encode("cpost19", "UTF-8")  + "=" + URLEncoder.encode(s19, "UTF-8");
            data += "&" + URLEncoder.encode("cpost20", "UTF-8")  + "=" + URLEncoder.encode(s20, "UTF-8");
            data += "&" + URLEncoder.encode("cpost21", "UTF-8")  + "=" + URLEncoder.encode(s21, "UTF-8");
            data += "&" + URLEncoder.encode("cpost22", "UTF-8")  + "=" + URLEncoder.encode(s22, "UTF-8");
            data += "&" + URLEncoder.encode("cpost23", "UTF-8")  + "=" + URLEncoder.encode(s23, "UTF-8");
            data += "&" + URLEncoder.encode("cpost24", "UTF-8")  + "=" + URLEncoder.encode(s24, "UTF-8");
            data += "&" + URLEncoder.encode("cpost25", "UTF-8")  + "=" + URLEncoder.encode(s25, "UTF-8");
            data += "&" + URLEncoder.encode("cpost26", "UTF-8")  + "=" + URLEncoder.encode(s26, "UTF-8");
            data += "&" + URLEncoder.encode("cpost27", "UTF-8")  + "=" + URLEncoder.encode(s27, "UTF-8");
            data += "&" + URLEncoder.encode("cpost28", "UTF-8")  + "=" + URLEncoder.encode(s28, "UTF-8");
            data += "&" + URLEncoder.encode("cpost29", "UTF-8")  + "=" + URLEncoder.encode(s29, "UTF-8");
            data += "&" + URLEncoder.encode("cpost30", "UTF-8")  + "=" + URLEncoder.encode(s30, "UTF-8");




            //inventory control
            if(nm.carbon[4][0][72].equals("1")){

                System.out.println("TEST1");

                try{

                    ix0x = Integer.parseInt(carbonfiber[95][post_number]);
                    ix1x = Integer.parseInt(carbonfiber[nm.total_on_hand_xx][post_number]);
                    ix2x = nm.current_submit_item_a;

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

	                   if( (ix1x - nm.current_submit_item_x) >= 0 ){ix0x = 1;}
	                   else{ix0x = 0;}

                    }//********************************
                    else{ix0x = 0;}

                    System.out.println("TEST5");

                    data += "&" + URLEncoder.encode("total_on_hand", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(ix0x).replace("<<,>>",""), "UTF-8");

                    System.out.println("TEST6");

                }catch(Exception e){data += "&" + URLEncoder.encode("total_on_hand", "UTF-8") + "=" + URLEncoder.encode(carbonfiber[95][post_number].replace("<<,>>",""), "UTF-8"); System.out.println("Inventory Control fail.");}

            }//*********************************
            else{data += "&" + URLEncoder.encode("total_on_hand", "UTF-8") + "=" + URLEncoder.encode(carbonfiber[95][post_number].replace("<<,>>",""), "UTF-8");}
            //inventory control





            // Send data
            System.out.println("SEND TO " + nm.carbon[5][1][nm.current_submit_item_a] + "/import_inventory.php");
            url = new URL(nm.carbon[5][1][nm.current_submit_item_a] + "/import_inventory.php");
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
    
            }//*************************************

            wr.close();
            rd.close();

        } catch (Exception e){System.out.println("URL falure. Alchemy.");}


    }//connectx()*********************************************************************************************






    public void pullThePlug() {

        System.out.println("PULL THE PLUG");

        nm.firex = 1;

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(String[][] sxx, String ssxs, String ssxu, String ssxp){

	   customapi_export_items xr = new customapi_export_items(sxx, ssxs, ssxu, ssxp);

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