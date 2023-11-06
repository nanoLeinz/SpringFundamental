package id.nano.employeemanagement.service;

import id.nano.employeemanagement.entity.Rekening;

import java.util.Map;

public interface RekeningService {
    //
    Map save(Rekening request);

    Map update(Rekening request);

    Map delete(Rekening request);
}
