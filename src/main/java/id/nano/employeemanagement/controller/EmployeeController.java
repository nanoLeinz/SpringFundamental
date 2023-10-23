package id.nano.employeemanagement.controller;

import id.nano.employeemanagement.entity.Employee;
import id.nano.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping(value = {"/insert", "/insert/"})
    public ResponseEntity<Map> save(@RequestBody Employee request) {
        return new ResponseEntity<Map>(employeeService.insert(request), HttpStatus.OK);
    }

    @PutMapping(value = {"/update", "/update/"})
    public ResponseEntity<Map> update(@RequestBody Employee request) {
        return new ResponseEntity<Map>(employeeService.update(request), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete", "/delete/"})
    public ResponseEntity<Map> delete(@RequestBody Employee request) {
        return new ResponseEntity<Map>(employeeService.delete(request.getId()), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Map> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<Map>(employeeService.delete(id), HttpStatus.OK);
    }

}

