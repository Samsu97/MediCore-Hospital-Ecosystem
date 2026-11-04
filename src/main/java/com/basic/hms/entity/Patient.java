package com.basic.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Age is mandatory.")
    @Column(nullable = false)
    private Integer age;

    @NotBlank(message = "Email is Required.")
    @Email(message = "Invalid email.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Please provide Gender.")
    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Bill> bills;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments;

}

