package com.example.mapstruct.example_spring;

import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SoJuDTO {

    private String name;
    private float strength;
    private BottleType type;
    private int size;

    @Builder
    public SoJuDTO(String name, float strength, BottleType type, int size) {
        this.name = name;
        this.strength = strength;
        this.type = type;
        this.size = size;
    }
}
