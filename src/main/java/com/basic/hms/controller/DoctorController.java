package com.basic.hms.controller;

import com.basic.hms.entity.Doctor;
import com.basic.hms.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    // Constructor Injection
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Doctor> createDoctor (@Valid @RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
    }

    //Read - Get all
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctor(){
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }


    //Read - Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.getDoctorById(id), HttpStatus.OK);
    }


    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctor), HttpStatus.OK);
    }


    //Delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
