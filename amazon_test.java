import java.util.List;
import java.util.ArrayList;
import com.amazonaws.mws.*;
import com.amazonaws.mws.model.*;
import com.amazonaws.mws.mock.MarketplaceWebServiceMock;
import javax.swing.JOptionPane;





public class amazon_test {


static int get_report_number = -1;
	



amazon_test(){


	//nm.pass_com = "1";

    final String accessKeyId = nm.carbon[5][2][nm.what_item]; //"AKIAJJ
    final String secretAccessKey = nm.carbon[5][3][nm.what_item]; // "ueTGIbb
    final String merchantId = nm.carbon[5][6][nm.what_item]; //"A2ISA

	System.out.println("accessKeyId " + accessKeyId);
	System.out.println("secretAccessKey " + secretAccessKey);
	System.out.println("merchantId " + merchantId);

    final String appName = "Alchemist";
    final String appVersion = "1.4.3";

    MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

    config.setServiceURL(nm.carbon[5][1][nm.what_item]);//"https://mws.amazonservices.com"


    config.setMaxAsyncThreads(35);


    MarketplaceWebService service = new MarketplaceWebServiceClient(accessKeyId, secretAccessKey, appName, appVersion, config);


    //MarketplaceWebService service = new MarketplaceWebServiceMock();



    GetReportCountRequest request = new GetReportCountRequest();
    request.setMerchant( merchantId );

	System.out.println("     " + get_report_number);
    invokeGetReportCount(service, request);

	System.out.println("     " + get_report_number);


	//if(get_report_number > -1){nm.pass_com = "1";}
	
	System.out.println("     " + get_report_number);


}//test



    /**
     * Get Report Count  request sample
     * returns a count of reports matching your criteria;
     * by default, the number of reports generated in the last 90 days,
     * regardless of acknowledgement status
     *   
     * @param service instance of MarketplaceWebService service
     * @param request Action to invoke
     */
    public static void invokeGetReportCount(MarketplaceWebService service, GetReportCountRequest request) {

        try {

            GetReportCountResponse response = service.getReportCount(request);


            System.out.println ("GetReportCount Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    GetReportCountResponse");
            System.out.println();
            if (response.isSetGetReportCountResult()) {
                System.out.print("        GetReportCountResult");
                System.out.println();
                GetReportCountResult  getReportCountResult = response.getGetReportCountResult();
                if (getReportCountResult.isSetCount()) {
                    System.out.print("            Count");
                    System.out.println();
                    System.out.print("                " + getReportCountResult.getCount()); get_report_number = getReportCountResult.getCount();
                    System.out.println();
                }
            } 
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 

            System.out.println();


        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage()); 
            //nm.pass_error = ex.getMessage(); 
            //JOptionPane.showMessageDialog(null, nm.pass_error);
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode() );
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());

            //nm.pass_com = "0";

        }
    }




}//last
