package id.nano.employeemanagement.repository;

import id.nano.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    //Query : menggunakan JPAQL
    @Query(value = "select e from Employee e where id = :idEmployee",nativeQuery = false)
    public Object getByIdJPQL(@Param("idEmployee") Long idEmployee);

    //Native Query : menggunakan JPAQL
    @Query(value = "select e from employee e where id = :idEmployee;",nativeQuery = true)
    public Object getByIdNativeQuery(@Param("idEmployee") Long idEmployee);

    long count();

}