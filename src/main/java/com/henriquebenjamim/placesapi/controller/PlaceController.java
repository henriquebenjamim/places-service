package com.henriquebenjamim.placesapi.controller;

import com.henriquebenjamim.placesapi.models.Place;
import com.henriquebenjamim.placesapi.services.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public Place create(@RequestBody @Valid Place place) {
        return placeService.create(place);
    }

    @GetMapping
    public List<Place> getAll() {
        return placeService.list();
    }

    @PutMapping("{id}")
    public Place update(@PathVariable Long id, @RequestBody Place place) {
        return placeService.update(place);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long placeId) {
        placeService.delete(placeId);
    }
}
