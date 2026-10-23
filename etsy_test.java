import java.io.*;
import javax.swing.*;
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
import java.awt.datatransfer.*;





public class etsy_test{//************************************************************************




    public String test(int what_item) {


        String pass_com = "0";


        // Construct data
        try {



            String apiKey = nm.carbon[5][nm.user_info_xx][what_item];
            String apiSecret = nm.carbon[5][nm.pass_info_xx][what_item];


            String NETWORK_NAME = "Etsy";
            String AUTHORIZE_URL = "";
            String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/shops/" + nm.carbon[5][nm.key2_info_xx][what_item] + "/receipts/unshipped";
            Token EMPTY_TOKEN = new Token(apiKey, apiSecret);



            System.out.println(apiKey);
            System.out.println(apiSecret);

            OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();


            Scanner in = new Scanner(System.in);

            System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
            System.out.println();


            EMPTY_TOKEN = service.getRequestToken();


            // Obtain the Authorization URL
            System.out.println("Fetching the Authorization URL...");
            String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);

            System.out.println(EMPTY_TOKEN.getToken());

            System.out.println("Got the Authorization URL!");
            System.out.println("Now go and authorize Scribe here:");
            System.out.println(authorizationUrl);
            System.out.println("And paste the authorization code here");
            System.out.print(">>");


            StringSelection selection = new StringSelection(authorizationUrl);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);


            JOptionPane.showMessageDialog(null, "Login Here for your Key: " + authorizationUrl + "\nThe URL has been saved to your clipboard also.");

            Verifier verifier = new Verifier("");
            System.out.println();

            String verifier2 = JOptionPane.showInputDialog(null, "Enter the Key", "Key", JOptionPane.QUESTION_MESSAGE);

            if (verifier2.length() > 0) {

                verifier = new Verifier(verifier2);

            }//**************************
            else {

                JOptionPane.showMessageDialog(null, "Invalid Key!");

            }//***


            // Trade the Request Token and Verfier for the Access Token
            System.out.println("Trading the Request Token for an Access Token...");
            Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
            System.out.println("Got the Access Token!");
            System.out.println("(if your curious it looks like this: " + accessToken + " )");
            System.out.println("(if your curious it looks like this: " + accessToken.getToken() + " )");
            System.out.println("(if your curious it looks like this: " + accessToken.getSecret() + " )");
            System.out.println("(if your curious it looks like this: " + accessToken.getRawResponse() + " )");
            System.out.println();

            nm.carbon[5][etsy_settings.etsy_token_xx][what_item] = accessToken.getToken();
            nm.carbon[5][etsy_settings.etsy_secret_xx][what_item] = accessToken.getSecret();
            nm.carbon[5][etsy_settings.etsy_raw_xx][what_item] = accessToken.getRawResponse();

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

		        pass_com = "1";


	        } catch (ParseException e) {

                e.printStackTrace(); 
                pass_com = "0"; 
                JOptionPane.showMessageDialog(null, response.getBody());

            }




        } catch(Exception e) {e.printStackTrace(); pass_com = "0";}


        return pass_com;

    }//connectx()*********************************************************************************************




}//last****************************************







