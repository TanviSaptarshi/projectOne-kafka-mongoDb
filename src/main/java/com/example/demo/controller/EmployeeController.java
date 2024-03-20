// EmployeeController.java
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
        kafkaProducerService.sendMessage(employee);
        return "Employee data sent to Kafka topic successfully.";
    }
}
