package id.nano.employeemanagement.repository;

import id.nano.employeemanagement.entity.DetailEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    public interface EmployeeDetailRepository extends JpaRepository<DetailEmployee, Long>, JpaSpecificationExecutor<DetailEmployee> {

    @Query(value = "select c from DetailEmployee c WHERE c.id = :id", nativeQuery = false)
    public DetailEmployee getById(@Param("id") Long id);


}
