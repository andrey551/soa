/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.Entities;

import com.tad.itmo.Entities.Enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Never
 */

@Data
@AllArgsConstructor
class Person {
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле не может быть null
    private com.tad.itmo.Entities.Enums.Color eyeColor; //Поле может быть null
    private com.tad.itmo.Entities.Color hairColor; //Поле может быть null
}
