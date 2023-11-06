package id.nano.employeemanagement.service;

import id.nano.employeemanagement.entity.Employee;

import java.util.Map;

public interface EmployeeService {
    //
    Map save(Employee employee);

    Map update(Employee employee);

    Map delete(Long employee);

    Map getByID(Long employee);
}
