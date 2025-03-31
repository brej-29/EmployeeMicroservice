package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeMicroserviceApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add dummy data
        repository.save(new Employee("Alice", "HR", 60000));
        repository.save(new Employee("Bob", "Engineering", 75000));
        repository.save(new Employee("Charlie", "Marketing", 50000));
    }
}
