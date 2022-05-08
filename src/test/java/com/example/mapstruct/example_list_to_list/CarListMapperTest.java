package com.example.mapstruct.example_list_to_list;

import com.example.mapstruct.example_java.Car;
import com.example.mapstruct.example_java.CarDTO;
import com.example.mapstruct.example_java.CarType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class CarListMapperTest {

    @Test
    void caeListMapperTest() {
        // Given
        List<Car> cars = List.of(
                Car.builder()
                        .make("tesla")
                        .numberOfSeats(6)
                        .type(CarType.SUV)
                        .build(),
                Car.builder()
                        .make("lucid")
                        .numberOfSeats(5)
                        .type(CarType.SEDAN)
                        .build()
        );

        // When
        List<CarDTO> carDTOs = CarListMapper.INSTANCE.of(cars);

        // Then
        assertThat(carDTOs)
                .isNotNull()
                .hasSize(2)
                .extracting("make", "seatCount", "type")
                .contains(
                        tuple("tesla", 6, CarType.SUV.name()),
                        tuple("lucid", 5, CarType.SEDAN.name())
                );

        assertThat(carDTOs)
                .isNotNull()
                .hasSize(2)
                .extracting(
                        CarDTO::getMake,
                        CarDTO::getSeatCount,
                        CarDTO::getType
                ).containsExactly(
                        tuple("tesla", 6, CarType.SUV.name()),
                        tuple("lucid", 5, CarType.SEDAN.name())
                );
    }
}