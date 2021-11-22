package org.fasttrackit.persistence;

import org.fasttrackit.config.DatabaseConfiguration;
import org.fasttrackit.domain.OfficeSupply;
import org.fasttrackit.transfer.CreateSupplyRequest;
import org.fasttrackit.transfer.UpdateSupplyRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO (Data Access Object)
@SuppressWarnings("SqlNoDataSourceInspection")
public class SupplyDemandRepository {

    public void createSupplyDemand(CreateSupplyRequest request) throws SQLException {
        String sql = "INSERT INTO supplies (department, supplies, quantity_pcs_pckgs, quantity_unit_price, " +
                " value_RON, delivery_date) VALUES (?, ?, ?, ?, ?, ?) ";

        //try with resources
        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, request.getDepartment());
            preparedStatement.setString(2, request.getSupplyName());
            preparedStatement.setDouble(3, request.getQuantityPcsPckgs());
            preparedStatement.setDouble(4, request.getSupplyUnitPrice());
            preparedStatement.setDouble(5, request.getValueRON());
            preparedStatement.setDate(6, Date.valueOf(request.getDeliveryDate()));

            preparedStatement.executeUpdate();
        }
    }

    public void deleteSupplyDemand(long id) throws SQLException {
        String sql = "DELETE FROM supplies WHERE id = ? ";

        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }

    public void updateSupplyDemand(long id, UpdateSupplyRequest request) throws SQLException {
        String sql = " UPDATE supplies SET completed = ? WHERE id = ? ";
        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setBoolean(1, request.isCompleted());
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        }
    }

    public List<OfficeSupply> getSupplyDemands() throws SQLException {
        String sql = "SELECT id, department, supplies, quantity_pcs_pckgs, quantity_unit_price," +
                " value_RON, delivery_date, completed FROM supplies ";

        List<OfficeSupply> officeSupplies = new ArrayList<>();
        try(Statement statement = DatabaseConfiguration.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                OfficeSupply officeSupply = new OfficeSupply();
                officeSupply.setId(resultSet.getLong("id"));
                officeSupply.setDepartment(resultSet.getString("department"));
                officeSupply.setSupplyName(resultSet.getString("supplies"));
                officeSupply.setQuantityPcsPckgs(resultSet.getDouble("quantity_pcs_pckgs"));
                officeSupply.setSupplyUnitPrice(resultSet.getDouble("quantity_unit_price"));
                officeSupply.setValueRON(resultSet.getDouble("value_RON"));
                officeSupply.setDeliveryDate(resultSet.getDate("delivery_date").toLocalDate());
                officeSupply.setCompleted(resultSet.getBoolean("completed"));

                officeSupplies.add(officeSupply);
            }
        }
        return officeSupplies;
    }
}
