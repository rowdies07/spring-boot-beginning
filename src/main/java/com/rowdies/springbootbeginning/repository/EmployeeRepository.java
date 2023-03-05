package com.rowdies.springbootbeginning.repository;

import com.rowdies.springbootbeginning.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {


}
