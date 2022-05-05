package com.example.mapstruct.example_nested_list;

import com.example.mapstruct.example_nested_list.dto.BottleShopDTO;
import com.example.mapstruct.example_nested_list.entity.Beer;
import com.example.mapstruct.example_nested_list.entity.BottleShop;
import com.example.mapstruct.example_nested_list.entity.Whisky;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.*;

class BottleShopMapperTest {

    private BottleShopMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(BottleShopMapper.class);
    }

    @Test
    void bottleShopMapperTest() {
        // Given
        BottleShop bottleShop = BottleShop.builder()
                .name("ingduk2 BottleShop")
                .address("Seoul")
                .phoneNumber("010-1111-2222")
                .beers(List.of(
                        Beer.builder()
                                .name("Terra")
                                .alcohol(5)
                                .ml(300)
                                .dateOfManufacture(LocalDate.of(2021, 1, 1))
                                .build(),
                        Beer.builder()
                                .name("Hite")
                                .alcohol(4.5f)
                                .ml(300)
                                .dateOfManufacture(LocalDate.of(2021, 2, 2))
                                .build()
                ))
                .whiskies(List.of(
                        Whisky.builder()
                                .name("Glenfiddich")
                                .alcohol(40)
                                .ml(500)
                                .dateOfManufacture(LocalDate.of(2000, 12, 12))
                                .build()
                ))
                .build();

        // When
        BottleShopDTO.BottleShopInfo result = mapper.of(bottleShop);

        // Then
        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", bottleShop.getName())
                .hasFieldOrPropertyWithValue("address", bottleShop.getAddress())
                .hasFieldOrPropertyWithValue("phoneNumber", bottleShop.getPhoneNumber());
        assertThat(result.getBeers())
                .isNotNull()
                .hasSize(2)
                .extracting("beerName", "strength", "ml", "dateOfManufacture")
                .contains(
                        tuple("Terra", 5f, 300, LocalDate.of(2021, 1, 1)),
                        tuple("Hite", 4.5f, 300, LocalDate.of(2021, 2, 2))
                );
        assertThat(result.getWhiskies())
                .isNotNull()
                .hasSize(1)
                .extracting("whiskyName", "strength", "ml", "dateOfManufacture")
                .contains(
                        tuple("Glenfiddich", 40f, 500, LocalDate.of(2000, 12, 12))
                );
    }
}