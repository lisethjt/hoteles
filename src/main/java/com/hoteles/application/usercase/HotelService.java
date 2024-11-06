package com.hoteles.application.usercase;

import java.util.List;

import com.hoteles.domain.model.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getByName(String name);

	List<Hotel> getAvailables();

	void deleteById(Long id);

	Hotel update(Hotel user);
}