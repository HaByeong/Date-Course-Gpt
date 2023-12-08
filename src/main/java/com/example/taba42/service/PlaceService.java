package com.example.taba42.service;

import com.example.taba42.domain.Place;
import com.example.taba42.exception.PlaceException;
import com.example.taba42.repository.PlaceRepository;
import com.example.taba42.responsedto.PlaceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public PlaceResponse placeInfo(Long PlaceId) {
        Place place = getPlaceById(PlaceId);
        return PlaceResponse.from(place);
    }

    private Place getPlaceById(Long placeId) {
        System.out.println(placeId);
        return placeRepository.findById(placeId).orElseThrow(
                () -> new PlaceException("장소 관련 정보가 존재하지 않습니다.")
        );
    }
}