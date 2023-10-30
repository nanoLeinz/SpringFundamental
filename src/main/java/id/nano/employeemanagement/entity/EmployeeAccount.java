package id.nano.employeemanagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "rekening")
@Where(clause = "deleted_date is null")
public class EmployeeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis")
    private String jenis;

    @Column(length = 100)
    private String rekening;

    @ManyToOne
    @JoinColumn(name = "id_karyawan")
    private Employee employee;
}
