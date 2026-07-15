package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public double getAverageSalary(int id){
        return repository.getAverageSalary(id);
    }

    public List<Employee> getAllEmployeesNative() {
        return repository.getAllEmployeesNative();
    }

}