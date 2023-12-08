package com.example.taba42.controller;

import com.example.taba42.responsedto.PlaceResponse;
import com.example.taba42.service.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService PlaceService;

    public PlaceController(PlaceService PlaceService) {
        this.PlaceService = PlaceService;
    }

    @GetMapping("{placeId}")
    ResponseEntity<PlaceResponse> placeInfo(@PathVariable Long placeId) {
        PlaceResponse PlaceResponse = PlaceService.placeInfo(placeId);
        return ResponseEntity.ok().body(PlaceResponse);
    }
}