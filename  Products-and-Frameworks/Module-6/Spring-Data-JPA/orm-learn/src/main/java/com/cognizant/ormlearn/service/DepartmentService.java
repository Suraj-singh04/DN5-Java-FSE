package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Transactional
    public List<Department> getDepartments() {
        return repository.findAll();
    }
}