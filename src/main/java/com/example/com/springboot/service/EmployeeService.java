package com.example.com.springboot.service;

import com.example.com.springboot.domian.Employee;
import com.example.com.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee add(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> all(){
        return repository.findAll();
    }

    public Employee findById(Long id){
        return repository.findById(id).get();
    }

    public List<Employee> findByName(String name){
        return repository.findByName(name);
    }
}
