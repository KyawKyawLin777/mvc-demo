package com.example.mvcdemo.dao;

import com.example.mvcdemo.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
