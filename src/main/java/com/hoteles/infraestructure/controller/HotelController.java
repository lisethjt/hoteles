package com.hoteles.infraestructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteles.application.usercase.HotelService;
import com.hoteles.infraestructure.mapper.HotelRequestMapper;
import com.hoteles.infraestructure.mapper.HotelResponseMapper;
import com.hoteles.infraestructure.payload.HotelRequest;
import com.hoteles.infraestructure.payload.HotelResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "hotels")
public class HotelController {

	private HotelService hotelservice;

	public HotelController(HotelService hotelservice) {
		this.hotelservice = hotelservice;
	}

	@GetMapping(value = "/getAll")
	public List<HotelResponse> getHotels() {
		return hotelservice.getAll().stream().map(HotelResponseMapper::toHotelResponse).collect(Collectors.toList());
	}

	@PostMapping
	public HotelResponse saveHotel(@RequestBody HotelRequest hotelRequest) {
		return HotelResponseMapper.toHotelResponse(hotelservice.createHotel(HotelRequestMapper.toHotel(hotelRequest)));
	}

	@PutMapping("/{id}")
	public HotelResponse updateHotel(@RequestBody HotelRequest hotelRequest, @PathVariable Long id) {
		return HotelResponseMapper.toHotelResponse(hotelservice.update(HotelRequestMapper.toHotel(hotelRequest), id));
	}

	@GetMapping("/{id}")
	public HotelResponse getHotel(@PathVariable Long id) {
		return HotelResponseMapper.toHotelResponse(hotelservice.findById(id));
	}
	
	@GetMapping("/delete/{id}")
	public void deleteHotel(@PathVariable Long id) {
		hotelservice.deleteById(id);
	}
}