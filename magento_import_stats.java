import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import com.google.code.magja.model.order.OrderItem;
import com.google.code.magja.model.order.Order;
import com.google.code.magja.model.product.Product;
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
import com.google.code.magja.service.order.OrderRemoteService;
import com.google.code.magja.service.product.ProductRemoteService;
import com.google.code.magja.service.product.ProductRemoteServiceImpl;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapClient;





public class magento_import_stats {//************************************************************************


int what_item = 0;



magento_import_stats(int what_itemx) {//***************************

	what_item = what_itemx;

	System.out.println("Test Magento");

	connectx();

}//csv_loader_x1*************************************







	public void connectx() {

		nm.stats_hits = "n/a";
		nm.stats_running = "n/a";
		nm.stats_sales = "n/a";


		try {

	 
		    String user = nm.carbon[5][2][ Integer.parseInt(nm.carbon[1][6][what_item]) ];
		    String pass = nm.carbon[5][3][ Integer.parseInt(nm.carbon[1][6][what_item]) ];
		    String host = nm.carbon[5][1][ Integer.parseInt(nm.carbon[1][6][what_item]) ];


		    System.out.println("user " + user);
		    System.out.println("pass " + pass);
		    System.out.println("host " + host);

	 	    // configure connection
		    SoapConfig soapConfig = new SoapConfig(user, pass, host);

		    MagentoSoapClient magentoSoapClient = MagentoSoapClient.getInstance(soapConfig);
		    magentoSoapClient.setConfig(soapConfig);

	        OrderRemoteService servicex = new RemoteServiceFactory(magentoSoapClient).getOrderRemoteService();
	        servicex.setSoapClient(magentoSoapClient);

			int ix0 = 1;

	        List<Order> list = servicex.list(null);
	        for (Order order : list) {

				ix0++;

			}//for

			// TODO: is not working tha find with filter
			// make sure to have a order with billing_name = Joao da Silva
			//OrderFilter filter = new OrderFilter();
			//filter.getItems().add(new OrderFilterItem("billing_name", "like", "%Silva%"));
			//filter.getItems().add(new OrderFilterItem("billing_lastname", "=", "Martins"));

			//List<Order> filtered = service.list(filter);
			//for (Order order : filtered)
			//System.out.println(order.toString());


			System.out.println(ix0);
			nm.stats_sales = Integer.toString(ix0);

			System.out.println("Products list");

		    ProductRemoteService servicex2 = new RemoteServiceFactory(magentoSoapClient).getProductRemoteService();
	        servicex2.setSoapClient(magentoSoapClient);

			int ix1 = 0;
	                        
	        List<Product> list2 = servicex2.listAllNoDep();
	        for (Product product : list2) {

				ix1++;

			}//for


			System.out.println(ix1);
			nm.stats_running = Integer.toString(ix1);


		} catch (Exception e) {System.out.println(e.getMessage());}


		System.out.println("Done");


	}//connectx()*********************************************************************************************








}//last****************************************