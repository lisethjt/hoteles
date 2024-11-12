package com.hoteles.application.usercase;

import java.util.List;

import com.hoteles.domain.model.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getByName(String name);

	List<Hotel> getAll();

	void deleteById(Long id);

	Hotel update(Hotel hotel, Long id);

	Hotel findById(Long id);
}