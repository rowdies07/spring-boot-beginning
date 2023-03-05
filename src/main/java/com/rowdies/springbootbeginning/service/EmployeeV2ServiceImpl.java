package com.rowdies.springbootbeginning.service;

import com.rowdies.springbootbeginning.entity.EmployeeEntity;
import com.rowdies.springbootbeginning.model.Employee;
import com.rowdies.springbootbeginning.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null ||
                employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> empList =  employeeRepository.findAll();
        List<Employee> employees =
                empList
                        .stream()
                        .map(empEntity -> {
                            Employee employee = new Employee();
                            BeanUtils.copyProperties(empEntity, employee);
                            return employee;
                        })
                        .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        Employee employee = new Employee();
        BeanUtils.copyProperties(entity.get(), employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee with id : " + id + "is deleted";
    }
}
