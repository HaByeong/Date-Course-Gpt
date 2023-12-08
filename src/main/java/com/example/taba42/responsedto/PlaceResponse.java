package com.example.taba42.responsedto;

import com.example.taba42.domain.Place;
import lombok.Getter;

@Getter
public class PlaceResponse {

    private String placeType;

    private String placeName;

    private Long price;

    private String location;

    private String openTime;

    private Float rating;

    public PlaceResponse(String placeType, String placeName, Long price, String location, String openTime, Float rating) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.price = price;
        this.location = location;
        this.openTime = openTime;
        this.rating = rating;
    }

    public static PlaceResponse from(Place place) {
        return new PlaceResponse(
                place.getPlaceType(),
                place.getPlaceName(),
                place.getPrice(),
                place.getLocation(),
                place.getOpenTime(),
                place.getRating()
        );
    }
}
