package com.hoteles.infraestructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteles.application.usercase.HotelService;
import com.hoteles.infraestructure.mapper.HotelResponseMapper;
import com.hoteles.infraestructure.payload.HotelResponse;


@RestController
@CrossOrigin(origins="*")
public class HotelController {

	private HotelService hotelservice;

	public HotelController(HotelService hotelservice) {
		this.hotelservice = hotelservice;
	}
	
	@GetMapping (value ="/getHotels")
	public List<HotelResponse> getHotels () {
		return hotelservice.getAvailables().stream()
                .map(HotelResponseMapper::toHotelResponse)
                .collect(Collectors.toList());
	}	
}