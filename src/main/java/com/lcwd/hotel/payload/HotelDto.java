package com.lcwd.hotel.payload;

import lombok.Data;

@Data
public class HotelDto {

    private long id;
    private String name;
    private String location;
    private String about;
}
