import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;






public class csv_export_csv_inventory{

JFrame frame = new JFrame();
int ix0 = 0;
int ix1 = 0;
String cx0 = new String("");


File f1;



csv_export_csv_inventory(){//*****************************************************************************************
	



	f1 = new File(nm.carbon[4][0][26]);

	JFileChooser fc = new JFileChooser(f1);

	fc.setCurrentDirectory(new File(f1.getAbsolutePath()));


	f1 = new File("inventory_export.csv");


	fc.setSelectedFile(f1);

	int returnVal = fc.showSaveDialog(frame);


	f1 = fc.getSelectedFile(); //This grabs the File you typed


	cx0 = f1.toString();
	ix0 = cx0.lastIndexOf("\\");
	if(ix0 > -1){nm.carbon[4][0][26] = cx0.substring(0, ix0 + 1);}
	System.out.println(nm.carbon[4][0][26]);


	export_csvx();



}//postid*************************************************************************************************************











	public void export_csvx(){






	try {

        BufferedWriter out = new BufferedWriter(new FileWriter(f1));

		out.write(nm.carbon[0][nm.part_number_xx][0].replace(",","").replace("\"",""));
		out.write(",");
		out.write(nm.carbon[0][nm.total_on_hand_xx][0].replace(",","").replace("\"",""));
		out.newLine();



		for (int loop2 = 1; loop2 < nm.carbon[0][0].length; loop2++){//**********************
		try{

			System.out.println(loop2);

			if(Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][loop2]) > 0){

			//JOptionPane.showMessageDialog(null, nm.carbon[0][nm.part_number_xx][loop2] + " " + nm.carbon[0][nm.total_on_hand_xx][loop2]);

			out.write(nm.carbon[0][nm.part_number_xx][loop2].replace(",","").replace("\"",""));
			out.write(",");
			out.write(nm.carbon[0][nm.total_on_hand_xx][loop2].replace(",","").replace("\"",""));
			out.newLine();

			}//****************************************************************

		}catch(Exception e){e.printStackTrace();}	
		}//for*******************************************************************************
	


    out.close();
    } catch (IOException e) {System.out.println("print fail.");}






	JOptionPane.showMessageDialog(null, "Exported. inventory_export.csv");



	}//***************************










}//last