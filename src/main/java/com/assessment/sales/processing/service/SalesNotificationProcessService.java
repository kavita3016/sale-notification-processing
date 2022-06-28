package com.assessment.sales.processing.service;

import com.assessment.sales.processing.model.SalesNotificationMessage;


public interface SalesNotificationProcessService {
    void processSalesMessage(SalesNotificationMessage salesMsg);
}
