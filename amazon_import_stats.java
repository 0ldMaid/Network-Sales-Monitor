import java.util.List;
import java.util.ArrayList;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.*;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.model.*;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.mock.FBAInventoryServiceMWSMock;



public class amazon_import_stats {


int what_item = 0;

String accessKeyId = new String("");
String secretAccessKey = new String("");
String merchantId = new String("");
String marketplaceId = new String("");

String sellerId = new String("");

String applicationName = new String("Alchemist");
String applicationVersion = new String("1.4.3");




amazon_import_stats(int what_item_x) {//**************************************************************

    what_item = what_item_x;

    nm.stats_hits = "n/a";
    nm.stats_running = "n/a";
    nm.stats_sales = "n/a";

    SellerSkuList sku = new SellerSkuList();


}//***************************************************************************************************





    /**
     * List Inventory Supply By Next Token  request sample
     * Continues pagination over a resultset of inventory data for inventory
     * items.
     * 
     * This operation is used in conjunction with ListUpdatedInventorySupply.
     * Please refer to documentation for that operation for further details.
     *   
     * @param service instance of FBAInventoryServiceMWS service
     * @param request Action to invoke
     */
    public static void invokeListInventorySupplyByNextToken(FBAInventoryServiceMWS service, ListInventorySupplyByNextTokenRequest request) {

        try {
            
            ListInventorySupplyByNextTokenResponse response = service.listInventorySupplyByNextToken(request);

            
            System.out.println ("ListInventorySupplyByNextToken Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    ListInventorySupplyByNextTokenResponse");
            System.out.println();
            if (response.isSetListInventorySupplyByNextTokenResult()) {
                System.out.println("        ListInventorySupplyByNextTokenResult");
                System.out.println();
                ListInventorySupplyByNextTokenResult  listInventorySupplyByNextTokenResult = response.getListInventorySupplyByNextTokenResult();
                if (listInventorySupplyByNextTokenResult.isSetInventorySupplyList()) {
                    System.out.println("            InventorySupplyList");
                    System.out.println();
                    InventorySupplyList  inventorySupplyList = listInventorySupplyByNextTokenResult.getInventorySupplyList();
                    java.util.List<InventorySupply> memberList = inventorySupplyList.getMember();
                    for (InventorySupply member : memberList) {
                        System.out.println("                member");
                        System.out.println();
                        if (member.isSetSellerSKU()) {
                            System.out.println("                    SellerSKU");
                            System.out.println();
                            System.out.println("                        " + member.getSellerSKU());
                            System.out.println();
                        }
                        if (member.isSetFNSKU()) {
                            System.out.println("                    FNSKU");
                            System.out.println();
                            System.out.println("                        " + member.getFNSKU());
                            System.out.println();
                        }
                        if (member.isSetASIN()) {
                            System.out.println("                    ASIN");
                            System.out.println();
                            System.out.println("                        " + member.getASIN());
                            System.out.println();
                        }
                        if (member.isSetCondition()) {
                            System.out.println("                    Condition");
                            System.out.println();
                            System.out.println("                        " + member.getCondition());
                            System.out.println();
                        }
                        if (member.isSetTotalSupplyQuantity()) {
                            System.out.println("                    TotalSupplyQuantity");
                            System.out.println();
                            System.out.println("                        " + member.getTotalSupplyQuantity());
                            System.out.println();
                        }
                        if (member.isSetInStockSupplyQuantity()) {
                            System.out.println("                    InStockSupplyQuantity");
                            System.out.println();
                            System.out.println("                        " + member.getInStockSupplyQuantity());
                            System.out.println();
                        }
                        if (member.isSetEarliestAvailability()) {
                            System.out.println("                    EarliestAvailability");
                            System.out.println();
                            Timepoint  earliestAvailability = member.getEarliestAvailability();
                            if (earliestAvailability.isSetTimepointType()) {
                                System.out.println("                        TimepointType");
                                System.out.println();
                                System.out.println("                            " + earliestAvailability.getTimepointType());
                                System.out.println();
                            }
                            if (earliestAvailability.isSetDateTime()) {
                                System.out.println("                        DateTime");
                                System.out.println();
                                System.out.println("                            " + earliestAvailability.getDateTime());
                                System.out.println();
                            }
                        } 
                        if (member.isSetSupplyDetail()) {
                            System.out.println("                    SupplyDetail");
                            System.out.println();
                            InventorySupplyDetailList  supplyDetail = member.getSupplyDetail();
                            java.util.List<InventorySupplyDetail> member1List = supplyDetail.getMember();
                            for (InventorySupplyDetail member1 : member1List) {
                                System.out.println("                        member");
                                System.out.println();
                                if (member1.isSetQuantity()) {
                                    System.out.println("                            Quantity");
                                    System.out.println();
                                    System.out.println("                                " + member1.getQuantity());
                                    System.out.println();
                                }
                                if (member1.isSetSupplyType()) {
                                    System.out.println("                            SupplyType");
                                    System.out.println();
                                    System.out.println("                                " + member1.getSupplyType());
                                    System.out.println();
                                }
                                if (member1.isSetEarliestAvailableToPick()) {
                                    System.out.println("                            EarliestAvailableToPick");
                                    System.out.println();
                                    Timepoint  earliestAvailableToPick = member1.getEarliestAvailableToPick();
                                    if (earliestAvailableToPick.isSetTimepointType()) {
                                        System.out.println("                                TimepointType");
                                        System.out.println();
                                        System.out.println("                                    " + earliestAvailableToPick.getTimepointType());
                                        System.out.println();
                                    }
                                    if (earliestAvailableToPick.isSetDateTime()) {
                                        System.out.println("                                DateTime");
                                        System.out.println();
                                        System.out.println("                                    " + earliestAvailableToPick.getDateTime());
                                        System.out.println();
                                    }
                                } 
                                if (member1.isSetLatestAvailableToPick()) {
                                    System.out.println("                            LatestAvailableToPick");
                                    System.out.println();
                                    Timepoint  latestAvailableToPick = member1.getLatestAvailableToPick();
                                    if (latestAvailableToPick.isSetTimepointType()) {
                                        System.out.println("                                TimepointType");
                                        System.out.println();
                                        System.out.println("                                    " + latestAvailableToPick.getTimepointType());
                                        System.out.println();
                                    }
                                    if (latestAvailableToPick.isSetDateTime()) {
                                        System.out.println("                                DateTime");
                                        System.out.println();
                                        System.out.println("                                    " + latestAvailableToPick.getDateTime());
                                        System.out.println();
                                    }
                                } 
                            }
                        } 
                    }
                } 
                if (listInventorySupplyByNextTokenResult.isSetNextToken()) {
                    System.out.println("            NextToken");
                    System.out.println();
                    System.out.println("                " + listInventorySupplyByNextTokenResult.getNextToken());
                    System.out.println();
                }
            } 
            if (response.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

           
        } catch (FBAInventoryServiceMWSException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            
        }

    }//*******************************************************************************************



}//last
