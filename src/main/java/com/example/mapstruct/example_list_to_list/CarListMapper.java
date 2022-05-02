package com.example.mapstruct.example_list_to_list;

import com.example.mapstruct.example_java.Car;
import com.example.mapstruct.example_java.CarDTO;
import com.example.mapstruct.example_java.CarMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarListMapper {

    CarListMapper INSTANCE = Mappers.getMapper(CarListMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car);

    List<CarDTO> of(List<Car> cars);
}
