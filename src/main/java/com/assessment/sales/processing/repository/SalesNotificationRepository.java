package com.assessment.sales.processing.repository;

import com.assessment.sales.processing.model.SalesNotificationMessage;

import java.util.List;

public interface SalesNotificationRepository {
    void saveNotificationMsg(SalesNotificationMessage salesMsg);

    void saveTotalSales(SalesNotificationMessage salesMsg);

    void saveTotalOperations(SalesNotificationMessage salesMsg);

    public List<SalesNotificationMessage> getTotalSalesMessages();
    public List<SalesNotificationMessage> getTotalSales();
    public List<SalesNotificationMessage> getTotalOperations();

    void performSalesOperation(SalesNotificationMessage salesMsg);
}
