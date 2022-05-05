package com.example.mapstruct.example_nested_list;

import com.example.mapstruct.example_nested_list.dto.BottleShopDTO;
import com.example.mapstruct.example_nested_list.entity.Beer;
import com.example.mapstruct.example_nested_list.entity.BottleShop;
import com.example.mapstruct.example_nested_list.entity.Whisky;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface BottleShopMapper {

    @Mappings({
            @Mapping(target = "beerName", source = "name"),
            @Mapping(target = "strength", source = "alcohol")
    })
    BottleShopDTO.BeerDTO of (Beer beer);

    @Mappings({
            @Mapping(target = "whiskyName", source = "name"),
            @Mapping(target = "strength", source = "alcohol")
    })
    BottleShopDTO.WhiskyDTO of (Whisky whisky);

    BottleShopDTO.BottleShopInfo of(BottleShop bottleShop);
}
