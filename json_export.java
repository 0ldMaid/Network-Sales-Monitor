import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.lang.Object.*;  
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.io.File;
import java.util.ArrayList;
import java.util.*;




public class json_export {//************************************************************************


File f1 = new File("alchemist_json_export.json");






json_export() {//****************************


	JFrame frame = new JFrame();
	JFileChooser fc = new JFileChooser(f1);

	// Export files.
	String config_json_name = "alchemist_json_export.json";

	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	frame.setIconImage(ximagex);



	f1 = new File(nm.carbon[4][0][26]);

	System.out.println(f1);

	fc = new JFileChooser(nm.carbon[4][0][26]);

	     if (nm.db_number == 0) {fc.setSelectedFile(new File((nm.carbon[4][0][26] + "\\alchemist_json_export.json")));}
	else if (nm.db_number == 2) {fc.setSelectedFile(new File((nm.carbon[4][0][26] + "\\alchemist_json_sold.json")));}
	else if (nm.db_number == 3) {fc.setSelectedFile(new File((nm.carbon[4][0][26] + "\\alchemist_json_archive.json")));}


   	int ix0 = fc.showSaveDialog(frame);
	System.out.println(ix0 + " " + f1.exists());

	if (ix0 == 0) {

   		f1 = fc.getSelectedFile();

		if (nm.total_items_selected > 99) {JOptionPane.showMessageDialog(null,"Exporting more then 100 items by JSON may not work.");}

		build_file_item();

		JOptionPane.showMessageDialog(null, "Exported " + config_json_name);

		String cx0 = f1.toString();
		ix0 = cx0.lastIndexOf("\\");

		if (ix0 > -1) {nm.carbon[4][0][26] = cx0.substring(0, ix0 + 1);}

		System.out.println(nm.carbon[4][0][26]);

	}//if***********************
	else {System.out.println("USER CANCEL");}




}//csv_loader_x1********************************************************










	public void build_file_item() {


		// Convert item for upload*

		try {


			int ix0 = 0;

			for(int loop1 = 0; loop1 < nm.carbon[nm.db_number][0].length; loop1++) {//*************************

				if (nm.selected_int[loop1] == 1) {ix0++;}

			}//***********************************************************************************************



			String[] arrayx = new String[ix0];


			int ix1 = 0;

			for (int loop1 = 0; loop1 < nm.carbon[nm.db_number][0].length; loop1++) {//*************************


				if (nm.selected_int[loop1] == 1) {



					JSONObject obj = new JSONObject();

					for (int loop2 = 0; loop2 < nm.db_cc_number; loop2++){//*************************

						obj.put(nm.db_string[loop2], nm.carbon[nm.db_number][loop2][loop1]);

					}//******************************************************************************

					StringWriter out = new StringWriter();
					obj.writeJSONString(out);
					String jsontext = out.toString();
					System.out.println(jsontext);

					arrayx[ix1] = jsontext;

				}//*****************************
	


				if (nm.selected_int[loop1] == 1) {ix1++;}

			}//************************************************************************************************





			LinkedList<String> list = new LinkedList<String>();
			String jsonarry = new String("");

			try {


				for (int xloop = 0; xloop < arrayx.length; xloop++) {//****

					list.add(arrayx[xloop]); 

				}//for*****************************************************

				jsonarry = JSONValue.toJSONString(list);


				JSONObject obj = new JSONObject();
				obj.put("count", ix1);
				obj.put("array", jsonarry);

				StringWriter out = new StringWriter();
				obj.writeJSONString(out);
				String jsonText = out.toString();
				System.out.println(jsonText);


				BufferedWriter outfx = new BufferedWriter(new FileWriter(f1));

				outfx.write(jsonText);

				outfx.close();

			} catch (Exception ex) {ex.printStackTrace();}



		} catch (Exception e) {e.printStackTrace();}



        System.out.println("Done");


	}//*************************build_file







}//last****************************************