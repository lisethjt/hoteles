package com.hoteles.infraestructure.mapper;

import com.hoteles.domain.model.Hotel;
import com.hoteles.infraestructure.payload.HotelResponse;

public final class HotelResponseMapper {

	public static HotelResponse toHotelResponse(Hotel hotel) {
		return HotelResponse.builder()
				.id(hotel.getId())
				.name(hotel.getName())
				.category(hotel.getCategory())
				.available(hotel.getAvailable())
				.price(hotel.getPrice())
				.image(hotel.getImage())
				.build();
	}
}