/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.DTO;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 *
 * @author Never
 */
@Schema( enumAsRef = true, description = "Color: \n" +
        "* `YELLOW` - Yellow\n" +
        "* `ORANGE` - Orange\n" +
        "* `WHITE` - White\n" +
        "* `BROWN` - Brown\n" +
        "")
public enum Color {
    YELLOW,
    ORANGE,
    WHITE,
    BROWN;
}
