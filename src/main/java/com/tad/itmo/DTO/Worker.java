/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.DTO;

import com.tad.itmo.DTO.Enums.Status;
//import jakarta.persistence.Entity;
import lombok.*;

/**
 *
 * @author Never
 */
@Data
@AllArgsConstructor
public class Worker {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    private java.util.Date startDate; //Поле не может быть null
    private java.util.Date endDate; //Поле может быть null
    private Status status; //Поле не может быть null
    private Person person; //Поле может быть null
}
