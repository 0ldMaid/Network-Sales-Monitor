import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;




public class alchemy_get_items_list{//************************************************************************



String cx0 = new String();



alchemy_get_items_list(){



    System.out.println("Get listed Items.");

	for (int loop0 = 1; loop0 < nm.carbon[0][0].length; loop0++){//*************************************

	   nm.carbon[0][nm.sale_status_xx][loop0] = "Error";

	}//for**********************************************************************************************



    // Construct data
    try {


        String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][nm.current_submit_item_a], "UTF-8");
        data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");

        System.out.println(nm.carbon[5][1][nm.current_submit_item_a] + "/dbx_export_item_list.php");

        // Send data
        URL url = new URL(nm.carbon[5][1][nm.current_submit_item_a] + "/dbx_export_item_list.php");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();

        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null){

            cx0 = line;
	        System.out.println(cx0);

	        for (int loop0 = 1; loop0 < nm.carbon[0][0].length; loop0++){//*************************************

	            if(nm.carbon[0][nm.item_id_xx][loop0].equals(cx0)){nm.carbon[0][nm.sale_status_xx][loop0] = "Listed"; break;}

	        }//for**********************************************************************************************


        }//************************************
    
        wr.close();
        rd.close();
        //conn.close();

    }catch(Exception e){System.out.println("URL falure.");}





}//ebaytest













}//last****************************************