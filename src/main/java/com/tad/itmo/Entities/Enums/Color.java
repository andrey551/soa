/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.Entities.Enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Never
 */
@Schema(enumAsRef = true, description = "Color: \n" +
        "* `GREEN` - Green\n" +
        "* `RED` - Red\n" +
        "* `BLACK` - Black\n" +
        "* `BLUE` - Blue\n" +
        "")
public enum Color {
    GREEN,
    RED,
    BLACK,
    BLUE;
}
