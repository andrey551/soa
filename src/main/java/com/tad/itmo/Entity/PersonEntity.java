/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 *
 * @author Never
 */
@Entity
public class PersonEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "weight")
    private double weight; 
    
    @Column(name = "passportID")
    private String passportID; 
    
    @Column(name = "eyeColor")
    @Enumerated(EnumType.STRING)
    private com.tad.itmo.DTO.Enums.Color eyeColor; 
    
    @Column(name = "hairColor")
    @Enumerated(EnumType.STRING)
    private com.tad.itmo.DTO.Color hairColor; 
}
