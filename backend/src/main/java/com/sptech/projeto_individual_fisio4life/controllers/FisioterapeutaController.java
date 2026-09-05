package com.sptech.projeto_individual_fisio4life.controllers;

import com.sptech.projeto_individual_fisio4life.entities.Fisioterapeuta;
import com.sptech.projeto_individual_fisio4life.services.FisioterapeutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fisioterapeutas")
@CrossOrigin(origins = "http://127.0.0.1:5500/")

public class FisioterapeutaController {

    @Autowired
    private FisioterapeutaService fisioterapeutaService;

    public FisioterapeutaController(FisioterapeutaService fisioterapeutaService) {
        this.fisioterapeutaService = fisioterapeutaService;
    }

    @GetMapping
    public ResponseEntity<List<Fisioterapeuta>> getAll(){
        return fisioterapeutaService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Fisioterapeuta fisioterapeuta){
        return fisioterapeutaService.create(fisioterapeuta);
    }



}
