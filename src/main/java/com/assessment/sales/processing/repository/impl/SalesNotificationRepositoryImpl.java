package com.assessment.sales.processing.repository.impl;

import com.assessment.sales.processing.constants.ErrorCodeMapping;
import com.assessment.sales.processing.exception.SalesNotificationException;
import com.assessment.sales.processing.model.SalesNotificationMessage;
import com.assessment.sales.processing.repository.SalesNotificationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SalesNotificationRepositoryImpl implements SalesNotificationRepository {

    private List<SalesNotificationMessage> totalSalesMessages = new ArrayList<>();
    private List<SalesNotificationMessage> totalSales = new ArrayList<>();
    private List<SalesNotificationMessage> totalOperations = new ArrayList<>();

    @Override
    public void saveNotificationMsg(SalesNotificationMessage salesMsg) {

            totalSalesMessages.add(salesMsg);
    }

    @Override
    public void saveTotalSales(SalesNotificationMessage salesMsg) {

            totalSales.add(salesMsg);
    }

    @Override
    public void saveTotalOperations(SalesNotificationMessage salesMsg) {

            totalOperations.add(salesMsg);

    }

    public List<SalesNotificationMessage> getTotalSalesMessages() {

        return Collections.unmodifiableList(totalSalesMessages);
    }

    public List<SalesNotificationMessage> getTotalSales() {
        return Collections.unmodifiableList(totalSales);
    }

    public List<SalesNotificationMessage> getTotalOperations() {
        return Collections.unmodifiableList(totalOperations);
    }

    @Override
    public void performSalesOperation(SalesNotificationMessage salesMsg) {

        for(int i=0; i< totalSales.size(); i++){

            if(totalSales.get(i).getProduct().equals(salesMsg.getProduct())){

                totalSales.set(i, adjustPrice(salesMsg.getAdjustmentOperation(), salesMsg.getAdjustmentPrice(),totalSales.get(i)));
            }
        }
    }

    public SalesNotificationMessage adjustPrice(String operation, Double adjustPrice, SalesNotificationMessage sales) {
        if("ADD".equals(operation)){
            sales.setPrice(sales.getPrice() + adjustPrice);
        } else if ("SUBTRACT".equals(operation)){
            sales.setPrice(sales.getPrice() - adjustPrice);
        } else if ("MULTIPLY".equals(operation) && adjustPrice!=0.0){
            sales.setPrice(sales.getPrice() * adjustPrice);
        }
        return sales;
    }
}
