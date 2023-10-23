package id.nano.employeemanagement.service;

import id.nano.employeemanagement.entity.Employee;

import java.util.Map;


public interface EmployeeService {
    public Map insert(Employee employee);

    public Map update(Employee employee);

    public Map delete(Long id);

    public Map getById(Long id);

    public Map getAll(int size, int page);
}
