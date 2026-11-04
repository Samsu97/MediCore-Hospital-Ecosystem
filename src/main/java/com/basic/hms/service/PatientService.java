package com.basic.hms.service;

import com.basic.hms.entity.Patient;
import com.basic.hms.exception.ResourceNotFoundException;
import com.basic.hms.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    // Constructor Injection
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //Create
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    //Read - Get all
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    //Read - Get by id
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
    }

    //Update by id
    public Patient updatePatient(Long id, Patient patient) {

        Patient existingPatient = getPatientById(id);

        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setEmail((patient.getEmail()));
        existingPatient.setGender(patient.getGender());

        return patientRepository.save(existingPatient);
    }

    //Delete by id
    public void deletePatient(Long id) {
        Patient existingPatient = getPatientById(id);
        patientRepository.delete(existingPatient);
    }
}