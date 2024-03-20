// KafkaProducerService.java
package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "employee-topic";

    @Autowired
    KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage(Employee employee) {
        // Swap first name and last name
//        String temp = employee.getFirstName();
//        employee.setFirstName(employee.getLastName());
//        employee.setLastName(temp);

        kafkaTemplate.send(TOPIC, employee);
    }
}
