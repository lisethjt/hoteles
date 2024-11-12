package com.hoteles.infraestructure.mapper;

import com.hoteles.domain.model.Hotel;
import com.hoteles.infraestructure.payload.HotelRequest;

public final class HotelRequestMapper {

	public static Hotel toHotel(HotelRequest hotel) {
		return Hotel.builder()				
				.name(hotel.getName())
				.category(hotel.getCategory())
				.available(hotel.getAvailable())
				.price(hotel.getPrice())
				.image(hotel.getImage())
				.build();
	}
}