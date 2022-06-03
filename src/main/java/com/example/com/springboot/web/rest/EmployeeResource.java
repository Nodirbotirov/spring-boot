package com.example.com.springboot.web.rest;

import com.example.com.springboot.domian.Employee;
import com.example.com.springboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService service;

    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public ResponseEntity add(@RequestBody Employee employee){
        Employee employee1 = service.add(employee);
        return ResponseEntity.ok(employee1);
    }

    @GetMapping("/employees")
    public ResponseEntity getAll(){
        List<Employee> employeeList = service.all();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/employees{name}")
    public  ResponseEntity findByName(@PathVariable String name){
        List<Employee> employeeList = service.findByName(name);
        return ResponseEntity.ok(employeeList);
    }
}
