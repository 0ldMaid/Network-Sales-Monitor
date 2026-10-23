import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  






public class amazon_upload_builder extends JFrame{

JFrame frame = new JFrame();
File f1;

int ix0 = 0;
int ix1 = 0;
String cx0 = new String("");



amazon_upload_builder(){//********************************************************************************************************
	

	f1 = new File("Amazon_Upload_File.txt");


	if(nm.current_submit_item_a == 0){JOptionPane.showMessageDialog(null,"(Export Site) is not set to an Amazon Account. The settings will not be matched.");}
	else if(!nm.carbon[5][4][nm.current_submit_item_a].equals("Amazon")){JOptionPane.showMessageDialog(null,"(Export Site) is not set to an Amazon Account. The settings will not be matched.");}


	export_csvx();



}//postid**************************************************************************************************************











	public void export_csvx(){

		System.out.println("Export .txt " + f1.toString());

		System.out.println("write file.");



		try {

		    BufferedWriter out = new BufferedWriter(new FileWriter(f1.toString()));

			out.write("sku	");
			out.write("price	");
			out.write("quantity	");
			out.write("product-id	");
			out.write("product-id-type	");
			out.write("condition-type	");
			out.write("condition-note	");
			out.newLine();

			for (int loop2 = 0; loop2 < nm.carbon[0][0].length; loop2++){//*************************

				if(nm.selected_int[loop2] == 1){//***************

					System.out.println(nm.carbon[0][nm.part_number_xx][loop2]);
					out.write(nm.carbon[0][nm.part_number_xx][loop2] + "	");
					out.write(nm.carbon[0][nm.item_price_xx][loop2] + "	");
					out.write(nm.carbon[0][nm.total_on_hand_xx][loop2] + "	");
					out.write(nm.carbon[0][ Integer.parseInt(nm.carbon[5][nm.match_column_xxa][nm.current_submit_item_a]) ][loop2] + "	");
					if(Integer.parseInt(nm.carbon[5][nm.match_type_xxa][nm.current_submit_item_a]) == 0){out.write("ASIN" + "	");}
					else if(Integer.parseInt(nm.carbon[5][nm.match_type_xxa][nm.current_submit_item_a]) == 1){out.write("UPC" + "	");}
					else if(Integer.parseInt(nm.carbon[5][nm.match_type_xxa][nm.current_submit_item_a]) == 2){out.write("EIN" + "	");}
					out.write("New" + "	");
					out.write("In original package" + "	");

					out.newLine();

				}//if*********************************************

			}//for*******************************************************************************
		
	        out.close();

	    }catch(IOException e) {System.out.println("print fail.");}


		JOptionPane.showMessageDialog(null,"Exported. Amazon_Upload_File.csv to program file directory.");



	}//***************************










}//last