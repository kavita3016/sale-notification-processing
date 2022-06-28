package com.assessment.sales.processing.repository;

import com.assessment.sales.processing.model.SalesNotificationMessage;

import com.assessment.sales.processing.repository.impl.SalesNotificationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;




public class SalesNotificationProcessRepoTest {


        private SalesNotificationRepository salesNotificationRepository = new SalesNotificationRepositoryImpl();

        @Test
        public void testSalesNotificationRepo_whenAdjustOprIsNotPresentThenPersistMsg(){
            SalesNotificationMessage salesNotificationMessage = new SalesNotificationMessage();
            salesNotificationMessage.setPrice(12.5);
            salesNotificationMessage.setProduct("Apple");
            salesNotificationMessage.setQuantity(1);
            salesNotificationRepository.saveNotificationMsg(salesNotificationMessage);
            Assert.assertTrue(salesNotificationRepository.getTotalSalesMessages().get(0).getPrice().equals(12.5));
            Assert.assertTrue(salesNotificationRepository.getTotalSalesMessages().get(0).getProduct().equals("Apple"));
            Assert.assertTrue(salesNotificationRepository.getTotalSalesMessages().get(0).getQuantity().equals(1));
            salesNotificationRepository.saveTotalSales(salesNotificationMessage);
            Assert.assertTrue(salesNotificationRepository.getTotalSales().get(0).getPrice().equals(12.5));
            Assert.assertTrue(salesNotificationRepository.getTotalSales().get(0).getProduct().equals("Apple"));
            Assert.assertTrue(salesNotificationRepository.getTotalSales().get(0).getQuantity().equals(1));

    }

    @Test
    public void testSalesNotificationRepo_whenAdjustOprIsPresentThenPersistMsg(){
        SalesNotificationMessage salesNotificationMessage = new SalesNotificationMessage();
        salesNotificationMessage.setAdjustmentPrice(20.0);
        salesNotificationMessage.setProduct("Apple");
        salesNotificationMessage.setAdjustmentOperation("ADD");
        salesNotificationRepository.saveTotalOperations(salesNotificationMessage);

        Assert.assertTrue(salesNotificationRepository.getTotalOperations().get(0).getAdjustmentPrice().equals(20.0));
        Assert.assertTrue(salesNotificationRepository.getTotalOperations().get(0).getProduct().equals("Apple"));
        Assert.assertTrue(salesNotificationRepository.getTotalOperations().get(0).getAdjustmentOperation().equals("ADD"));

        salesNotificationRepository.performSalesOperation(salesNotificationMessage);
        if(salesNotificationRepository.getTotalSales().size()!=0) {
            Assert.assertTrue(salesNotificationRepository.getTotalSales().get(0).getPrice().equals(32.5));
            Assert.assertTrue(salesNotificationRepository.getTotalSales().get(0).getProduct().equals("Apple"));
            Assert.assertTrue(salesNotificationRepository.getTotalSales().get(0).getQuantity().equals(1));
        }

    }


}
