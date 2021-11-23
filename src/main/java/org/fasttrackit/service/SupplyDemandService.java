package org.fasttrackit.service;

import org.fasttrackit.domain.OfficeSupply;
import org.fasttrackit.persistence.SupplyDemandRepository;
import org.fasttrackit.transfer.CreateSupplyRequest;
import org.fasttrackit.transfer.UpdateSupplyRequest;

import java.sql.SQLException;
import java.util.List;

public class SupplyDemandService {

    private SupplyDemandRepository supplyDemandRepository = new SupplyDemandRepository();

    public void createSupplyDemand(CreateSupplyRequest request) throws SQLException {
        System.out.println("Creating  supplyDemand" + request);
        supplyDemandRepository.createSupplyDemand(request);
    }

    public List<OfficeSupply> getSupplyDemands() throws SQLException {
        System.out.println("Retrieving supplyDemands.");
        return supplyDemandRepository.getSupplyDemands();
    }

    public void updateSupplyDemand(long id, UpdateSupplyRequest request) throws SQLException {
        System.out.println(" Updating supplyDemand " + request);
        supplyDemandRepository.updateSupplyDemand(id, request);
    }

    public void deleteSupplyDemand(long id) throws SQLException {
        System.out.println("Deleting supplyDemand with id " + id);
        supplyDemandRepository.deleteSupplyDemand(id);
    }

}
