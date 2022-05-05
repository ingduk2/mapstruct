package com.example.mapstruct.example_nested_list.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Whisky {

    private String name;
    private float alcohol;
    private int ml;
    private LocalDate dateOfManufacture;

    @Builder
    public Whisky(String name, float alcohol, int ml, LocalDate dateOfManufacture) {
        this.name = name;
        this.alcohol = alcohol;
        this.ml = ml;
        this.dateOfManufacture = dateOfManufacture;
    }
}
