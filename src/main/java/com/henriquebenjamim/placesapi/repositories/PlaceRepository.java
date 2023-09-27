package com.henriquebenjamim.placesapi.repositories;

import com.henriquebenjamim.placesapi.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
