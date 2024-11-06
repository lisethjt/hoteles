package com.hoteles.domain.port;

import java.util.List;

import com.hoteles.domain.model.Hotel;

public interface HotelRepository {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getByName(String name);

	List<Hotel> getAll();

	void deleteById(Long id);

	Hotel update(Hotel user);
}