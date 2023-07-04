package com.lcwd.hotel.controller;

import com.lcwd.hotel.payload.HotelDto;
import com.lcwd.hotel.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/hotel")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //http://localhost:8082/hotel
    @PostMapping
    public ResponseEntity<HotelDto> postHotelId(@RequestBody HotelDto hotelDto){
        HotelDto dto = hotelService.postHotelId(hotelDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // http://localhost:8082/hotel/2
    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> updateHotelId(@PathVariable ("id") long id,
                                                  @RequestBody HotelDto hotelDto){
        HotelDto dto = hotelService.updateHotelId(hotelDto, id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // http://localhost:8082/hotel/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotelId(@PathVariable ("id") long id){
        hotelService.deleteHotelId(id);
        return new ResponseEntity<>("Deleted Hotel id", HttpStatus.OK);
    }

   // http://localhost:8082/hotel
    @GetMapping
    public List<HotelDto> getAllHotelId(){
        return hotelService.getAllHotelId();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable("id") long id){
      HotelDto dto =  hotelService.getHotelById(id);
      return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
