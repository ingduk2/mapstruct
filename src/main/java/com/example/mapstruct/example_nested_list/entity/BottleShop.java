package com.example.mapstruct.example_nested_list.entity;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class BottleShop {

    private String name;
    private String address;
    private String phoneNumber;

    private List<Beer> beers;
    private List<Whisky> whiskies;

    @Builder
    public BottleShop(String name, String address, String phoneNumber, List<Beer> beers, List<Whisky> whiskies) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.beers = beers;
        this.whiskies = whiskies;
    }
}
