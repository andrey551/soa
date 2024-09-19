/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.DTO.Enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Never
 */
@Schema(enumAsRef = true, description = "Status: \n" +
        "* `FIRED` - Fired\n" +
        "* `HIRED` - Hired\n" +
        "* `RECOMMENDED_FOR_PROMOTION` - Recommended for promotion\n" +
        "* `REGULAR` - Regular\n" +
        "* `PROBATION` - BProbation\n" +
        "")
public enum Status {
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION,
    REGULAR,
    PROBATION;
}
