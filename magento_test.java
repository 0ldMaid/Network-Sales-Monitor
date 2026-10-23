import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;



import com.google.code.magja.model.customer.Customer;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.customer.CustomerRemoteService;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.soap.SoapCallFactory;
import com.google.code.magja.soap.MagentoSoapClient;

import com.google.code.magja.service.order.OrderRemoteService;

import com.google.code.magja.model.country.Country;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.country.CountryRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import java.util.List;


import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapClient;



public class magento_test{//************************************************************************


int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

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
int stop = 0;
int post_number = 1;
int what_item_here = 0;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String cx3 = new String("");

File st1;


String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;








magento_test(){//****************************

System.out.println("Test Magento");
System.out.println(nm.carbon[5][2][nm.what_item]);
connectx();
System.out.println(nm.carbon[5][2][nm.what_item]);

}//csv_loader_x1********************************************************










	public void connectx(){


		try{

			System.out.println(nm.carbon[5][1][nm.what_item]);


			System.out.println(nm.carbon[5][2][nm.what_item]);
			System.out.println(nm.carbon[5][3][nm.what_item]);



		    String user = nm.carbon[5][2][nm.what_item];
		    String pass = nm.carbon[5][3][nm.what_item];
		    String host = nm.carbon[5][1][nm.what_item];

	


		    System.out.println("user " + user);
		    System.out.println("pass " + pass);
		    System.out.println("host " + host);



		    // configure connection
		    SoapConfig soapConfig = new SoapConfig(user, pass, host);

		    if(soapConfig == null){System.out.println("0000");}


		    System.out.println(soapConfig.getApiUser());
		    System.out.println(soapConfig.getApiKey());
		    System.out.println(soapConfig.getRemoteHost());


		    //MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
		    MagentoSoapClient magentoSoapClient = MagentoSoapClient.getInstance(soapConfig);
		    //magentoSoapClient.setConfig(soapConfig);




            // get country service
            CountryRemoteService countryRemoteService = new RemoteServiceFactory(magentoSoapClient).getCountryRemoteService();
            countryRemoteService.setSoapClient(magentoSoapClient);



            // get list of all countries
            List<Country> countries = countryRemoteService.list();

            // display all countries
            for (Country country : countries) {
                //System.out.println(country);
            }




		    System.out.println(countries.size());
		    if(countries.size() > 1){cx0 = "1";}



		} catch (Exception e) {e.printStackTrace(); JOptionPane.showMessageDialog(null, e.getMessage()); System.out.println(e.getMessage()); cx0 = "0";}




		System.out.println("Get html " + cx0);

		nm.pass_com = cx0;



	}//connectx()*********************************************************************************************
















}//last****************************************