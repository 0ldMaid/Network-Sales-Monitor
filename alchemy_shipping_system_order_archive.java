import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;







public class alchemy_shipping_system_order_archive{//************************************************************************






alchemy_shipping_system_order_archive(){//****************************


    export_to_shipping_system();

    pullThePlug();


}//csv_loader_x1********************************************************







	public void export_to_shipping_system(){


        try {//*******************************************************


            String new_name = nm.carbon[3][nm.quantity_sold_xx][nm.what_item]    + "X_Unit(s)_" + nm.carbon[3][nm.part_number_xx][nm.what_item].replace(" ","_").replace("'","").replace("/","") + "_" + nm.carbon[3][nm.sale_id_xx][nm.what_item];


            String data = URLEncoder.encode("quantity", "UTF-8")          + "=" + URLEncoder.encode(nm.carbon[3][nm.quantity_sold_xx][nm.what_item], "UTF-8");
            data += "&" + URLEncoder.encode("buyer_name", "UTF-8")        + "=" + URLEncoder.encode(nm.carbon[3][nm.buyers_first_name_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("item_part", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[3][nm.part_number_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("pdf_link", "UTF-8")          + "=" + URLEncoder.encode("/labels/" + new_name + ".pdf", "UTF-8");
            data += "&" + URLEncoder.encode("user", "UTF-8")              + "=" + URLEncoder.encode(nm.carbon[4][0][58], "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8")          + "=" + URLEncoder.encode(nm.carbon[4][0][57], "UTF-8");
            data += "&" + URLEncoder.encode("key", "UTF-8")               + "=" + URLEncoder.encode(nm.carbon[4][0][59], "UTF-8");
            data += "&" + URLEncoder.encode("tracking_id", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[3][nm.tracking_number_xx][nm.what_item].replace(" ",""), "UTF-8");

            data += "&" + URLEncoder.encode("shipping_id_a1", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[3][nm.address_1_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_id_city", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[3][nm.address_2_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_id_state", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[3][nm.address_3_xx][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_id_zip", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[3][nm.address_4_xx][nm.what_item].replace("'",""), "UTF-8");

            System.out.println(nm.carbon[3][ Integer.parseInt(nm.carbon[4][62][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[3][ Integer.parseInt(nm.carbon[4][63][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[3][ Integer.parseInt(nm.carbon[4][64][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[3][ Integer.parseInt(nm.carbon[4][65][0]) ][nm.what_item].replace("'",""));
            System.out.println(nm.carbon[3][ Integer.parseInt(nm.carbon[4][66][0]) ][nm.what_item].replace("'",""));

            data += "&" + URLEncoder.encode("status", "UTF-8")            + "=" + URLEncoder.encode(nm.carbon[3][ nm.sale_status_xx ][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("store_idx", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[3][ nm.source_of_sale_xx ][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("shipping_company", "UTF-8")  + "=" + URLEncoder.encode(nm.carbon[3][ nm.shipping_company_xx ][nm.what_item].replace("'",""), "UTF-8");
            data += "&" + URLEncoder.encode("sale_id", "UTF-8")           + "=" + URLEncoder.encode(nm.carbon[3][ nm.sale_id_xx ][nm.what_item], "UTF-8");

            System.out.println(nm.carbon[3][ nm.transaction_id_xx ][nm.what_item]);
            System.out.println("idx " + nm.carbon[5][0][ Integer.parseInt(nm.carbon[3][ nm.transaction_id_xx ][nm.what_item]) ].replace("'",""));



            // Send data
            System.out.println("post order too: " + nm.carbon[4][0][56]);
            URL url = new URL(nm.carbon[4][0][56]);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
    
            while ((line = rd.readLine()) != null) {
        
                //infox2.setText(line);
	            System.out.println(line);

            }//*************************************

            wr.close();
            rd.close();

        } catch (Exception e){System.out.println("URL falure. EXPORT LABEL.");}




	}//**************************************









    public void pullThePlug() {


        nm.firex = 1;

        System.out.println("PULL THE PLUG");


    }//pull







}//last****************************************