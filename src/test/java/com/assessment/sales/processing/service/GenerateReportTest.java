package com.assessment.sales.processing.service;

import com.assessment.sales.processing.model.SalesNotificationMessage;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;


public class GenerateReportTest {

    List<SalesNotificationMessage> totalSales = new ArrayList<>();

    @Test
    public void testGenerateReport_whenSalesReportThenPrintReport(){
        SalesNotificationMessage salesNotificationMessage1 = new SalesNotificationMessage();
        salesNotificationMessage1.setPrice(12.5);
        salesNotificationMessage1.setProduct("Apple");
        salesNotificationMessage1.setQuantity(1);

        SalesNotificationMessage salesNotificationMessage2 = new SalesNotificationMessage();
        salesNotificationMessage2.setPrice(5.0);
        salesNotificationMessage2.setProduct("Banana");
        salesNotificationMessage2.setQuantity(1);
        totalSales.add(salesNotificationMessage1);
        totalSales.add(salesNotificationMessage2);

        GenerateReports.generateSalesReport(totalSales);


    }

    @Test
    public void testGenerateReport_whenAdjustmentReportThenPrintReport(){
        SalesNotificationMessage salesNotificationMessage1 = new SalesNotificationMessage();
        salesNotificationMessage1.setAdjustmentPrice(12.5);
        salesNotificationMessage1.setProduct("Apple");
        salesNotificationMessage1.setAdjustmentOperation("ADD");

        SalesNotificationMessage salesNotificationMessage2 = new SalesNotificationMessage();
        salesNotificationMessage2.setAdjustmentPrice(5.0);
        salesNotificationMessage2.setProduct("Banana");
        salesNotificationMessage2.setAdjustmentOperation("MULTIPLY");
        totalSales.add(salesNotificationMessage1);
        totalSales.add(salesNotificationMessage2);

        GenerateReports.generateAdjustmentReport(totalSales);


    }
}

