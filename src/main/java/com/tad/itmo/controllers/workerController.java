/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.controllers;
import com.tad.itmo.DTO.Worker;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Never
 */
@RestController
@RequestMapping("/workers")
public class workerController {
    @PutMapping(consumes = "application/xml")
    @ResponseBody
    public ResponseEntity signUp(@RequestBody @Valid
                                Worker request) {
        return new ResponseEntity(HttpStatusCode.valueOf(400));
    }
}
