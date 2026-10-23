import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;



public class jdb_update_sale_ids{

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";


int ix0 = 0;
int ix1 = 0;

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();




    jdb_update_sale_ids(){//************************************************************************



        try{


            //jdb_driver.s.execute("DELETE FROM archived_sales_ids WHERE ids='01000000021'");


            //reload the list
            System.out.println("Load Settings.");
            jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT ids FROM archived_sales_ids ORDER BY ids");

            jdb_driver.rs.last();
            int rowCount2 = jdb_driver.rs.getRow();
            nm.jdb_load_sales_ids = new String[rowCount2];

            jdb_driver.rs.beforeFirst();

            ix0 = 0;
            while(jdb_driver.rs.next()){

                nm.jdb_load_sales_ids[ix0] = new String(jdb_driver.rs.getString(1));
                //System.out.println("LOADER " + nm.jdb_load_sales_ids[ix0]);

                ix0++;

            }//while********************




            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        }catch(Exception e){e.printStackTrace();}




    }//save




}//last
