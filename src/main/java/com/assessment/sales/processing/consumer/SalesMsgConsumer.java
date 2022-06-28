package com.assessment.sales.processing.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.assessment.sales.processing.constants.ApplicationConstants;
import com.assessment.sales.processing.constants.ErrorCodeMapping;
import com.assessment.sales.processing.exception.SalesNotificationException;
import com.assessment.sales.processing.model.SalesNotificationMessage;
import com.assessment.sales.processing.repository.SalesNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
public class SalesMsgConsumer {
    private static final Logger LOGGER = Logger.getLogger( SalesMsgConsumer.class.getName() );


    @Autowired
    private SalesNotificationRepository salesNotificationService;

    @KafkaListener(topics = ApplicationConstants.TOPIC_NAME, groupId = ApplicationConstants.GROUP_ID)
    public void receiveNotification(String salesMsg){


    ObjectMapper object = new ObjectMapper();
    SalesNotificationMessage sales = null;
    try {
        sales = object.readValue(salesMsg, SalesNotificationMessage.class);
    } catch (
    JsonProcessingException e) {
        throw new SalesNotificationException(ErrorCodeMapping.SNP_EXCEPTION_003.getValue());
    }
        salesNotificationService.processSalesMessage(sales);
    }
}
