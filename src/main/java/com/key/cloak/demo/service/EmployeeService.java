package com.key.cloak.demo.service;

import com.key.cloak.demo.model.Employee;
import com.key.cloak.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initializeEmployeeTable(){
        employeeRepository.saveAll(
            Stream.of(
                    new Employee("sahil","IT"),
                    new Employee("saurabh","MECH"),
                    new Employee("aniket","COMMERECE")
            ).collect(Collectors.toList()));
    }

    public Employee getEmployee(Integer id){
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> all = employeeRepository.findAll();
        return all;
    }
}
