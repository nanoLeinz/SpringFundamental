package id.nano.employeemanagement.service.impl;

import id.nano.employeemanagement.Config;
import id.nano.employeemanagement.entity.Employee;
import id.nano.employeemanagement.entity.Rekening;
import id.nano.employeemanagement.repository.EmployeeRepository;
import id.nano.employeemanagement.repository.RekeningRepository;
import id.nano.employeemanagement.service.RekeningService;
import id.nano.employeemanagement.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class RekeningImpl implements RekeningService {

    @Autowired
    public Response response;

    @Autowired
    public RekeningRepository rekeningRepository;

    @Autowired
    public EmployeeRepository employeeRepository;
    @Override
    public Map save(Rekening request) {
        try {
            log.info("save rekening");
             /*
        validasi langsung
        lagnsung save
         */
            if(request.getNama().isEmpty()){
                return response.Error(Config.NAME_REQUIRED);
            }
            if(request.getEmployee() ==null && request.getEmployee().getId() == null){
                return response.Error(Config.EMPLOYEE_REQUIRED);
            }
            Optional<Employee> chekDataDB = employeeRepository.findById(request.getEmployee().getId());
            if(chekDataDB.isEmpty()){
                return response.Error(Config.EMPLOYEE_NOT_FOUND);
            }

            request.setEmployee(chekDataDB.get());

            return response.sukses(rekeningRepository.save(request));
        }catch (Exception e){
            log.error("save rekening eror: "+e.getMessage());
            return response.Error("Save Rekening ="+e.getMessage());
        }

    }

    @Override
    public Map update(Rekening request) {
        try {
            log.info("Update rekening");
            if(request.getId() ==null ){
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Rekening> chekDataDBRekening = rekeningRepository.findById(request.getId());
            if(chekDataDBRekening.isEmpty()){
                return response.Error(Config.REKENING_NOT_FOUND);
            }

            if(request.getEmployee() ==null && request.getEmployee().getId() == null){
                return response.Error(Config.EMPLOYEE_REQUIRED);
            }
            Optional<Employee> chekDataDB = employeeRepository.findById(request.getEmployee().getId());
            if(chekDataDB.isEmpty()){
                return response.Error(Config.EMPLOYEE_NOT_FOUND);
            }

            // apa yang ingin kalian update
            chekDataDBRekening.get().setRekening(request.getRekening());
            chekDataDBRekening.get().setEmployee(chekDataDB.get());
            chekDataDBRekening.get().setJenis(request.getJenis());

            // do save , balikin responya

            return response.sukses(rekeningRepository.save(chekDataDBRekening.get()));
        }catch (Exception e){
            log.error("Update rekening eror: "+e.getMessage());
            return response.Error("Update Rekening ="+e.getMessage());
        }
    }

    @Override
    public Map delete(Rekening request) {
        try {
            log.info("Delete rekening");
            if(request.getId() ==null ){
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Rekening> chekDataDBRekening = rekeningRepository.findById(request.getId());
            if(chekDataDBRekening.isEmpty()){
                return response.Error(Config.REKENING_NOT_FOUND);
            }
            // apa yang ingin kalian update
            chekDataDBRekening.get().setDeleted_date(new Date());
            // do save , balikin responya
            return response.sukses(Config.SUCCESS);
        }catch (Exception e){
            log.error("Delete rekening eror: "+e.getMessage());
            return response.Error("Delete Rekening ="+e.getMessage());
        }
    }
}
