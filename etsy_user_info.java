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
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;



public class etsy_user_info{//************************************************************************

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








public String get_user_info(){//**********************************************************


    String testx = new String("");

		// Construct data
		try {

  			cx0 = "-1";
  			ix0 = 0;


  			String apiKey = nm.carbon[5][2][nm.current_submit_item_a];
  			String apiSecret = nm.carbon[5][3][nm.current_submit_item_a];


  			String NETWORK_NAME = "Etsy";
  			String AUTHORIZE_URL = "";
  			String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/users/" + nm.carbon[5][nm.etsy_account_id][nm.current_submit_item_a] + "";//13106362




			System.out.println(apiKey);
			System.out.println(apiSecret);

    		OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();



    		System.out.println(nm.carbon[5][nm.etsy_token_xx][nm.current_submit_item_a]);
    		System.out.println(nm.carbon[5][nm.etsy_secret_xx][nm.current_submit_item_a]);
    		System.out.println(nm.carbon[5][nm.etsy_raw_xx][nm.current_submit_item_a]);


    		Token accessToken = new Token(nm.carbon[5][nm.etsy_token_xx][nm.current_submit_item_a],nm.carbon[5][nm.etsy_secret_xx][nm.current_submit_item_a],nm.carbon[5][nm.etsy_raw_xx][nm.current_submit_item_a]);
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

                testx = requestx;

				System.out.println(requestx);


			}catch(ParseException e){e.printStackTrace(); nm.pass_com = "0"; JOptionPane.showMessageDialog(null, response.getBody());}


		}catch(Exception e){e.printStackTrace();}


		return testx;

}//csv_loader_x1********************************************************












class BackgroundPanel extends JPanel{

  	Image image;
  	public BackgroundPanel(){

    	try{

      		image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundyellow.jpg"), "backgroundyellow.jpg"));

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

