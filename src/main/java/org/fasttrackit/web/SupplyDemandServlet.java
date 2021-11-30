package org.fasttrackit.web;

import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.OfficeSupply;
import org.fasttrackit.service.SupplyDemandService;
import org.fasttrackit.transfer.CreateSupplyRequest;
import org.fasttrackit.transfer.UpdateSupplyRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/demands")
public class SupplyDemandServlet extends HttpServlet {

    private SupplyDemandService supplyDemandService = new SupplyDemandService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCorsHeaders(resp);

        CreateSupplyRequest request = ObjectMapperConfiguration.getObjectMapper().readValue(req.getReader(), CreateSupplyRequest.class);

        try {
            supplyDemandService.createSupplyDemand(request);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCorsHeaders(resp);

        try {
            List<OfficeSupply> supplyDemands = supplyDemandService.getSupplyDemands();

            //writing supplyDemands to response as JSON array

            ObjectMapperConfiguration.getObjectMapper().writeValue(resp.getWriter(), supplyDemands);

        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCorsHeaders(resp);

        String idAsString = req.getParameter("id");


        UpdateSupplyRequest updateSupplyRequest = ObjectMapperConfiguration.getObjectMapper()
                .readValue(req.getReader(), UpdateSupplyRequest.class);

        try {
            supplyDemandService.updateSupplyDemand(Long.parseLong(idAsString), updateSupplyRequest);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCorsHeaders(resp);

        String idAsString = req.getParameter("id");
        try {
            supplyDemandService.deleteSupplyDemand(Long.parseLong(idAsString));
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCorsHeaders(resp);
    }

    private void addCorsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "content-type");

    }
}
