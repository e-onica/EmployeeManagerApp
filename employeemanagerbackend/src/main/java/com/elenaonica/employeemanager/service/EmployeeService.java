package com.elenaonica.employeemanager.service;

import com.elenaonica.employeemanager.exception.UserNotFoundException;
import com.elenaonica.employeemanager.model.Employee;
import com.elenaonica.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id:" + id + "was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
