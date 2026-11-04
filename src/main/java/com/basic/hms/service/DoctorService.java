package com.basic.hms.service;

import com.basic.hms.entity.Doctor;
import com.basic.hms.exception.ResourceNotFoundException;
import com.basic.hms.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    //DI
    private final DoctorRepository doctorRepository;

    //Constructor Injection
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    //Create
    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    //Read - Get all
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    //Read - Get by id
    public Doctor getDoctorById(Long id){
        return doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
    }

    //Update by id
    public Doctor updateDoctor(Long id, Doctor doctor){
        Doctor existingDoctor = getDoctorById(id);

        existingDoctor.setName(doctor.getName());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setSpeciality(doctor.getSpeciality());
        existingDoctor.setYearsOfExp(doctor.getYearsOfExp());

        return doctorRepository.save(existingDoctor);
    }

    //Delete by id
    public void deleteDoctor(Long id){
        Doctor existingDoctor = getDoctorById(id);
        doctorRepository.delete(existingDoctor);
    }

}
