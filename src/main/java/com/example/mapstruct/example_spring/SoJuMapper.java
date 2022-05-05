package com.example.mapstruct.example_spring;

import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SoJuMapper {

    @Mappings({
            @Mapping(source = "alcohol", target = "strength"),
            @Mapping(source = "bottleType", target = "type"),
            @Mapping(source = "ml", target = "size"),
    })
    SoJuDTO of(SoJu soJu);
}
