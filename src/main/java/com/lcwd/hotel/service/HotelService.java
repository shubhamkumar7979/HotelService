package com.lcwd.hotel.service;

import com.lcwd.hotel.payload.HotelDto;

import java.util.List;

public interface HotelService {
    HotelDto postHotelId(HotelDto hotelDto);

    HotelDto updateHotelId(HotelDto hotelDto, long id);

    void deleteHotelId(long id);

    List<HotelDto> getAllHotelId();

    HotelDto getHotelById(long id);
}
