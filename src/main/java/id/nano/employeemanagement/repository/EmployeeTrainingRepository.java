package id.nano.employeemanagement.repository;

import id.nano.employeemanagement.entity.KaryawanTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    public interface EmployeeTrainingRepository extends JpaRepository<KaryawanTraining, Long>, JpaSpecificationExecutor<KaryawanTraining> {

    @Query(value = "select c from KaryawanTraining c WHERE c.id = :id", nativeQuery = false)
    public KaryawanTraining getById(@Param("id") Long id);
}
