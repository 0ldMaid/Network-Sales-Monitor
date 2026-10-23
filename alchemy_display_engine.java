import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.util.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;





public class alchemy_display_engine implements KeyListener, MouseListener, MouseMotionListener{//************************************************************************

private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
private int what_item_id;

FlowLayout flow = new FlowLayout(0);
FlowLayout flow1 = new FlowLayout(0);

JButton display_csvx_field[][] = new JButton[100][300];
JButton display_csvx_field_header[][] = new JButton[100][1];
JButton display_csvx_field_extra[][] = new JButton[2][300];

JButton display_csvx_field_extrah1 = new JButton();
JButton display_csvx_field_extrah2 = new JButton();

JPanel jpkx[] = new JPanel[0];
JPanel jpkx_head = new JPanel();
JPanel jpk1 = new JPanel();

JScrollPane scrollPane;

JPopupMenu menu = new JPopupMenu("Popup");

//right mouse button
JMenuItem item0;
JMenuItem item1;
JMenuItem item2;
JMenuItem item3;
JMenuItem item4;
JMenuItem item5;
JMenuItem item6;

JMenuItem item_0;
JMenuItem item_1;
JMenuItem item_2;
JMenuItem item_3;
JMenuItem item_4;
JMenuItem item_5;
JMenuItem item_6;

JMenuItem itemx0;
JMenuItem itemx1;
JMenuItem itemx2;
JMenuItem itemx3;

JMenuItem items0;
JMenuItem items1;
JMenuItem items2;
JMenuItem items3;
JMenuItem items4;
JMenuItem items5;
JMenuItem items6;

boolean press_s = false;//if SELECT button is pressed
boolean press_c = false;//if CTRL button is pressed

//Colors are here so no one changes them.
Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color jgray = new Color(0.92f, 0.92f, 0.92f);
Color jblue = new Color(0.78f, 0.86f, 0.94f);
Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
Color st_gray1 = new Color(0.8f, 0.8f, 0.8f);//light gray for sites
Color st_gray2 = new Color(0.99f, 0.99f, 0.99f);//darker gray for sites
Color highlight_color = new Color(0.3f, 0.5f, 0.6f);
Color redx = new Color(1.0f, 0.2f, 0.216f);
Color darkgreenx = new Color(0.1f, 0.3f, 0.1f);
Color bluex2 = new Color(0.1f, 0.17f, 0.39f);
Color gray7 = new Color(0.7f, 0.7f, 0.7f);
Color yellowx = new Color(1.0f, 0.9f, 0.0f);
Color lightgreenx = new Color(0.5f, 0.9f, 0.5f);

int selected_int[] = new int[0];//what items are selected
int error_int[] = new int[0];//what items are selected
int warning_int[] = new int[0];//what items are selected
int size_int[] = new int[0];//what items are selected
int what_item_old = 0;//last item clicked
int what_item0 = 0;//
int what_item = 0;//current item selected
int what_item2 = 0;//what cell number was clicked on
int item_size = 18;//display info
int total_items_selected = 0;//
int pressx_repaint = 0;
int what_item_old_select = 0;

String header_list[] = new String[0];
String displayList[][] = new String[0][0];

Font f_01 = new Font("Arial", Font.PLAIN, 11);
Font f_02 = new Font("Arial", Font.PLAIN, 14);







alchemy_display_engine() {


	flow.setHgap(5);
	flow.setVgap(0);

	flow1.setHgap(0);
	flow1.setVgap(0);


    item0 = new JMenuItem("Preview");
    item0.setFont(f_01);
    item0.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Preview", 0, 1); }});
    menu.add(item0);

    item1 = new JMenuItem("Edit");
    item1.setFont(f_01);
    item1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Edit", 0, 1); }});
    menu.add(item1);

    item2 = new JMenuItem("Duplicate");
    item2.setFont(f_01);
    item2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Duplicate", 0, 1); }});
    menu.add(item2);

    menu.addSeparator();

    item3 = new JMenuItem("Delete");
    item3.setFont(f_01);
    item3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Delete", 0, 1); }});
    menu.add(item3);

    menu.addSeparator();

    item4 = new JMenuItem("Copy Field");
    item4.setFont(f_01);
    item4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Copy", 0, 1); }});
    menu.add(item4);

    item5 = new JMenuItem("Paste Field");
    item5.setFont(f_01);
    item5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Paste", 0, 1); }});
    menu.add(item5);

    menu.addSeparator();

    items0 = new JMenuItem("SHIP: Print Label");
    items0.setFont(f_01);
    items0.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("PrintLabel", 0, 1); }});
    //menu.add(items0);

    items1 = new JMenuItem("SHIP: FTP Label");
    items1.setFont(f_01);
    items1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("FTPLabel", 0, 1); }});
    menu.add(items1);

    items2 = new JMenuItem("SHIP: Get XML Postback");
    items2.setFont(f_01);
    items2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("XMLPostback", 0, 1); }});
    menu.add(items2);

    items3 = new JMenuItem("SHIP: Shipping System Order");
    items3.setFont(f_01);
    items3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("SSOrder", 0, 1); }});
    menu.add(items3);

    items4 = new JMenuItem("SHIP: Post Tracking Number");
    items4.setFont(f_01);
    items4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("PostTracking", 0, 1); }});
    menu.add(items4);

    items5 = new JMenuItem("SHIP: Leave Feedback");
    items5.setFont(f_01);
    items5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Feedback", 0, 1); }});
    menu.add(items5);

    menu.addSeparator();

    items6 = new JMenuItem("REFUND: Return Label");
    items6.setFont(f_01);
    items6.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("ReturnLabel", 0, 1); }});
    menu.add(items6);

    menu.addSeparator();

    item_0 = new JMenuItem("Export Item(s)");
    item_0.setFont(f_01);
    item_0.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Export", 0, 1); }});
    menu.add(item_0);

    item_1 = new JMenuItem("Import");
    item_1.setFont(f_01);
    item_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Import", 0, 1); }});
    menu.add(item_1);

    item_2 = new JMenuItem("Shipping Label");
    item_2.setFont(f_01);
    item_2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("ShippingLabel", 0, 1); }});
    menu.add(item_2);

    item_3 = new JMenuItem("Hide from eBay search");
    item_3.setFont(f_01);
    item_3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("Hide", 0, 1); }});//empty_yes();
    menu.add(item_3);

    menu.addSeparator();

    itemx0 = new JMenuItem("Export .csv");
    itemx0.setFont(f_01);
    itemx0.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("CSV", 0, 1); }});
    menu.add(itemx0);

    itemx1 = new JMenuItem("Export .iff");
    itemx1.setFont(f_01);
    itemx1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("IFF", 0, 1); }});
    menu.add(itemx1);

    itemx2 = new JMenuItem("Export .xml");
    itemx2.setFont(f_01);
    itemx2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("XML", 0, 1); }});
    menu.add(itemx2);

    itemx3 = new JMenuItem("Export .json");
    itemx3.setFont(f_01);
    itemx3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { pcs.firePropertyChange("JSON", 0, 1); }});
    menu.add(itemx3);




}//********************





    public void addPropertyChangeListener( PropertyChangeListener listener ) {

        pcs.addPropertyChangeListener(listener);

    }//***********************************************************************







	public void setErrorList(int errorList[]) {

		error_int = errorList;

	}//*******************************************


	public void setWarningList(int warningList[]) {

		warning_int = warningList;

	}//***********************************************


	public void setSizeList(int sizeList[]) {

		size_int = sizeList;

	}//**************************************


	public void setSizeList(String sizeList[][]) {

		size_int = new int[sizeList.length];

		for (int xloop0 = 0; xloop0 < sizeList.length; xloop0++){//******

			try {

				size_int[xloop0] = Integer.parseInt(sizeList[xloop0][0]);

			} catch (Exception e) {

				size_int[xloop0] = 150;

			}

		}//**************************************************************

	}//***********************************************


	public void setHeaderList(String headerList[]) {

		try {

			header_list = headerList;

		} catch (Exception e) {}	

	}//*********************************************


	public void setHeaderList(String headerList[][]) {

		header_list = new String[headerList.length];

		try {

			for (int xloop0 = 0; xloop0 < headerList.length; xloop0++) {//*****

				header_list[xloop0] = headerList[xloop0][0];

			}//****************************************************************

		} catch (Exception e) {}

	}//***********************************************









	public void display_item(String[][] display, int offset) {

		displayList = display;

		display_item(offset);

	}//*******************************************************



	public void display_item(int offset) {


		if (what_item == -1) {what_item = 0;}
		if (what_item_old == -1) {what_item_old = 0;}

		int items_x = displayList.length;
		int items_y = displayList[0].length;


		System.out.println("pressx_repaint " + pressx_repaint);
		System.out.println("press_s        " + press_s);
		System.out.println("press_c        " + press_c);
		System.out.println("items_x        " + items_x);
		System.out.println("items_y        " + items_y);



		if (!press_s && pressx_repaint == 1) {//***********************************************************************

			pressx_repaint = 0;

			make_stripes();

			System.out.println("reset all items after multi select. x");


			for (int xloop = 0; xloop < items_y; xloop++) {//******


				//reset all items to black. 
				for (int xloopx = 0; xloopx < items_x; xloopx++) {//*******************


					try {

						display_csvx_field[xloopx][xloop].setForeground(blackx);

					} catch (Exception e) {}


				}//***************************************************************** 


			}//for****************************************************************


			if (!press_c) {//******
			
				System.out.println("carbon: " + items_y +  " selected_int: " + selected_int.length);

				for (int xloop = 0; xloop < items_y; xloop++) {//*******

					selected_int[xloop] = 0;

				}//*****************************************************
		
				System.out.println("RESET SELECTED ITEMS COUNT...........");

			}//*********************


		}//reset if*****************************************************************************************************




		//Reset fields
		for (int xloop = 0; xloop < items_x; xloop++){//*****************

			try {

				display_csvx_field[xloop][what_item_old].setForeground(blackx);

			} catch (Exception e) {}

		}//**************************************************************



		for (int xloop = 0; xloop < items_y; xloop++) {//****


			display_csvx_field_extra[0][xloop].setText(Integer.toString(offset + xloop)); 
       		display_csvx_field_extra[1][xloop].setText(""); 

			for (int xloopx = 0; xloopx < items_x; xloopx++) {//**************

  				display_csvx_field[xloopx][xloop].setText(displayList[xloopx][xloop]);
  				display_csvx_field[xloopx][xloop].setToolTipText(displayList[xloopx][xloop]);

			}//for************************************************************


		}//for************************************************




		try {

			//Show warnings and Errors.
			for (int xloop = 0; xloop < items_y; xloop++) {//******


				if (error_int[xloop] == 1) {

					display_csvx_field_extra[0][xloop].setBackground(redx);
					display_csvx_field_extra[1][xloop].setText(""); 
					//display_csvx_field_extra[1][xloop].setToolTipText(displayList[xloopx][xloop]);

				}//*************************
				else if (warning_int[xloop] == 1) {

					display_csvx_field_extra[0][xloop].setBackground(yellowx);
					display_csvx_field_extra[1][xloop].setText("");
					//display_csvx_field_extra[1][xloop].setToolTipText("Warning! Check item notes for details");

				}//********************************
				else {

					display_csvx_field_extra[0][xloop].setBackground(gray7);
					display_csvx_field_extra[1][xloop].setText("");
					display_csvx_field_extra[1][xloop].setToolTipText("");

				}//***


			}//*******************************************************

		} catch(Exception e) {}





		if (!press_s && !press_c) {

			try {

				for (int xloop = 0; xloop < items_y; xloop++) {//******

					selected_int[xloop] = 0;

				}//for*************************************************

				total_items_selected = 1;
				selected_int[what_item] = 1;
				show_selected();

			} catch (Exception e) {}

		}//if******************************





		if (press_s) {

			//what_item0 = what_item_old; 
			select_items(); 
			pressx_repaint = 1;

		}//***********


		if (press_c) {

			System.out.println("press_c " + press_c);

			if (selected_int[what_item] == 0) {

				System.out.println(what_item + " 1");
				selected_int[what_item] = 1;

			}//********************************
			else if (selected_int[what_item] == 1) {

				System.out.println(what_item + " 0");
				selected_int[what_item] = 0;

			}//*************************************

			//what_item0 = what_item_old;

			select_items2(); 
			pressx_repaint = 1;

		}//****************

		


		System.out.println("total_items_selected dd " + total_items_selected);
		System.out.println("what_item               " + what_item);
		System.out.println("what_item_old           " + what_item_old);

		//Notify the user. 
		pcs.firePropertyChange("leftClick", what_item + 1, what_item);


		what_item_old_select = what_item;
		what_item_old = what_item;

		for (int xloop = 0; xloop < items_x; xloop++) {//*****************

			if (!press_s && !press_c) {//press_s != 1 && press_c != 1

				//System.out.println(xloop);
				try {

					display_csvx_field[xloop][what_item_old].setForeground(whitex);

				} catch (Exception e) {

					System.out.println("what_item_old " + what_item_old);

				}//*******************

			}//********************************

		}//for************************************************************





	}//**************************








	public void deselect_all_items(){

		System.out.println("Deselect All");

		//what_item_selected = -1;
		//what_item_old = -1;
		//what_item = -1;

		int items_x = displayList.length;
		int items_y = displayList[0].length;

		for (int xloop = 0; xloop < items_y; xloop++) {//*******

			selected_int[xloop] = 0; 

			for (int xloopx = 0; xloopx < items_x; xloopx++) {//**************************
	
				display_csvx_field[xloopx][xloop].setForeground(blackx);

			}//***************************************************************************

		}//*****************************************************

	}//all***************************










	public void select_items() {

		int items_x = displayList.length;
		int items_y = displayList[0].length;

		//selected_int[0] = 0;
		System.out.println("select all:    " + items_y);
		System.out.println("select all x : " + what_item);
		System.out.println("select all y : " + what_item_old);
		System.out.println("select all z : " + what_item_old_select);
		System.out.println("selected_int : " + selected_int.length);

		int ix0 = 0;
		int ix1 = 0;
		int ix2 = 0;

		//Test to see if the select was top to bottom or bottom to top. 
		if (what_item_old < what_item) {ix0 = what_item_old; ix1 = what_item;}
		else {ix1 = what_item_old; ix0 = what_item;}

		ix2 = (ix1 + 1) - ix0;


		for (int xloop = 0; xloop < items_y; xloop++) {//******

			if (xloop >= ix0 && xloop <= ix1) {


				selected_int[xloop] = 1;

				jpkx[xloop].setBackground(highlight_color); 

				for (int xloopx = 0; xloopx < items_x; xloopx++) {//******

					display_csvx_field[xloopx][xloop].setForeground(whitex);

				}//for****************************************************


			}//********************************		
			else{selected_int[xloop] = 0;}

		}//for************************************************************


		total_items_selected = ix2;

		System.out.println("total_items_selected vv "  + total_items_selected);

		pcs.firePropertyChange("totalItemsSelected", total_items_selected + 1, total_items_selected);

		//selected_int[0] = 0;

	}//select_all_items*********************************************************





	public void select_items2() {

		int items_x = displayList.length;
		int items_y = displayList[0].length;

		//selected_int[0] = 0;
		System.out.println("select all:    " + items_y);
		System.out.println("select all x : " + what_item);
		System.out.println("select all y : " + what_item_old);
		System.out.println("select all z : " + what_item_old_select);
		System.out.println("selected_int : " + selected_int.length);

		make_stripes();

		total_items_selected = 0;

		for (int xloop = 0; xloop < items_y; xloop++) {//******

			if (selected_int[xloop] == 1) {


				jpkx[xloop].setBackground(highlight_color); 

				for (int xloopx = 0; xloopx < items_x; xloopx++) {//******

					display_csvx_field[xloopx][xloop].setForeground(whitex);

				}//for****************************************************


				total_items_selected++;

			}//****************************

		}//for************************************************************


		System.out.println("total_items_selected vv "  + total_items_selected);

		//selected_int[0] = 0;

	}//*********************************************







	public void select_all_items() {

		int items_x = displayList.length;
		int items_y = displayList[0].length;

		//what_item_old = -1;
		//what_item = -1;


		System.out.println("select all ctr1: " + items_y);

		int ix2 = 0;


		for (int xloop = 0; xloop < items_y; xloop++) {//****

			selected_int[xloop] = 1;

			ix2++;

		}//for***********************************************




		for (int xloop = 0; xloop < items_y; xloop++) {//**************

			if (selected_int[xloop] == 1) {


				jpkx[xloop].setBackground(highlight_color); 


				for (int xloopx = 0; xloopx < items_x; xloopx++) {//****************

					display_csvx_field[xloopx][xloop].setForeground(whitex);

				}//for**************************************************************


				System.out.println("xloop " + xloop);

				//ix2++;

			}//if**************************

		}//for*********************************************************




		total_items_selected = ix2;
		System.out.println("total_items_selected xx "  + total_items_selected);

		//selected_int[0] = 0;

		pressx_repaint = 1;

	}//**************************************








	public JScrollPane getDisplay(String[][] displayList1, int xzx, int xzy, int db_number, int offset) {

		jpk1 = new JPanel(flow);

		displayx(displayList1,xzx,xzy,offset);

		scrollPane = new JScrollPane(jpk1);
		//scrollPane.setPreferredSize(new Dimension(xzx, xzy));
		scrollPane.setBackground(jgray);
		scrollPane.setFont(f_02);

		set_button_on_off(db_number);

		return scrollPane;

	}//**************************************************************************************************








	public void displayx(String[][] displayList1, int xzx, int xzy, int offset) {

		System.out.println("DISPLAY X");

		displayList = displayList1;

		int items_x = displayList.length;
		int items_y = displayList[0].length;

		//If the item is below our new list. 
		if (what_item > (items_y -1))     {what_item = (items_y -1);}
		if (what_item_old > (items_y -1)) {what_item_old = (items_y -1);}

		selected_int = new int[items_y];

		display_csvx_field = new JButton[items_x][items_y];
		display_csvx_field_extra[0] = new JButton[items_y];
		display_csvx_field_extra[1] = new JButton[items_y];

		jpkx = new JPanel[items_y];

		jpk1.removeAll();


		System.out.println("DISPLAYX SPAN " + offset + " - " + (offset + items_y));
    	System.out.println("DISPLAYX      " + items_y);

    	//set header 
		display_csvx_field_extrah1 = new JButton(""); 
		display_csvx_field_extrah1.setBorder(null);  
		display_csvx_field_extrah1.setPreferredSize(new Dimension(40, (item_size)));   
		display_csvx_field_extrah1.setOpaque(true);  
		display_csvx_field_extrah1.setBackground(gray7); 
		display_csvx_field_extrah1.setForeground(blackx);
		display_csvx_field_extrah1.addKeyListener(this);      
		display_csvx_field_extrah1.setHorizontalAlignment(SwingConstants.CENTER);    
		display_csvx_field_extrah1.setFont(f_01);
		
		//set header 2
		display_csvx_field_extrah2 = new JButton(""); 
		display_csvx_field_extrah2.setBorder(null);  
		display_csvx_field_extrah2.setPreferredSize(new Dimension(20, (item_size)));   
		display_csvx_field_extrah2.setOpaque(true);  
		display_csvx_field_extrah2.setBackground(gray7); 
		display_csvx_field_extrah2.setForeground(blackx);
		display_csvx_field_extrah2.addKeyListener(this);   
		display_csvx_field_extrah2.setHorizontalAlignment(SwingConstants.CENTER);    
		display_csvx_field_extrah2.setFont(f_01);



		//main
		for (int xloop = 0; xloop < items_y; xloop++) {//***************

			//disx_num = items_value;

			//set visable.
			display_csvx_field_extra[0][xloop] = new JButton("" + Integer.toString(offset + xloop)); 
			display_csvx_field_extra[0][xloop].setBorder(null);  
			display_csvx_field_extra[0][xloop].setPreferredSize(new Dimension(40, (item_size))); 
			display_csvx_field_extra[0][xloop].setOpaque(true);
			display_csvx_field_extra[0][xloop].setBackground(gray7);
			display_csvx_field_extra[0][xloop].setForeground(blackx);
			display_csvx_field_extra[0][xloop].addKeyListener(this);   
			display_csvx_field_extra[0][xloop].setHorizontalAlignment(SwingConstants.CENTER); 
			display_csvx_field_extra[0][xloop].setFont(f_01);
			
			//set visable 2.
			display_csvx_field_extra[1][xloop] = new JButton("");                                             
			display_csvx_field_extra[1][xloop].setBorder(null);  
			display_csvx_field_extra[1][xloop].setPreferredSize(new Dimension(20, (item_size))); 
			display_csvx_field_extra[1][xloop].setOpaque(false); 
			display_csvx_field_extra[1][xloop].setBackground(gray7); 
			display_csvx_field_extra[1][xloop].setForeground(blackx);
			display_csvx_field_extra[1][xloop].addKeyListener(this);   
			display_csvx_field_extra[1][xloop].setHorizontalAlignment(SwingConstants.CENTER); 
			display_csvx_field_extra[1][xloop].setFont(f_01);



			//non csv
			for (int xloopn = 0; xloopn < items_x; xloopn++) {//******************************************************

				final int xx_xx = xloopn;
				final int xx_xy = xloop;


				int header_size = 150;

				try {

					header_size = size_int[xloopn];

				} catch (Exception e) {}


				String header_title = "error";

				try {

					header_title = header_list[xloopn];

				} catch (Exception e) {}


				final String sort_string_send = header_title;

				//display_header
				display_csvx_field_header[xloopn][0] = new JButton("[[" + header_title + "]]");              
				display_csvx_field_header[xloopn][0].setBorder(null);  
				display_csvx_field_header[xloopn][0].setPreferredSize(new Dimension(header_size,(item_size)));  
				display_csvx_field_header[xloopn][0].setOpaque(false);
				//display_csvx_field_header[xloopn][0].setContentAreaFilled(false);
				display_csvx_field_header[xloopn][0].setFocusPainted(false);
				display_csvx_field_header[xloopn][0].setBackground(gray7);  
				display_csvx_field_header[xloopn][0].setForeground(blackx);
				display_csvx_field_header[xloopn][0].addKeyListener(this);   
				display_csvx_field_header[xloopn][0].setHorizontalAlignment(SwingConstants.LEFT); 
				display_csvx_field_header[xloopn][0].setFont(f_01);
				display_csvx_field_header[xloopn][0].addActionListener(new ActionListener() {         
				public void actionPerformed(ActionEvent e) {

					//System.out.println(int_items_x);
					//System.out.println(int_items_y);

					pcs.firePropertyChange("sortClick", what_item + 1, sort_string_send);

				}
				}); 


				//regular items
				display_csvx_field[xloopn][xloop] = new JButton("1");              
				display_csvx_field[xloopn][xloop].setBorder(null);  
				display_csvx_field[xloopn][xloop].setPreferredSize(new Dimension(header_size,(item_size)));  
				display_csvx_field[xloopn][xloop].setOpaque(false);
				display_csvx_field[xloopn][xloop].setContentAreaFilled(false);
				display_csvx_field[xloopn][xloop].setFocusPainted(false);
				display_csvx_field[xloopn][xloop].setBackground(blackx);  
				display_csvx_field[xloopn][xloop].setForeground(blackx);
				display_csvx_field[xloopn][xloop].addKeyListener(this);     
				display_csvx_field[xloopn][xloop].setHorizontalAlignment(SwingConstants.LEFT); 
				display_csvx_field[xloopn][xloop].setFont(f_01);
				display_csvx_field[xloopn][xloop].addMouseListener(new MouseAdapter(){//**********
				public void mousePressed(MouseEvent e) {//*************************************


					System.out.println("Mouse CLICKED 1");
					if (SwingUtilities.isLeftMouseButton(e)) {//*********

						try {

		      				if (!press_s && !press_c) {//press_s != 1 && press_c != 1

		      					System.out.println("SET COLOR... " + xx_xx + " " + xx_xy);

								if (what_item % 2 == 0) {jpkx[what_item].setBackground(st_gray1);}
								else {jpkx[what_item].setBackground(st_gray2);}

								for (int xloop3 = 0; xloop3 < items_x; xloop3++) {//******

									display_csvx_field[xloop3][what_item].setForeground(blackx);

								}//*******************************************************	

								//Show the blue selected item.
								jpkx[xx_xy].setBackground(highlight_color);

								for (int xloop3 = 0; xloop3 < items_x; xloop3++) {//******

									display_csvx_field[xloop3][xx_xy].setForeground(whitex);

								}//*******************************************************	

		       				}//if******************************

						} catch (Exception ex) {ex.printStackTrace(); System.out.println("MAKE LINES SET SELECTED FAIL OUT OF BOUNDS");}

					}//*************************************************
					else {

						System.out.println("RIGHT MOUSE LOCATION " + Integer.toString(what_item)); 
						System.out.println("copy x");
						pcs.firePropertyChange("rightClick", what_item + 1, what_item);

					}//***



				}//****************************************************************************
				});//*********************************************************************************
				display_csvx_field[xloopn][xloop].addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {

					System.out.println("Mouse CLICKED " + xx_xx + " " + xx_xy);
					if (SwingUtilities.isRightMouseButton(e)) {menu.show(e.getComponent(), e.getX(), e.getY());}
					else if (SwingUtilities.isLeftMouseButton(e)) {

						System.out.println("xx_xx " + xx_xx); 
						what_item = xx_xy; 
						what_item2 = xx_xx;
						display_item(offset); 

					}//********************************************
					else {System.out.println("NOTHING FOUND");}


					if (e.getClickCount() == 2 && !e.isConsumed()) {

						if (!press_c && !press_s) {

							e.consume();
							System.out.println("double click");

							pcs.firePropertyChange("doubleClick", what_item + 1, xx_xy);

						}

					}//*********************************************

				}//**************************************
				});//*******************************************************************


				

			}//for****************************************************************************************************
			//non csv


			//System.out.println("db_number " + db_number + " xloop " + xloop);

			jpkx_head = new JPanel(flow1);
			jpkx_head.setPreferredSize(new Dimension(xzx + 3840, item_size));
			jpkx_head.setBackground(gray7);
			jpkx_head.add(display_csvx_field_extrah1);
			jpkx_head.add(display_csvx_field_extrah2);


			jpkx[xloop] = new JPanel(flow1);
			jpkx[xloop].setPreferredSize(new Dimension(xzx + 3840, item_size));
			jpkx[xloop].setBackground(xstripesc);
			jpkx[xloop].add(display_csvx_field_extra[0][xloop]);
			jpkx[xloop].add(display_csvx_field_extra[1][xloop]);



			for (int xloopn = 0; xloopn < items_x; xloopn++) {//****************

				jpkx_head.add(display_csvx_field_header[xloopn][0]);
				jpkx[xloop].add(display_csvx_field[xloopn][xloop]);
				//if(db_number == ss_settings && ){}

			}//for**************************************************************




		}//for**********************************************************


		

		try {

			jpk1.add(jpkx_head);

		} catch (Exception e) {}


		for (int xloop = 0; xloop < items_y; xloop++) {//******************

			jpk1.add(jpkx[xloop]);

		}//for*************************************************************




		Dimension dimx = new Dimension();//for csv field. 
		int csv_width_total = 0;

		for (int xloop = 0; xloop < items_x; xloop++) {//******

			try {

				//System.out.println(db_number + " " + xloop);
				dimx = display_csvx_field[xloop][0].getPreferredSize();
				csv_width_total = csv_width_total + dimx.width + 3;

			} catch (Exception e) {System.out.println("error");}

			System.out.println("Program display width   d  d  x " + csv_width_total);

		}//for***********************************************************



		jpk1.setPreferredSize(new Dimension((csv_width_total + 10), item_size + (items_y * (item_size))));

		System.out.println("csv_width_total " + csv_width_total);

		jpkx_head.setPreferredSize(new Dimension(csv_width_total + 2000, item_size));

		//db lines
		for (int xloop = 0; xloop < items_y; xloop++) {//***********

			jpkx[xloop].setPreferredSize(new Dimension(csv_width_total + 2000, item_size));

		}//for******************************************************


		make_stripes();
		display_item(offset);


	}//displayx***********************************************************************************************************











	public void make_stripes(){

		System.out.println("make stripes");

		int stripesx = 0;
		int items_x = displayList.length;
		int items_y = displayList[0].length;
		


		try {

			System.out.println("d1 " + items_y);
			System.out.println("d2 " + items_x);
			//System.out.println("d3 " + nm.carbon[nm.db_number][0].length);

		} catch (Exception e) {}



		for (int xloop = 0; xloop < items_y; xloop++) {//******

			xstripesc = st_gray1;
			if (stripesx == 1) {stripesx = 0; xstripesc = st_gray2;} 
			else {stripesx++;}

			//System.out.println(db_number + " " + xloop);

			jpkx[xloop].setBackground(xstripesc);

		}//****************************************************

		System.out.println("xx");


		//throw new ArithmeticException("/ by zero");


	}//***************************make_striples








	public void show_selected() {

		int items_x = displayList.length;
		int items_y = displayList[0].length;

		try {

			//** this is needed on start up and during errors. 

			//Show the blue selected item.
			jpkx[what_item].setBackground(highlight_color);

			for (int xloop3 = 0; xloop3 < items_x; xloop3++) {//******

				display_csvx_field[xloop3][what_item].setForeground(whitex);

			}//*******************************************************	

		} catch (Exception e) {System.out.println("MAKE LINES SET SELECTED FAIL OUT OF BOUNDS");}


	}//**************************









	public void set_button_on_off(int db_number){

		try {


			System.out.println("SET_BUTTONS_ON_OFF");

			if (db_number == 0) {//********************************************

				items0.setEnabled(false);
				items1.setEnabled(false);
				items2.setEnabled(false);
				items3.setEnabled(false);
				items4.setEnabled(false);
				items5.setEnabled(false);
				items6.setEnabled(false);
				item0.setEnabled(false);
				item1.setEnabled(true);
				item2.setEnabled(true);
				item3.setEnabled(true);
				item4.setEnabled(true);
				item5.setEnabled(true);
				item_0.setEnabled(true);
				item_1.setEnabled(false);
				item_2.setEnabled(false);
				item_3.setEnabled(false);
				itemx0.setEnabled(true);
				itemx1.setEnabled(true);
				itemx2.setEnabled(true);
				itemx3.setEnabled(true);

			}//if************************************************************

			if (db_number == 1) {//********************************************

				items0.setEnabled(false);
				items1.setEnabled(false);
				items2.setEnabled(false);
				items3.setEnabled(false);
				items4.setEnabled(false);
				items5.setEnabled(false);
				items6.setEnabled(false);
				item0.setEnabled(false);
				item1.setEnabled(false);
				item2.setEnabled(false);
				item3.setEnabled(false);
				item4.setEnabled(false);
				item5.setEnabled(false);
				item_0.setEnabled(false);
				item_1.setEnabled(false);
				item_2.setEnabled(false);
				item_3.setEnabled(false);
				itemx0.setEnabled(false);
				itemx1.setEnabled(false);
				itemx2.setEnabled(false);
				itemx3.setEnabled(false);

			}//if************************************************************

			if (db_number == 2) {//********************************************

				items0.setEnabled(true);
				items1.setEnabled(true);
				items2.setEnabled(true);
				items3.setEnabled(true);
				items4.setEnabled(true);
				items5.setEnabled(true);
				items6.setEnabled(true);
				item0.setEnabled(false);
				item1.setEnabled(false);
				item2.setEnabled(false);
				item3.setEnabled(true);
				item4.setEnabled(false);
				item5.setEnabled(false);
				item_0.setEnabled(false);
				item_1.setEnabled(true);
				item_2.setEnabled(true);
				item_3.setEnabled(false);
				itemx0.setEnabled(true);
				itemx1.setEnabled(true);
				itemx2.setEnabled(true);
				itemx3.setEnabled(true);

			}//if************************************************************

			if (db_number == 3) {//********************************************

				items0.setEnabled(false);
				items1.setEnabled(false);
				items2.setEnabled(false);
				items3.setEnabled(false);
				items4.setEnabled(false);
				items5.setEnabled(false);
				items6.setEnabled(false);
				item0.setEnabled(false);
				item1.setEnabled(false);
				item2.setEnabled(false);
				item3.setEnabled(true);
				item4.setEnabled(false);
				item5.setEnabled(false);
				item_0.setEnabled(false);
				item_1.setEnabled(true);
				item_2.setEnabled(false);
				item_3.setEnabled(false);
				itemx0.setEnabled(true);
				itemx1.setEnabled(true);
				itemx2.setEnabled(true);
				itemx3.setEnabled(true);

			}//if************************************************************

			if (db_number == 4) {//********************************************

				items0.setEnabled(false);
				items1.setEnabled(false);
				items2.setEnabled(false);
				items3.setEnabled(false);
				items4.setEnabled(false);
				items5.setEnabled(false);
				items6.setEnabled(false);
				item0.setEnabled(false);
				item1.setEnabled(false);
				item2.setEnabled(false);
				item3.setEnabled(false);
				item4.setEnabled(false);
				item5.setEnabled(false);
				item_0.setEnabled(false);
				item_1.setEnabled(false);
				item_2.setEnabled(false);
				item_3.setEnabled(false);
				itemx0.setEnabled(false);
				itemx1.setEnabled(false);
				itemx2.setEnabled(false);
				itemx3.setEnabled(false);

			}//if************************************************************

			if (db_number == 5) {//********************************************

				items0.setEnabled(false);
				items1.setEnabled(false);
				items2.setEnabled(false);
				items3.setEnabled(false);
				items4.setEnabled(false);
				items5.setEnabled(false);
				items6.setEnabled(false);
				item0.setEnabled(false);
				item1.setEnabled(true);
				item2.setEnabled(false);
				item3.setEnabled(true);
				item4.setEnabled(false);
				item5.setEnabled(false);
				item_0.setEnabled(false);
				item_1.setEnabled(false);
				item_2.setEnabled(false);
				item_3.setEnabled(false);
				itemx0.setEnabled(false);
				itemx1.setEnabled(false);
				itemx2.setEnabled(false);
				itemx3.setEnabled(false);

			}//if************************************************************

			if (db_number == 6) {//********************************************

				items0.setEnabled(false);
				items1.setEnabled(false);
				items2.setEnabled(false);
				items3.setEnabled(false);
				items4.setEnabled(false);
				items5.setEnabled(false);
				items6.setEnabled(false);
				item0.setEnabled(false);
				item1.setEnabled(false);
				item2.setEnabled(false);
				item3.setEnabled(false);
				item4.setEnabled(false);
				item5.setEnabled(false);
				item_0.setEnabled(false);
				item_1.setEnabled(false);
				item_2.setEnabled(false);
				item_3.setEnabled(false);
				itemx0.setEnabled(false);
				itemx1.setEnabled(false);
				itemx2.setEnabled(false);
				itemx3.setEnabled(false);

			}//if************************************************************

		} catch(Exception e) {e.printStackTrace();}


	}//on off***********************





	public int getWhatItemValue() {

		return what_item;

	}//*******************************


	public int[] getSelectedValues() {

		return selected_int;

	}//*******************************







    public void mousePressed(MouseEvent ev) {

        if (ev.isPopupTrigger()) {menu.show(ev.getComponent(), ev.getX(), ev.getY());}

    }//**************************************

    public void mouseReleased(MouseEvent ev) {

        //if (ev.isPopupTrigger()) {menu.show(ev.getComponent(), ev.getX(), ev.getY());}

    }//***************************************

    public void mouseClicked(MouseEvent ev) {}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}

    public void mouseDragged(MouseEvent e){}

    public void mouseMoved(MouseEvent e){}



    public void keyPressed(KeyEvent e){

    	//System.out.println("PRESS");

		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {press_s = true; pressx_repaint = 1;}//pressx
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {press_c = true; pressx_repaint = 1;}//pressy
		if (press_c && e.getKeyCode() == KeyEvent.VK_A) {select_all_items();}

    }//pressed



    public void keyTyped(KeyEvent e){}//typed*************************
    public void keyReleased(KeyEvent e){

    	//System.out.println("RELEASE");

		if (e.getKeyCode() == KeyEvent.VK_UP) {}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {}

		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {press_s = false;}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {press_c = false;}

		if (e.getKeyCode() == KeyEvent.VK_DELETE) {pcs.firePropertyChange("Delete", 0, 1);}

    }//*********************************







public void actionPerformed(ActionEvent event){




}//********************************************




}//last****************************************


