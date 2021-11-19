package org.fasttrackit.persistence;

import org.fasttrackit.transfer.CreateSupplyRequest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DAO (Data Access Object)
@SuppressWarnings("SqlNoDataSourceInspection")
public class SupplyDemandRepository {

    public void createSupplyDemand(CreateSupplyRequest request) throws SQLException {
        String sql = "INSERT INTO supplies (department, supplies, quantity_pcs_pckgs, quantity_unit_price, " +
                " value_RON, delivery_date) VALUES (?, ?, ?, ?, ?, ?) ";

        //try with resources
        try (PreparedStatement preparedStatement = org.fasttrackit.config.DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, request.getDepartment());
            preparedStatement.setString( 2, request.getSupplyName());
            preparedStatement.setDouble( 3, request.getQuantityPcsPckgs());
            preparedStatement.setDouble( 4, request.getSupplyUnitPrice());
            preparedStatement.setDouble( 5, request.getValueRON());
            preparedStatement.setDate(6, Date.valueOf(request.getDeliveryDate()));

            preparedStatement.executeUpdate();
        }


    }
}
