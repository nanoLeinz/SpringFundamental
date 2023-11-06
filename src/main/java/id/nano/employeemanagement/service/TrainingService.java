package id.nano.employeemanagement.service;

import id.nano.employeemanagement.entity.Training;

import java.util.Map;

public interface TrainingService {
    //
    Map save(Training request);

    Map update(Training request);

    Map delete(Training request);
}
