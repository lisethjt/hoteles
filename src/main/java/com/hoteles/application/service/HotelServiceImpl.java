package com.hoteles.application.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hoteles.application.usercase.HotelService;
import com.hoteles.domain.constant.HotelConstant;
import com.hoteles.domain.model.Hotel;
import com.hoteles.domain.port.HotelRepository;
import com.hoteles.infraestructure.exception.HotelException;

@Service
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;

	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void deleteById(Long id) {
		Hotel hotelDb = hotelRepository.findById(id);
		if (hotelDb != null) {
			hotelRepository.deleteById(id);
		} else {
			new HotelException(HttpStatus.BAD_REQUEST, HotelConstant.HOTEL_NOT_FOUND_MESSAGE_ERROR);
		}
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		hotel.setAvailable("true");
		return hotelRepository.createHotel(hotel);
	}

	@Override
	public Hotel update(Hotel hotel, Long id) {
		Hotel hotelDb = hotelRepository.findById(id);
		if (hotelDb != null) {
			hotelDb.setPrice(hotel.getPrice());
			hotelDb.setCategory(hotel.getCategory());
			hotelDb.setImage(hotel.getImage());
		} else {
			new HotelException(HttpStatus.BAD_REQUEST, HotelConstant.HOTEL_NOT_FOUND_MESSAGE_ERROR);
		}
		return hotelRepository.createHotel(hotelDb);
	}

	@Override
	public List<Hotel> getByName(String name) {
		return hotelRepository.getByName(name);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.getAll();
	}

	@Override
	public Hotel findById(Long id) {
		return hotelRepository.findById(id);
	}

//	public List<Hotel> getAll() {
//		return hotelRepository.getAll().stream()
//				.filter(hotel -> hotel.getAvailable().equals("true"))
//				.collect(Collectors.toList());
//	}
}