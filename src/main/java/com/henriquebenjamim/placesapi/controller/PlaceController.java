package com.henriquebenjamim.placesapi.controller;

import com.henriquebenjamim.placesapi.exceptions.ResourceNotFoundException;
import com.henriquebenjamim.placesapi.models.Place;
import com.henriquebenjamim.placesapi.services.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody @Valid Place place) {
        Place newPlace = placeService.create(place);
        newPlace.setCreatedAt(LocalDateTime.now());
        newPlace.setUpdatedAt(LocalDateTime.now());

        return new ResponseEntity<>(newPlace, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Place> getAll() {
        return placeService.list();
    }

    @PutMapping("{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place placeDetails) {
        Place updatedPlace = placeService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Place not exist with id: " + id));

        updatedPlace.setName(placeDetails.getName());
        updatedPlace.setSlug(placeDetails.getSlug());
        updatedPlace.setCity(placeDetails.getCity());
        updatedPlace.setState(placeDetails.getState());
        updatedPlace.setUpdatedAt(LocalDateTime.now());

        placeService.update(updatedPlace);
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long placeId) {
        placeService.delete(placeId);
    }
}
