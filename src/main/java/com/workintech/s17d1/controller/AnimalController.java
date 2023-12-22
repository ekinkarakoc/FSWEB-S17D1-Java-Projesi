package com.workintech.s17d1.controller;

import com.workintech.s17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll() {
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
    }
    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals() {
        System.out.println("animals triggered");
        return new ArrayList<>(this.animals.values());
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id) {
        return this.animals.get(id);
    }

    @PostMapping("/workintech/animal")
    public void addAnimal(@RequestBody Animal animal) {
        this.animals.put(animal.getId(), animal);
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(
            @PathVariable("id") Integer existingRecordId, @RequestBody Animal animal) {
        this.animals.replace(existingRecordId, animal);
        return this.animals.get(existingRecordId);
    }

    @DeleteMapping("/workintech/animal/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id) {
        this.animals.remove(id);
    }

}
