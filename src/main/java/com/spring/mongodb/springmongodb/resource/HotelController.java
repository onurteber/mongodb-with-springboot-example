package com.spring.mongodb.springmongodb.resource;

import com.spring.mongodb.springmongodb.model.Hotel;
import com.spring.mongodb.springmongodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository repository;

    @GetMapping("/all")
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        if (repository.existsById(id))
            return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Hotel hotel) {
        repository.save(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Hotel hotel) {
        repository.save(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
