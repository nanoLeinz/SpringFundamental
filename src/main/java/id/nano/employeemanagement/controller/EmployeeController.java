package id.nano.employeemanagement.controller;

import id.nano.employeemanagement.entity.Employee;
import id.nano.employeemanagement.repository.EmployeeRepository;
import id.nano.employeemanagement.service.EmployeeService;
import id.nano.employeemanagement.utils.SimpleStringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();

    @Autowired
    public EmployeeRepository employeeRepository;

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

    @GetMapping(value = {"/list-spec", "/list-spec/"})
    public ResponseEntity<Map> listQuizHeaderSpec(
            @RequestParam() Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String orderby,
            @RequestParam(required = false) String ordertype) {

        Pageable show_data = simpleStringUtils.getShort(orderby, ordertype, page, size);

        Specification<Employee> spec =
                ((root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    if (name != null && !name.isEmpty()) {
                        //      select  * from employee e where name like '%a%' ;
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
                    }
                    if (address != null && !address.isEmpty()) {
                        // equal == select  * from employee e where  address ='jakarta'
                        predicates.add(criteriaBuilder.equal(root.get("address"), address));
                    }
                    if (status != null && !status.isEmpty()) {
                        // equal == select  * from employee e where  address ='jakarta'
                        predicates.add(criteriaBuilder.equal(root.get("status"), status));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                });

        //        PageRequest pageRequest = PageRequest.of(page,size);
        Page<Employee> list = employeeRepository.findAll(spec, show_data);

        Map map = new HashMap();
        map.put("data",list);
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = {"/default-jpa", "/default-jpa/"})
    public ResponseEntity<?> defaultJPA() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

}

