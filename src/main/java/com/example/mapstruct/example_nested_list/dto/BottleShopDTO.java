package com.example.mapstruct.example_nested_list.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class BottleShopDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class BottleShopInfo {
        private String name;
        private String address;
        private String phoneNumber;

        private List<BeerDTO> beers;
        private List<WhiskyDTO> whiskies;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class BeerDTO {
        private String beerName;
        private float strength;
        private int ml;
        private LocalDate dateOfManufacture;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class WhiskyDTO{
        private String whiskyName;
        private float strength;
        private int ml;
        private LocalDate dateOfManufacture;
    }

}
