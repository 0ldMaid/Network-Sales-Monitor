import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;






public class json_import {//************************************************************************

File f1 = new File("alchemist_json_export.json");






json_import() {//****************************


	JFrame frame = new JFrame();
	JFileChooser fc = new JFileChooser(f1);


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	frame.setIconImage(ximagex);



	f1 = new File(nm.carbon[4][0][26]);

	fc = new JFileChooser(f1);
	fc.setSelectedFile(new File(f1.toString()));

   	int ix0 = fc.showOpenDialog(frame);

   	System.out.println("f1 " + f1);
   	System.out.println("ix0 " + ix0);

   	f1 = fc.getSelectedFile();

	if (f1.exists() && ix0 == 0) {

		build_file_item();

	}//if***********************
	else {System.out.println("USER CANCEL"); }


	System.out.println(f1);



}//csv_loader_x1********************************************************








	public void build_file_item(){


		//convert xml item for upload*

		try{



			BufferedReader in = new BufferedReader(new FileReader(f1));
			String xlinex = new String("");
			String jsonx = new String("");
			while ((xlinex = in.readLine()) != null){jsonx = jsonx + xlinex;}
			in.close();
		

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonx);
			JSONObject jsonObject = (JSONObject) obj;
  	
			String count = (String) jsonObject.get("count").toString();
			String array = (String) jsonObject.get("array");


			int ix0 = Integer.parseInt(count);

			System.out.println(">>> " + ix0);


			Object obj2 = parser.parse(array);
			JSONArray array2 = (JSONArray) obj2;

  			System.out.println(array2.size());



			int ix6 = 0;

			for (int xloopx1 = 0; xloopx1 < array2.size(); xloopx1++) {//***************

				System.out.println("new nodes " + array2.get(xloopx1));

				Object obj3 = parser.parse(array2.get(xloopx1).toString());
				JSONObject jsonObject3 = (JSONObject) obj3;
  	

	 			String[][] save_item = new String[nm.db_cc_number][1];

	 			for (int xloop3 = 0; xloop3 < nm.db_cc_number; xloop3++) {//****

					save_item[xloop3][0] = (String) jsonObject3.get(nm.db_string[xloop3]);

	 			}//***********************************************************

	 			save_item[nm.item_id_xx][0] = "js" + nm.carbon[4][0][12];

	 			int h43d = Integer.parseInt(nm.carbon[4][0][12]) + 1;
				nm.carbon[4][0][12] = Integer.toString(h43d);


	 			jdb_new_item addx = new jdb_new_item(save_item);

				ix6++;

			}//**********************************************************************




		} catch (Exception ex) {

			ex.printStackTrace();

		}//catch



	    System.out.println("Done");


	}//*************************build_file






}//last****************************************