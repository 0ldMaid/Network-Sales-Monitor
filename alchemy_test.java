import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_test{//************************************************************************


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








alchemy_test(){//****************************

    System.out.println(nm.carbon[5][2][nm.what_item]);
    connectx();
    System.out.println(nm.carbon[5][2][nm.what_item]);

}//csv_loader_x1********************************************************










    public void connectx(){


        System.out.println(nm.carbon[5][1][nm.what_item] + "/dbx_test.php");


        System.out.println(nm.carbon[5][2][nm.what_item]);
        System.out.println(nm.carbon[5][3][nm.what_item]);


        // Construct data
        try {

            cx0 = "-1";
            ix0 = 0;


            String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][nm.what_item], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][nm.what_item], "UTF-8");


            // Send data
            URL url = new URL(nm.carbon[5][1][nm.what_item] + "/dbx_test.php");
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

            }//*************************************

            wr.close();
            rd.close();
            //conn.close();

        } catch (Exception e){System.out.println("Connection Failed. " + nm.carbon[5][1][nm.what_item] + "/dbx_test.php");}



        System.out.println("Get html " + cx0);


        nm.pass_com = cx0;



    }//connectx()*********************************************************************************************










}//last****************************************