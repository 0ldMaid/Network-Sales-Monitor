import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.util.Timer;
import java.util.TimerTask;



public class alchemy_start_screen extends JFrame{

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 400;
int xzy = 200;
//int xzx = 360;
//int xzy = 168;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("", JLabel.CENTER);
JLabel infox2 = new JLabel("", JLabel.LEFT);

Timer xtimerx_loop;//program loop
Timer xtimerx;//class loop.

Toolkit toolkit;



alchemy_start_screen() {//**************************************************************************



	super("Load Database");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(nm.jblue);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setDefaultLookAndFeelDecorated(false);
	setUndecorated(true);


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	Icon aicon = new ImageIcon(ximagex);


	infox0.setPreferredSize(new Dimension(xzx, 20));
	infox0.setBackground(nm.jgray);
	infox0.setForeground(nm.whitex);
	//infox0.setOpaque(false);
	//infox0.setIcon(aicon);
	//infox0.setText("Version " + nm.Program_version + " ");
	//infox0.setHorizontalTextPosition(Label.LEFT);
	//infox0.setIconTextGap(80);

	infox1.setPreferredSize(new Dimension(xzx, xzy - 40));
	infox1.setBackground(nm.jgray);
	infox1.setForeground(nm.whitex);
	//infox1.setIcon(aicon);
	//infox1.setOpaque(false);
	infox1.setText("");

	infox2.setPreferredSize(new Dimension(xzx, 20));
	infox2.setBackground(nm.jgray);
	infox2.setForeground(nm.whitex);
	infox2.setText(" Version " + nm.program_version + " ");


	FlowLayout fl1 = new FlowLayout();
	fl1.setHgap(0);
	fl1.setVgap(0);


	BackgroundPanelccl bkp = new BackgroundPanelccl();
	bkp.setPreferredSize(new Dimension(xzx, xzy));
	bkp.setLayout(fl1);
	//bkp.setBackground(nm.jgray);
	bkp.setForeground(nm.blackx);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);


	Container cpx = getContentPane();
	cpx.setLayout(fl1);
	cpx.setBackground(nm.jgray);
	cpx.setForeground(nm.blackx);
	cpx.add(bkp);



	setVisible(true);



    //Keep showing the logo until the program is ready. 
	toolkit = Toolkit.getDefaultToolkit();
	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_wait_for_display(), 0);



}//load








	class RemindTask_wait_for_display extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************


		while (!nm.program_display_ready) {

			try {Thread.sleep(100);} catch (InterruptedException e) {}

		}//*****************************

		pullThePlug();


	}//runx***************************************************************************************************
    }//remindtask







    public void pullThePlug() {

    	//try{Thread.sleep(5000);} catch (InterruptedException e){}

    	System.out.println("PULL THE PLUG");

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull






	class BackgroundPanelccl extends JPanel{

		private static final long serialVersionUID = 1;

	  	Image image;

	  	public BackgroundPanelccl(){

	    	try{

	      		image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/alchemy3.jpg"), "alchemy3.jpg"));

	    	}catch(Exception e){e.printStackTrace();}

	  	}//backgroundpanel

	  	protected void paintComponent(Graphics g){

	    	super.paintComponent(g); 

	    	if (image != null){

	      		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);

	      	}//****************

	  	}//paint

	}//jpanel






}//last
