import java.sql.ResultSet;




public class jdb_loader_titles {





	jdb_loader_titles(){//**************************************************************************



		try {



			//34594
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT xd FROM listings");

			jdb_driver.rs.last();
            nm.db_00_size = jdb_driver.rs.getRow();


			//34594
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT xd FROM sold");

			jdb_driver.rs.last();
            nm.db_02_size = jdb_driver.rs.getRow();


			//34594
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT xd FROM archived");

			jdb_driver.rs.last();
            nm.db_03_size = jdb_driver.rs.getRow();




            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        } catch (Exception e) {e.printStackTrace();}



	}//load







}//last