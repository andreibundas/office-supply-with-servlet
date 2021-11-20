package org.fasttrackit;

import org.fasttrackit.persistence.SupplyDemandRepository;
import org.fasttrackit.transfer.CreateSupplyRequest;
import org.fasttrackit.transfer.UpdateSupplyRequest;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );

        SupplyDemandRepository supplyDemandRepository = new SupplyDemandRepository();
//        CreateSupplyRequest request = new CreateSupplyRequest();
//        request.setDepartment("Logistic");
//        request.setSupplyName("paper");
//        request.setQuantityPcsPckgs(3);
//        request.setValueRON(30);
//        request.setDeliveryDate(LocalDate.now().plusWeeks(2));
//
//        supplyDemandRepository.createSupplyDemand(request);

//        supplyDemandRepository.deleteSupplyDemand(18);


        //update
        UpdateSupplyRequest request = new UpdateSupplyRequest();
        request.setCompleted(true);

        supplyDemandRepository.updateSupplyDemand(request, 17);



    }
}
