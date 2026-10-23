import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_order_system extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 500;
int xzy = 500;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

Object newItem;
JComboBox cb;


String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

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

Float ixx0;

int stop = 0;
int post_number = 1;


String cxx0[] = new String[1];
String ORDER_LIST_X = new String("");
int MATCHI = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
Color grayx2 = new Color(0.6f, 0.6f, 0.6f);



JLabel order1_l = new JLabel("MATCH Order Qty MIN", JLabel.LEFT);
JLabel order2_l = new JLabel("MATCH Order Qty MAX", JLabel.LEFT);

JComboBox order1_cb = new JComboBox();
JComboBox order2_cb = new JComboBox();


TextArea order_list = new TextArea(13, 60);



JLabel part_l = new JLabel("MATCH Order PART Number", JLabel.LEFT);
JComboBox part_cb = new JComboBox();



JLabel part_to_order_l = new JLabel("Select Part or Brand to ORDER: ", JLabel.LEFT);
JComboBox part_to_order_cb = new JComboBox();







JLabel order_q_l = new JLabel("Items: 0", JLabel.CENTER);
JLabel order_m_l = new JLabel("Cost: $0.00", JLabel.CENTER);




FlowLayout flow = new FlowLayout();






alchemy_order_system(){//****************************

	super("Order System");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.firex = 1;}});





	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);




	try{

		System.out.println(nm.settingsx[75]);
		ix0 = Integer.parseInt(nm.settingsx[75]);

	}catch(Exception e){ix0 = 1;}

	if(ix0 > nm.db_string.length){ix0 = 0;}

	order1_cb = new JComboBox(nm.db_string);
	order1_cb.setSelectedIndex(ix0);
	order1_cb.addActionListener(this);
	order1_cb.setPreferredSize(new Dimension(150, 20));
	order1_cb.setToolTipText("Set Match Type.");



	try{

		System.out.println(nm.settingsx[76]);
		ix0 = Integer.parseInt(nm.settingsx[76]);

	}catch(Exception e){ix0 = 1;}

	if(ix0 > nm.db_string.length){ix0 = 0;}

	order2_cb = new JComboBox(nm.db_string);
	order2_cb.setSelectedIndex(ix0);
	order2_cb.addActionListener(this);
	order2_cb.setPreferredSize(new Dimension(150, 20));
	order2_cb.setToolTipText("Set Match Type.");









	try{

		System.out.println(nm.settingsx[77]);
		ix0 = Integer.parseInt(nm.settingsx[77]);

	}catch(Exception e){ix0 = 1;}

	if(ix0 > nm.db_string.length){ix0 = 0;}

	part_cb = new JComboBox(nm.db_string);
	part_cb.setSelectedIndex(ix0);
	part_cb.addActionListener(this);
	part_cb.setPreferredSize(new Dimension(150, 20));
	part_cb.setToolTipText("Set Match Type.");











//part to order.


	try{

		ix0 = 0;
		cxx0 = new String[(nm.carbon[0][0].length -1)];

		for (int loop2 = 1; loop2 < nm.carbon[0][0].length; loop2++){//*************************

			cxx0[ix0] = nm.carbon[0][ Integer.parseInt(nm.settingsx[77]) ][loop2];
			ix0++;

		}//*************************************************************************************



		part_to_order_cb = new JComboBox(cxx0);
		part_to_order_cb.setSelectedIndex(0);

	}catch(Exception e){}

	part_to_order_cb.addActionListener(this);
	part_to_order_cb.setPreferredSize(new Dimension(150, 20));
	part_to_order_cb.setToolTipText("Set Match Type.");











	order1_l.setPreferredSize(new Dimension(250, 20));
	order2_l.setPreferredSize(new Dimension(250, 20));

	part_l.setPreferredSize(new Dimension(250, 20));

	part_to_order_l.setPreferredSize(new Dimension(250, 20));

	order_q_l.setPreferredSize(new Dimension(230, 20));
	order_m_l.setPreferredSize(new Dimension(230, 20));







        JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(480, 90));
	jpk1.setBackground(nm.jgray);
	jpk1.add(order1_l);	jpk1.add(order1_cb);
	jpk1.add(order2_l);	jpk1.add(order2_cb);


        JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(480, 40));
	jpk2.setBackground(nm.jgray);
	jpk2.add(part_l);     jpk2.add(part_cb);


        JPanel jpk3 = new JPanel();
	jpk3.setPreferredSize(new Dimension(480, 40));
	jpk3.setBackground(nm.jgray);
	jpk3.add(part_to_order_l);     jpk3.add(part_to_order_cb);


        JPanel jpk4 = new JPanel();
	jpk4.setPreferredSize(new Dimension(480, 40));
	jpk4.setBackground(nm.jgray);
	jpk4.add(order_q_l);     jpk4.add(order_m_l);


        JPanel jpk5 = new JPanel();
	jpk5.setPreferredSize(new Dimension(480, 230));
	jpk5.setBackground(nm.jgray);
	jpk5.add(order_list);







	Container cpx = getContentPane();
	cpx.setLayout(flow);
	cpx.setBackground(nm.jblue);
	cpx.setForeground(whitex);
	cpx.add(jpk1);
	cpx.add(jpk2);
	cpx.add(jpk3);
	cpx.add(jpk4);
	cpx.add(jpk5);



	setVisible(true);





	requestFocus();



}//csv_loader_x1********************************************************







	public void loadx_x(){

	}//savex



	public void savex_x(){

	}//savex







	public void show_order(){

		ix0 = 0;
		ix1 = 0;
		ixx0 = (float) 0.0;
		ORDER_LIST_X = "";


		for (int loop2 = 1; loop2 < nm.carbon[0][0].length; loop2++){//*************************

			if(cxx0[MATCHI].equals(nm.carbon[0][ Integer.parseInt(nm.settingsx[77]) ][loop2])){//*************************

				if( Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][loop2]) < Integer.parseInt(nm.carbon[0][ Integer.parseInt(nm.settingsx[75]) ][loop2]) ){

					ix0 = ix0 + Integer.parseInt(nm.carbon[0][ Integer.parseInt(nm.settingsx[76]) ][loop2]) - Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][loop2]);
					ixx0 = ixx0 + (Float.parseFloat(nm.carbon[0][nm.item_price_xx][loop2]) * (Integer.parseInt(nm.carbon[0][ Integer.parseInt(nm.settingsx[76]) ][loop2]) - Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][loop2])) );

					ix1 = Integer.parseInt(nm.carbon[0][ Integer.parseInt(nm.settingsx[76]) ][loop2]) - Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][loop2]);

					ORDER_LIST_X = ORDER_LIST_X + Integer.toString(ix1) + " X Units   " + nm.carbon[0][nm.part_number_xx][loop2] + "\n";

				}//if**********************************************************************************************************************************************

			}//**************************************************************************************************************

		}//*************************************************************************************


		order_q_l.setText("Items: " + Integer.toString(ix1));
		order_m_l.setText("Cost: $" + Float.toString(ixx0));

		order_list.setText(ORDER_LIST_X);


	}//**********************











//handel all the button clicks. 
public void actionPerformed(ActionEvent event){







	if(event.getSource() == order1_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();
		
		for (int loop1 = 0; loop1 < order1_cb.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.settingsx[75] = Integer.toString(loop1);}

		}//*********************

	}//not used






	if(event.getSource() == order2_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < order2_cb.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.settingsx[76] = Integer.toString(loop1);}

		}//*********************

	}//not used









	if(event.getSource() == part_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < part_cb.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.settingsx[77] = Integer.toString(loop1);}

		}//*********************

	}//not used










	if(event.getSource() == part_to_order_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < part_to_order_cb.getItemCount(); loop1++){//s1x

			if(cxx0[loop1].equals(newItem)){MATCHI = loop1;}

		}//*********************
		show_order();

	}//not used






}//actionPerformed














    public static void main(){

		alchemy_order_system xr = new alchemy_order_system();

    }//main










}//last****************************************