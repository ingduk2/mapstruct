package com.example.mapstruct.example_java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    @Test
    void carMapperTest() {
        // Given
        Car car = Car.builder()
                .make("tesla")
                .numberOfSeats(5)
                .type(CarType.SEDAN)
                .build();

        // When
        CarDTO carDTO = CarMapper.INSTANCE.carToCarDto(car);

        // Then
        assertThat(carDTO)
                .isNotNull()
                .hasFieldOrPropertyWithValue("make", "tesla")
                .hasFieldOrPropertyWithValue("seatCount", 5)
                .hasFieldOrPropertyWithValue("type", CarType.SEDAN.name());
    }
}