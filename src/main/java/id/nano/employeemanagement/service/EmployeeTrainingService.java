package id.nano.employeemanagement.service;

import id.nano.employeemanagement.entity.KaryawanTraining;

import java.util.Map;

public interface EmployeeTrainingService {
    //
    Map save(KaryawanTraining request);

    Map update(KaryawanTraining request);

    Map delete(KaryawanTraining request);
}
