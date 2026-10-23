import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;
import java.awt.Toolkit;
import java.net.URLConnection;
import java.security.Security.*;
import com.sun.net.ssl.*;
import com.sun.*; 
import javax.net.ssl.HttpsURLConnection;
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;




public class etsy_post_order_addtrack {//************************************************************************



int ix10 = 0;



etsy_post_order_addtrack(int px10) {//*******************************************

    ix10 = px10;

	connectx();

}//csv_loader_x1********************************************************







    public static int find_site_match(String id) {

        System.out.println("Find Site Match...");

        int id_match = -1;

        for (int loop1 = 0; loop1 < nm.carbon[5][2].length; loop1++){

            if(nm.carbon[5][nm.id_mm][loop1].equals(id)){id_match = loop1;}

        }//************************************************

        System.out.println("id_match " + id_match);

        return id_match;

    }//************************************








    public void connectx(){


        // Construct data
        try {


            int id_match = find_site_match(nm.carbon[2][nm.transaction_id_xx][ix10]);

            //String apiKey = nm.carbon[5][2][nm.current_submit_item_a];
            //String apiSecret = nm.carbon[5][3][nm.current_submit_item_a];

            String apiKey = nm.carbon[5][2][id_match];
            String apiSecret = nm.carbon[5][3][id_match];


            String NETWORK_NAME = "Etsy";
            String AUTHORIZE_URL = "";

            String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/shops/" + nm.carbon[5][etsy_settings.etsy_shop_id][id_match] + "/receipts/" + nm.carbon[2][nm.transaction_info_xx][nm.what_item] + "/tracking";


            System.out.println(apiKey);
            System.out.println(apiSecret);

            OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();



            System.out.println(nm.carbon[5][etsy_settings.etsy_token_xx][id_match]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_secret_xx][id_match]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_raw_xx][id_match]);


            Token accessToken = new Token(nm.carbon[5][etsy_settings.etsy_token_xx][id_match],nm.carbon[5][etsy_settings.etsy_secret_xx][id_match],nm.carbon[5][etsy_settings.etsy_raw_xx][id_match]);
            System.out.println("Got the Access Token!");
            System.out.println();



            // Now let's go and ask for a protected resource!
            System.out.println("Now we're going to access a protected resource...");
            OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
            

            request.addBodyParameter("tracking_code",            "25131520696");
            request.addBodyParameter("carrier_name",             "USPS");
            request.addBodyParameter("send_bcc",                 "1000N1");


            service.signRequest(accessToken, request);

            Response response = request.send();
            System.out.println("Got it! Lets see what we found...");
            System.out.println();
            System.out.println(response.getCode());
            System.out.println(response.getBody());

            System.out.println();
            System.out.println("Thats it man! Go and build something awesome with Scribe! :)");





	        JSONParser parser = new JSONParser();

	        try {//*********************************************************
 

		        Object obj = parser.parse(response.getBody());
 
		        JSONObject jsonObject = (JSONObject) obj;
  
		        String requestx = (String) jsonObject.get("count").toString();
                String resultsx = (String) jsonObject.get("results").toString();

		        //System.out.println(requestx);

                if(requestx.equals("1")){

                    System.out.println("NEXT>>");
                    System.out.println(resultsx);


                }//**********************



                nm.carbon[2][nm.notes_xx][ix10] = "[INFO UPLOADED TO STORE]";

	        } catch (ParseException e){

                e.printStackTrace(); 
                nm.pass_com = "0";
                JOptionPane.showMessageDialog(null, response.getBody());

            }



        } catch (Exception e) {e.printStackTrace();}



    }//connectx()*********************************************************************************************








}//last****************************************