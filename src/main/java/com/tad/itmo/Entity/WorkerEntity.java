/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.Entity;

import com.tad.itmo.DTO.Coordinates;
import com.tad.itmo.DTO.Enums.Status;
import com.tad.itmo.DTO.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Never
 */
public class WorkerEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    @Column(name = "name")
    private String name; 
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "coordinates_id", referencedColumnName = "id", nullable = false)
    private CoordinateEntity coordinates; 
    
    @Column(name = "creationDate")
    private java.time.ZonedDateTime creationDate; 
    
    @Column(name = "salary")
    private float salary; 
    
    @Column(name = "startDate")
    private java.util.Date startDate; 
    
    @Column(name = "endDate")
    private java.util.Date endDate;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status; 
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person; 
}
