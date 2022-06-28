package com.assessment.sales.processing.service.impl;

import com.assessment.sales.processing.constants.ErrorCodeMapping;
import com.assessment.sales.processing.exception.SalesNotificationException;
import com.assessment.sales.processing.model.SalesNotificationMessage;
import com.assessment.sales.processing.repository.SalesNotificationRepository;
import com.assessment.sales.processing.service.GenerateReports;
import com.assessment.sales.processing.service.SalesNotificationProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.logging.Logger;

@Service
public class SalesNotificationProcessServiceImpl implements SalesNotificationProcessService {

    private static final Logger LOGGER = Logger.getLogger( SalesNotificationProcessServiceImpl.class.getName() );
    enum AdjustmentOperation { ADD, MULTIPLY, SUBTRACT}
    @Autowired
    private SalesNotificationRepository salesNotificationRepository;
    @Override
    public void processSalesMessage(SalesNotificationMessage salesMsg) {
        if(salesMsg!=null){

            salesNotificationRepository.saveNotificationMsg(salesMsg);

            if(salesMsg.getAdjustmentOperation()==null){
                salesNotificationRepository.saveTotalSales(salesMsg);

            } else if (Arrays.stream(AdjustmentOperation.values()).anyMatch((t) -> t.name().equals(salesMsg.getAdjustmentOperation().toUpperCase() ))){
                salesNotificationRepository.saveTotalOperations(salesMsg);
                salesNotificationRepository.performSalesOperation(salesMsg);
            }else {
                throw new SalesNotificationException(ErrorCodeMapping.SNP_EXCEPTION_002.getValue());
            }

        }else{
            throw new SalesNotificationException(ErrorCodeMapping.SNP_EXCEPTION_001.getValue());
        }

        if(salesNotificationRepository.getTotalSalesMessages().size()!=0 && salesNotificationRepository.getTotalSalesMessages().size() % 10 == 0)
        {
            GenerateReports.generateSalesReport(salesNotificationRepository.getTotalSales());

        }

        if(salesNotificationRepository.getTotalSalesMessages().size()!=0 && salesNotificationRepository.getTotalSalesMessages().size() % 50 == 0){
                GenerateReports.generateAdjustmentReport(salesNotificationRepository.getTotalOperations());

        }
    }
}
