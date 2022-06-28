# sale-notification-processing
This is a sales notification processing application, it reads sales notifications from Kafka Topic and processes them.

## Description:

This is a basic spring boot application which processes Sales notification messages and amendments received.

## Reporting:

  After every 10 messages, a Sales report is generated which provides total value and total units sold for every product.  
  This report contains adjusted price value if any amendment/operation is received.  
  
  After every 50 messages, the application will pause to generate Sales amendments reports.  
  This report will provide all operations received for individual products.  
  
  After generating the Sales Operations Report, the application will resume processing sales notification messages.

## Technologies Used:

  Spring Boot 2.7.1  
  Spring Kafka  
  Core Java 1.8

## Installation

  Download Apache kafka if not already present from [here](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz) .  
  Run Zookeeper : Command for windows  bin\windows\zookeeper-server-start.bat config\zookeeper.properties (starts on port 2181 by default)  
  Run Kafka Server :  Command for windows  bin\windows\kafka-server-start.bat config\server.properties (starts on port 9092 by default)  
  Skip above two steps if zookeeper and kafka servers are already running  
  Run the main class SaleNotificationProcessingApplication.java  
  Application will generate Sales and Operations reports after every 10th and 50th message.
