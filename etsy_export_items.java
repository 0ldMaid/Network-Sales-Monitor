import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.scribe.builder.*;
import org.scribe.model.*;
import org.scribe.oauth.*;
import org.apache.http.entity.ContentType;
import org.apache.http.HttpEntity;
import org.apache.http.Header;
import org.apache.http.entity.mime.MultipartEntityBuilder;






public class etsy_export_items extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

String request_id = new String("");//the ID of the new item that is created
boolean SUCCESS = false;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int what_item_here = 0;




etsy_export_items() {//**********************************************************

	super("Etsy Export");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


    //load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	Image ximagex2 = new ImageIcon(this.getClass().getResource("images/etsy.png")).getImage();
	Icon aicon = new ImageIcon(ximagex2);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("OAuth Start");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("Loading...");
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



	Container cp = getContentPane();
	cp.add(bkp);



    //runxxx();//set up the local shipping box

	setVisible(true);



    what_item_here = 0;
    int ix0 = 0;

    for (int xloopx = 0; xloopx < nm.carbon[0][0].length; xloopx++) {//*****************************************************


        if (nm.selected_int[xloopx] == 1) {

            what_item_here = xloopx;

            setTitle("Export to Etsy: (" + (ix0 + 1) + ")");
            infox1.setText("Export: (" + (ix0 + 1) + ") " + nm.carbon[0][nm.part_number_xx][what_item_here]);
            connectx();

            System.out.println("TEST RS " + request_id.length());

            infox2.setText("Exported: (" + (ix0 + 1) + ") item(s)");

            ix0++;

        }//if******************


    }//for*****************************************************************************************************************


    pullThePlug();





}//csv_loader_x1********************************************************










    public void connectx() {


        // Construct data
        try {


            //reset
            request_id = "";

            infox2.setText("Get new token ID...");

            String apiKey = nm.carbon[5][2][nm.current_submit_item_a];
            String apiSecret = nm.carbon[5][3][nm.current_submit_item_a];

            String NETWORK_NAME = "Etsy";
            String AUTHORIZE_URL = "";

            String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/listings";

            System.out.println(apiKey);
            System.out.println(apiSecret);

            OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();



            System.out.println(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a]);

            System.out.println(nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);


            Token accessToken = new Token(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a], nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a], nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);
            System.out.println("Got the Access Token!");
            System.out.println();



            // Now let's go and ask for a protected resource!
            System.out.println("Now we're going to access a protected resource...");
            OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
            

            int ssx_materials = Integer.parseInt(nm.carbon[5][etsy_settings.etsy_materials_xx][nm.current_submit_item_a]);
            int ssx_shipping = Integer.parseInt(nm.carbon[5][etsy_settings.etsy_template_xx][nm.current_submit_item_a]);
            int ssx_state = Integer.parseInt(nm.carbon[5][etsy_settings.etsy_state_xx][nm.current_submit_item_a]);
            int ssx_processing_min = Integer.parseInt(nm.carbon[5][etsy_settings.etsy_processing_min_xx][nm.current_submit_item_a]);
            int ssx_processing_max = Integer.parseInt(nm.carbon[5][etsy_settings.etsy_processing_max_xx][nm.current_submit_item_a]);


            request.addBodyParameter("quantity",                        nm.carbon[0][nm.total_on_hand_xx][what_item_here]);               //Y
            request.addBodyParameter("title",                           nm.carbon[0][nm.title_xx][what_item_here]);                       //Y
            request.addBodyParameter("description",                     nm.carbon[0][nm.item_description_xx][what_item_here]);            //Y
            request.addBodyParameter("price",                           nm.carbon[0][nm.item_price_xx][what_item_here]);                  //Y
            request.addBodyParameter("materials",                       nm.carbon[0][ssx_materials][what_item_here]);                     //N
            request.addBodyParameter("shipping_template_id",            nm.carbon[0][ssx_shipping][what_item_here]);//25131520696         //Y
            //request.addBodyParameter("shop_section_id",               "1");                                                             //N
            //request.addBodyParameter("image_ids",                     "10001");                                                         //N
            //request.addBodyParameter("is_customizable",               "false");                                                         //N
            request.addBodyParameter("non_taxable",                     "true");                                                          //N
            //request.addBodyParameter("image",                         imageBody);                                                       //N
            request.addBodyParameter("state",                           "draft");                                                         //N
            request.addBodyParameter("processing_min",                  nm.carbon[0][ssx_processing_min][what_item_here]);                //N
            request.addBodyParameter("processing_max",                  nm.carbon[0][ssx_processing_max][what_item_here]);                //N
            //request.addBodyParameter("category_id",                   "1");                                                             //N
            request.addBodyParameter("tags",                            nm.carbon[0][nm.title_xx][what_item_here].replace(" ",","));      //N
            request.addBodyParameter("who_made",                        "i_did");                                                         //Y
            request.addBodyParameter("is_supply",                       "true");                                                          //Y
            request.addBodyParameter("when_made",                       "made_to_order");                                                 //Y
            //request.addBodyParameter("recipient",                     "women");                                                         //N
            //request.addBodyParameter("occasion",                      "wedding");                                                       //N
            //request.addBodyParameter("style",                         "");                                                              //N



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

                if (requestx.equals("1")) {

                    System.out.println("NEXT>>");
                    System.out.println(resultsx);

                    Object objx2 = parser.parse(resultsx);
                    JSONArray array = (JSONArray) objx2;

                    //there is only 1 item so we can do this
                    String resultsx2 = (String) array.get(0).toString();

                    Object objx3 = parser.parse(resultsx2);
                    JSONObject jsonObject3 = (JSONObject) objx3;

                    String request_id = (String) jsonObject3.get("listing_id").toString();

                    System.out.println("request_id " + request_id);

                    infox2.setText(request_id);

                    //update the listing
                    nm.carbon[0][nm.item_id_xx][what_item_here] = request_id;
                    jdb_driver.s.execute("UPDATE listings SET listing_id='" + request_id + "' WHERE item_id='" + nm.carbon[0][nm.item_id_xx][what_item_here] + "'");

                    if (request_id.length() > 0){connectx2(request_id);}
                    if (!SUCCESS && request_id.length() > 0){connectx2(request_id);}

                    System.out.println("connect 1 done... " + request_id.length());

                }//**********************

	        } catch (ParseException e) {

                e.printStackTrace(); 
                JOptionPane.showMessageDialog(null, response.getBody());

            }//*************************



        } catch (Exception e) {e.printStackTrace();}



    }//connectx()*********************************************************************************************











    public void connectx2(String request_id2) {


        // Construct data
        try {


            infox2.setText("Upload images...");
            SUCCESS = false;


            String apiKey = nm.carbon[5][2][nm.current_submit_item_a];
            String apiSecret = nm.carbon[5][3][nm.current_submit_item_a];


            String NETWORK_NAME = "Etsy";
            String AUTHORIZE_URL = "";



            String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/listings/" + request_id2 + "/images";



            System.out.println(apiKey);
            System.out.println(apiSecret);

            OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();



            System.out.println(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a]);
            System.out.println(nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);


            Token accessToken = new Token(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a], nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a], nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);
            System.out.println("Got the Access Token!");
            System.out.println();



            // Now let's go and ask for a protected resource!
            System.out.println("Now we're going to access a protected resource...");
            OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
            

            String file_name = new String("test.jpg");

            File file = new File(file_name);
            

            ContentType photoTyp = org.apache.http.entity.ContentType.MULTIPART_FORM_DATA; 
            MultipartEntityBuilder reqEntity = MultipartEntityBuilder.create();

            reqEntity.addBinaryBody("image", file, photoTyp, "test.png");

            HttpEntity msg = reqEntity.build();




            ByteArrayOutputStream bos = new ByteArrayOutputStream((int)msg.getContentLength());
            msg.writeTo(bos);


            Header contentType = msg.getContentType();
            request.addHeader(contentType.getName(), contentType.getValue());


            //image type
            request.addPayload(bos.toByteArray());



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

                if(requestx.equals("1")){SUCCESS = true;}

                infox2.setText("Done!");

                System.out.println(requestx);


            } catch (ParseException e) {

                e.printStackTrace(); 
                SUCCESS = false;
                JOptionPane.showMessageDialog(null, response.getBody());

            }//**************************



        } catch (Exception e) {e.printStackTrace();}



    }//connectx()*********************************************************************************************













    public void pullThePlug() {

	    nm.firex = 1;

        try {Thread.sleep(600);}
        catch (InterruptedException e) {System.out.println("import black failed 000332");}

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull






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












