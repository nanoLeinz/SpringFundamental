package id.nano.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "employee")
@Where(clause = "deleted_date is null")
public class Employee extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "address", columnDefinition = "TEXT")
    public String address;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public  String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_detail_karyawan")
    private DetailEmployee detailEmployee;


    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // employee_id
    private List<EmployeeAccount> accounts;
}
