/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.DTO;

import com.tad.itmo.DTO.Enums.Color;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author Never
 */

@Data
@AllArgsConstructor
public class Person {
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    private com.tad.itmo.DTO.Enums.Color eyeColor; //Поле может быть null
    private com.tad.itmo.DTO.Color hairColor; //Поле может быть null
}
