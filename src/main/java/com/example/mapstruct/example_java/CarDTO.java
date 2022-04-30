package com.example.mapstruct.example_java;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class CarDTO {

    private String make;
    private int seatCount;
    private String type;

    @Builder
    public CarDTO(String make, int seatCount, String type) {
        this.make = make;
        this.seatCount = seatCount;
        this.type = type;
    }
}
