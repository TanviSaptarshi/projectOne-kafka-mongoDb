package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    EmployeeRepository employeeRepository;

    @KafkaListener(topics = "employee-topic", groupId = "employee-group")
    public void consume(Employee employee) {
        // Swap first name and last name
        String temp = employee.getFirstName();
        employee.setFirstName(employee.getLastName());
        employee.setLastName(temp);

        employeeRepository.save(employee);
    }
}

