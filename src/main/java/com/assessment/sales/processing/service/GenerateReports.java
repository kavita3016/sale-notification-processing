package com.assessment.sales.processing.service;

import com.assessment.sales.processing.model.SalesNotificationMessage;


import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GenerateReports {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final Logger LOGGER = Logger.getLogger( GenerateReports.class.getName() );

    public static void generateSalesReport(List<SalesNotificationMessage> salesList){


        LOGGER.info("******************** Sales Report ********************");
        LOGGER.info(String.format("%-20s %-20s%-20s","Product","Quantity","Value"));
        //LOGGER.info("|Product           | Quantity           | Value            |");
        LOGGER.info("-----------------------------------------------------");
        salesList.stream().collect(Collectors.groupingBy(SalesNotificationMessage :: getProduct)).entrySet()
                .forEach(x -> LOGGER.info("" +x.getKey()
                        + "                "
                        + x.getValue().stream().filter(o -> o.getQuantity() > 0).mapToInt(SalesNotificationMessage::getQuantity).sum()
                        + "                "
                        + df.format( x.getValue().stream().filter(o -> o.getPrice() > 0).mapToDouble(y -> y.getPrice() * y.getQuantity()).sum())

                ) );
        LOGGER.info("--------------------------------------------------------\n\n\n\n");

    }

    public static void generateAdjustmentReport(List<SalesNotificationMessage> salesList){

        LOGGER.warning("!!! Important !!! ");
        LOGGER.warning("Application is pausing to generate Sales Adjustment report and no sales messages will be processed until report generation is completed..\n\n\n");
        LOGGER.info("*********************** Sales Adjustment Report ***********************");
        LOGGER.info(String.format("%-20s %-20s%-20s","Product","Operation","AdjustmentValue"));

        LOGGER.info("-----------------------------------------------------------");
        salesList.stream().collect(Collectors.groupingBy(SalesNotificationMessage :: getProduct)).entrySet()
                .forEach(x -> {LOGGER.info("" +x.getKey());
                    x.getValue().forEach(y-> LOGGER.info("                     " + y.getAdjustmentOperation() + "                 " + df.format(y.getAdjustmentPrice())));

                });
        LOGGER.info("------------------------------------------------------\n\n\n\n");
        LOGGER.info("Sales Adjustment Report generation completed.. Sales messages will be processed now!!");

    }
}
