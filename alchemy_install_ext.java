import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;


import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;






public class alchemy_install_ext{

String getfilex = new String("");
String filename = new String("");
String carbonfiber[] = new String[37];

int ix0 = 0;
int ix1 = 0;
int bytesRead = 0;








alchemy_install_ext(String str){//********************************************************************************************************
	
	//str = "ext_ebayx";

	carbonfiber[0] = new String("activation.jar");
	carbonfiber[1] = new String("attributes.jar");
	carbonfiber[2] = new String("ebaycalls.jar");
	carbonfiber[3] = new String("ebaysdkcore.jar");
	carbonfiber[4] = new String("FastInfoset.jar");
	carbonfiber[5] = new String("helper.jar");
	carbonfiber[6] = new String("http.jar");
	carbonfiber[7] = new String("jakarta-oro-2.0.8.jar");
	carbonfiber[8] = new String("jaxb-api.jar");
	carbonfiber[9] = new String("jaxb-impl.jar");
	carbonfiber[10] = new String("jaxb-xjc.jar");
	carbonfiber[11] = new String("jaxws-api.jar");
	carbonfiber[12] = new String("jaxws-rt.jar");
	carbonfiber[13] = new String("jaxws-tools.jar");
	carbonfiber[14] = new String("jsr173_api.jar");
	carbonfiber[15] = new String("jsr181-api.jar");
	carbonfiber[16] = new String("jsr250-api.jar");
	carbonfiber[17] = new String("log4j-1.2.16.jar");
	carbonfiber[18] = new String("mimepull.jar");
	carbonfiber[19] = new String("resolver.jar");
	carbonfiber[20] = new String("saaj-api.jar");
	carbonfiber[21] = new String("saaj-impl.jar");
	carbonfiber[22] = new String("serializer.jar");
	carbonfiber[23] = new String("sjsxp.jar");
	carbonfiber[24] = new String("slf4j-api-1.6.1.jar");
	carbonfiber[25] = new String("slf4j-log4j12-1.6.1.jar");
	carbonfiber[26] = new String("stax-ex.jar");
	carbonfiber[27] = new String("streambuffer.jar");
	carbonfiber[28] = new String("xalan.jar");

	carbonfiber[29] = new String("mysql-connector-java-5.1.18-bin.jar");
	carbonfiber[30] = new String("derby.jar");

	carbonfiber[31] = new String("FBAInventoryServiceMWSJavaClientLibrary-1.1.jar");
	carbonfiber[32] = new String("commons-codec-1.3.jar");
	carbonfiber[33] = new String("commons-httpclient-3.0.1.jar");
	carbonfiber[34] = new String("commons-logging-1.1.jar");
	carbonfiber[35] = new String("MaWSJavaClientLibrary-1.0.jar");
	carbonfiber[36] = new String("log4j-1.2.14.jar");



	ix0 = carbonfiber.length;


	System.out.println(carbonfiber.length);


	for(int loop1 = 0; loop1 < ix0; loop1++){//********************

		getfilex = "ext\\" + carbonfiber[loop1];
		filename = str + "\\" + carbonfiber[loop1];

		System.out.println("getfilex " + getfilex);
		System.out.println("filename " + filename);

		try{
	
			InputStream in = nm.class.getResourceAsStream(getfilex);
			//BufferedInputStream in = new BufferedInputStream(new FileInputStream(getfilex));
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filename));
			byte xdatax[] = new byte[10240];

			while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}

			bout.close();
			in.close();

		}catch (IOException e){System.out.println(filename); e.printStackTrace();}




	}//for*********************************************************







}//install_ebay_connect**************************************************************************************************************









}//last