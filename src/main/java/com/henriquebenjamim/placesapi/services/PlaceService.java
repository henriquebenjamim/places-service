package com.henriquebenjamim.placesapi.services;

import com.henriquebenjamim.placesapi.models.Place;
import com.henriquebenjamim.placesapi.repositories.PlaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    
    @Transactional
    public Place create(Place place) {
        return placeRepository.save(place);
    }

    public List<Place> list() {
        return placeRepository.findAll();
    }

    public Optional<Place> getById(Long id){
        return placeRepository.findById(id);
    }

    public Place update(Place place) {
        return placeRepository.save(place);
    }

    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}
