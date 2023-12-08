package com.example.taba42.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "places")
@Entity
public class Place {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //@Column(name="aaa")
    private String placeType;

    //@Column(name="aaab")
    private String placeName;

    //@Column(name="aaac")
    private Long price;

    //@Column(name="aaad")
    private String location;

    //@Column(name="aaads")
    private String openTime;

    //@Column(name="aaaass")
    private Float rating;

    public Place() {
    }

    public Place(String placeType, String placeName, Long price, String location, String openTime, Float rating) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.price = price;
        this.location = location;
        this.openTime = openTime;
        this.rating = rating;
    }
}
