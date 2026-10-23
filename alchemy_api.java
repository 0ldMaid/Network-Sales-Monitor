import java.io.*;
import java.text.*;   
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.sql.ResultSet;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.util.Timer;





public class alchemy_api{


JSONObject jsonObject;

Timer xtimerx;//class loop.

String message = new String("");
String jsonText = new String("");
String responsex = new String("");
String clientSentence;          
String capitalizedSentence;          
String passwordx = new String("");



alchemy_api(){//*****************************************************************

	System.out.println("Start Server");

	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_server(), 0);

}//*********************************************************************************






	class RemindTask_server extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************



		ServerSocket welcomeSocket;

		while (true) {   


			try {//*********************************************************     

				welcomeSocket = new ServerSocket(nm.api_server_port, 0, InetAddress.getByName("localhost"));
				Socket connectionSocket = welcomeSocket.accept(); 
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());             
				clientSentence = inFromClient.readLine();



				JSONParser parser = new JSONParser();

				try {//*********************************************************
 

					jsonText = "";
					message = "";

					if(!clientSentence.contains("")){throw new EmptyStackException();}
					Object obj = parser.parse(clientSentence);
 
					jsonObject = (JSONObject) obj;
  
					String request = (String) jsonObject.get("request");

					nm.server_requests++;


					      if(request.equals("is_active")){responsex = "1"; message = "active";}

					else if(request.equals("get_program_status")){responsex = "1"; get_status();}  

					else if(request.equals("start_import")){responsex = "1";}

					else if(request.equals("get_database_fields")){responsex = "1"; get_database_fields();}

					else if(request.equals("get_settings")){responsex = "1"; get_settings();} 


					else if(request.equals("get_listings_count")){responsex = "1"; message = Integer.toString(nm.db_00_size);}

					else if(request.equals("get_listings")){responsex = "1"; get_listings();}

					else if(request.equals("get_listing_by_id")){responsex = "1"; get_listing_by_id(jsonObject.get("id").toString());}

					else if(request.equals("set_new_listing")){responsex = "1";}

					else if(request.equals("edit_listing_by_id")){responsex = "1";}


					else if(request.equals("get_sales_count")){responsex = "1"; message = Integer.toString(nm.db_02_size);}
						
					else if(request.equals("get_sale_by_id")){responsex = "1"; get_sale_by_id(jsonObject.get("id").toString());}
					
					else if(request.equals("get_sales_by_status")){responsex = "1"; get_sales_by_status(jsonObject.get("status").toString());}

					else if(request.equals("set_sales_status")){responsex = "1"; String request_status = (String) jsonObject.get("status");}

					else if(request.equals("set_sales_tracking")){responsex = "1"; set_sold_tracking(jsonObject.get("sale_id").toString(),jsonObject.get("tracking_number").toString());}

					else if(request.equals("edit_sale_by_id")){responsex = "1";}


					else if(request.equals("get_archive_count")){responsex = "1"; message = Integer.toString(nm.db_03_size);}
					
					else if(request.equals("get_archive_by_status")){responsex = "1"; get_archived_by_status(jsonObject.get("status").toString());}

					else if(request.equals("get_archive_by_id")){responsex = "1"; get_archived_by_id(jsonObject.get("id").toString());}

					else if(request.equals("set_archive_status")){responsex = "1"; String request_status = (String) jsonObject.get("status");}

					else if(request.equals("set_archive_tracking")){responsex = "1"; set_archive_tracking(jsonObject.get("sale_id").toString(),jsonObject.get("tracking_number").toString());}


					else{responsex = "0"; message = "cannot find request";}


				}//try
				catch (ParseException e) {e.printStackTrace(); responsex = "0"; message = "json error";}
				catch (Exception e) {e.printStackTrace(); message = "request error";}


				JSONObject obj = new JSONObject();
				obj.put("response", responsex);
				obj.put("message", message);

				StringWriter out = new StringWriter();
				obj.writeJSONString(out);
				jsonText = out.toString();

				outToClient.writeBytes(jsonText + '\n');
				welcomeSocket.close();

	
			} catch (Exception e) {e.printStackTrace(); System.out.println("Server ERROR API");}


         
		}//**********while



	}//runx***************************************************************************************************
    }//remindtask








    public void get_status() {

    	message = "";

		try {

			JSONObject objx = new JSONObject();
			objx.put("export_count", nm.db_00_size);
			objx.put("sold_count", nm.db_02_size);
			objx.put("archived_count", nm.db_03_size);
			objx.put("connections_count", nm.carbon[5][0].length);
			objx.put("connections_active_count", nm.carbon[1][0].length);
			objx.put("version", nm.program_version);
			objx.put("auto_ship", nm.auto_sales);
			objx.put("server_requests", nm.server_requests);
			//objx.put("selected_item", nm.what_item);
			objx.put("selected_items_total", nm.total_items_selected);
			objx.put("current_submit_item_a", nm.current_submit_item_a);
			objx.put("current_submit_item_x", nm.current_submit_item_x);
			objx.put("program_working", nm.program_working);
			objx.put("tab_view", nm.db_number);
			objx.put("internet_access", nm.internet_access);
			objx.put("shipping_access", nm.shipping_api_access);

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);
			message = outx.toString();

        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }


    }//********************************************





    public void get_settings(){

    	message = "";

		try {

			JSONObject objx = new JSONObject();
			objx.put("count", nm.carbon[4][0].length);

			for (int loop = 0; loop < nm.carbon[4][0].length; loop++) {//**********

	    		objx.put(loop, nm.carbon[4][0][loop]);

	    	}//*****************************************************************

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);
			message = outx.toString();

        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }


    }//********************************************





    public void get_database_fields(){

    	message = "";

		try {
 
			JSONObject objx = new JSONObject();
			objx.put("count", nm.db_string.length);

			for (int loop = 0; loop < nm.db_string.length; loop++) {//***********

	    		objx.put(loop, nm.db_string[loop]);

	    	}//******************************************************************

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);
			message = outx.toString();

        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }


    }//********************************************









    public void get_listings(){

    	message = "";

		try {

			int ix0 = 0;

			LinkedList<String> list = new LinkedList<String>();

            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_id FROM listings");

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

	    		list.add(jdb_driver.rs.getString(1));

	    		ix0++;

	    	}//while

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



			JSONObject objx = new JSONObject();
			objx.put("count", ix0);
			objx.put("ids", JSONValue.toJSONString(list));

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);
			message = outx.toString();

        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }


    }//********************************************





    public void get_listing_by_id(String id){

    	message = "";

		try {


			int ix0 = 0;

			JSONObject obj = new JSONObject();

            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT * FROM listings WHERE item_id='" + id + "'");

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

				for (int loop = 2; loop < 101; loop++) {//***************************

	    			obj.put(nm.db_string[(loop - 2)], jdb_driver.rs.getString(loop));

	    		}//******************************************************************

	    		ix0++;

	    	}//while

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


            if (ix0 == 0) {responsex = "0"; message = "Cannot find record!";}
            else {

				StringWriter out = new StringWriter();
				obj.writeJSONString(out);

				JSONObject objx = new JSONObject();
				objx.put("count", ix0);
				objx.put("item", out.toString());

				StringWriter outx = new StringWriter();
				objx.writeJSONString(outx);
				message = outx.toString();

			}//**


        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }



    }//***********************************************













    public void get_sales_by_status(String status){

    	message = "";

		try {


			int ix0 = 0;

			LinkedList<String> list = new LinkedList<String>();

            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT sale_id FROM sold WHERE sale_status='" + status + "'");

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

	    		list.add(jdb_driver.rs.getString(1));

	    		ix0++;

	    	}//while

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



			JSONObject objx = new JSONObject();
			objx.put("count", ix0);
			objx.put("ids", JSONValue.toJSONString(list));

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);
			message = outx.toString();



        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }


    }//********************************************





    public void get_sale_by_id(String id){

    	message = "";

		try {


			int ix0 = 0;

			JSONObject obj = new JSONObject();

            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT * FROM sold WHERE sale_id='" + id + "'");

	    	ix0 = 0;
	    	while(jdb_driver.rs.next()){

				for (int loop = 2; loop < 101; loop++){//****************************

	    			obj.put(nm.db_string[(loop - 2)], jdb_driver.rs.getString(loop));

	    		}//******************************************************************

	    		ix0++;

	    	}//while

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


            if (ix0 == 0) {responsex = "0"; message = "Cannot find record!";}
            else {

				StringWriter out = new StringWriter();
				obj.writeJSONString(out);

				JSONObject objx = new JSONObject();
				objx.put("count", ix0);
				objx.put("item", out.toString());

				StringWriter outx = new StringWriter();
				objx.writeJSONString(outx);
				message = outx.toString();

			}//**


        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }



    }//***********************************************





    public void set_sold_tracking(String id, String tracking){

    	message = "";

		try {


			int ip0x = 0;

			for (int loop = 0; loop < nm.carbon[2][nm.sale_id_xx].length; loop++) {//*********

	    		if (nm.carbon[2][nm.sale_id_xx][loop].equals(id)) {

	    			nm.carbon[2][nm.tracking_number_xx][loop] = tracking;

					jdb_driver.s.execute("UPDATE sold SET tracking_number='" + tracking + "' WHERE sale_id='" + id + "'");
					jdb_driver.conn.commit();

					nm.what_item_api_switch = loop;

	    			nm.reset_display_switch = true;

					ip0x++;

	    		}//**********************************************

	    	}//******************************************************************************


            if (ip0x == 0) {responsex = "0"; message = "Cannot find record!";}
            else {message = "Tracking number set.";}//**


        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }



    }//***********************************************

















    public void get_archived_by_status(String status){

    	message = "";

		try {


			int ix0 = 0;

			LinkedList<String> list = new LinkedList<String>();

            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT sale_id FROM archived WHERE sale_status='" + status + "'");

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

	    		list.add(jdb_driver.rs.getString(1));

	    		ix0++;

	    	}//while

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



			JSONObject objx = new JSONObject();
			objx.put("count", ix0);
			objx.put("ids", JSONValue.toJSONString(list));

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);
			message = outx.toString();



        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }



    }//***********************************************





    public void get_archived_by_id(String id){

    	message = "";

		try {


			int ix0 = 0;

			JSONObject obj = new JSONObject();

            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT * FROM archived WHERE sale_id='" + id + "'");

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

				for (int loop = 2; loop < 101; loop++){//****************************

	    			obj.put(nm.db_string[(loop - 2)], jdb_driver.rs.getString(loop));

	    		}//******************************************************************

	    		ix0++;

	    	}//while

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


            if (ix0 == 0) {responsex = "0"; message = "Cannot find record!";}
            else {

				StringWriter out = new StringWriter();
				obj.writeJSONString(out);

				JSONObject objx = new JSONObject();
				objx.put("count", ix0);
				objx.put("item", out.toString());

				StringWriter outx = new StringWriter();
				objx.writeJSONString(outx);
				message = outx.toString();

			}//**


        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }



    }//***********************************************





    public void set_archive_tracking(String id, String tracking){

    	message = "";

		try {


			int ip0x = 0;

			for (int loop = 0; loop < nm.carbon[3][nm.sale_id_xx].length; loop++) {//*********

	    		if (nm.carbon[3][nm.sale_id_xx][loop].equals(id)) {

	    			nm.carbon[3][nm.tracking_number_xx][loop] = tracking;

					jdb_driver.s.execute("UPDATE archived SET tracking_number='" + tracking + "' WHERE sale_id='" + id + "'");
					jdb_driver.conn.commit();

	    			nm.reset_display_switch = true;

					ip0x++;

	    		}//**********************************************

	    	}//******************************************************************************


            if (ip0x == 0) {responsex = "0"; message = "Cannot find record!";}
            else {message = "Tracking number set.";}//**


        } catch (Exception e) {

        	e.printStackTrace(); 
        	responsex = "0"; 
        	message = e.getMessage().toString();

        }



    }//***********************************************











}//last
