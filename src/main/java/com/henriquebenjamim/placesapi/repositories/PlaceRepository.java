package com.henriquebenjamim.placesapi.repositories;

import com.henriquebenjamim.placesapi.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findById(Long id);
}
