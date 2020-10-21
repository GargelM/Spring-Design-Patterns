package com.gargeis.DesignPatterns.controller;

import com.gargeis.DesignPatterns.model.Animal;
import com.gargeis.DesignPatterns.repository.AnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public ResponseEntity<List<Animal>> buscarAnimais() {
        return ResponseEntity.ok(animalRepository.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Animal> buscarUmAnimal(@PathVariable Integer codigo) {
        return ResponseEntity.ok(animalRepository.findById(codigo).get());
    }

    @PostMapping
    public ResponseEntity<Animal> cadastrarAnimal(@RequestBody Animal animal) {
        return ResponseEntity.ok(animalRepository.save(animal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizarAnimal(@RequestBody Animal animal, @PathVariable Integer id) {
        Animal animalExistente = animalRepository.findById(id).get();
        BeanUtils.copyProperties(animal, animalExistente, "codigo");
        return ResponseEntity.ok(animalRepository.save(animalExistente));
    }

    @DeleteMapping("/{id}")
    public void removerAnimal(@PathVariable Integer id) {
        animalRepository.deleteById(id);
    }
}
