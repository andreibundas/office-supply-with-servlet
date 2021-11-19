package org.fasttrackit.transfer;

import java.time.LocalDate;

// DTO (Data Transfer Object)
public class CreateSupplyRequest {

    private String department;
    private String supplyName;
    private double quantityPcsPckgs;
    private double supplyUnitPrice;
    private double valueRON;
    private LocalDate deliveryDate;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public double getQuantityPcsPckgs() {
        return quantityPcsPckgs;
    }

    public void setQuantityPcsPckgs(double quantityPcsPckgs) {
        this.quantityPcsPckgs = quantityPcsPckgs;
    }

    public double getSupplyUnitPrice() {
        return supplyUnitPrice;
    }

    public void setSupplyUnitPrice(double supplyUnitPrice) {
        this.supplyUnitPrice = supplyUnitPrice;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getValueRON() {
        return valueRON;
    }

    public void setValueRON(double valueRON) {
        this.valueRON = valueRON;
    }

    @Override
    public String toString() {
        return "CreateSupplyRequest{" +
                "department='" + department + '\'' +
                ", supplyName='" + supplyName + '\'' +
                ", quantityPcsPckgs=" + quantityPcsPckgs +
                ", supplyUnitPrice=" + supplyUnitPrice +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
