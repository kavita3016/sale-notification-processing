package com.assessment.sales.processing.consumer;

import com.assessment.sales.processing.service.SalesNotificationProcessService;
import com.assessment.sales.processing.constants.ApplicationConstants;
import com.assessment.sales.processing.model.SalesNotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
public class SalesMsgConsumer {
    private static final Logger LOGGER = Logger.getLogger( SalesMsgConsumer.class.getName() );


    @Autowired
    private SalesNotificationProcessService salesNotificationService;

    @KafkaListener(topics = ApplicationConstants.TOPIC_NAME, groupId = ApplicationConstants.GROUP_ID)
    public void receiveNotification(SalesNotificationMessage salesMsg){
        salesNotificationService.processSalesMessage(salesMsg);
    }
}
