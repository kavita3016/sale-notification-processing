package com.assessment.sales.processing.model;


import java.math.BigDecimal;

public class SalesNotificationMessage {


    private String product;
    private Integer quantity;
    private Double price;
    private String adjustmentOperation;
    private Double adjustmentPrice;

    public SalesNotificationMessage(String product, Integer quantity, Double price, String adjustmentOperation, Double adjustmentPrice) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.adjustmentOperation = adjustmentOperation;
        this.adjustmentPrice = adjustmentPrice;
    }

    public SalesNotificationMessage() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAdjustmentOperation() {
        return adjustmentOperation;
    }

    public void setAdjustmentOperation(String adjustmentOperation) {
        this.adjustmentOperation = adjustmentOperation;
    }

    public Double getAdjustmentPrice() {
        return adjustmentPrice;
    }

    public void setAdjustmentPrice(Double adjustmentPrice) {
        this.adjustmentPrice = adjustmentPrice;
    }
}
