package id.nano.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Data
@Entity
@Table(name = "detail_karyawan")
@Where(clause = "deleted_date is null")
public class DetailEmployee extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @NotBlank(message = "NIK harus diisi")
    @Column(name = "nik")
    private String nik;

//    @NotBlank(message = "NPWP harus diisi")
    @Column(length = 15)
    private String npwp;
}
