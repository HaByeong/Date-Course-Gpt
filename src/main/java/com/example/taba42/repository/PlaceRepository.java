package com.example.taba42.repository;

import com.example.taba42.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
