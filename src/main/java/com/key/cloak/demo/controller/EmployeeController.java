package com.key.cloak.demo.controller;

import com.key.cloak.demo.model.Employee;
import com.key.cloak.demo.repository.EmployeeRepository;
import com.key.cloak.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        Employee employee = employeeService.getEmployee(id);

        return ResponseEntity.status(HttpStatus.OK).body(employee);

    }

    @GetMapping("/admin")
    public ResponseEntity<List<Employee>> getEmployee(){
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
    }
}
