package com.example.mapstruct.example_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SoJuMapperTest {

    private final SoJuMapper soJuMapper;

    public SoJuMapperTest(
            @Autowired SoJuMapper soJuMapper
    ) {
        this.soJuMapper = soJuMapper;
    }

    @Test
    void soJuMapperTest() {
        // Given
        SoJu jinRo = SoJu.builder()
                .name("JinRo")
                .alcohol(17.5f)
                .bottleType(BottleType.GLASS)
                .dateOfManufacture(LocalDate.of(2022, 3, 3))
                .ml(350)
                .build();

        // When
        SoJuDTO soJuDTO = soJuMapper.of(jinRo);

        // Then
        assertThat(soJuDTO)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", jinRo.getName())
                .hasFieldOrPropertyWithValue("strength", jinRo.getAlcohol())
                .hasFieldOrPropertyWithValue("type", jinRo.getBottleType())
                .hasFieldOrPropertyWithValue("size", jinRo.getMl());
    }
}