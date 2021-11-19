package org.fasttrackit.domain;

import java.time.LocalDate;

public class OfficeSupply {

    private long id;
    private String department;
    private String supplyName;
    private double quantityPcsPckgs;
    private double supplyUnitPrice;
    private double valueRON;
    private LocalDate deliveryDate;
    private boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getValueRON() {
        return valueRON;
    }

    public void setValueRON(double valueRON) {
        this.valueRON = valueRON;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "OfficeSupply{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", supplyName='" + supplyName + '\'' +
                ", quantityPcsPckgs=" + quantityPcsPckgs +
                ", supplyUnitPrice=" + supplyUnitPrice +
                ", valueRON=" + valueRON +
                ", deliveryDate=" + deliveryDate +
                ", completed=" + completed +
                '}';
    }
}
