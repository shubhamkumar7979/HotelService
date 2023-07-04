package com.lcwd.hotel.service.Impl;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.exception.ResourceNotFoundException;
import com.lcwd.hotel.payload.HotelDto;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelDto postHotelId(HotelDto hotelDto) {
       Hotel hotel =  mapToEntity(hotelDto);
       Hotel newHotel = hotelRepository.save(hotel);
       HotelDto dto = mapToDto(newHotel);
        return dto;
    }

    @Override
    public HotelDto updateHotelId(HotelDto hotelDto, long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("hotel", "id", id)
        );
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setLocation(hotelDto.getLocation());
        hotel.setAbout(hotelDto.getAbout());
        Hotel dto = hotelRepository.save(hotel);
        return mapToDto(dto);
    }

    @Override
    public void deleteHotelId(long id) {
        Hotel dto = hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)

        );
        hotelRepository.delete(dto);
    }

    @Override
    public List<HotelDto> getAllHotelId() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(hotel -> mapToDto(hotel)).collect(Collectors.toList());
    }

    @Override
    public HotelDto getHotelById(long id) {
        Hotel dto = hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("hotel", "id", id)
        );

        return mapToDto(dto);
    }

    private HotelDto mapToDto(Hotel newHotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(newHotel.getId());
        hotelDto.setName(newHotel.getName());
        hotelDto.setLocation(newHotel.getLocation());
        hotelDto.setAbout(newHotel.getAbout());

        return hotelDto;
    }

    private Hotel mapToEntity(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        //hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setLocation(hotelDto.getLocation());
        hotel.setAbout(hotelDto.getAbout());
        return hotel;
    }
}
