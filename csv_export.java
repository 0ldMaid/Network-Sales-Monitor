import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  






public class csv_export extends JFrame{

JFrame frame = new JFrame();
File f1;


String carbon_export[] = new String[1];
int ix0 = 0;
int ix1 = 0;
String cx0 = new String("");



csv_export(){//********************************************************************************************************
	


	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();

	frame.setIconImage(ximagex);
	this.setIconImage(ximagex);


	f1 = new File(nm.settingsx[26]);

	JFileChooser fc = new JFileChooser(f1);

	fc.setCurrentDirectory(new File(f1.getAbsolutePath()));


	if(nm.db_number == 0){f1 = new File("alchemist_export_csv.csv");}
	else if(nm.db_number == 2){f1 = new File("alchemist_sold_csv.csv");}
	else if(nm.db_number == 3){f1 = new File("alchemist_archived_csv.csv");}


	fc.setSelectedFile(f1);

	int returnVal = fc.showSaveDialog(frame);


	f1 = fc.getSelectedFile(); //This grabs the File you typed


	cx0 = f1.toString();
	ix0 = cx0.lastIndexOf("\\");
	if(ix0 > -1){nm.settingsx[26] = cx0.substring(0, ix0 + 1);}
	System.out.println(nm.settingsx[26]);


	if(returnVal == 0){export_csvx();}



}//postid**************************************************************************************************************











	public void export_csvx(){

		System.out.println("Export CSV " + f1.toString());





		ix0 = 0;
		for(int xloop = 0; xloop < nm.carbon[nm.db_number][0].length; xloop++){//******
			if(nm.selected_int[xloop] == 1){

				ix0++;

			}//if*************************
		}//*******************************************************



		System.out.println("build file. " + ix0);


		carbon_export = new String[(ix0 + 1)];



		for(int xloop = 0; xloop < (ix0 + 1); xloop++){//*************

			carbon_export[xloop] = new String("");

		}//*****************************************************





		for(int xloop = 0; xloop < 100; xloop++){//*************

			if( xloop > -1 ){carbon_export[0] = carbon_export[0] + "\"";}
			carbon_export[0] = carbon_export[0] + nm.db_string[xloop]; 
			if( xloop < (100 -1) ){carbon_export[0] = carbon_export[0] + "\",";}
			if( xloop == (100 -1) ){carbon_export[0] = carbon_export[0] + "\"";}

		}//*****************************************************


		System.out.println("build file 2.");



		ix1 = 1;
		for(int xloop = 0; xloop < nm.carbon[nm.db_number][0].length; xloop++){//**************
			if(nm.selected_int[xloop] == 1){

				for(int xloopx = 0; xloopx < 100; xloopx++){//***

					cx0 = nm.carbon[nm.db_number][xloopx][xloop];
					cx0 = cx0.replace("\r\n", " ").replace("\n", " ");
					cx0 = cx0.replace("\"", "$|$");
					cx0 = cx0.replace(",", "$:$");

					//cx0 = cx0.replace("[[url]]", nm.carbon[5][1][nm.current_submit_item_a]);

					if( xloopx > -1 ){carbon_export[ix1] = carbon_export[ix1] + "\"";}
					carbon_export[ix1] = carbon_export[ix1] + cx0; 
					if( xloopx < 99 ){carbon_export[ix1] = carbon_export[ix1] + "\",";}
					if( xloopx == 99 ){carbon_export[ix1] = carbon_export[ix1] + "\"";}

				}//*******************************************
			ix1++;
			}//if*************************

		}//*******************************************************



		System.out.println("write file.");



		try {

        	BufferedWriter out = new BufferedWriter(new FileWriter(f1.toString()));

			for (int loop2 = 0; loop2 < carbon_export.length; loop2++){//*************************

				System.out.println(carbon_export[loop2]);
				out.write(carbon_export[loop2]);
				out.newLine();

			}//for*******************************************************************************
	
        out.close();
        } catch (IOException e) {System.out.println("print fail.");}






		JOptionPane.showMessageDialog(null,"Exported. Comma was changed to $:$ and quote was changed to $|$");



	}//***************************










}//last