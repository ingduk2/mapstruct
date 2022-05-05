package com.example.mapstruct.example_spring;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SoJu {

    private String name;
    private float alcohol;
    private BottleType bottleType;
    private int ml;
    private LocalDate dateOfManufacture;

    @Builder
    public SoJu(String name, float alcohol, BottleType bottleType, int ml, LocalDate dateOfManufacture) {
        this.name = name;
        this.alcohol = alcohol;
        this.bottleType = bottleType;
        this.ml = ml;
        this.dateOfManufacture = dateOfManufacture;
    }
}
