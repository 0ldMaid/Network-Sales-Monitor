import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_import_messages extends JFrame{//************************************************************************

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

String data2;
URL url2;
OutputStreamWriter wr2;
BufferedReader rd2;
URLConnection conn2;



JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int kcountxx = 0;
int kcountxx2 = 0;
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int stop = 0;
int post_number = 1;
int db_items = 0;
int carbon_items; 
int running = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0;
int ix6 = 0;
int ix1x = 0;
int ix0x = 0;
int websites = 50;
int HTMLINT = 0;
int looppx = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;

String carbonfiber = new String();
String[][] silver = new String[1][1];
String[][] silverx = new String[1][1];
String xgetx[] = new String[10000];
String xlinex = new String("");
String blank = new String("");
String HTMLGO = new String("");

File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");

int current_submit_item_xx = -1;


//************************************************************************************************************************
alchemy_import_messages(int ssxs){//****************************

	super("Import messages");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1; running = 0;}});


    //load images from JAR
	//Image ximagex = new ImageIcon(this.getClass().getResource("hex.png")).getImage();
	//setIconImage(ximagex);




    current_submit_item_xx = ssxs;

    System.out.println("current_submit_item_xx " + current_submit_item_xx);

    infoxs.setPreferredSize(new Dimension(320, 25));
    infoxs.setText("Import item list.");
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


	//setVisible(true);



    requestFocus();
    repaint();

    connectx();
    pullThePlug();

}//csv_loader_x1********************************************************








    public void connectx(){

        System.out.println("0");
        db_items = 0;

        // get list data
        try {

        	System.out.println("1");

                   data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][nm.current_submit_item_a], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");

        	System.out.println(data);

        	HTMLGO = nm.carbon[5][1][nm.current_submit_item_a];

        	System.out.println(HTMLGO + "/dbx_export_messages.php");

            // Send data
            url = new URL(HTMLGO + "/dbx_export_messages.php");
            conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {

            	ix0 = line.indexOf("<<<");
            	ix1 = line.indexOf(">>>");

            	if(ix0 > -1){

            	   xgetx[db_items] = line.substring(3, ix1);
            	   db_items++;

            	}//if

            }//while
            wr.close();
            rd.close();

        } catch (Exception e) {System.out.println("URL falure get item list.");}





        ix5 = 1;
        //import items

        System.out.println("db_items " + db_items);	
        carbon_items = 0;

        for(int xloopx = 0; xloopx < db_items; xloopx++){//********************************************************************
        infox0.setText("Import item: " + (xloopx + 1) + " of " + db_items);

            //see if item is already imported
        	for(int xloopx2 = 0; xloopx2 < nm.carbon[6][3].length; xloopx2++){//***************

            	nm.carbon[6][3][0] = "Message ID:";
            	ix3 = 0;
            	
                System.out.println(xloopx2 + " " + nm.carbon[6][3].length + " " + nm.carbon[6][3][xloopx2]);
            	ix4 = xgetx[xloopx].indexOf(nm.carbon[6][3][xloopx2]);
            	if(ix4 > -1){ix3++; System.out.println(" 77 " + nm.carbon[6][3][xloopx2]); break;}

        	}//for**************************************************************************
            //see if item is already imported

            if(ix3 == 0){looppx = xloopx; add_item(); ix5++; carbon_items++;}
            else{System.out.println("getx item already imported.");}//carbon_items++;


            requestFocus();

        }//for*****************************************************************************************************************



    }//connectx()*********************************************************************************************













    public void add_item(){//****************************************     *******       *********          ************



        silver = new String[nm.db_cc_number][nm.carbon[6][0].length + 1];
        System.out.println("silver length " + silver[0].length);


        ix6 = 0;
        for(int xloop1 = 1; xloop1 < silver[0].length; xloop1++){//************************
        for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************

            silver[xloop2][xloop1] = nm.carbon[6][xloop2][ix6]; 

        }//for********************************************
        ix6++;
        }//for********************************************



        nm.carbon[6] = silver;


        for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************
            nm.carbon[6][xloop2][0] = new String("*");
        }//for********************************************

        //first item is blank
        nm.carbon[6][0][0] = new String("Name");
        nm.carbon[6][1][0] = new String("E-mail");
        nm.carbon[6][2][0] = new String("Message body");
        nm.carbon[6][3][0] = new String("Message ID");
        nm.carbon[6][4][0] = new String("read?");
        nm.carbon[6][5][0] = new String("Site type");
        nm.carbon[6][6][0] = new String("Account");


        for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************
            nm.carbon[6][xloop2][1] = new String("*");
        }//for********************************************

        //first item is blank
        nm.carbon[6][0][1] = new String("Senders name:");
        nm.carbon[6][1][1] = new String("E-mail");
        nm.carbon[6][2][1] = new String("Message body");
        nm.carbon[6][3][1] = new String("Message ID");
        nm.carbon[6][4][1] = new String("read?");
        nm.carbon[6][5][1] = new String("Site type");
        nm.carbon[6][6][1] = new String("Account");






        // get items*************************************************************************************************
        try {

                   data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][nm.current_submit_item_a], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");
            data += "&" + URLEncoder.encode("item", "UTF-8")     + "=" + URLEncoder.encode(xgetx[looppx]  , "UTF-8");

            System.out.println(HTMLGO + "/dbx_export_messages.php" + data);


            // Send data
            url = new URL(HTMLGO + "/dbx_export_messages.php");
            conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            carbonfiber = new String("");

            while ((line = rd.readLine()) != null) {

            	carbonfiber = carbonfiber + line;
            	System.out.println("dd " + line);
        	
            }//while
            wr.close();
            rd.close();

        } catch (Exception e) {System.out.println("URL falure."); infox0.setText("URL falure.");}







        for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************

            silver[xloop2][1] = new String("*");

        }//for********************************************

        silver[0][1] = new String("Senders name:");
        silver[1][1] = new String("email");
        silver[2][1] = new String("message");
        silver[3][1] = new String("messageid");
        silver[4][1] = new String("no");
        silver[5][1] = new String("Alchemy");
        silver[6][1] = new String("sales@");

        System.out.println("nums " + (nm.carbon[6][0].length +1));







        cx0 = carbonfiber;

        System.out.println("numsx " + cx0);
        System.out.println("numsx " + ix5);


        for(int xloop2 = 0; xloop2 < 7; xloop2++){//************************

            ix0 = cx0.indexOf("<<,>>");


        	if(ix0 > -1){

            	silver[xloop2][1] = new String(cx0.substring(0, ix0));
            	System.out.println("nn " + silver[xloop2][1]);

            	cx0 = cx0.substring(ix0 + 5, cx0.length());

        	}//if**********************


        }//for*********************************************************************


        nm.carbon[6] = silver;

    }//******************add item















    public void pullThePlug() {

        System.out.println("PULL THE PLUG");

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

        nm.firex = 1;

    }//pull



    public static void main(int ssxs){

	   alchemy_import_messages xr = new alchemy_import_messages(ssxs);

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