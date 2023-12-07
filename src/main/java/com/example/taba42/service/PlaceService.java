package com.example.taba42.service;

import com.example.taba42.entity.Place;
import com.example.taba42.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getPlaces() {
        // 모든 Place 객체를 가져옴
        return placeRepository.findAll();
    }

    /*if(!tiberoItems.isEmpty()) return placeRepository.findAll();
    else throw new IllegalArgumentException("no such data");
    }

    public Place getPlaceById(final Long id) {
        return placeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("no such data"));
    }

    public Place createTiberoItem(final Place createTiberoItem) {
        if(createTiberoItem == null) throw new IllegalArgumentException("item cannot be null");
        return placeRepository.save(createTiberoItem);
}

    /*public Place updateTiberoItem(final long id, final Place updateTiberoItem) {
        Place place = getPlaceById(id);
        place.setName(updateTiberoItem.getName());
        place.setSold(updateTiberoItem.isSold());
        return placeRepository.save(place);
    }

    public void deleteTiberoItemById(final Long id) {
        placeRepository.deleteById(id);
    }*/
}