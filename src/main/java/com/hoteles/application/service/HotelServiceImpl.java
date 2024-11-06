package com.hoteles.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hoteles.application.usercase.HotelService;
import com.hoteles.domain.model.Hotel;
import com.hoteles.domain.port.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;

	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.createHotel(hotel);
	}

	@Override
	public Hotel update(Hotel hotel) {
		return hotelRepository.createHotel(hotel);
	}

	@Override
	public List<Hotel> getByName(String name) {
		return hotelRepository.getByName(name);
	}

	@Override
	public List<Hotel> getAvailables() {
		return hotelRepository.getAll().stream()
				.filter(hotel -> hotel.getAvailable().equals("true"))
				.collect(Collectors.toList());
	}
}