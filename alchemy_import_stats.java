import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_import_stats extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


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








alchemy_import_stats(){//****************************


    connectx();


}//csv_loader_x1********************************************************










    public void connectx(){


        nm.stats_hits = "n/a";
        nm.stats_running = "n/a";
        nm.stats_sales = "n/a";

        System.out.println(nm.carbon[1][1][nm.what_item] + "/dbx_export_stats.php");


        System.out.println(nm.carbon[5][2][nm.what_item]);
        System.out.println(nm.carbon[5][3][nm.what_item]);


        // Construct data
        try {

            cx0 = "-1";
            ix0 = 0;


            String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][Integer.parseInt(nm.carbon[1][6][nm.what_item])], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][Integer.parseInt(nm.carbon[1][6][nm.what_item])], "UTF-8");


            // Send data
            URL url = new URL(nm.carbon[1][1][nm.what_item] + "/dbx_export_stats.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {

                cx0 = line;

            }
            wr.close();
            rd.close();
            //conn.close();





            System.out.println("Get html " + cx0);

            ix0 = cx0.indexOf("<<,>>");
            if(ix0 > -1){cx1 = cx0.substring(0, ix0);}
            nm.carbon[nm.db_number][2][nm.what_item] = cx1;
            if(cx0.length() > 2){cx0 = cx0.substring(ix0 + 5, cx0.length());}
            else{infox1.setText("HTML falure. String is = -1. Section 1");}
            System.out.println(cx1);
            nm.stats_running = cx1;

            ix0 = cx0.indexOf("<<,>>");
            if(ix0 > -1){cx2 = cx0.substring(0, ix0);}
            nm.carbon[nm.db_number][3][nm.what_item] = cx2;
            if(cx0.length() > 2){cx0 = cx0.substring(ix0 + 5, cx0.length());}
            else{infox1.setText("HTML falure. String is = -1. Section 2");}
            System.out.println(cx2);
            nm.stats_hits = cx2;

            ix0 = cx0.indexOf("<<,>>");
            if(ix0 > -1){cx3 = cx0.substring(0, ix0);}
            nm.carbon[nm.db_number][4][nm.what_item] = cx3;
            System.out.println(cx3);
            nm.stats_sales = cx3;



        }catch(Exception e){System.out.println("Connection Failed. " + nm.carbon[1][1][nm.what_item] + "/dbx_import_stats.php");}



    }//connectx()*********************************************************************************************






    public void pullThePlug() {

        System.out.println("PULL THE PLUG");

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull






}//last****************************************