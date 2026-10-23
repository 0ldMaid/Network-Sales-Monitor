import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.util.*;
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



public class etsy_import_stats {//************************************************************************


int what_item = 0;


etsy_import_stats(int what_item_x){//***********************************


    what_item = what_item_x;

    connectx();


}//csv_loader_x1********************************************************






    public void connectx() {


        // Construct data
        try {


            System.out.println("to string " + Integer.parseInt(nm.carbon[1][6][what_item]));

            String apiKey = nm.carbon[5][2][ Integer.parseInt(nm.carbon[1][6][what_item]) ];
            String apiSecret = nm.carbon[5][3][ Integer.parseInt(nm.carbon[1][6][what_item]) ];


            String NETWORK_NAME = "Etsy";
            String AUTHORIZE_URL = "";
            String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/shops/" + nm.carbon[5][etsy_settings.etsy_shop_id][ Integer.parseInt(nm.carbon[1][6][what_item]) ] + "/listings/active";
            Token EMPTY_TOKEN = new Token(apiKey, apiSecret);



            System.out.println(apiKey);
            System.out.println(apiSecret);

            OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();



            System.out.println(nm.carbon[5][etsy_settings.etsy_token_xx][ Integer.parseInt(nm.carbon[1][6][what_item]) ]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_secret_xx][ Integer.parseInt(nm.carbon[1][6][what_item]) ]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_raw_xx][ Integer.parseInt(nm.carbon[1][6][what_item]) ]);


            Token accessToken = new Token(nm.carbon[5][etsy_settings.etsy_token_xx][ Integer.parseInt(nm.carbon[1][6][what_item]) ], nm.carbon[5][etsy_settings.etsy_secret_xx][ Integer.parseInt(nm.carbon[1][6][what_item]) ], nm.carbon[5][etsy_settings.etsy_raw_xx][ Integer.parseInt(nm.carbon[1][6][what_item]) ]);
            System.out.println("Got the Access Token!");
            System.out.println();



            // Now let's go and ask for a protected resource!
            System.out.println("Now we're going to access a protected resource...");
            OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
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

		        System.out.println(requestx);

                nm.stats_running = requestx;
                nm.stats_hits = "n/a";
                nm.stats_sales = "n/a";


	        } catch (ParseException e) {

                e.printStackTrace(); 
                JOptionPane.showMessageDialog(null, response.getBody());

            }



        } catch (Exception e) {e.printStackTrace();}



    }//connectx()*********************************************************************************************



}//last****************************************







