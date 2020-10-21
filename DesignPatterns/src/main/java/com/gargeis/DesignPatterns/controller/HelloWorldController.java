package com.gargeis.DesignPatterns.controller;

import com.gargeis.DesignPatterns.model.dto.AnimalDTO;
import com.gargeis.DesignPatterns.model.dto.Caracteristica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/HelloWorld") //endereco url mapear
@RestController //controlador + assoc.
public class HelloWorldController {

    @GetMapping
    public String retornar() {
        return "Hello World ";
    }

    @GetMapping("/somar")
    public Integer somar(@RequestParam(name = "numero1") Integer num1, @RequestParam(name = "numero2") Integer num2) {
        return num1 + num2;
    }

    @GetMapping("/animais")
    public ResponseEntity<AnimalDTO> buscarAnimal(@RequestParam String nome) {
        return ResponseEntity.ok(new AnimalDTO(nome, 24, new Caracteristica("Cachorro", "mamif")));
    }

    @GetMapping("/animais/{nome}")
    public String mostrarNome(@PathVariable String nome) {
        return nome;
    }

    @GetMapping("/somarPath/{num2}/{num1}")
    public Integer somarPath(@PathVariable Integer num1, @PathVariable Integer num2) {
        return num2 + num1;
    }
}