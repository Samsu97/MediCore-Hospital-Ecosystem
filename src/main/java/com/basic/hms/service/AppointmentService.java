package com.basic.hms.service;

import com.basic.hms.entity.Appointment;
import com.basic.hms.exception.ResourceNotFoundException;
import com.basic.hms.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    //Create
    public Appointment createAppointment(Appointment appointment){
        return  appointmentRepository.save(appointment);
    }

    //Read All
    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    //Read by id
    public Appointment getAppointmentById(Long id){
        return appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
    }

    //Update
    public Appointment updateAppointment(Long id, Appointment appointment){
        Appointment existingAppointment = getAppointmentById(id);

        existingAppointment.setAppointDate(appointment.getAppointDate());
        existingAppointment.setDoctor(appointment.getDoctor());
        existingAppointment.setPatient(appointment.getPatient());

        return appointmentRepository.save(existingAppointment);

    }


    //Delete
    public void deleteAppointment (Long id){
        Appointment existingAppointment = getAppointmentById(id);
        appointmentRepository.delete(existingAppointment);
    }

}
